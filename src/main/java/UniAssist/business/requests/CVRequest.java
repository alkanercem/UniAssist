package UniAssist.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CVRequest {
	 private int studentId;
	 private String aboutMe;
	 private String skills;
	 private String experience;

}
