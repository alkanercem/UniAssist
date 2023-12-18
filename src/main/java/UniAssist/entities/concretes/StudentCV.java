package UniAssist.entities.concretes;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "student_cv")
@Data
@NoArgsConstructor
@Entity
public class StudentCV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "about_me")
    private String aboutMe;

    @Column(name = "skills")
    private String skills;

    @Column(name = "experience")
    private String experience;

}
