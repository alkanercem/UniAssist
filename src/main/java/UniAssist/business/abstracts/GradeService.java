package UniAssist.business.abstracts;

import java.util.List;

import UniAssist.business.requests.AddCourseToStudent;
import UniAssist.business.responses.GetByIdCourseResponse;
import UniAssist.entities.concretes.Student;

public interface GradeService {
	void addCourseToStudent(AddCourseToStudent addCourseToStudent);
	List<GetByIdCourseResponse> getCoursesByStudent(Student student);
}
