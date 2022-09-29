package main;

import java.util.ArrayList;

public class ElevatorManager implements Runnable {

    final int ELEVATORS_NUMBER = 16;

    private ArrayList<Elevator> elevators = new ArrayList<>();

    public ArrayList<Elevator> getElevators(){ return elevators; }



    @Override
    public void run() {

        try {
            for (int i = 0; i < ELEVATORS_NUMBER; i++) {

                synchronized (elevators){
                    //zapisywanie i odczytywanie
                    elevators.add(new Elevator(
                            i,
                            0,
                            0,
                            0,
                            ElevatorDirection.NONE ));
                }

            }
        }
        catch (Exception e){

        }

    }

}
