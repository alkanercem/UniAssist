package UniAssist.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByMailTeacherResponse {
	
	private int id;
	private Long tc;
	private String firstName;
	private String lastName;
	private String departmentName;
	private String mail;
	private String officeNo;
	private String image;

}
