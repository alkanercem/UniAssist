package UniAssist.business.abstracts;

import java.util.List;

import UniAssist.business.requests.CreateCourseRequest;
import UniAssist.business.responses.GetAllCoursesResponse;
import UniAssist.business.responses.GetByClassCoursesResponse;
import UniAssist.business.responses.GetByIdCourseResponse;
import UniAssist.entities.concretes.Course;

public interface CourseService {
	
	List<GetAllCoursesResponse> getAll();
	List<GetByClassCoursesResponse> findByCourseClassAndSemesterName(int courseClass, String semesterName);
	void addCourseToTeacher(CreateCourseRequest createCourseRequest);
	GetByIdCourseResponse getById(int id);
}
