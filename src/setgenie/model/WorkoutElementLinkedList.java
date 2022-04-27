package setgenie.model;

import java.util.LinkedList;
import java.util.ListIterator;

// this linkedList will sort the the elements inside by total distance
public class WorkoutElementLinkedList {

    private LinkedList<WorkoutElement> workoutList = new LinkedList<>();

    public WorkoutElementLinkedList(){
        buildWorkoutList();
        printWorkoutList();
    }

    public void buildWorkoutList(){

        this.addItem(new WorkoutElement(5, 100, 65, WorkoutElement.STROKE.FREESTYLE));
        this.addItem(new WorkoutElement(2, 200, 120, WorkoutElement.STROKE.KICK));
        this.addItem(new WorkoutElement(1, 400, 300, WorkoutElement.STROKE.IM));
        this.addItem(new WorkoutElement(1, 500, 300, WorkoutElement.STROKE.FREESTYLE));
    }

    public void printWorkoutList(){
        ListIterator<WorkoutElement> elementListIterator = workoutList.listIterator();
        while(elementListIterator.hasNext()){
            System.out.println(elementListIterator.next().toString());
        }
    }

    public void addItem(WorkoutElement newElement){
        boolean itemAdded = false;
        boolean insertDecision = false;
        ListIterator<WorkoutElement> elementListIterator = workoutList.listIterator();
        while(elementListIterator.hasNext()){
            insertDecision = elementListIterator.next().decideToInsert(newElement);
            if (insertDecision){
                workoutList.add(elementListIterator.previousIndex(), newElement);
                itemAdded = true;
                break;
            }
        }

        if(!itemAdded){
            workoutList.add(newElement);
        }
    }

    public boolean removeItem(WorkoutElement elementToRemove){
        return workoutList.remove(elementToRemove);
    }

    // the search feature uses the STROKE of the workoutElement object
    public WorkoutElement getItem(String searchTerm){

        ListIterator<WorkoutElement> elementListIterator = workoutList.listIterator();
        while (elementListIterator.hasNext()){
            WorkoutElement nextElement = elementListIterator.next();
            if (nextElement.getElementStroke().toString().equalsIgnoreCase(searchTerm)){
                return nextElement;
            }
        }
        return null;
    }
}
