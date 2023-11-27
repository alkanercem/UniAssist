package UniAssist.business.requests;

import lombok.Data;

@Data
public class UserRequest {
	
	String userName;
	String password;
	String roleName;

}