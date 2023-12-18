package UniAssist.business.concretes;

import org.springframework.stereotype.Service;

import UniAssist.business.abstracts.WebScrapingService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

@Service
public class WebScrapingManager implements WebScrapingService {
	 
	@Override
	public List<Map<String, String>> scrapeAnnouncements() {
	    List<Map<String, String>> announcements = new ArrayList<>();

	    try {
	        Document document = Jsoup.connect("https://muh.karabuk.edu.tr/index.aspx").get();
	        Elements newsPosts = document.select("#alanDuyuru .news-post");

	        for (Element newsPost : newsPosts) {
	            String title = newsPost.select("h3 a").text();
	            String link = newsPost.select("h3 a").attr("href");

	            System.out.println("Title: " + title);
	            System.out.println("Link: " + link);
	            System.out.println("----------------------");

	            Map<String, String> announcementMap = new HashMap<>();
	            announcementMap.put("title", title);
	            announcementMap.put("link", "https://muh.karabuk.edu.tr" + link);
	            announcements.add(announcementMap);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return announcements;
	}

	 
	@Override
	public List<String> scrapeEvents() {
		
		List<String> events = new ArrayList<>();
        
		 try {
	            Document document = Jsoup.connect("https://muh.karabuk.edu.tr/index.aspx").get();
	            Elements newsEvents = document.select("#alanEtkinlikler .event-post");

	            for (Element newEvent : newsEvents) {
	                String title = newEvent.select("h3 a").text();
	                String link = newEvent.select("h3 a").attr("href");

	                System.out.println("Title: " + title);
	                System.out.println("Link: " + link);
	                System.out.println("----------------------");

	                events.add("Title: " + title + ", Link: https://muh.karabuk.edu.tr" + link);
	            }
	        } 
		 catch (IOException e) {
	            e.printStackTrace();
	        }
		 return events;
	    }
	}