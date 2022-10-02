package main;

import main.commands.*;
import main.simulator.SimulatorManager;

import java.util.*;


public class ElevatorSystem{


    public static void main(String[] args){


        ElevatorManager elevatorManager = new ElevatorManager();
        Thread elevatorThread = new Thread(elevatorManager);
        elevatorThread.setDaemon(true);
        elevatorThread.start();

        SimulatorManager simulatorManager = new SimulatorManager(elevatorManager);

        synchronized (elevatorManager.getSimulatorManager()){
            elevatorManager.setSimulatorManager(simulatorManager);
        }

        Map<String, ElevatorCommandInterface> commandMap = new HashMap<>();
        commandMap.put("status", new StatusCommand(elevatorManager));
        commandMap.put("pickup", new PickupCommand(elevatorManager));
        commandMap.put("step", new StepCommand(simulatorManager));
        commandMap.put("switch-simulator", new SwitchSimulatorCommand(simulatorManager, elevatorManager));

        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.print("> ");
            String command = input.nextLine();
            String[] arguments = command.split(" ");

            if (arguments[0] == null) continue;

            try {
                commandMap.get(arguments[0]).RunCommand(arguments);
            }
            catch (Exception e){
                System.out.println("main " + e.getMessage());
                continue;
            }
        }
    }

    public ElevatorSystem(){}

}
