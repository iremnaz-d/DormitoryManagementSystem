package Infrastructure;

import Application.Interfaces.IMenuRepository;
import Domain.MealMenu;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class MenuRepository implements IMenuRepository {

    private static MenuRepository instance;
    private Map<LocalDate, MealMenu> menuList;

    private MenuRepository(){
        this.menuList = new HashMap<>();
    }

    public MenuRepository getInstance(){
        if(instance == null){
            instance =  new MenuRepository();
        }
        return instance;
    }

    @Override
    public void save(MealMenu menu) {
        this.menuList.put(menu.getDate(),menu);
    }

    @Override
    public void delete(LocalDate date) {
        this.menuList.remove(date);
    }

    @Override
    public Map<LocalDate, MealMenu> findAll() {
        return this.menuList;
    }

    @Override
    public MealMenu findByDate(LocalDate date) {
        return this.menuList.get(date);
    }
}
