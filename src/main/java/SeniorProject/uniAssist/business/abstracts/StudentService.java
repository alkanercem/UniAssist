package SeniorProject.uniAssist.business.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import SeniorProject.uniAssist.business.requests.CreateStudentRequest;
import SeniorProject.uniAssist.business.requests.UpdateStudentRequest;
import SeniorProject.uniAssist.business.responses.GetAllStudentsResponse;
import SeniorProject.uniAssist.business.responses.GetByIdStudentResponse;
import SeniorProject.uniAssist.business.responses.GetByMailStudentResponse;

public interface StudentService {
	
	List<GetAllStudentsResponse> getAll();
	GetByIdStudentResponse getById(int id);
	void add(CreateStudentRequest createStudentRequest);
	void update(UpdateStudentRequest updateStudentRequest);
	void delete(int id);
	GetByMailStudentResponse getByMail(String mail);
	ResponseEntity<String> register(CreateStudentRequest createStudentRequest);
	
}
