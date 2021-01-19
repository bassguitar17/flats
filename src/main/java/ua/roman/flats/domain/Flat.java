package ua.roman.flats.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.roman.flats.domain.type.TypeHeating;
import ua.roman.flats.domain.type.TypeMarket;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private int area;
    private BigDecimal price;
    private int numberOfRooms;
    private boolean isBalcony;
    private boolean isKitchenette;
    private boolean isFurnished;
    private boolean isAirCondition;
    private boolean isToRenovation;
    private BigDecimal rent;

    @OneToMany(mappedBy = ConstantsDatabase.FLAT, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Advertisement> advertisements = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ConstantsDatabase.ID_HEATING)
    private TypeHeating typeHeating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ConstantsDatabase.ID_MARKET)
    private TypeMarket typeMarket;
}
