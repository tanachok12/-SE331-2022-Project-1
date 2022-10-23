package se331.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VaccineDTO {
    Long id;
    String name;
    List<VaccineOwnEventsDTO> ownEvents = new ArrayList<>();
}
