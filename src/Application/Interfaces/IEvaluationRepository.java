package Application.Interfaces;

import Domain.MealEvaluation;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IEvaluationRepository {

    void save(MealEvaluation evaluation);

    void delete(MealEvaluation evaluation);

    List<MealEvaluation> findAll();

    List<MealEvaluation> findByDate(LocalDate date);
}
