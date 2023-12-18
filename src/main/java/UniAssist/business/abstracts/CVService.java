package UniAssist.business.abstracts;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

import UniAssist.business.requests.CVRequest;
import UniAssist.entities.concretes.StudentCV;

public interface CVService {
	 void createCV(CVRequest cvRequest) throws IOException, DocumentException;
	 void generatePDF(StudentCV studentCV) throws IOException,DocumentException;

}
