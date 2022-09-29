package main;

public class Pickup {

    private int _target;
    private ElevatorDirection direction;
    private main.Elevator Elevator;

   public Pickup(int _target){
        this._target = _target;
    }

    public Pickup(int _target, ElevatorDirection direction){
        this._target = _target;
        this.direction = direction;
        //System.out.println("INFO [Pickup]: Set to floor " + _target + "direction: " + direction );
    }

    public void set_target(int _target) {
        this._target = _target;
    }

    public void setDirection(ElevatorDirection direction) {
        this.direction = direction;
    }

    public String sendElevator(){ return "Sent to floor" + _target; }
}
