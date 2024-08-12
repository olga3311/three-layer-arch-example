package service;

import Entity.Schedule;

import java.util.List;

public interface TrainService {

    List<Schedule> getSchedule();

    boolean deleteFromSchedule(String trainName);

    boolean addToSchedule(String data);

}
