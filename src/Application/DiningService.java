package Application;

import Application.Interfaces.IMenuRepository;
import Domain.MealMenu;
import Infrastructure.MenuRepository;

import java.time.LocalDate;


public class DiningService {

    private IMenuRepository repository;

    public DiningService(){
        this.repository = MenuRepository.getInstance();
    }

    public boolean publishMenu(LocalDate date, String [] items){

        MealMenu menu = new MealMenu(date);
        for (String item: items){
            menu.addMealItem(item);
        }
        this.repository.save(menu);
        return true;
    }

    public MealMenu getMenuByDate(LocalDate date){
       return this.repository.findByDate(date);
    }


}
