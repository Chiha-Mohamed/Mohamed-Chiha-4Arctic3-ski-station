package SkiStation.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Registration implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numRegistration;

    int numWeek;

    @ManyToOne
    @JoinColumn(name = "skier_id")
    Skier skier;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;
}
