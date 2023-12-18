package UniAssist.webApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import UniAssist.business.abstracts.FileService;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@RequestMapping("/file")
@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping(value = "/upload/pdf", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadPdf(@RequestParam("file") MultipartFile pdfFile) throws IOException {
        fileService.savePdfFile(pdfFile);
        return ResponseEntity.ok("PDF file uploaded successfully.");
    }

    @PostMapping(value = "/upload/word", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadWord(@RequestParam("file") MultipartFile wordFile) throws IOException {
        fileService.saveWordFile(wordFile);
        return ResponseEntity.ok("Word file uploaded successfully.");
    }

    @GetMapping("/download/pdf/{fileName}")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable String fileName) throws IOException {
        byte[] pdfBytes = fileService.readPdfFile(fileName);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }

    @GetMapping(value = "/download/word/{fileName}", produces = "application/vnd.openxmlformats-officedocument.wordprocessingml.document")
    public ResponseEntity<byte[]> downloadWord(@PathVariable String fileName,HttpServletResponse response) throws IOException {
    	response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");      
    	response.setHeader("Content-Disposition", "attachment; filename=download.docx"); 
        byte[] wordBytes = fileService.readWordFile(fileName);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(wordBytes);
    }
}
