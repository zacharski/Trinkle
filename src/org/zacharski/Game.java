package org.zacharski;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


/**
 * Created by raz on 3/11/15.
 */
public class Game {

    ArrayList<Room> rooms;
    int startState;
    int currentState;


    // constructor - read in game from file
    //
    public Game(String filename){
        String line;
        rooms = new ArrayList<Room>();
        File file = new File(filename);
        try {
            Scanner sc = new Scanner(file);
            String start = sc.nextLine();

            String[] states = start.split(";");
            startState = Integer.parseInt(states[0]);
            currentState = startState;

            while (sc.hasNext()){
                line = sc.nextLine();
                String[] fields = line.split(";");
                Room room = new Room(fields[1], fields[2]);

                // now add exits
                for (int i = 3; i < 6; i++){
                    //System.out.print(i);
                    //System.out.println(fields[i]);
                    String[] anExit  = fields[i].split(":");
                    int exitnum = Integer.parseInt(anExit[1]);
                    room.addExit(anExit[0], exitnum);

                }
                rooms.add(room);
            }
        } catch (FileNotFoundException e) {
            System.out.println(filename);
            e.printStackTrace();
        }

        //for (Room room : rooms){
        //    room.describe();
        //}


    }   // end constructor


    public void describeRoom(){
        rooms.get(currentState).describe();
    }

    public void move(int option){
        //
        // to do
    }



}
