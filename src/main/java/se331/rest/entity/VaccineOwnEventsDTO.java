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
public class VaccineOwnEventsDTO {
    Long id;
    String patient;
    String title;
    String surname;
    String age;
    String location;
    Boolean petAllowed;
    List<Participant> participants;
}

