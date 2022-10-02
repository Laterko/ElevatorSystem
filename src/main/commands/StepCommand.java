package main.commands;

import main.simulator.ManualSimulator;
import main.simulator.SimulatorManager;

public class StepCommand implements ElevatorCommandInterface{

    private SimulatorManager simulatorManager;

    public StepCommand(SimulatorManager simulatorManager){

        this.simulatorManager = simulatorManager;
    }

    @Override
    public void RunCommand(String[] arguments) {

        if( simulatorManager.getSimulatorBase() instanceof ManualSimulator ){
            simulatorManager.getSimulatorBase().simulate();
            System.out.println("1 step");
        }
        else {
            System.out.println("this command is only available for manual simulator");
        }
        
    }
}
