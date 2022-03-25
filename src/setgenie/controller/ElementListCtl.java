package setgenie.controller;

import setgenie.model.ElementTableModel;
import setgenie.model.WorkoutElement;
import setgenie.model.WorkoutElementList;
import setgenie.view.ElementListUI;
import setgenie.view.WorkoutElementUI;

import java.util.ArrayList;

public class ElementListCtl {
    private WorkoutElementList elementList;
    private ElementTableModel elementTableModel;
    private ElementListUI elementListUI;
    private WorkoutElementUI singleElementUI;
    private WorkoutElementCntl singleElementCtl;

    public ElementTableModel getTableModel(){
        return this.elementTableModel;
    }

    public ElementListCtl(){
        elementList = new WorkoutElementList();
        createSampleData();
        elementTableModel = new ElementTableModel(elementList.getElementList());
        elementListUI = new ElementListUI(this);
        elementListUI.setVisible(true);
    }

    public ElementListCtl(WorkoutElementList elementList){
        this.elementList = elementList;
        elementTableModel = new ElementTableModel(elementList.getElementList());
        elementListUI = new ElementListUI(this);
        elementListUI.setVisible(true);
    }

    public void getElementDetailUI(int selectedModelRow){
        elementListUI.dispose();
        WorkoutElementCntl elementCtl = new WorkoutElementCntl(selectedModelRow, elementList);
    }

    public void getElementDetailUI(){
        elementListUI.dispose();
        WorkoutElementCntl elementCtl = new WorkoutElementCntl(elementList);
        elementCtl.elementUI.clearFields();
    }

    //qty, dist, interval, stroke
    public void createSampleData(){
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

    public ArrayList<WorkoutElement> getElementArrayList() {return this.elementList.getElementList();}
}
