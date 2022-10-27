package se331.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizerOwnEventsDTO {
    Long id;

    String name;
    String vaccine1;
    String vaccine2;
    String vaccine3;
    String age;
    String durationTime1;
    String durationTime2;
    String durationTime3;
    String description;
    String location;
    String addimg;


    List<Participant> participants;
}

