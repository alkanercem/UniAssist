package SeniorProject.uniAssist.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import SeniorProject.uniAssist.dataAccess.abstracts.UserRepository;
import SeniorProject.uniAssist.entities.concretes.User;
import SeniorProject.uniAssist.security.JwtUserDetails;

@Service
public class UserDetailsManager implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);		
		return JwtUserDetails.create(user);
	
	}
	
	public UserDetails loadUserById(Long id) {
		User user = userRepository.findById(id).get();
		return JwtUserDetails.create(user); 
	}
}
