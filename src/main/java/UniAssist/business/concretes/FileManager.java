package UniAssist.business.concretes;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import UniAssist.business.abstracts.FileService;
import UniAssist.dataAccess.abstracts.CourseRepository;
import UniAssist.dataAccess.abstracts.FileDataRepository;
import UniAssist.entities.concretes.Course;
import UniAssist.entities.concretes.FileData;

@Service
public class FileManager implements FileService{

    String uploadDir = "C:\\Users\\ercem\\Desktop\\Files";
    
    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private FileDataRepository fileDataRepository;

   
    public void savePdfFile(MultipartFile pdfFile, int courseId) throws IOException{

    	Course course = courseRepository.findById(courseId);
        
        FileData fileData = new FileData();
        fileData.setName(pdfFile.getOriginalFilename());
        fileData.setType(pdfFile.getContentType());
        fileData.setFilePath("uploadDir" + pdfFile.getOriginalFilename());
        fileData.setCourse(course);
        fileDataRepository.save(fileData);

        String filePath = uploadDir + "/" + Objects.requireNonNull(pdfFile.getOriginalFilename());
        File file = new File(filePath);
        pdfFile.transferTo(file);
    }

    public void saveWordFile(MultipartFile wordFile, int courseId) throws IOException {
    	
    	Course course = courseRepository.findById(courseId);
        
        FileData fileData = new FileData();
        fileData.setName(wordFile.getOriginalFilename());
        fileData.setType(wordFile.getContentType());
        fileData.setFilePath("uploadDir" + wordFile.getOriginalFilename());
        fileData.setCourse(course);
        fileDataRepository.save(fileData);
      
        String filePath = uploadDir + "/" + Objects.requireNonNull(wordFile.getOriginalFilename());
        File file = new File(filePath);
        wordFile.transferTo(file);
    }

    public byte[] readPdfFile(String fileName) throws IOException {
       
    	String filePath = uploadDir + "/" + fileName;
        File file = new File(filePath);

        try (PDDocument document = PDDocument.load(file)) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            document.save(outputStream);
            return outputStream.toByteArray();
        }
    }

    public byte[] readWordFile(String fileName) throws IOException {
        
    	String filePath = uploadDir + "/" + fileName;
        File file = new File(filePath);

        try (FileInputStream inputStream = new FileInputStream(file)) {
            XWPFDocument document = new XWPFDocument(inputStream);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            document.write(outputStream);

            return outputStream.toByteArray();
        }
    }

    

}
