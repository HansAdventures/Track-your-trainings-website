package trackYourTraining.demo.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import trackYourTraining.demo.Dto.TrainingDto;
import trackYourTraining.demo.domain.Training;
import trackYourTraining.demo.service.TrainingService;

@AllArgsConstructor
@Controller
@RequestMapping("/api")
public class TrainingController {

    private final TrainingService trainingService;



    @PostMapping("/add")
    public String register(@ModelAttribute("training") TrainingDto.TrainingAddrequest request){
        trainingService.addNewTraining(request);
        return "redirect:/api/training/add";
    }

    @GetMapping("/add")
    public String showRegistrationForm(Model model){
        model.addAttribute("training", new Training());
        return "newTraining";
    }

    @GetMapping("/index")
    public String showIdex(){
        return ("index");
    }

    @GetMapping("/about")
    public String showAbout(){
        return ("about");
    }

    @GetMapping("/all")
    public String showAllTrainings(){
        return "allTrainings";
    }

}

//    @GetMapping("/edit")
//    public String showTrainingEditForm(Model model){
//        return("");
//    }
//
//    @GetMapping("/edit/{date}")
//    public Training getTraining(@PathVariable Date date){
//        return trainingService.getTrainingByDate(date);
//    }
//    @PostMapping("/editEvent")
//    public String updateEvent(@ModelAttribute("eventUpdate") EventEditRequest update) {
//        eventService.updateEvent(update);
//        return "redirect:/admin/eventSettings";
//    }
//
//
//    @GetMapping("/AllTrainings")
//    public List<Training> getTrainings(){return trainingService.getTrainings();}
//
//    @GetMapping("/findTraining/{date}")
//    public Training getTrainingsByDate(Date date){return trainingService.getTrainingByDate(date);}
//
//    @GetMapping("/findTraining/between+{date1}+{date2}")
//    public List<Training> getTrainingsByDatumBetween(Date date1, Date date2){return trainingService.findTrainingByDatumBetween(date1, date2);}
//
//
//



