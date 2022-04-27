package setgenie;

import setgenie.controller.*;
import setgenie.model.User;
import setgenie.model.WorkoutElement;
import setgenie.model.WorkoutElementLinkedList;

public class SetGenie {

    // this is the main method in this case.
    public static void main(String[] args) {
        //WorkoutElementCntl uiCtl = new WorkoutElementCntl();
        //ElementListCtl listCtl = new ElementListCtl();
        //LoginCtl loginCtl = new LoginCtl();

        // use this for the LinkedList Assignment
        WorkoutElementLinkedList workoutList = new WorkoutElementLinkedList();

        System.out.println("================ Adding");
        workoutList.addItem(new WorkoutElement(4, 50, 50, WorkoutElement.STROKE.BUTTERFLY));
        workoutList.printWorkoutList();

        System.out.println("================ Searching");
        WorkoutElement butterflyElement = workoutList.getItem("butterfly");
        System.out.println(butterflyElement.toString());

        System.out.println("================ Removing");
        WorkoutElement distElement = new WorkoutElement(400, 300, WorkoutElement.STROKE.FREESTYLE);
        System.out.println(distElement);
        System.out.println("----");
        workoutList.addItem(distElement);
        workoutList.printWorkoutList();
        System.out.println("----");
        boolean completed = workoutList.removeItem(distElement);
        System.out.println("Removed? " + completed);
        workoutList.printWorkoutList();
    }
}
