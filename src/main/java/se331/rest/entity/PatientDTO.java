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
public class PatientDTO {
    Long id;

    String name;

    String location;
    String vaccine1;
    String vaccine2;
    String age;

    String addimg;


    PatientOrganizerDTO organizer;
    List<String> imageUrls;
    List<CommentDTO> commentList;

}

