package UniAssist.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddGradeRequest {
	private int student_id;
	private int course_id;
	private float grade;

}
