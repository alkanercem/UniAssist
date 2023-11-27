package UniAssist.business.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import UniAssist.business.requests.CreateStudentRequest;
import UniAssist.business.requests.UpdateStudentRequest;
import UniAssist.business.responses.GetAllStudentsResponse;
import UniAssist.business.responses.GetByIdStudentResponse;
import UniAssist.business.responses.GetByMailStudentResponse;

public interface StudentService {
	
	List<GetAllStudentsResponse> getAll();
	GetByIdStudentResponse getById(int id);
	void add(CreateStudentRequest createStudentRequest);
	void update(UpdateStudentRequest updateStudentRequest);
	void delete(int id);
	GetByMailStudentResponse getByMail(String mail);
	ResponseEntity<String> register(CreateStudentRequest createStudentRequest);
	
}
