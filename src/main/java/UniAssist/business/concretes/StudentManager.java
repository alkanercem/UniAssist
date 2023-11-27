package UniAssist.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import UniAssist.business.abstracts.StudentService;
import UniAssist.business.requests.CreateStudentRequest;
import UniAssist.business.requests.UpdateStudentRequest;
import UniAssist.business.responses.GetAllStudentsResponse;
import UniAssist.business.responses.GetByIdStudentResponse;
import UniAssist.business.responses.GetByMailStudentResponse;
import UniAssist.core.utilities.mappers.ModelMapperService;
import UniAssist.dataAccess.abstracts.StudentRepository;
import UniAssist.entities.concretes.Student;
import UniAssist.entities.concretes.User;
import lombok.AllArgsConstructor;

@Service //Bu sınıf bir business nesnesidir
@AllArgsConstructor
public class StudentManager implements StudentService{
	
	private ModelMapperService modelMapperService;
	private StudentRepository studentRepository;
	private UserManager userManager;
	private PasswordEncoder passwordEncoder;

	@Override
	public List<GetAllStudentsResponse> getAll() {
		
		List<Student>students = studentRepository.findAll();
	/*  List<GetAllStudentsResponse> studentsResponse = new ArrayList<GetAllStudentsResponse>();
		
		for (Student student : students) {
			GetAllStudentsResponse responseItem = new GetAllStudentsResponse();
			responseItem.setId(student.getId());
			responseItem.setName(student.getName());
			studentsResponse.add(responseItem);
		} */
		List<GetAllStudentsResponse> studentsResponse = students.stream()
				.map(student->this.modelMapperService.forResponse()
						.map(student, GetAllStudentsResponse.class)).collect(Collectors.toList());

		return studentsResponse;	
	}

	@Override
	public void add(CreateStudentRequest createStudentRequest) {
		
		//Student student = new Student();
		//student.setName(createStudentRequest.getName());
		Student student = this.modelMapperService.forRequest().map(createStudentRequest, Student.class);
		this.studentRepository.save(student);		
	}
	
	public ResponseEntity<String> register(CreateStudentRequest createStudentRequest) {
		if(userManager.getOneUserByUserName(createStudentRequest.getMail()) != null) 
			return new ResponseEntity<>("Username already in use.",HttpStatus.BAD_REQUEST);
		User user = new User();
		user.setUserName(createStudentRequest.getMail());
		user.setPassword(passwordEncoder.encode(createStudentRequest.getPassword()));
		userManager.saveOneUser(user);
		userManager.addRoleTo(createStudentRequest.getMail(),createStudentRequest.getRoleName());
		return new ResponseEntity<>("Student succesfully registered", HttpStatus.CREATED);

	}

	@Override
	public GetByIdStudentResponse getById(int id) {
		
		Student student = this.studentRepository.findById(id).orElseThrow();
		
		GetByIdStudentResponse response 
		= this.modelMapperService.forResponse().map(student, GetByIdStudentResponse.class);
		
		return response;
	}
	
	@Override
	public GetByMailStudentResponse getByMail(String mail) {
		
		Student student = this.studentRepository.findByMail(mail);
		
		GetByMailStudentResponse response 
		= this.modelMapperService.forResponse().map(student, GetByMailStudentResponse.class);
		
		return response;
	}

	@Override
	public void update(UpdateStudentRequest updateStudentRequest) {
		
		Student student = this.modelMapperService.forRequest().map(updateStudentRequest, Student.class);
		this.studentRepository.save(student);
		//ID olmasaydı insert yapardı fakat id updateStudentRequest'de var olduğu için update yapılır)
	}

	@Override
	public void delete(int id) {
		
		this.studentRepository.deleteById(id);
		
	}
	

}
