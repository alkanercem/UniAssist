package UniAssist.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import UniAssist.entities.concretes.ImageData;

import java.util.Optional;


public interface StorageRepository extends JpaRepository<ImageData,Long> {
  Optional<ImageData> findByName(String fileName);
  Optional<ImageData> findById(long id);
   
}