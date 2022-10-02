package main.simulator;

import main.ElevatorManager;

public class SimulatorManager {

    private ElevatorManager elevatorManager;
    private SimulatorBase simulatorBase;

    public SimulatorManager(ElevatorManager elevatorManager){

        this.elevatorManager = elevatorManager;
        simulatorBase = new AutomaticSimulator(elevatorManager);
    }

    public SimulatorManager(ElevatorManager elevatorManager, SimulatorBase simulatorBase){

        this.elevatorManager = elevatorManager;
        this.simulatorBase = simulatorBase;

    }

    public SimulatorBase getSimulatorBase() {
        return simulatorBase;
    }

    public void setSimulatorBase(SimulatorBase simulatorBase) {
        this.simulatorBase = simulatorBase;
    }

    public void simulate(){
        if( simulatorBase instanceof AutomaticSimulator){
            try{
                Thread.sleep(1000);
                simulatorBase.simulate();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }
}
