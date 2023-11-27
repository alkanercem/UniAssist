package UniAssist.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentRequest {
	@NotNull
	@NotBlank
	@Size(min=5, max=20)
	private String firstName;
	
	@NotNull
	@NotBlank
	@Size(min=5, max=20)
	private String lastName;
	
	@NotNull
	@NotBlank
	@Size(min=5, max=20)
	private String password;
	
	@NotNull
	@NotBlank
	@Size(min=5, max=20)
	private int courseClass;
	
	
	@NotNull
	@NotBlank
	@Size(min=5, max=20)
	private String mail;
	
	@NotNull
	@NotBlank
	private String roleName;
}
