package UniAssist.business.concretes;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import UniAssist.business.abstracts.CVService;
import UniAssist.business.requests.CVRequest;
import UniAssist.dataAccess.abstracts.StudentRepository;
import UniAssist.entities.concretes.Student;
import UniAssist.entities.concretes.StudentCV;

@Service
public class CVManager implements CVService {
   
	@Autowired
    private StudentRepository studentRepository;
   
    @Autowired
    private TemplateEngine templateEngine;
	
    @Override
    public void createCV(CVRequest cvRequest) throws IOException, DocumentException{
    	if (cvRequest != null) {
    		System.out.println("kontrol-1");
    		Student student = studentRepository.findById(cvRequest.getStudentId());
    		
            StudentCV studentCV = new StudentCV();
            studentCV.setStudent(student);
            studentCV.setAboutMe(cvRequest.getAboutMe());
            studentCV.setSkills(cvRequest.getSkills());
            studentCV.setExperience(cvRequest.getExperience());

            student.setStudentCV(studentCV);

            studentRepository.save(student);
           
				generatePDF(studentCV);
			
        } else {
            throw new RuntimeException("Öğrenci bulunamadı e-posta: " + cvRequest.getStudentId());
        }
        
    }
    @Override
    public void generatePDF(StudentCV studentCV) throws IOException, DocumentException {
        Context context = new Context();
        context.setVariable("aboutMe", studentCV.getAboutMe());
        context.setVariable("skills", studentCV.getSkills());
        context.setVariable("experience", studentCV.getExperience());

        String processedHtml = templateEngine.process("cv-template", context);

        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("cv_" + studentCV.getStudent().getId() + ".pdf"));
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(processedHtml.getBytes()));
        document.close();
    }
    
 
    
}


