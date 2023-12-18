package UniAssist.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import UniAssist.dataAccess.abstracts.RoleRepository;
import UniAssist.dataAccess.abstracts.UserRepository;
import UniAssist.entities.concretes.Role;
import UniAssist.entities.concretes.User;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserManager {

	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	

	public UserManager(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User saveOneUser(User newUser) {
		return userRepository.save(newUser);
	}

	public User getOneUserById(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}
	
	public void addRoleTo(String userName, String roleName) {
		User user = userRepository.findByUserName(userName);
		Role role = roleRepository.findByName(roleName);
		user.getRoles().add(role);
		userRepository.save(user);
		
	}
	
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	public void deleteById(Long userId) {
		try {
		userRepository.deleteById(userId);
		}catch(EmptyResultDataAccessException e) { //user zaten yok, db'den empty result gelmiş
			System.out.println("User "+userId+" doesn't exist"); //istersek loglayabiliriz
		}
	}

	public User getOneUserByUserName(String userName) {
		return userRepository.findByUserName(userName);

	}
}