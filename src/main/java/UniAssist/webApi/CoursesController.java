package UniAssist.webApi;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import UniAssist.business.abstracts.CourseService;
import UniAssist.business.abstracts.GradeService;
import UniAssist.business.requests.AddCourseToStudent;
import UniAssist.business.requests.CreateCourseRequest;
import UniAssist.business.requests.CreateStudentRequest;
import UniAssist.business.responses.GetAllCoursesResponse;
import UniAssist.business.responses.GetByClassCoursesResponse;
import UniAssist.business.responses.GetByIdCourseResponse;
import UniAssist.business.responses.GetByMailStudentResponse;
import UniAssist.entities.concretes.Course;
import UniAssist.entities.concretes.Student;
import lombok.AllArgsConstructor;


@RestController //annotation
@RequestMapping("/courses")

public class CoursesController {
	
	@Autowired
    private CourseService courseService;
	
	@Autowired
    private GradeService gradeService;
	
	@GetMapping("/getAllCourses")
	public List<GetAllCoursesResponse> getAllCourses(){
		return courseService.getAll();
	}
	
	@PostMapping("/addCourseToTeacher")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody CreateCourseRequest createCourseRequest) {
		this.courseService.addCourseToTeacher(createCourseRequest);	
	}


	 @GetMapping("/findByCourseClassAndSemesterName/{courseClass}/{semesterName}")
	 public List<GetByClassCoursesResponse> findByCourseClassAndSemesterName(@PathVariable int courseClass, @PathVariable String semesterName) {	 
		 return courseService.findByCourseClassAndSemesterName(courseClass,semesterName); 
	    }
	 
	/* @PostMapping("/addCourse/{studentId}/{courseId}")
	    public ResponseEntity<String> selectCourse(
	    		@PathVariable int studentId,
	    		@PathVariable int courseId) {

	        gradeService.selectCourse(studentId, courseId);

	        return ResponseEntity.ok("Course selected successfully");
	    } */
	@PostMapping("/addCourseToStudent")
	@ResponseStatus(code=HttpStatus.CREATED)
		public ResponseEntity<String> add(@RequestBody AddCourseToStudent addCourseToStudent) throws IOException {
			this.gradeService.addCourseToStudent(addCourseToStudent);
			return ResponseEntity.ok("Course selected successfully");
		}
	
	@GetMapping("/getCoursesByStudent/{student}")
	 public List<GetByIdCourseResponse> getCoursesByStudent(@PathVariable Student student) {	 
		 return gradeService.getCoursesByStudent(student); 
	    }
	 
	}
