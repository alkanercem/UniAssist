package UniAssist.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import UniAssist.business.abstracts.CourseService;
import UniAssist.business.requests.CreateCourseRequest;
import UniAssist.business.responses.GetAllCoursesResponse;
import UniAssist.core.utilities.mappers.ModelMapperService;
import UniAssist.dataAccess.abstracts.CourseRepository;
import UniAssist.entities.concretes.Course;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseManager implements CourseService {
	private ModelMapperService modelMapperService;
	private CourseRepository courseRepository;
	
	public List<GetAllCoursesResponse> getAll(){
		List<Course>courses = courseRepository.findAll();
		
		List<GetAllCoursesResponse> coursesResponse = courses.stream()
				.map(course->this.modelMapperService.forResponse()
						.map(course, GetAllCoursesResponse.class)).collect(Collectors.toList());

		return coursesResponse;
		
	}

	@Override
	public void add(CreateCourseRequest createCourseRequest) {
		Course course = this.modelMapperService.forRequest().map(createCourseRequest, Course.class);
		this.courseRepository.save(course);		
	};

}
