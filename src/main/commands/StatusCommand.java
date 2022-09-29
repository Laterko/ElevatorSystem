package main.commands;

import main.Elevator;
import main.ElevatorManager;

public class StatusCommand implements ElevatorCommandInterface{

    private ElevatorManager elevatorManager;

    public StatusCommand(ElevatorManager elevatorManager){
        this.elevatorManager = elevatorManager;

    }

    @Override
    public void RunCommand() {

        System.out.printf(String.format("%-5s \t%-13s \t%-13s \t%-15s \t%-9s \n",
                "Winda","Current Floor","Target Floor","Called To Floor","Direction"));

        for(Elevator elevator: elevatorManager.getElevators()) {
            synchronized (elevatorManager.getElevators()) {
                System.out.printf(String.format("%5d \t%13d \t%13d \t%15d \t%9s \n",
                        elevator.getIdElevator(),
                        elevator.getCurrentFloor(),
                        elevator.getTargetFloor(),
                        elevator.getCalledToFloor(),
                        elevator.getDirection()
                ));
            }
        }
    }
}
