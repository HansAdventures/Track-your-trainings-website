package trackYourTraining.demo.service;



import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import trackYourTraining.demo.Dto.TrainingDto;
import trackYourTraining.demo.domain.Training;
import trackYourTraining.demo.repository.TrainingRepository;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class TrainingService {

    private final TrainingRepository trainingRepository;

    public void addNewTraining (TrainingDto.TrainingAddrequest request){
        Training training = Training.builder()
                .datum(changeDate(request))
                .opwarming(request.getOpwarming())
                .gevoelOpwarming(request.getGevoelOpwarming())
                .soortTraining(request.getSoortTraining())
                .uitlegTraining((request.getUitlegTraining()))
                .gevoelTraining(request.getGevoelTraining())

//                .trainer(request.getTrainer())
//                .feedback(request.getFeedback())
                .build();
        trainingRepository.save(training);
    }

    public String changeDate(TrainingDto.TrainingAddrequest request){
        String date = request.getDatum();
        String[] splitDate = date.split("-");

        return (splitDate[2]+"-"+splitDate[1]+"-"+splitDate[0]);
    }

    public Training getTrainingByDate(String date){
        return trainingRepository.findByDatum(date);
    }

    public List<Training> getTrainings(){
        return trainingRepository.findAll();
    }

    public List<Training> findTrainingByDatumBetween(Date date1, Date date2){
        return findTrainingByDatumBetween(date1, date2);
    }
}
