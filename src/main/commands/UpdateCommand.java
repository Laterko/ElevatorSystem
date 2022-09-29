package main.commands;

import main.ElevatorManager;

public class UpdateCommand implements ElevatorCommandInterface{

    private ElevatorManager elevatorManager;

    public UpdateCommand(ElevatorManager elevatorManager){
        this.elevatorManager = elevatorManager;
    }
    //update mozna uzyc zeby zmienic skad startuje winda o id (int)
    @Override
    public void RunCommand() {

    }
}
