package SeniorProject.uniAssist.webApi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import SeniorProject.uniAssist.business.abstracts.CourseService;
import SeniorProject.uniAssist.business.requests.CreateCourseRequest;
import SeniorProject.uniAssist.business.responses.GetAllCoursesResponse;
import lombok.AllArgsConstructor;

@RestController //annotation
@RequestMapping("/courses")
@AllArgsConstructor
public class CoursesController {
	private CourseService courseService;
	
	@GetMapping("/getAllCourses")
	public List<GetAllCoursesResponse> getAllCourses(){
		return courseService.getAll();
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody CreateCourseRequest createCourseRequest) {
		this.courseService.add(createCourseRequest);	
	}

}
