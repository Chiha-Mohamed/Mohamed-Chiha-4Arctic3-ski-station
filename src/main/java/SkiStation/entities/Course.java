package SkiStation.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numCourse;

    int level;

    @Enumerated(EnumType.STRING)
    TypeCourse typeCourse;

    @Enumerated(EnumType.STRING)
    Support support;

    Float price;

    int timeSlot;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "instructor_id")
    Instructor instructor;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    List<Registration> registrations;
}
