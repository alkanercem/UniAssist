package UniAssist.business.responses;

import java.util.List;

import UniAssist.entities.concretes.Grade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByMailStudentResponse {
	
	private int id;
	private String firstName;
	private String lastName;
	private int courseClass;
	private String mail;
	private String departmentName;
	private String sectionName;
//	private List<Grade> grades;


}
