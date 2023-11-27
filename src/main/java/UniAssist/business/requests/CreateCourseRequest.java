package UniAssist.business.requests;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseRequest {
	
	@NotNull
	@NotBlank
	@Size(min=5, max=20)
	private String Name;
	
	@NotNull
	@NotBlank
	@Size(min=5, max=20)
	private String departmentName;
	
	@NotNull
	@NotBlank
	@Size(min=5, max=20)
	private String semesterName;
	
	
	private int courseClass;
	
	
	private int creditHours;
	
}
