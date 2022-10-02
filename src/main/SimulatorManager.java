package main;

public class SimulatorManager {

    private ElevatorManager elevatorManager;

    public SimulatorManager(ElevatorManager elevatorManager){
        this.elevatorManager = elevatorManager;
    }

    public void simulate(){
        for (Elevator elevator : elevatorManager.getElevators()){
            if (elevator.getElevatorStatus() == ElevatorStatus.RUNNING){
                if (elevator.getCurrentFloor() != elevator.getTargetFloor()){
                    switch (elevator.getDirection()){
                        case UP: {
                            synchronized (elevatorManager.getElevators()){
                                elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
                            }
                            break;
                        }
                        case DOWN: {
                            synchronized (elevatorManager.getElevators()){
                                elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
                            }
                            break;
                        }
                        default:
                            break;
                    }
                }else {
                    synchronized (elevatorManager.getElevators()){
                        elevator.setDirection(ElevatorDirection.NONE);
                        elevator.setElevatorStatus(ElevatorStatus.STOPPED);
                    }
                }
            }
        }
    }
}
