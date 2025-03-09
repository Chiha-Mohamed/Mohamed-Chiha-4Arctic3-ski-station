package SkiStation.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subscription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numSub;

    LocalDate startDate;
    LocalDate endDate;
    Float price;

    @Enumerated(EnumType.STRING)
    TypeSubscription typeSub;

    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Skier> skiers;
}
