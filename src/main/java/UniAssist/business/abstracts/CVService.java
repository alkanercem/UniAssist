package UniAssist.business.abstracts;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

import UniAssist.business.requests.CvRequest;

public interface CVService {
	 void generatePDF(CvRequest cvRequest) throws IOException,DocumentException;
}
