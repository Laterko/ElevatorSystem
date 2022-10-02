package main.simulator;

import main.Elevator;
import main.ElevatorDirection;
import main.ElevatorManager;
import main.ElevatorStatus;

public abstract class SimulatorBase {

   private ElevatorManager elevatorManager;
   public abstract void run();

   public SimulatorBase(ElevatorManager elevatorManager) {
      this.elevatorManager = elevatorManager;
   }

   public void simulate(){
      for (Elevator elevator : elevatorManager.getElevators()){
         if (elevator.getElevatorStatus() != ElevatorStatus.STOPPED){
            if(elevator.getCurrentFloor() != elevator.getCalledToFloor()
                    && elevator.getElevatorStatus() == ElevatorStatus.CALLED){
                  move(elevator);
                  if(elevator.getCurrentFloor() == elevator.getCalledToFloor()){
                     synchronized (elevatorManager.getElevators()){
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

            else if (elevator.getCurrentFloor() != elevator.getTargetFloor()
                    && elevator.getElevatorStatus() == ElevatorStatus.RUNNING){
               move(elevator);
            }else {
               synchronized (elevatorManager.getElevators()){
                  elevator.setDirection(ElevatorDirection.NONE);
                  elevator.setElevatorStatus(ElevatorStatus.STOPPED);
               }
            }
         }
      }
   }

   private void move(Elevator elevator){

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


   }
}