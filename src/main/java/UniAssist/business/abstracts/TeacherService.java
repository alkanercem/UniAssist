package UniAssist.business.abstracts;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import UniAssist.business.requests.CreateTeacherRequest;
import UniAssist.business.requests.UpdateStudentRequest;

public interface TeacherService {
	
	void add(CreateTeacherRequest createTeacherRequest);
	void update(UpdateStudentRequest updateStudentRequest);
	void delete(int id);
	ResponseEntity<String> register(CreateTeacherRequest createTeacherRequest);

}
