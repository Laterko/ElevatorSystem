package main.commands;

import main.Elevator;
import main.ElevatorDirection;
import main.ElevatorManager;
import main.ElevatorStatus;

import java.util.LinkedList;
import java.util.Queue;

public class PickupCommand implements ElevatorCommandInterface{

    private ElevatorManager elevatorManager;
    private int calledToFloorInt;
    private int targetFloorInt;

    public PickupCommand(ElevatorManager elevatorManager){

        this.elevatorManager = elevatorManager;
    }

    @Override
    public void RunCommand(String[] arguments) {

        if ((arguments.length >= 2) &&
                (arguments[1].equalsIgnoreCase("help"))){
            showHelp();
            return;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i < arguments.length; i++){

            int first;
            int second;
            String[] stringListToInt = arguments[i].split(":");

            try {
                first = Integer.parseInt(stringListToInt[0]);
                second = Integer.parseInt(stringListToInt[1]);
                queue.add(first);//calledToFloor
                queue.add(second);//targetFloor
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            finally {
                continue;
            }

        }
        if (queue.size()  % 2 != 0 ){
            System.out.println("Wrong number of passed ints");
            return;
        }


        for(Elevator elevator: elevatorManager.getElevators()) {
            if (queue.isEmpty()){
                break;
            }
            synchronized (elevatorManager.getElevators()) {

                if (elevator.getElevatorStatus() != ElevatorStatus.STOPPED){
                    queue.remove();
                    queue.remove();
                    continue;
                }
                elevator.setCalledToFloor(queue.remove());
                elevator.setTargetFloor(queue.remove());

                elevator.setElevatorStatus(ElevatorStatus.RUNNING);

                if(elevator.getCurrentFloor() > elevator.getTargetFloor()){
                    elevator.setDirection(ElevatorDirection.DOWN);
                }
                else if(elevator.getCurrentFloor() < elevator.getTargetFloor()){
                    elevator.setDirection(ElevatorDirection.UP);
                }
                else {
                    elevator.setDirection(ElevatorDirection.NONE);
                }
            }
        }

    }
    void showHelp(){
        System.out.println("uzycie komendy: pickup x:y z:i ...");
    }
}
