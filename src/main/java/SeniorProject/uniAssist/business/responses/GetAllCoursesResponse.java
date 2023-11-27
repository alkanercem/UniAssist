package SeniorProject.uniAssist.business.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCoursesResponse {
	private String name;
	private String departmentName;
	private String semesterName;
	private int courseClass;
	private int creditHours;

}
