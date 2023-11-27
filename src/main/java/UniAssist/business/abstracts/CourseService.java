package UniAssist.business.abstracts;

import java.util.List;

import UniAssist.business.requests.CreateCourseRequest;
import UniAssist.business.responses.GetAllCoursesResponse;

public interface CourseService {
	
	List<GetAllCoursesResponse> getAll();
	void add(CreateCourseRequest createCourseRequest);

}
