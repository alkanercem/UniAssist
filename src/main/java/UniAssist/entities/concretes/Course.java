package UniAssist.entities.concretes;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="courses")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne 
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;
	
	@Column(name="name")
	private String name;
	
	@Column(name="department_name")
	private String departmentName;
	
	@Column(name="section_name")
	private String sectionName;
	
	@Column(name="semester_name")
	private String semesterName;
	
	@Column(name="course_class")
	private int courseClass;
	
	@Column(name="credit_hours")
	private int creditHours;
	
	@Column(name = "day")
	private String day; // Pazartesi, Salı, Çarşamba, ...

	@Column(name = "time_interval")
	private String timeInterval; // 8-10, 10-12, ...
	
	@Column(name = "exam_time")
	private String examTime; // 8-10, 10-12, ...
	
	@OneToMany(mappedBy = "course")
	List<Grade> grade;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<FileData> pdfFiles;
	

}
