package UniAssist.webApi;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;

import UniAssist.business.abstracts.CVService;
import UniAssist.business.requests.CVRequest;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/cv")
public class CVController {

    @Autowired
    private CVService cvService;

    @PostMapping("/create")
    public ResponseEntity<String> createCV(@RequestBody CVRequest cvRequest) throws IOException, DocumentException {
        this.cvService.createCV(cvRequest);
        return ResponseEntity.ok("CV created");
    }
}