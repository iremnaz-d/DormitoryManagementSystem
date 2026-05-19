package Domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MealMenu {

    private LocalDate date;
    private List<String> mealItems;

    public MealMenu(LocalDate date){
        this.date = date;
        this.mealItems = new ArrayList<>();
    }

    public String getMenuDetails(){
        return "ğ";
    }

    public void addMealItem(String item){
        mealItems.add(item);
    }

    public void removeMealItem(String item){ //çıkarırken upper/lowercase sıkıntısı çıkabilir
        mealItems.remove(item);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
