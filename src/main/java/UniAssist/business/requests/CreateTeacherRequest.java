package UniAssist.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTeacherRequest {
	
	private long tc;
	
	private String firstName;
	
	private String lastName;
	
	private String password;
	
	private String departmentName;
	
	private String mail;
	
	private String officeNo;
	
	@NotNull
	@NotBlank
	private String roleName;
	
	private String image;

}
