package UniAssist.webApi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import UniAssist.business.abstracts.TeacherService;
import UniAssist.business.requests.AddAttendanceRequest;
import UniAssist.business.requests.AddGradeRequest;
import UniAssist.business.requests.CreateTeacherRequest;
import UniAssist.business.responses.GetAllStudentsResponse;
import UniAssist.business.responses.GetByMailTeacherResponse;
import UniAssist.business.responses.GetByTeacherCoursesResponse;
import UniAssist.dataAccess.abstracts.CourseRepository;
import UniAssist.dataAccess.abstracts.TeacherRepository;
import UniAssist.entities.concretes.Course;
import UniAssist.entities.concretes.Teacher;
import lombok.AllArgsConstructor;

@RestController //annotation
@RequestMapping("/teacher")
@AllArgsConstructor
public class TeacherController {
	
	private TeacherService teacherService;
	private TeacherRepository teacherRepository;
	private CourseRepository courseRepository;
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody CreateTeacherRequest createTeacherRequest) {
		this.teacherService.add(createTeacherRequest);	
		this.teacherService.register(createTeacherRequest);
		}
	
	@GetMapping("/mail/{mail}")
	public GetByMailTeacherResponse getByMail(@PathVariable String mail) {
		return teacherService.getByMail(mail);
	}
	
	@GetMapping("/getCoursesByTeacher/{teacher}")
	public List<GetByTeacherCoursesResponse> getCoursesByTeacher(@PathVariable Teacher teacher) {	 
		 return teacherService.getCoursesByTeacher(teacher); 
	    }
	
	@GetMapping("/getAllStudentsByTeacherAndCourse/{teacherId}/{courseId}")
	public ResponseEntity<List<GetAllStudentsResponse>> getStudentsByTeacherAndCourse(
	        @PathVariable int teacherId,
	        @PathVariable int courseId) {
	    Teacher teacher = teacherRepository.findById(teacherId);
	    Course course = courseRepository.findById(courseId);

	    if (teacher == null || course == null) {
	        return ResponseEntity.notFound().build();
	    }

	    List<GetAllStudentsResponse> students = teacherService.getStudentsByTeacherAndCourse(teacher, course);
	    return ResponseEntity.ok(students);
	}

	

	@PostMapping("/addGrade")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void addGrade(@RequestBody AddGradeRequest addGradeRequest) {
		this.teacherService.addGrade(addGradeRequest);	
		}
	
	@PostMapping("/addAttendance")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void addAttendance(@RequestBody AddAttendanceRequest addAttendanceRequest) {
		this.teacherService.addAttendance(addAttendanceRequest);	
		}
	
	
	

	
	
}
