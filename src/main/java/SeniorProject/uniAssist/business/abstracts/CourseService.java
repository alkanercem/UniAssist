package SeniorProject.uniAssist.business.abstracts;

import java.util.List;

import SeniorProject.uniAssist.business.requests.CreateCourseRequest;
import SeniorProject.uniAssist.business.responses.GetAllCoursesResponse;

public interface CourseService {
	
	List<GetAllCoursesResponse> getAll();
	void add(CreateCourseRequest createCourseRequest);

}
