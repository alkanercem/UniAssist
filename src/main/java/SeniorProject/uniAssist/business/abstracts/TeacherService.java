package SeniorProject.uniAssist.business.abstracts;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import SeniorProject.uniAssist.business.requests.CreateTeacherRequest;
import SeniorProject.uniAssist.business.requests.UpdateStudentRequest;

public interface TeacherService {
	
	void add(CreateTeacherRequest createTeacherRequest);
	void update(UpdateStudentRequest updateStudentRequest);
	void delete(int id);
	ResponseEntity<String> register(CreateTeacherRequest createTeacherRequest);

}
