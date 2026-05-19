package Infrastructure;

import Application.Interfaces.IEvaluationRepository;
import Domain.MealEvaluation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationRepository implements IEvaluationRepository {

    private static EvaluationRepository instance;
    private List<MealEvaluation> evaluationList;

    private EvaluationRepository(){
        this.evaluationList = new ArrayList<>();
    }

    public EvaluationRepository getInstance(){
        if(instance == null){
            return new EvaluationRepository();
        }
        return instance;
    }


    @Override
    public void save(MealEvaluation evaluation) {
        this.evaluationList.add(evaluation);
    }

    @Override
    public void delete(MealEvaluation evaluation) {
        this.evaluationList.remove(evaluation);
    }

    @Override
    public List<MealEvaluation> findAll() {
        return this.evaluationList;
    }

    @Override
    public List<MealEvaluation> findByDate(LocalDate date) {
        List<MealEvaluation> oneDayEvaluationList = new ArrayList<>();

        for (MealEvaluation i: this.evaluationList){
            if(i.getMenuDate().equals(date)){
                oneDayEvaluationList.add(i);
            }
        }
        return oneDayEvaluationList;
    }
}
