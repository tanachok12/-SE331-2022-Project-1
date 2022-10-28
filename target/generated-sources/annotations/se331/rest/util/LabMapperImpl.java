package se331.rest.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.processing.Generated;
import se331.rest.entity.EventDTO;
import se331.rest.entity.EventOrganizerDTO;
import se331.rest.entity.Organizer;
import se331.rest.entity.OrganizerAuthDTO;
import se331.rest.entity.OrganizerDTO;
import se331.rest.entity.Patient;
import se331.rest.security.entity.User;
import se331.rest.security.entity.UserDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-28T18:11:57+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
public class LabMapperImpl implements LabMapper {

    @Override
    public EventDTO getEventDto(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        EventDTO.EventDTOBuilder eventDTO = EventDTO.builder();

        eventDTO.id( patient.getId() );
        eventDTO.name( patient.getName() );
        eventDTO.location( patient.getLocation() );
        eventDTO.vaccine1( patient.getVaccine1() );
        eventDTO.vaccine2( patient.getVaccine2() );
        eventDTO.vaccine3( patient.getVaccine3() );
        eventDTO.age( patient.getAge() );
        eventDTO.durationTime1( patient.getDurationTime1() );
        eventDTO.durationTime2( patient.getDurationTime2() );
        eventDTO.durationTime3( patient.getDurationTime3() );
        eventDTO.addimg( patient.getAddimg() );
        eventDTO.organizer( organizerToEventOrganizerDTO( patient.getOrganizer() ) );
        List<String> list = patient.getImageUrls();
        if ( list != null ) {
            eventDTO.imageUrls( new ArrayList<String>( list ) );
        }

        return eventDTO.build();
    }

    @Override
    public UserDTO getUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.username( user.getUsername() );
        userDTO.email( user.getEmail() );
        userDTO.password( user.getPassword() );

        return userDTO.build();
    }

    @Override
    public List<EventDTO> getEventDto(List<Patient> patients) {
        if ( patients == null ) {
            return null;
        }

        List<EventDTO> list = new ArrayList<EventDTO>( patients.size() );
        for ( Patient patient : patients ) {
            list.add( getEventDto( patient ) );
        }

        return list;
    }

    @Override
    public OrganizerDTO getOrganizerDTO(Organizer organizer) {
        if ( organizer == null ) {
            return null;
        }

        OrganizerDTO.OrganizerDTOBuilder organizerDTO = OrganizerDTO.builder();

        organizerDTO.id( organizer.getId() );
        organizerDTO.name( organizer.getName() );

        return organizerDTO.build();
    }

    @Override
    public List<OrganizerDTO> getOrganizerDTO(List<Organizer> organizers) {
        if ( organizers == null ) {
            return null;
        }

        List<OrganizerDTO> list = new ArrayList<OrganizerDTO>( organizers.size() );
        for ( Organizer organizer : organizers ) {
            list.add( getOrganizerDTO( organizer ) );
        }

        return list;
    }

    @Override
    public OrganizerAuthDTO getOrganizerAuthDTO(Organizer organizer) {
        if ( organizer == null ) {
            return null;
        }

        OrganizerAuthDTO.OrganizerAuthDTOBuilder organizerAuthDTO = OrganizerAuthDTO.builder();

        organizerAuthDTO.id( organizer.getId() );
        organizerAuthDTO.name( organizer.getName() );

        organizerAuthDTO.authorities( organizer.getUser().getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()) );

        return organizerAuthDTO.build();
    }

    protected EventOrganizerDTO organizerToEventOrganizerDTO(Organizer organizer) {
        if ( organizer == null ) {
            return null;
        }

        EventOrganizerDTO.EventOrganizerDTOBuilder eventOrganizerDTO = EventOrganizerDTO.builder();

        eventOrganizerDTO.id( organizer.getId() );
        eventOrganizerDTO.name( organizer.getName() );

        return eventOrganizerDTO.build();
    }
}
