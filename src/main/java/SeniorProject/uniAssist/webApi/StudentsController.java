package SeniorProject.uniAssist.webApi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import SeniorProject.uniAssist.business.abstracts.StudentService;
import SeniorProject.uniAssist.business.requests.CreateStudentRequest;
import SeniorProject.uniAssist.business.requests.UpdateStudentRequest;
import SeniorProject.uniAssist.business.responses.GetAllStudentsResponse;
import SeniorProject.uniAssist.business.responses.GetByIdStudentResponse;
import SeniorProject.uniAssist.business.responses.GetByMailStudentResponse;
import lombok.AllArgsConstructor;

@RestController //annotation
@RequestMapping("/students")
@AllArgsConstructor
public class StudentsController {
	
	private StudentService studentService;
	
	@GetMapping("/getAllStudents")
	@PreAuthorize("hasAnyAuthority('Admin')")
	public List<GetAllStudentsResponse> getAllStudents(){
		return studentService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdStudentResponse getById(@PathVariable int id) {
		return studentService.getById(id);
	}
	
	@GetMapping("/mail/{mail}")
	public GetByMailStudentResponse getByMail(@PathVariable String mail) {
		return studentService.getByMail(mail);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody CreateStudentRequest createStudentRequest) {
		this.studentService.add(createStudentRequest);
		this.studentService.register(createStudentRequest);
	}

	@PutMapping
	public void update(@RequestBody UpdateStudentRequest updateStudentRequest) {
		this.studentService.update(updateStudentRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		 this.studentService.delete(id);
	}
	

}
