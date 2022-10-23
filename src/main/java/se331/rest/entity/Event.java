package se331.rest.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    String id;
    String patient;
    String title;
    String surname;
    String age;
    String location;
    Boolean petAllowed;
    @ManyToOne
    Vaccine vaccine;
    @ManyToMany(mappedBy = "eventHistory")
    List<Participant> participants;
    @ElementCollection
    List<String> imageUrls;


}


