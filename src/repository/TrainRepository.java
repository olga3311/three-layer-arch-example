package repository;

import Entity.Schedule;

import java.util.List;

public interface TrainRepository {

    List<Schedule> getSchedule();

    boolean deleteFromSchedule(String trainName);

    boolean addToSchedule(String data);

    boolean addToSchedule(Schedule schedule);
}
