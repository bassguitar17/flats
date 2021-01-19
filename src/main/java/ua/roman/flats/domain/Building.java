package ua.roman.flats.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.roman.flats.domain.type.TypeConstruction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private boolean lift;
    private int numberOfFloors;
    private int floor;
    private int year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ConstantsDatabase.ID_CONSTRUCTION_TYPE)
    private TypeConstruction typeConstruction;

    @OneToMany(mappedBy = ConstantsDatabase.BUILDING, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Advertisement> advertisements = new HashSet<>();

    public Building(boolean lift, int numberOfFloors, int floor, int year, TypeConstruction typeConstruction) {
        this.lift = lift;
        this.numberOfFloors = numberOfFloors;
        this.floor = floor;
        this.year = year;
        this.typeConstruction = typeConstruction;
    }
}
