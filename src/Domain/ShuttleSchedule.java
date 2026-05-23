package Domain;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ShuttleSchedule { //bir günün servis saatleri

    DayOfWeek day;
    Set<LocalTime> departureTimes; //ascending sıralı ve tekrarlama olmaması için TreeSet

    public ShuttleSchedule (DayOfWeek day){
        this.day = day;
        this.departureTimes = new TreeSet<>();
    }

    public LocalTime getTimeBySession(int session){
        Iterator<LocalTime> iterator = this.departureTimes.iterator();
        LocalTime time = iterator.next();
        for (int i = 1; i < session; i++){
            time = iterator.next();
        }
        return time;
    }

    public String getShuttleScheduleDetails(){
        return"ğ";
    }

    public void addDepartureTime(int hour, int minute){
        departureTimes.add(LocalTime.of(hour,minute));
    }

   public void removeDepartureTime(int hour, int minute){
        departureTimes.remove(LocalTime.of(hour, minute));
   }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }


}
