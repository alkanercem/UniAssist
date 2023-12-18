package UniAssist.business.requests;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCourseToStudent {
	int studentId;
	 List<Integer> courseIds;
}
