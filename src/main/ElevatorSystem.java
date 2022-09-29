package main;

import main.commands.PickupCommand;
import main.commands.StatusCommand;
import java.util.Scanner;


public class ElevatorSystem{


    public static void main(String[] args){

        ElevatorManager elevatorManager = new ElevatorManager();
        Thread elevatorThread = new Thread(elevatorManager);
        elevatorThread.setDaemon(true);
        elevatorThread.start();
        StatusCommand statusCommand = new StatusCommand(elevatorManager);

        while (true) {

            statusCommand.RunCommand();
            System.out.println("Podaj pietro na ktorym jestes i na ktore chcesz jechac");

            Scanner input = new Scanner(System.in);

            int calledToFloorInt = input.nextInt();
            int targetFloorInt = input.nextInt();
            String command = input.nextLine();
            PickupCommand pickupCommand = new PickupCommand(
                    elevatorManager,
                    calledToFloorInt,
                    targetFloorInt
            );
            pickupCommand.RunCommand();
            statusCommand.RunCommand();

        }
    }

    public ElevatorSystem(){}

}
