package UniAssist.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UniAssist.business.abstracts.CourseService;
import UniAssist.business.requests.CreateCourseRequest;
import UniAssist.business.responses.GetAllCoursesResponse;
import UniAssist.business.responses.GetByClassCoursesResponse;
import UniAssist.business.responses.GetByIdCourseResponse;
import UniAssist.business.responses.GetByTeacherCoursesResponse;
import UniAssist.core.utilities.mappers.ModelMapperService;
import UniAssist.dataAccess.abstracts.CourseRepository;
import UniAssist.dataAccess.abstracts.TeacherRepository;
import UniAssist.entities.concretes.Course;
import UniAssist.entities.concretes.Grade;
import UniAssist.entities.concretes.Student;
import UniAssist.entities.concretes.Teacher;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseManager implements CourseService {
	
	@Autowired
	private ModelMapperService modelMapperService;
    @Autowired
	private CourseRepository courseRepository;
    @Autowired
	private TeacherRepository teacherRepository;
	
	public List<GetAllCoursesResponse> getAll(){
		List<Course>courses = courseRepository.findAll();
		
		List<GetAllCoursesResponse> coursesResponse = courses.stream()
				.map(course->this.modelMapperService.forResponse()
						.map(course, GetAllCoursesResponse.class)).collect(Collectors.toList());

		return coursesResponse;		
	}
	
	@Override
	public GetByIdCourseResponse getById(int id) {
		Course course = this.courseRepository.findById(id);
		
		GetByIdCourseResponse response 
		= this.modelMapperService.forResponse().map(course, GetByIdCourseResponse.class);
		
		return response;
	}
	  
	public List<GetByClassCoursesResponse> findByCourseClassAndSemesterName(int courseClass, String semesterName) {
		List<Course>courses = courseRepository.findByCourseClassAndSemesterName(courseClass,semesterName);

		List<GetByClassCoursesResponse> coursesResponse = courses.stream()
				.map(course->this.modelMapperService.forResponse()
						.map(course, GetByClassCoursesResponse.class)).collect(Collectors.toList());

		return coursesResponse;		
    }

	public void addCourseToTeacher(CreateCourseRequest createCourseRequest) {
	    Teacher teacher = teacherRepository.findByFirstNameAndLastName(createCourseRequest.getFirstName(), createCourseRequest.getLastName());
	    
	        if (teacher == null) 
	            System.out.println("Teacher not found");
	         
	        else {
	            Course course = modelMapperService.forRequest().map(createCourseRequest, Course.class);
	            course.setTeacher(teacher);
	            courseRepository.save(course);
	            // kontrol noktası
	            System.out.println("Before adding course: " + teacher.getCourse());

	            teacher.getCourse().add(course);

	            // kontrol noktası
	            System.out.println("After adding course: " + teacher.getCourse());
	            
	            teacherRepository.save(teacher);
	        }
	    }


}
