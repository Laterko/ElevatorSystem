package main;

import main.simulator.SimulatorManager;

import java.util.ArrayList;

public class ElevatorManager implements Runnable {

    final int ELEVATORS_NUMBER = 16;

    private ArrayList<Elevator> elevators = new ArrayList<>();

    public ArrayList<Elevator> getElevators(){ return elevators; }

   SimulatorManager simulatorManager;

    public ElevatorManager() {
        simulatorManager = new SimulatorManager(this);
    }
    public ElevatorManager(SimulatorManager simulatorManager) {
        this.simulatorManager =  simulatorManager;
    }

    public SimulatorManager getSimulatorManager() {
        return simulatorManager;
    }

    public void setSimulatorManager(SimulatorManager simulatorManager) {
        this.simulatorManager = simulatorManager;
    }

    @Override
    public void run() {

        try {
            for (int i = 0; i < ELEVATORS_NUMBER; i++) {

                synchronized (elevators){

                    elevators.add(new Elevator(
                            i,
                            0,
                            0,
                            0,
                            ElevatorDirection.NONE,
                            ElevatorStatus.STOPPED));
                }

            }
            while (true){
                simulatorManager.simulate();
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

}
