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
    Long id;

    String name;

    String location;
    String vaccine1;
    String vaccine2;
    String vaccine3;
    String age;
    String durationTime1;
    String durationTime2;
    String durationTime3;
    String addimg;

    @ManyToOne
    Organizer organizer;
    @ManyToMany(mappedBy = "eventHistory")
    List<Participant> participants;
    @ElementCollection
    List<String> imageUrls;


}


