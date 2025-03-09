package SkiStation.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Piste implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numPiste;

    String namePiste;

    @Enumerated(EnumType.STRING)
    Color color;

    int length;

    int slope;

    @ManyToMany(mappedBy = "pistes")
    List<Skier> skiers;
}