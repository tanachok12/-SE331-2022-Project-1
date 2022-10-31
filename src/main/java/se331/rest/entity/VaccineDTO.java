package se331.rest.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VaccineDTO {
    Long id;

    String vaccine;
    String vaccine2;
    String vaccine3;
}
