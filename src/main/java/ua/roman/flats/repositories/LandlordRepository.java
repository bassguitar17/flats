package ua.roman.flats.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.roman.flats.domain.Landlord;

public interface LandlordRepository extends CrudRepository<Landlord, Long> {
}
