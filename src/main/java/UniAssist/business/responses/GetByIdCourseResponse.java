package UniAssist.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCourseResponse {
	private int id;
	private int teacherId;
	private String name;
	private String departmentName;
	private String sectionName;
	private String semesterName;
	private int courseClass;
	private int creditHours;
	private String day;
	private String timeInterval;
	private String examTime;
	
	private float grade;	
	private int attendanceStatus;
}
