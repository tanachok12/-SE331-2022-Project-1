package se331.rest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    String id;
    String title;
    String telNo;
    @ManyToMany
    List<Event> eventHistory;
}

