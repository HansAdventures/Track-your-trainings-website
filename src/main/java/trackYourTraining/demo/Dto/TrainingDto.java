package trackYourTraining.demo.Dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TrainingDto {

    @Data
    public static class TrainingAddrequest {

        private String datum;
        private String opwarming;
        private String gevoelOpwarming;
        private String specifiekOnderdeel;
        private String gevoelSpecifiekOnderdeel;
        private String specifiekOnderdeelUitleg;
//        private String trainer;
//        private String feedback;
    }

    public static class TrainingEditrequest{
        private Date datum;
        private String opwarming;
        private int gevoelOpwarming;
        private String specifiekOnderdeel;
        private int gevoelSpecifiekOnderdeel;
 //       private String trainer;
 //       private String feedback;
    }

    public static class TrainingEditResponse{

    }
}
