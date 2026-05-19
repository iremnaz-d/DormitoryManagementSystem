package Application.Interfaces;

import Domain.MealMenu;

import java.time.LocalDate;
import java.util.Map;

public interface IMenuRepository {

    void save(MealMenu menu);

    void delete(LocalDate date);

    Map<LocalDate, MealMenu> findAll();

    MealMenu findByDate(LocalDate date);

}
