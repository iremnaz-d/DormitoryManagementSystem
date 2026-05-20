package Infrastructure;

import Application.Interfaces.IShuttleScheduleRepository;
import Domain.ShuttleSchedule;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

public class ShuttleScheduleRepository implements IShuttleScheduleRepository {

    private static ShuttleScheduleRepository instance;
    private Map<DayOfWeek, ShuttleSchedule> shuttleScheduleMap;

    private ShuttleScheduleRepository(){
        this.shuttleScheduleMap = new HashMap<>();
    }

    public static ShuttleScheduleRepository getInstance(){
        if(instance == null){
            instance =  new ShuttleScheduleRepository();
        }
        return instance;
    }


    @Override
    public void save(ShuttleSchedule shuttleSchedule) {
        this.shuttleScheduleMap.put(shuttleSchedule.getDay(),shuttleSchedule);
    }

    @Override
    public void delete(DayOfWeek day) {
        this.shuttleScheduleMap.remove(day);
    }

    @Override
    public ShuttleSchedule findByDay(DayOfWeek day) {
        return this.shuttleScheduleMap.get(day);
    }
}
