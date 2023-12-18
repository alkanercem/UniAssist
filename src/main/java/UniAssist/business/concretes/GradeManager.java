package UniAssist.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UniAssist.business.abstracts.CourseService;
import UniAssist.business.abstracts.GradeService;
import UniAssist.business.abstracts.StudentService;
import UniAssist.business.requests.AddCourseToStudent;
import UniAssist.business.responses.GetAllCoursesResponse;
import UniAssist.business.responses.GetByClassCoursesResponse;
import UniAssist.business.responses.GetByIdCourseResponse;
import UniAssist.business.responses.GetByIdStudentResponse;
import UniAssist.core.utilities.mappers.ModelMapperService;
import UniAssist.dataAccess.abstracts.GradeRepository;
import UniAssist.entities.concretes.Course;
import UniAssist.entities.concretes.Grade;
import UniAssist.entities.concretes.Student;

@Service
public class GradeManager implements GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private StudentService studentService;
    
    @Autowired
    private CourseService courseService;
    
    @Autowired
    private ModelMapperService modelMapperService;

    @Override
	public void addCourseToStudent(AddCourseToStudent addCourseToStudent) {
		GetByIdStudentResponse studentResponse = studentService.getById(addCourseToStudent.getStudentId());
		List<Integer> coursesResponse = addCourseToStudent.getCourseIds();
		
		Student student = this.modelMapperService.forRequest().map(studentResponse, Student.class);

        if (student != null && !coursesResponse.isEmpty()) {
        	for (Integer courseId : coursesResponse) {
                GetByIdCourseResponse courseResponse = courseService.getById(courseId);
                Course course = this.modelMapperService.forRequest().map(courseResponse, Course.class);
                	
                	Grade newGrade = new Grade();
                	newGrade.setStudent(student);
                	newGrade.setCourse(course);

                	gradeRepository.save(newGrade);
        	}        
        }
		
	}
    public List<GetByIdCourseResponse> getCoursesByStudent(Student student) {
    	List<Grade>courses = gradeRepository.findByStudent(student);
    	
    	List<GetByIdCourseResponse> coursesResponse = courses.stream()
				.map(course->this.modelMapperService.forResponse()
						.map(course, GetByIdCourseResponse.class)).collect(Collectors.toList());

		return coursesResponse;		
    	
    	
    }
}