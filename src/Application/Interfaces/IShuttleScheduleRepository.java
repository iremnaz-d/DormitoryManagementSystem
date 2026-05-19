package Application.Interfaces;

import Domain.ShuttleSchedule;

import java.time.DayOfWeek;

public interface IShuttleScheduleRepository {

    void save(ShuttleSchedule shuttleSchedule);

    void delete(DayOfWeek day);

    ShuttleSchedule findByDay(DayOfWeek day);
}
