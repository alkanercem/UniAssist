package UniAssist.webApi;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import UniAssist.business.concretes.StorageManager;


@RestController
@RequestMapping("/image")
public class StorageController {

	@Autowired
	private StorageManager storageManager;

	@PostMapping("/add/{roleName}/{mail}")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file, @PathVariable String roleName, @PathVariable String mail) throws IOException {
            String uploadImage = storageManager.uploadImage(file, roleName, mail);
            return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }
	

	@GetMapping("/{id}")
	public ResponseEntity<?> downloadImage(@PathVariable int id){
		byte[] imageData=storageManager.downloadImage(id);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);
	}


}