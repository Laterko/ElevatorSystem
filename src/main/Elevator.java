package main;

public class Elevator {

    int idElevator;
    int currentFloor;
    int targetFloor;
    int calledToFloor;
    ElevatorDirection direction;

   public Elevator(int idElevator, int currentFloor, int targetFloor, int calledToFloor, ElevatorDirection direction){
       this.idElevator = idElevator;
       this.currentFloor = currentFloor;
       this.targetFloor = targetFloor;
       this.calledToFloor = calledToFloor;
       this.direction = direction;
       System.out.println("INFO [Elevator]: " + idElevator + " Elevator created" );
    }

    public int getIdElevator() {
        return idElevator;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public void setTargetFloor(int targetFloor) {
        this.targetFloor = targetFloor;
    }

    public int getCalledToFloor() {
        return calledToFloor;
    }

    public void setCalledToFloor(int calledToFloor) {
        this.calledToFloor = calledToFloor;
    }

    public ElevatorDirection getDirection() {
        return direction;
    }

    public void setDirection(ElevatorDirection direction) {
       this.direction = direction;
    }

}
