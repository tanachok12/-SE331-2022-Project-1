package se331.rest.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.processing.Generated;
import se331.rest.entity.Comment;
import se331.rest.entity.CommentDTO;
import se331.rest.entity.Event;
import se331.rest.entity.EventDTO;
import se331.rest.entity.EventOrganizerDTO;
import se331.rest.entity.Organizer;
import se331.rest.entity.OrganizerAuthDTO;
import se331.rest.entity.OrganizerDTO;
import se331.rest.entity.OrganizerOwnEventsDTO;
import se331.rest.entity.Participant;
import se331.rest.entity.Vaccine;
import se331.rest.entity.VaccineDTO;
import se331.rest.security.entity.User;
import se331.rest.security.entity.UserDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-31T20:13:37+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
public class LabMapperImpl implements LabMapper {

    @Override
    public EventDTO getEventDto(Event event) {
        if ( event == null ) {
            return null;
        }

        EventDTO.EventDTOBuilder eventDTO = EventDTO.builder();

        eventDTO.id( event.getId() );
        eventDTO.name( event.getName() );
        eventDTO.location( event.getLocation() );
        eventDTO.vaccine1( event.getVaccine1() );
        eventDTO.vaccine2( event.getVaccine2() );
        eventDTO.vaccine3( event.getVaccine3() );
        eventDTO.age( event.getAge() );
        eventDTO.durationTime1( event.getDurationTime1() );
        eventDTO.durationTime2( event.getDurationTime2() );
        eventDTO.durationTime3( event.getDurationTime3() );
        eventDTO.addimg( event.getAddimg() );
        eventDTO.organizer( organizerToEventOrganizerDTO( event.getOrganizer() ) );
        List<String> list = event.getImageUrls();
        if ( list != null ) {
            eventDTO.imageUrls( new ArrayList<String>( list ) );
        }
        eventDTO.commentList( getCommentDto( event.getCommentList() ) );

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
    public VaccineDTO getVaccineDto(Vaccine vaccine) {
        if ( vaccine == null ) {
            return null;
        }

        VaccineDTO.VaccineDTOBuilder vaccineDTO = VaccineDTO.builder();

        vaccineDTO.id( vaccine.getId() );
        vaccineDTO.vaccine( vaccine.getVaccine() );
        vaccineDTO.vaccine2( vaccine.getVaccine2() );
        vaccineDTO.vaccine3( vaccine.getVaccine3() );

        return vaccineDTO.build();
    }

    @Override
    public CommentDTO getCommentDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDTO.CommentDTOBuilder commentDTO = CommentDTO.builder();

        commentDTO.id( comment.getId() );
        commentDTO.name( comment.getName() );
        commentDTO.comment( comment.getComment() );

        return commentDTO.build();
    }

    @Override
    public List<CommentDTO> getCommentDto(List<Comment> comments) {
        if ( comments == null ) {
            return null;
        }

        List<CommentDTO> list = new ArrayList<CommentDTO>( comments.size() );
        for ( Comment comment : comments ) {
            list.add( getCommentDto( comment ) );
        }

        return list;
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
    public List<VaccineDTO> getVaccineDto(List<Vaccine> vaccine) {
        if ( vaccine == null ) {
            return null;
        }

        List<VaccineDTO> list = new ArrayList<VaccineDTO>( vaccine.size() );
        for ( Vaccine vaccine1 : vaccine ) {
            list.add( getVaccineDto( vaccine1 ) );
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
        organizerDTO.ownEvents( eventListToOrganizerOwnEventsDTOList( organizer.getOwnEvents() ) );

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

    protected OrganizerOwnEventsDTO eventToOrganizerOwnEventsDTO(Event event) {
        if ( event == null ) {
            return null;
        }

        OrganizerOwnEventsDTO.OrganizerOwnEventsDTOBuilder organizerOwnEventsDTO = OrganizerOwnEventsDTO.builder();

        organizerOwnEventsDTO.id( event.getId() );
        organizerOwnEventsDTO.name( event.getName() );
        organizerOwnEventsDTO.vaccine1( event.getVaccine1() );
        organizerOwnEventsDTO.vaccine2( event.getVaccine2() );
        organizerOwnEventsDTO.vaccine3( event.getVaccine3() );
        organizerOwnEventsDTO.age( event.getAge() );
        organizerOwnEventsDTO.durationTime1( event.getDurationTime1() );
        organizerOwnEventsDTO.durationTime2( event.getDurationTime2() );
        organizerOwnEventsDTO.durationTime3( event.getDurationTime3() );
        organizerOwnEventsDTO.location( event.getLocation() );
        organizerOwnEventsDTO.addimg( event.getAddimg() );
        List<Participant> list = event.getParticipants();
        if ( list != null ) {
            organizerOwnEventsDTO.participants( new ArrayList<Participant>( list ) );
        }

        return organizerOwnEventsDTO.build();
    }

    protected List<OrganizerOwnEventsDTO> eventListToOrganizerOwnEventsDTOList(List<Event> list) {
        if ( list == null ) {
            return null;
        }

        List<OrganizerOwnEventsDTO> list1 = new ArrayList<OrganizerOwnEventsDTO>( list.size() );
        for ( Event event : list ) {
            list1.add( eventToOrganizerOwnEventsDTO( event ) );
        }

        return list1;
    }
}
