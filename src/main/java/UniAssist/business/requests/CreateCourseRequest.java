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
	
	private String sectionName;
	
	@NotNull
	@NotBlank
	@Size(min=5, max=20)
	private String semesterName;
	
	private String firstName;

    private String lastName;
    
	private int courseClass;
	
	private int creditHours;
	
	private String day; // Pazartesi, Salı, Çarşamba, ...

	private String timeInterval; // 8-10, 10-12, ...
			
	private String examTime; // 8-10, 10-12, ...

	
}
