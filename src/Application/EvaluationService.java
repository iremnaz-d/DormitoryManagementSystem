package Application;

import Application.Interfaces.IEvaluationRepository;
import Domain.MealEvaluation;
import Infrastructure.EvaluationRepository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Locale;

public class EvaluationService {

    private IEvaluationRepository repository;

    public EvaluationService(){
        this.repository = EvaluationRepository.getInstance();
    }

    public boolean submitEvaluation(String day, int score, String comment){

        DayOfWeek dayOfWeek;
        try{
            dayOfWeek = DayOfWeek.valueOf(day.toUpperCase());
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Day name is invalid.");
        }

        if(score <= 0 || score > 5) {
            throw new IllegalArgumentException("Evaluation score must be between 1-5.");
        }

        if (LocalDate.now().getDayOfWeek().getValue() <= dayOfWeek.getValue()){
            throw new IllegalArgumentException("You can not access this day of week in this moment.");
        }

        LocalDate evaluatedDate = LocalDate.now().with(TemporalAdjusters.previous(dayOfWeek)); //girilen günün tam tarihi bulunur
        this.repository.save(new MealEvaluation(evaluatedDate ,score, comment));
        return true;
    }

    public double calculateAverageRating(LocalDate date){

        List<MealEvaluation> evaluationList = this.repository.findByDate(date);

        int sum = 0, length = 0;
        for (MealEvaluation i: evaluationList){
            sum += i.getScore();
            length++;
        }

        double average = sum/(double)length;
        return Math.round(average * 100.0) / 100.0; //ortalamayı yuvarlayıp verir
    }
}
