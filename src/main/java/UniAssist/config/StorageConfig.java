package UniAssist.config;

import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class StorageConfig {
	
	private Storage storage = new Storage();
	


	public static class Storage{
		
		String root = "uploads";
		String profile = "profiles";
		
		public String getRoot() {
			return root;
		}
		public String getProfile() {
			return profile;
		}
		public void setRoot(String root) {
			this.root = root;
		}
		public void setProfile(String profile) {
			this.profile = profile;
		}
		
		
	}



	
	
}
