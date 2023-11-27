package SeniorProject.uniAssist.business.responses;

import java.util.List;

import SeniorProject.uniAssist.entities.concretes.Grade;
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
	List<Grade> grade;

}
