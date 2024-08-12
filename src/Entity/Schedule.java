package Entity;

import java.time.LocalDate;
import java.util.Objects;

public class Schedule {
    private String trainName;
    private LocalDate startDate;
    private LocalDate finishDate;

    public Schedule(String trainName, LocalDate startDate, LocalDate finishDate) {
        this.trainName = trainName;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public Schedule(String string){
        String[] strings = string.split(" ");
        this.trainName = strings[0];
        this.startDate = LocalDate.parse(strings[1]);
        this.finishDate = LocalDate.parse(strings[2]);
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule schedule = (Schedule) o;
        return Objects.equals(getTrainName(), schedule.getTrainName())
                && Objects.equals(getStartDate(), schedule.getStartDate())
                && Objects.equals(getFinishDate(), schedule.getFinishDate());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getTrainName());
        result = 31 * result + Objects.hashCode(getStartDate());
        result = 31 * result + Objects.hashCode(getFinishDate());
        return result;
    }

    @Override
    public String toString() {
        return trainName + " " + startDate + " " + finishDate;
    }

}
