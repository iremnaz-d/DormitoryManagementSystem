package Application;

import Application.Interfaces.IShuttleScheduleRepository;
import Domain.ShuttleSchedule;
import Infrastructure.ShuttleScheduleRepository;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ShuttleService {

    private IShuttleScheduleRepository repository;

    public ShuttleService(){
        this.repository = ShuttleScheduleRepository.getInstance();
    }

   //elde öğrenci ders programları olmadığı için veri uydurdum
    private List<LocalTime> aggregateStudentSchedules() {
        List<LocalTime> simulatedDemands = new ArrayList<>();
        simulatedDemands.add(LocalTime.of(8, 30));
        simulatedDemands.add(LocalTime.of(9, 30));
        simulatedDemands.add(LocalTime.of(12, 30));
        simulatedDemands.add(LocalTime.of(16, 30));
        return simulatedDemands;
    }

    private List<LocalTime> calculatePeakHours(List<LocalTime> demands) {
        List<LocalTime> peakHours = new ArrayList<>();
        peakHours.add(LocalTime.of(8, 0));
        peakHours.add(LocalTime.of(9, 0));
        peakHours.add(LocalTime.of(12, 0));
        peakHours.add(LocalTime.of(15, 0));
        peakHours.add(LocalTime.of(17, 0));

        return peakHours;
    }

    public boolean generateTimeTable(DayOfWeek day) {
        List<LocalTime> rawDemands = aggregateStudentSchedules();
        List<LocalTime> peakHours = calculatePeakHours(rawDemands);

        ShuttleSchedule schedule = new ShuttleSchedule(day);
        for (LocalTime time : peakHours) {
            schedule.addDepartureTime(time.getHour(), time.getMinute());
        }

        publishSchedule(schedule);
        return true;
    }

    public void publishSchedule(ShuttleSchedule schedule) {
        this.repository.save(schedule);
    }

}
