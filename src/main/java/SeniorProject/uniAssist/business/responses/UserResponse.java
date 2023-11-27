package SeniorProject.uniAssist.business.responses;


import SeniorProject.uniAssist.entities.concretes.User;
import lombok.Data;

@Data
public class UserResponse {
	
	Long id;
	String userName;
	

	public UserResponse(User entity) {
		this.id = entity.getId();
		this.userName = entity.getUserName();
	} 
}