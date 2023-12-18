package UniAssist.business.concretes;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import UniAssist.Util.ImageUtils;
import UniAssist.dataAccess.abstracts.StorageRepository;
import UniAssist.entities.concretes.ImageData;

@Transactional
@Service
public class StorageManager {
	
	@Autowired
    private StorageRepository repository;

    public String uploadImage(MultipartFile file) throws IOException {
      
    	ImageData imageData = repository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
    	
        if (imageData != null) {
            return "Image Uploaded Successfully : " + file.getOriginalFilename();
        }      
        return null;
    }
    
    public byte[] downloadImage(String fileName) {
       
    	Optional<ImageData> ImageData = repository.findByName(fileName);
        byte[] images = ImageUtils.decompressImage(ImageData.get().getImageData());
        return images;
    }



}
