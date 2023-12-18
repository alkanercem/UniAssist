package UniAssist.webApi;

import java.util.List;

import org.springframework.http.HttpStatus;
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
import UniAssist.business.responses.GetByIdCourseResponse;
import UniAssist.business.responses.GetByMailTeacherResponse;
import UniAssist.business.responses.GetByTeacherCoursesResponse;
import UniAssist.entities.concretes.Student;
import UniAssist.entities.concretes.Teacher;
import lombok.AllArgsConstructor;

@RestController //annotation
@RequestMapping("/teacher")
@AllArgsConstructor
public class TeacherController {
	
	private TeacherService teacherService;
	
	
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
