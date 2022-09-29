package main;

public class Status{

    private int idElevator;
    private int currentFloor;
    private int targetFloor;
    //ID windy, obecny numer piętra, docelowy numer piętra
    public Status(int idElevator, int currentFloor, int targetFloor){
        this.idElevator = idElevator;
        this.currentFloor = currentFloor;
        this.targetFloor = targetFloor;
        //System.out.println("INFO [Status]: " + targetFloor);

    }

    public void setIdElevator(int idElevator) {
        this.idElevator = idElevator;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setTargetFloor(int targetFloor) {
        this.targetFloor = targetFloor;
    }
}
