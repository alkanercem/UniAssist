package SeniorProject.uniAssist.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="grades")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Grade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne 
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne 
	@JoinColumn(name = "course_id")
	private Course course;
	
	@Column(name="grade")
	private float grade;
	
	@Column(name="attendance")
	private int attendanceStatus;
	
	
}
