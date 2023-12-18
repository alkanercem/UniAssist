package UniAssist.business.concretes;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import UniAssist.business.abstracts.FileService;

@Service
public class FileManager implements FileService{

    String uploadDir = "C:\\Users\\ercem\\Desktop\\Files";

    public void savePdfFile(MultipartFile pdfFile) throws IOException {
        
        String filePath = uploadDir + "/" + Objects.requireNonNull(pdfFile.getOriginalFilename());
        File file = new File(filePath);
        pdfFile.transferTo(file);
    }

    public void saveWordFile(MultipartFile wordFile) throws IOException {
      
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
