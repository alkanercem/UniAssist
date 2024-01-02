package UniAssist.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import UniAssist.business.abstracts.TeacherService;
import UniAssist.business.requests.AddAttendanceRequest;
import UniAssist.business.requests.AddGradeRequest;
import UniAssist.business.requests.CreateTeacherRequest;
import UniAssist.business.requests.UpdateStudentRequest;
import UniAssist.business.responses.GetAllStudentsResponse;
import UniAssist.business.responses.GetByMailTeacherResponse;
import UniAssist.business.responses.GetByTeacherCoursesResponse;
import UniAssist.core.utilities.mappers.ModelMapperService;
import UniAssist.dataAccess.abstracts.CourseRepository;
import UniAssist.dataAccess.abstracts.GradeRepository;
import UniAssist.dataAccess.abstracts.TeacherRepository;
import UniAssist.entities.concretes.Course;
import UniAssist.entities.concretes.Grade;
import UniAssist.entities.concretes.Student;
import UniAssist.entities.concretes.Teacher;
import UniAssist.entities.concretes.User;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeacherManager implements TeacherService {
	
	private ModelMapperService modelMapperService;
	private TeacherRepository teacherRepository;
	private GradeRepository gradeRepository;
	private CourseRepository courseRepository;
	private UserManager userManager;
	private PasswordEncoder passwordEncoder;
	
	public void add(CreateTeacherRequest createTeacherRequest) {
		Teacher teacher = this.modelMapperService.forRequest().map(createTeacherRequest, Teacher.class);
		this.teacherRepository.save(teacher);		
	}
	
	@Override
	public GetByMailTeacherResponse getByMail(String mail) {
		
		Teacher teacher = this.teacherRepository.findByMail(mail);
		
		GetByMailTeacherResponse response 
		= this.modelMapperService.forResponse().map(teacher, GetByMailTeacherResponse.class);
		
		return response;
	}


	@Override
	public void update(UpdateStudentRequest updateStudentRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	};
	
	public ResponseEntity<String> register(CreateTeacherRequest createTeacherRequest) {
		if(userManager.getOneUserByUserName(createTeacherRequest.getMail()) != null) 
			return new ResponseEntity<>("Username already in use.",HttpStatus.BAD_REQUEST);
		User user = new User();
		user.setUserName(createTeacherRequest.getMail());
		user.setPassword(passwordEncoder.encode(createTeacherRequest.getPassword()));
		userManager.saveOneUser(user);
		userManager.addRoleTo(createTeacherRequest.getMail(),createTeacherRequest.getRoleName());
		return new ResponseEntity<>("Teacher succesfully registered", HttpStatus.CREATED);

	}
	 
	public List<GetByTeacherCoursesResponse> getCoursesByTeacher(Teacher teacher) {
	    List<Course>courses = courseRepository.findByTeacher(teacher);
	  
	    List<GetByTeacherCoursesResponse> coursesResponse = courses.stream()
				.map(course->this.modelMapperService.forResponse()
						.map(course, GetByTeacherCoursesResponse.class)).collect(Collectors.toList());

		return coursesResponse;			    	
	    	
	    }
	
	public List<GetAllStudentsResponse> getStudentsByTeacherAndCourse(Teacher teacher, Course course) {
        List<Grade> grades = course.getGrade();
        List<GetAllStudentsResponse> studentResponses = new ArrayList<>();

        for (Grade grade : grades) {
            Student student = grade.getStudent();
            
            GetAllStudentsResponse response = new GetAllStudentsResponse();
            response.setId(student.getId());
            response.setFirstName(student.getFirstName());
            response.setLastName(student.getLastName());


            studentResponses.add(response);
        }

        return studentResponses;
    }
	public void addGrade(AddGradeRequest addGradeRequest) {
		Grade grade = gradeRepository.findByStudentIdAndCourseId(addGradeRequest.getStudent_id(), addGradeRequest.getCourse_id());
		grade.setGrade(addGradeRequest.getGrade());
        
        gradeRepository.save(grade);
		
	}
	public void addAttendance(AddAttendanceRequest addAttendanceRequest) {
		Grade grade = gradeRepository.findByStudentIdAndCourseId(addAttendanceRequest.getStudent_id(), addAttendanceRequest.getCourse_id());
		grade.setAttendanceStatus(addAttendanceRequest.getAttendance());
		
        gradeRepository.save(grade);
		
	}

}
