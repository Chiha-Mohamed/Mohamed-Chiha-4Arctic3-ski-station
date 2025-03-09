package SkiStation.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Instructor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numInstructor;

    String firstName;
    String lastName;
    LocalDate dateOfHire;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Course> courses;
}
