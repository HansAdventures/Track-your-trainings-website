package trackYourTraining.demo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Builder
@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private long id;
    private String datum;
    private String opwarming;
    private String gevoelOpwarming;
    private String soortTraining;
    private String uitlegTraining;
    private String gevoelTraining;
//    private String trainer;
//    private String feedback;

}