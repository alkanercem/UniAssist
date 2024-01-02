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
import UniAssist.business.requests.CvRequest;
import UniAssist.dataAccess.abstracts.StudentCvRepository;
import UniAssist.dataAccess.abstracts.StudentRepository;
import UniAssist.entities.concretes.Student;
import UniAssist.entities.concretes.StudentCV;

@Service
public class CVManager implements CVService {
   
	@Autowired
    private StudentRepository studentRepository;
   
    @Autowired
    private TemplateEngine templateEngine;
    
    @Autowired
    private StudentCvRepository studentCvRepository;
    
    
    @Override
    public void generatePDF(CvRequest cvRequest) throws IOException, DocumentException {
    	Student student = new Student();
        student = studentRepository.findById(cvRequest.getStudentId());
        if (student == null) 
        	throw new RuntimeException("Öğrenci bulunamadı ID: " + cvRequest.getStudentId());
            
        StudentCV studentCV = new StudentCV();
        studentCV.setStudent(student);
        studentCV.setAboutMe(cvRequest.getAboutMe());
        studentCV.setSkills(cvRequest.getSkills());
        studentCV.setExperience(cvRequest.getExperience());
            
        studentCvRepository.save(studentCV);    
      
        String aboutMe = cvRequest.getAboutMe();
        String skills = cvRequest.getSkills();
        String experience = cvRequest.getExperience();
        
        Context context = new Context();
        
        context.setVariable("student", student);
        context.setVariable("aboutMe", aboutMe);
        context.setVariable("skills", skills);
        context.setVariable("experience", experience);

        String processedHtml = templateEngine.process("cv-template", context);

        String fileName = "cv_" + cvRequest.getStudentId() + ".pdf";
        Document document = new Document();

        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(processedHtml.getBytes()));
        document.close();        
    }   
}


