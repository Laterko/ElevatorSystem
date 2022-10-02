package main;

public class InputManager {

    public InputManager(){

    }

    public boolean handle(String[] args){
        if (args[1].equalsIgnoreCase("help")){
            showHelp();
            return true;
        }



        if (args.length == 3){
            try {
                int calledToFloorInt = Integer.parseInt(args[1]);
                int targetFloorInt = Integer.parseInt(args[2]);

                //pickup 1 3
                //pickup
                //1,4 4,8 2,9 7,0


            }
            catch (Exception e){
                System.err.println("Argument" + args[1] + "and" + args[2]
                        + " must be an integer");
                System.exit(1);
            }
        }




        return false;
    }

    void showHelp(){
        System.out.println("dostepne komendy: status, pickup x y");
    }

}
