package setgenie.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WorkoutElementList implements Serializable {

    private List<WorkoutElement> elementList = new ArrayList<>();
    private String elementListFilename = "elementList.ser";
    private String associatedUser;

        public WorkoutElementList() {
            this.associatedUser = null;
            this.readElementList();
            if (elementList == null || elementList.isEmpty()){
                this.createElementList();
                this.writeElementListFile();
                this.readElementList();
            }
            this.printElementList();
        }

        public WorkoutElementList(String username) {
            this.associatedUser = username;
            this.readElementList(username);
            if (elementList == null || elementList.isEmpty()) {
                this.createElementList();
                this.writeElementListFile();
                this.readElementList(username);
            }
            this.printElementList();
        }

        private void readElementList(){
        FileInputStream fileInStream = null;
        ObjectInputStream objInStream = null;
        try {
            fileInStream = new FileInputStream(elementListFilename);
            objInStream = new ObjectInputStream(fileInStream);
            elementList = (ArrayList<WorkoutElement>) objInStream.readObject();
            objInStream.close();
            if (elementList.isEmpty()){
                System.out.println("The workout element list is empty.");
            }
        } catch (FileNotFoundException fne) {
            System.out.println("File was not found, a new one will be created");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void readElementList(String username){
        FileInputStream fileInStream = null;
        ObjectInputStream objInStream = null;
        try {
            fileInStream = new FileInputStream(elementListFilename);
            objInStream = new ObjectInputStream(fileInStream);
            elementList = (ArrayList<WorkoutElement>) objInStream.readObject();
            objInStream.close();
            if (elementList.isEmpty()){
                System.out.println("The workout element list is empty.");
            } else {
                elementList = this.getElementListByUser(username);
            }
        } catch (FileNotFoundException fne) {
            System.out.println("File was not found, a new one will be created");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void writeElementListFile() {
        FileOutputStream outStream = null;
        ObjectOutputStream objOut = null;
        try {
            outStream = new FileOutputStream(elementListFilename);
            objOut = new ObjectOutputStream(outStream);
            objOut.writeObject(elementList);
            objOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void createElementList(){
        WorkoutElement w1 = new WorkoutElement(1, 500, 360, WorkoutElement.STROKE.FREESTYLE);
        this.elementList.add(w1);
        WorkoutElement w2 = new WorkoutElement(2, 400, 300, WorkoutElement.STROKE.IM, "Drill, Kick, Drill, Swim by 100");
        this.elementList.add(w2);
        WorkoutElement w3 = new WorkoutElement(2, 300, 300, WorkoutElement.STROKE.KICK);
        this.elementList.add(w3);
        WorkoutElement w4 = new WorkoutElement(1, 200, 150, WorkoutElement.STROKE.IM);
        this.elementList.add(w4);
        WorkoutElement w5 = new WorkoutElement(5, 100, 75, WorkoutElement.STROKE.FREESTYLE, "Descend");
        this.elementList.add(w5);
    }

    public WorkoutElement get(int i){
        if (i >= 0 && i < elementList.size()){
            return this.elementList.get(i);
        } else {
            return null;
        }
    }

    public ArrayList<WorkoutElement> getElementList(){return (ArrayList<WorkoutElement>) this.elementList;}

    public void add(WorkoutElement w){
        if (!(associatedUser == null)){
            w.setElementAuthor(associatedUser);
        }
        this.elementList.add(w);
        writeElementListFile();
    }

    public int size(){
        return this.elementList.size();
    }

    public void set(int index, WorkoutElement w) {
        this.elementList.set(index, w);
    }

    public void remove(int index){
        this.elementList.remove(index);
        writeElementListFile();
    }

    public ArrayList<WorkoutElement> getElementListByUser(String username){
        ArrayList<WorkoutElement> l = new ArrayList<>();
        for (WorkoutElement w : this.elementList){
            if (w.getElementAuthor() == null || w.getElementAuthor().equalsIgnoreCase(username)){
                l.add(w);
            }
        }
        return l;
    }

    public void printElementList(){
        for (WorkoutElement w : elementList){
            System.out.println(w);
        }
    }
}
