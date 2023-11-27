package UniAssist.business.concretes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import UniAssist.business.abstracts.TeacherService;
import UniAssist.business.requests.CreateTeacherRequest;
import UniAssist.business.requests.UpdateStudentRequest;
import UniAssist.core.utilities.mappers.ModelMapperService;
import UniAssist.dataAccess.abstracts.TeacherRepository;
import UniAssist.entities.concretes.Teacher;
import UniAssist.entities.concretes.User;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeacherManager implements TeacherService {
	
	private ModelMapperService modelMapperService;
	private TeacherRepository teacherRepository;
	private UserManager userManager;
	private PasswordEncoder passwordEncoder;
	
	public void add(CreateTeacherRequest createTeacherRequest) {
		Teacher teacher = this.modelMapperService.forRequest().map(createTeacherRequest, Teacher.class);
		this.teacherRepository.save(teacher);		
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

}
