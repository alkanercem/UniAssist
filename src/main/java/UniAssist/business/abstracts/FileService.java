package UniAssist.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	
	void savePdfFile(MultipartFile pdfFile, int teacherId) throws IOException;
	void saveWordFile(MultipartFile wordFile, int teacherId) throws IOException;
	byte[] readPdfFile(String fileName) throws IOException;
	byte[] readWordFile(String fileName) throws IOException;

}
