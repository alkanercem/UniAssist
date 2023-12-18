package UniAssist.business.abstracts;

import java.util.List;
import java.util.Map;

public interface WebScrapingService {
	
	List<Map<String, String>> scrapeAnnouncements();
	List<String> scrapeEvents();

}
