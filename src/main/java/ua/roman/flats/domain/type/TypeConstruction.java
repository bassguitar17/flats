package ua.roman.flats.domain.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeConstruction {

    @Id
    private int id;

    private String name;

    public TypeConstruction(String name) {
        this.name = name;
    }
}