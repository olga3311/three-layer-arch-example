import controller.TrainController;
import repository.TrainFileRepositoryImpl;
import repository.TrainRepository;
import service.TrainService;
import service.TrainServiceImpl;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        File file = new File("schedule.txt");
        TrainRepository trainRepository = new TrainFileRepositoryImpl(file);
        TrainService trainService = new TrainServiceImpl(trainRepository);
        TrainController trainController = new TrainController(scanner, trainService);

        trainController.startProgram();
    }
}
