package SkiStation.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Skier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numSkier;

    String firstName;
    String lastName;
    LocalDate dateOfBirth;
    String city;

    @OneToMany(mappedBy = "skier", cascade = CascadeType.ALL)
    List<Registration> registrations;

    @ManyToOne
    @JoinColumn(name = "subscription_id")
    @JsonBackReference
    Subscription subscription;

    @ManyToMany
    @JoinTable(
            name = "skier_piste",
            joinColumns = @JoinColumn(name = "skier_id"),
            inverseJoinColumns = @JoinColumn(name = "piste_id")
    )

    List<Piste> pistes;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
