package UniAssist.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAttendanceRequest {
	private int student_id;
	private int course_id;
	private int attendance;
}
