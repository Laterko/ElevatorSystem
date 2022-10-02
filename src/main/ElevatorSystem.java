package main;

import main.commands.ElevatorCommandInterface;
import main.commands.PickupCommand;
import main.commands.StatusCommand;

import java.util.*;


public class ElevatorSystem{


    public static void main(String[] args){

        ElevatorManager elevatorManager = new ElevatorManager();
        Thread elevatorThread = new Thread(elevatorManager);
        elevatorThread.setDaemon(true);
        elevatorThread.start();

        Map<String, ElevatorCommandInterface> commandMap = new HashMap<>();
        commandMap.put("status", new StatusCommand(elevatorManager));
        commandMap.put("pickup", new PickupCommand(elevatorManager));

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

/*
            if (command.equals("pickup")){
                System.out.println("input up to 16 integer pairs where");
                System.out.println("#1 pickup floor #2 destination floor e.g. 0,2 5,1 3,8 6,0 2,9 8,5 ...");
                System.out.println("please be precise i didn't write input validation yet sowwy :'(");
                String line = input.nextLine();
                if (line.isEmpty()) continue;
                String[] stringList = line.split("\\s+");//1:2 enter 3:5
                for (String s : stringList){
                    String[] stringListToInt = s.split(":");//1 enter 2 enter 3 enter
                    for (String z : stringListToInt){
                        try {
                            int x = Integer.parseInt(z);
                            //queue.add(x);
                        }
                        catch (Exception e){
                            System.out.println("Wrong input");
                            continue;
                        }

                        // kolejka zaladowana intami

                            //laduj


                    }
                }
                //tutaj ladowanie z kolejki dwójkami do pickupa

                //ladowanie 1 windy
                //0:2 5:1 3:8
                //0 1 2 3 4 5
                // size 5
                //calledToFloorInt = queue.remove();
                //targetFloorInt = queue.remove();
            }
            */


        }
    }

    public ElevatorSystem(){}

}
