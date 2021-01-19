package ua.roman.flats.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.roman.flats.domain.Flat;

public interface FlatRepository extends CrudRepository<Flat, Long> {
}
