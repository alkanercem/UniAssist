package SeniorProject.uniAssist.webApi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import SeniorProject.uniAssist.business.abstracts.TeacherService;
import SeniorProject.uniAssist.business.requests.CreateTeacherRequest;
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

	
	
}
