package UniAssist.webApi;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UniAssist.business.abstracts.WebScrapingService;

@RestController
@RequestMapping("/scraping")
public class WebScrapingController {
	
	private WebScrapingService webScrapingService;

    @Autowired
    public WebScrapingController(WebScrapingService webScrapingService) {
        this.webScrapingService = webScrapingService;
    }

    @GetMapping("/announcements")
    public  List<Map<String, String>> GetAnnouncements() {
    	return webScrapingService.scrapeAnnouncements();     
    }
    
    @GetMapping("/events")
    public List<String> GetEvents() {
    	return webScrapingService.scrapeEvents();     
    }
}