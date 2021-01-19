package ua.roman.flats.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.roman.flats.domain.name.NameCity;
import ua.roman.flats.domain.name.NameDistrict;
import ua.roman.flats.domain.name.NameVoivodeship;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String street;
    private int buildingNumber;
    private int flatNumber;
    private int distanceToMainStation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ConstantsDatabase.ID_VOIVODESHIP)
    private NameVoivodeship nameVoivodeship;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ConstantsDatabase.ID_CITY)
    private NameCity nameCity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ConstantsDatabase.ID_DISTRICT)
    private NameDistrict nameDistrict;

    @OneToMany(mappedBy = ConstantsDatabase.ADDRESS, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Advertisement> advertisements = new HashSet<>();

    public Address(String street, int buildingNumber, int flatNumber, int distanceToMainStation) {
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.flatNumber = flatNumber;
        this.distanceToMainStation = distanceToMainStation;
    }

    public Address(String street, int buildingNumber, int flatNumber, int distanceToMainStation, NameVoivodeship nameVoivodeship, NameCity nameCity, NameDistrict nameDistrict) {
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.flatNumber = flatNumber;
        this.distanceToMainStation = distanceToMainStation;
        this.nameVoivodeship = nameVoivodeship;
        this.nameCity = nameCity;
        this.nameDistrict = nameDistrict;
    }
}
