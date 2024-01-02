package UniAssist.business.concretes;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import UniAssist.dataAccess.abstracts.StorageRepository;
import UniAssist.dataAccess.abstracts.StudentRepository;
import UniAssist.dataAccess.abstracts.TeacherRepository;
import UniAssist.entities.concretes.ImageData;
import UniAssist.entities.concretes.Student;
import UniAssist.entities.concretes.Teacher;
import UniAssist.util.ImageUtils;

@Transactional
@Service
public class StorageManager {
	
	@Autowired
    private StorageRepository storageRepository;
	
	@Autowired
    private StudentRepository studentRepository;
	
	@Autowired
    private TeacherRepository teacherRepository;


	public String uploadImage(MultipartFile file, String role, String mail) throws IOException {
		
		if ("student".equals(role)) {
	        Student student = studentRepository.findByMail(mail);
	        
	    if (student == null) 
	        return "Student not found with email: " + mail;
	        
	        ImageData imageData = storageRepository.save(ImageData.builder()
	                .name(file.getOriginalFilename())
	                .type(file.getContentType())
	                .imageData(ImageUtils.compressImage(file.getBytes()))
	                .student(student)
	                .build());
	        if (imageData != null) {
	            student.setImageData(imageData);
	            studentRepository.save(student); // Save the updated student entity
	            return "Image Uploaded Successfully for Student: " + file.getOriginalFilename();
	        }
	    } 
		else if ("teacher".equals(role)) {
	        Teacher teacher = teacherRepository.findByMail(mail);
	        if (teacher == null) 
	            return "Teacher not found with email: " + mail;        

	        ImageData imageData = storageRepository.save(ImageData.builder()
	                .name(file.getOriginalFilename())
	                .type(file.getContentType())
	                .imageData(ImageUtils.compressImage(file.getBytes()))
	                .teacher(teacher)
	                .build());

	        if (imageData != null) {
	            teacher.setImageData(imageData);
	            teacherRepository.save(teacher); // Save the updated teacher entity
	            return "Image Uploaded Successfully for Teacher: " + file.getOriginalFilename();
	        }
	    }

	    return "Invalid role: " + role;
	}
    
    public byte[] downloadImage(int id) {
    	Student student = studentRepository.findById(id);
    	Optional<ImageData> ImageData = storageRepository.findById(id);
        byte[] images = ImageUtils.decompressImage(ImageData.get().getImageData());
        return images;
    }

}
