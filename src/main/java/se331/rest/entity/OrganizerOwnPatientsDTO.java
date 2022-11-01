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
public class OrganizerOwnPatientsDTO {
    Long id;

    String name;
    String vaccine1;
    String vaccine2;
    String vaccine3;
    String age;


    String location;
    String addimg;


    List<Participant> participants;
}

