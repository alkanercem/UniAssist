package UniAssist.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCoursesByStudent {
	
	private int id;
	private String name;
	private String departmentName;
	private String semesterName;
	private int courseClass;
	private int creditHours;
	

}
	