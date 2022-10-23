package se331.rest.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import se331.rest.entity.*;
import se331.rest.security.entity.User;
import se331.rest.security.entity.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = Collectors.class)
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    EventDTO getEventDto(Event event);

    UserDTO getUserDTO(User user);
    List<EventDTO> getEventDto(List<Event> events);

    VaccineDTO getVaccineDTO(Vaccine vaccine);

    List<VaccineDTO> getVaccineDTO(List<Vaccine> vaccines);

    @Mapping(target = "authorities", expression = "java(vaccine.getUser().getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()))")
    VaccineAuthDTO getVaccineAuthDTO(Vaccine vaccine);

}