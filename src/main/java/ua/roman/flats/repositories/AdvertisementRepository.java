package ua.roman.flats.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.roman.flats.domain.Advertisement;

public interface AdvertisementRepository extends CrudRepository<Advertisement, Long> {
}
