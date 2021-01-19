package ua.roman.flats.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.roman.flats.domain.Building;

import java.util.List;
import java.util.Set;

public interface BuildingRepository extends CrudRepository<Building, Long> {

    Integer countByFloor(int floor);
    boolean existsByFloor(int floor);
    List<Building> findAllByFloorIsNotAndLiftTrue(int floor);
    Set<Building> findBuildingsByTypeConstructionIsNotNull();
}
