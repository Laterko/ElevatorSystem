package main.commands;

import main.Elevator;
import main.ElevatorDirection;
import main.ElevatorManager;
import main.Pickup;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class PickupCommand implements ElevatorCommandInterface{

    private ElevatorManager elevatorManager;
    private int calledToFloorInt;
    private int targetFloorInt;
    private Map<String, Function<String, PickupCommand>> myMap = new HashMap<>();
    private Map<String, PickupCommand> dwaMap;

    public PickupCommand(ElevatorManager elevatorManager, int calledToFloorInt, int targetFloorInt){

        this.elevatorManager = elevatorManager;
        this.calledToFloorInt = calledToFloorInt;
        this.targetFloorInt = targetFloorInt;
        //myMap.put("status", PickupCommand::RunCommand );
    }
/*
    public String por(String key){
       PickupCommand pickupCommand = new PickupCommand();
       statusCommand = dwaMap.getValue(key);
       return statusCommand.RunCommand();
    }
*/
    @Override
    public void RunCommand() {

        for(Elevator elevator: elevatorManager.getElevators()) {
            synchronized (elevatorManager.getElevators()) {
                elevator.setCalledToFloor(calledToFloorInt);
                elevator.setTargetFloor(targetFloorInt);

                if (elevator.getCurrentFloor() > elevator.getTargetFloor()){

                    elevator.setDirection(ElevatorDirection.DOWN);

                } else if (elevator.getCurrentFloor() < elevator.getTargetFloor()){

                    elevator.setDirection(ElevatorDirection.UP);
                } else {
                    elevator.setDirection(ElevatorDirection.NONE);
                }

            }
        }

    }
}
