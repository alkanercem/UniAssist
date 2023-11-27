package SeniorProject.uniAssist.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
	@NotNull
	@NotBlank
	@Size(min=5, max=20)
	private String password;
	
	private String departmentName;
	private String mail;
	private String officeNo;
	
	@NotNull
	@NotBlank
	private String roleName;

}
