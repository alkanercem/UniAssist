package UniAssist.business.requests;

import lombok.Data;

@Data
public class CvRequest {
    private int studentId;
    private String aboutMe;
    private String skills;
    private String experience;
}