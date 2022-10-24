package se331.rest.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.processing.Generated;
import se331.rest.entity.Event;
import se331.rest.entity.EventDTO;
import se331.rest.entity.EventOrganizerDTO;
import se331.rest.entity.Participant;
import se331.rest.entity.Vaccine;
import se331.rest.entity.VaccineAuthDTO;
import se331.rest.entity.VaccineDTO;
import se331.rest.entity.VaccineOwnEventsDTO;
import se331.rest.security.entity.User;
import se331.rest.security.entity.UserDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-24T18:44:38+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
public class LabMapperImpl implements LabMapper {

    @Override
    public EventDTO getEventDto(Event event) {
        if ( event == null ) {
            return null;
        }

        EventDTO.EventDTOBuilder eventDTO = EventDTO.builder();

        eventDTO.id( event.getId() );
        eventDTO.patient( event.getPatient() );
        eventDTO.title( event.getTitle() );
        eventDTO.surname( event.getSurname() );
        eventDTO.age( event.getAge() );
        eventDTO.location( event.getLocation() );
        eventDTO.petAllowed( event.getPetAllowed() );
        eventDTO.vaccine( vaccineToEventOrganizerDTO( event.getVaccine() ) );
        List<String> list = event.getImageUrls();
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
    public List<EventDTO> getEventDto(List<Event> events) {
        if ( events == null ) {
            return null;
        }

        List<EventDTO> list = new ArrayList<EventDTO>( events.size() );
        for ( Event event : events ) {
            list.add( getEventDto( event ) );
        }

        return list;
    }

    @Override
    public VaccineDTO getVaccineDTO(Vaccine vaccine) {
        if ( vaccine == null ) {
            return null;
        }

        VaccineDTO.VaccineDTOBuilder vaccineDTO = VaccineDTO.builder();

        vaccineDTO.id( vaccine.getId() );
        vaccineDTO.ownEvents( eventListToVaccineOwnEventsDTOList( vaccine.getOwnEvents() ) );

        return vaccineDTO.build();
    }

    @Override
    public List<VaccineDTO> getVaccineDTO(List<Vaccine> vaccines) {
        if ( vaccines == null ) {
            return null;
        }

        List<VaccineDTO> list = new ArrayList<VaccineDTO>( vaccines.size() );
        for ( Vaccine vaccine : vaccines ) {
            list.add( getVaccineDTO( vaccine ) );
        }

        return list;
    }

    @Override
    public VaccineAuthDTO getVaccineAuthDTO(Vaccine vaccine) {
        if ( vaccine == null ) {
            return null;
        }

        VaccineAuthDTO.VaccineAuthDTOBuilder vaccineAuthDTO = VaccineAuthDTO.builder();

        if ( vaccine.getId() != null ) {
            vaccineAuthDTO.id( String.valueOf( vaccine.getId() ) );
        }
        vaccineAuthDTO.title( vaccine.getTitle() );

        vaccineAuthDTO.authorities( vaccine.getUser().getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()) );

        return vaccineAuthDTO.build();
    }

    protected EventOrganizerDTO vaccineToEventOrganizerDTO(Vaccine vaccine) {
        if ( vaccine == null ) {
            return null;
        }

        EventOrganizerDTO.EventOrganizerDTOBuilder eventOrganizerDTO = EventOrganizerDTO.builder();

        if ( vaccine.getId() != null ) {
            eventOrganizerDTO.id( String.valueOf( vaccine.getId() ) );
        }
        eventOrganizerDTO.title( vaccine.getTitle() );

        return eventOrganizerDTO.build();
    }

    protected VaccineOwnEventsDTO eventToVaccineOwnEventsDTO(Event event) {
        if ( event == null ) {
            return null;
        }

        VaccineOwnEventsDTO.VaccineOwnEventsDTOBuilder vaccineOwnEventsDTO = VaccineOwnEventsDTO.builder();

        if ( event.getId() != null ) {
            vaccineOwnEventsDTO.id( Long.parseLong( event.getId() ) );
        }
        vaccineOwnEventsDTO.patient( event.getPatient() );
        vaccineOwnEventsDTO.title( event.getTitle() );
        vaccineOwnEventsDTO.surname( event.getSurname() );
        vaccineOwnEventsDTO.age( event.getAge() );
        vaccineOwnEventsDTO.location( event.getLocation() );
        vaccineOwnEventsDTO.petAllowed( event.getPetAllowed() );
        List<Participant> list = event.getParticipants();
        if ( list != null ) {
            vaccineOwnEventsDTO.participants( new ArrayList<Participant>( list ) );
        }

        return vaccineOwnEventsDTO.build();
    }

    protected List<VaccineOwnEventsDTO> eventListToVaccineOwnEventsDTOList(List<Event> list) {
        if ( list == null ) {
            return null;
        }

        List<VaccineOwnEventsDTO> list1 = new ArrayList<VaccineOwnEventsDTO>( list.size() );
        for ( Event event : list ) {
            list1.add( eventToVaccineOwnEventsDTO( event ) );
        }

        return list1;
    }
}
