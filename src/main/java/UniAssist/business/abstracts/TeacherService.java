package UniAssist.business.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import UniAssist.business.requests.AddAttendanceRequest;
import UniAssist.business.requests.AddGradeRequest;
import UniAssist.business.requests.CreateTeacherRequest;
import UniAssist.business.requests.UpdateStudentRequest;
import UniAssist.business.responses.GetByMailTeacherResponse;
import UniAssist.business.responses.GetByTeacherCoursesResponse;
import UniAssist.entities.concretes.Teacher;

public interface TeacherService {
	
	void add(CreateTeacherRequest createTeacherRequest);
	void update(UpdateStudentRequest updateStudentRequest);
	void delete(int id);
	ResponseEntity<String> register(CreateTeacherRequest createTeacherRequest);
	GetByMailTeacherResponse getByMail(String mail);
	List<GetByTeacherCoursesResponse> getCoursesByTeacher(Teacher teacher);
	void addGrade(AddGradeRequest addGradeRequest);
	void addAttendance(AddAttendanceRequest addAttendanceRequest);

}
