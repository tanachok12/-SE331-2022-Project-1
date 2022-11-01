package se331.rest.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.processing.Generated;
import se331.rest.entity.Comment;
import se331.rest.entity.CommentDTO;
import se331.rest.entity.Organizer;
import se331.rest.entity.OrganizerAuthDTO;
import se331.rest.entity.OrganizerDTO;
import se331.rest.entity.OrganizerOwnPatientsDTO;
import se331.rest.entity.Participant;
import se331.rest.entity.Patient;
import se331.rest.entity.PatientDTO;
import se331.rest.entity.PatientOrganizerDTO;
import se331.rest.entity.Vaccine;
import se331.rest.entity.VaccineDTO;
import se331.rest.security.entity.User;
import se331.rest.security.entity.UserDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-01T15:32:01+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
public class LabMapperImpl implements LabMapper {

    @Override
    public PatientDTO getPatientDto(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientDTO.PatientDTOBuilder patientDTO = PatientDTO.builder();

        patientDTO.id( patient.getId() );
        patientDTO.name( patient.getName() );
        patientDTO.location( patient.getLocation() );
        patientDTO.vaccine1( patient.getVaccine1() );
        patientDTO.vaccine2( patient.getVaccine2() );
        patientDTO.age( patient.getAge() );
        patientDTO.durationTime1( patient.getDurationTime1() );
        patientDTO.durationTime2( patient.getDurationTime2() );
        patientDTO.durationTime3( patient.getDurationTime3() );
        patientDTO.addimg( patient.getAddimg() );
        patientDTO.organizer( organizerToPatientOrganizerDTO( patient.getOrganizer() ) );
        List<String> list = patient.getImageUrls();
        if ( list != null ) {
            patientDTO.imageUrls( new ArrayList<String>( list ) );
        }
        patientDTO.commentList( getCommentDto( patient.getCommentList() ) );

        return patientDTO.build();
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
    public List<PatientDTO> getPatientDto(List<Patient> patients) {
        if ( patients == null ) {
            return null;
        }

        List<PatientDTO> list = new ArrayList<PatientDTO>( patients.size() );
        for ( Patient patient : patients ) {
            list.add( getPatientDto( patient ) );
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
        organizerDTO.ownPatients( patientListToOrganizerOwnPatientsDTOList( organizer.getOwnPatients() ) );

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

    protected PatientOrganizerDTO organizerToPatientOrganizerDTO(Organizer organizer) {
        if ( organizer == null ) {
            return null;
        }

        PatientOrganizerDTO.PatientOrganizerDTOBuilder patientOrganizerDTO = PatientOrganizerDTO.builder();

        patientOrganizerDTO.id( organizer.getId() );
        patientOrganizerDTO.name( organizer.getName() );

        return patientOrganizerDTO.build();
    }

    protected OrganizerOwnPatientsDTO patientToOrganizerOwnPatientsDTO(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        OrganizerOwnPatientsDTO.OrganizerOwnPatientsDTOBuilder organizerOwnPatientsDTO = OrganizerOwnPatientsDTO.builder();

        organizerOwnPatientsDTO.id( patient.getId() );
        organizerOwnPatientsDTO.name( patient.getName() );
        organizerOwnPatientsDTO.vaccine1( patient.getVaccine1() );
        organizerOwnPatientsDTO.vaccine2( patient.getVaccine2() );
        organizerOwnPatientsDTO.age( patient.getAge() );
        organizerOwnPatientsDTO.durationTime1( patient.getDurationTime1() );
        organizerOwnPatientsDTO.durationTime2( patient.getDurationTime2() );
        organizerOwnPatientsDTO.durationTime3( patient.getDurationTime3() );
        organizerOwnPatientsDTO.location( patient.getLocation() );
        organizerOwnPatientsDTO.addimg( patient.getAddimg() );
        List<Participant> list = patient.getParticipants();
        if ( list != null ) {
            organizerOwnPatientsDTO.participants( new ArrayList<Participant>( list ) );
        }

        return organizerOwnPatientsDTO.build();
    }

    protected List<OrganizerOwnPatientsDTO> patientListToOrganizerOwnPatientsDTOList(List<Patient> list) {
        if ( list == null ) {
            return null;
        }

        List<OrganizerOwnPatientsDTO> list1 = new ArrayList<OrganizerOwnPatientsDTO>( list.size() );
        for ( Patient patient : list ) {
            list1.add( patientToOrganizerOwnPatientsDTO( patient ) );
        }

        return list1;
    }
}
