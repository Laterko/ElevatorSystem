package main.commands;

import main.Elevator;
import main.ElevatorManager;
import main.ElevatorStatus;
import main.simulator.AutomaticSimulator;
import main.simulator.ManualSimulator;
import main.simulator.SimulatorManager;

public class SwitchSimulatorCommand implements ElevatorCommandInterface {

    private ElevatorManager elevatorManager;
    private SimulatorManager simulatorManager;


    public SwitchSimulatorCommand(SimulatorManager simulatorManager, ElevatorManager elevatorManager) {

        this.simulatorManager = simulatorManager;
        this.elevatorManager = elevatorManager;
    }

    @Override
    public void RunCommand(String[] arguments) {

        if(arguments.length < 2 ){
            System.out.println("Wrong number of arguments");
            return;
        }

        for (Elevator elevator : elevatorManager.getElevators()){
            synchronized (elevatorManager.getElevators()){
                if(elevator.getElevatorStatus() != ElevatorStatus.STOPPED){
                    System.out.println("Can't switch simulation mode while elevators are running!");
                    return;
                }
            }
        }

        switch(arguments[1]){
            case("automatic"): {
                if(simulatorManager.getSimulatorBase() instanceof AutomaticSimulator){
                    System.out.println("Simulator is already automatic");
                }
                simulatorManager.setSimulatorBase(new AutomaticSimulator(elevatorManager));
                System.out.println("Changed to automatic simulator");
                break;
            }
            case("manual"): {
                if(simulatorManager.getSimulatorBase() instanceof ManualSimulator){
                    System.out.println("Simulator is already manual");
                }
                simulatorManager.setSimulatorBase(new ManualSimulator(elevatorManager));
                System.out.println("Changed to manual simulator");
                break;
            }
        }
    }
}
