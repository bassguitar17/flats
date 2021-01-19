package ua.roman.flats.domain.name;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.roman.flats.domain.Address;
import ua.roman.flats.domain.ConstantsDatabase;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NameVoivodeship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = ConstantsDatabase.NAME_VOIVODESHIP, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Address> addresses = new HashSet<>();

    public NameVoivodeship(String name) {
        this.name = name;
    }
}