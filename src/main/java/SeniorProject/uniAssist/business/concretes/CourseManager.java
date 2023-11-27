package SeniorProject.uniAssist.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import SeniorProject.uniAssist.business.abstracts.CourseService;
import SeniorProject.uniAssist.business.requests.CreateCourseRequest;
import SeniorProject.uniAssist.business.responses.GetAllCoursesResponse;
import SeniorProject.uniAssist.core.utilities.mappers.ModelMapperService;
import SeniorProject.uniAssist.dataAccess.abstracts.CourseRepository;
import SeniorProject.uniAssist.entities.concretes.Course;
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
