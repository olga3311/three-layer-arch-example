package repository;

import Entity.Schedule;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TrainFileRepositoryImpl implements TrainRepository {

    private File file;

    public TrainFileRepositoryImpl(File file) {
        this.file = file;
    }

    @Override
    public List<Schedule> getSchedule() {
        try (FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader)){

             return bufferedReader.lines()
                    .map(Schedule::new)
                    .toList();

        }
        catch (IOException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


    @Override
    public boolean deleteFromSchedule(String trainName) {
        List<Schedule> schedules = getSchedule();

        schedules = schedules.stream()
                .filter((schedule -> !schedule.getTrainName().equals(trainName)))
                .toList();

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Schedule schedule : schedules) {
                bufferedWriter.write(schedule.toString());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            return true;
        }
         catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }



    @Override
    public boolean addToSchedule(String data) {
        return false;
    }

    @Override
    public boolean addToSchedule(Schedule schedule) {
        try (FileWriter fileWriter = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(schedule.toString());
            bufferedWriter.newLine();
            bufferedWriter.flush();

        return true;
    } catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

}
