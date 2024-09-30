package trackYourTraining.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trackYourTraining.demo.domain.Training;

import java.util.Date;
import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

    Training findByDatum(String date);

    List<Training> findTrainingByDatumBetween(String date1, String date2);
}
