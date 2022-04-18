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
    private String currentUser;

    public ElementTableModel getTableModel(){
        return this.elementTableModel;
    }

    public ElementListCtl(){
        currentUser = null;
        elementList = new WorkoutElementList();
        elementTableModel = new ElementTableModel(elementList.getElementList());
        elementListUI = new ElementListUI(this);
        elementListUI.setVisible(true);
    }

    public ElementListCtl(WorkoutElementList elementList){
        currentUser = null;
        this.elementList = elementList;
        elementTableModel = new ElementTableModel(elementList.getElementList());
        elementListUI = new ElementListUI(this);
        elementListUI.setVisible(true);
    }

    public ElementListCtl(String username){
        this.elementList = new WorkoutElementList(username);
        currentUser = username;
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

    public ArrayList<WorkoutElement> getElementArrayList() {return this.elementList.getElementList();}
}
