package setgenie.model;

import java.util.ArrayList;
import java.util.List;

public class WorkoutElementList {

    private List<WorkoutElement> elementList;

    public WorkoutElementList() {
        elementList = new ArrayList<>();
    }

    public WorkoutElement get(int i){
        if (i >= 0 && i < elementList.size()){
            return this.elementList.get(i);
        } else {
            return null;
        }
    }

    public void add(WorkoutElement w){
        this.elementList.add(w);
    }

    public int size(){
        return this.elementList.size();
    }

    public void set(int index, WorkoutElement w) {
        this.elementList.set(index, w);
    }

    public void remove(int index){
        this.elementList.remove(index);
    }


}
