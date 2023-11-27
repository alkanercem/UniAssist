package SeniorProject.uniAssist.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdStudentResponse {
	
	private int id;
	private String firstName;
	private String lastName;
	private int courseClass;
	private String mail;

}
