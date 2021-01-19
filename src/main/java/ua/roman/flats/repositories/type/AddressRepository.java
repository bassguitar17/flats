package ua.roman.flats.repositories.type;

import org.springframework.data.repository.PagingAndSortingRepository;
import ua.roman.flats.domain.Address;

import java.util.List;

public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {

    List<Address> findByStreetIgnoreCase(String street);
    List<Address> findByNameCityName(String name);
}
