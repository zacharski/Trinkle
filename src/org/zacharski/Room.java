package org.zacharski;
import java.util.ArrayList;
/**
 * Created by raz on 3/11/15.
 */


public class Room {

    public class Exit {
        public String description;
        public int next;

        public Exit(String description, int next){
            this.description = description;
            this.next = next;
        }
    }





    String title;
    String description;
    ArrayList<Exit> exits;



    public Room(String title, String desc){
        exits = new ArrayList<Exit>();
        this.title = title;
        this.description = desc.replace("@@", "\n");
    }

    public void addExit(String name, int roomNum){
        exits.add(new Exit(name, roomNum));
    }

    public void describe(){
        System.out.println("\n\n" + title);
        System.out.println(description + "\n");
        System.out.println("There are the following exits:");
        int i = 1;
        for (Exit exit : exits){
            //System.out.print("%d ", i);
            System.out.printf("   %d) %s\n", i++, exit.description);

        }
    }

}
