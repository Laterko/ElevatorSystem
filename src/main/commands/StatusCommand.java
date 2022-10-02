package main.commands;

import main.Elevator;
import main.ElevatorManager;

public class StatusCommand implements ElevatorCommandInterface{

    private ElevatorManager elevatorManager;

    public StatusCommand(ElevatorManager elevatorManager){
        this.elevatorManager = elevatorManager;
    }

    @Override
    public void RunCommand(String[] arguments) {

        System.out.printf(String.format("%-8s \t%-13s \t%-13s \t%-15s \t%-9s \t%-7s \n",
                "Elevator","Current Floor","Target Floor","Called To Floor","Direction","Status"));

        for(Elevator elevator: elevatorManager.getElevators()) {
            synchronized (elevatorManager.getElevators()) {
                System.out.printf(String.format("%8d \t%13d \t%13d \t%15d \t%9s \t%7s \n",
                        elevator.getIdElevator(),
                        elevator.getCurrentFloor(),
                        elevator.getTargetFloor(),
                        elevator.getCalledToFloor(),
                        elevator.getDirection(),
                        elevator.getElevatorStatus()
                ));
            }
        }
    }
}
