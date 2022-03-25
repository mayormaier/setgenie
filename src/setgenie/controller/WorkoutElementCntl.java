package setgenie.controller;

import setgenie.model.WorkoutElement;
import setgenie.model.WorkoutElementList;
import setgenie.view.WorkoutElementUI;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WorkoutElementCntl implements ActionListener, DocumentListener {
    WorkoutElementList elementList;
    WorkoutElementUI elementUI;
    int listPosition;
    boolean fromListView = false;

    public WorkoutElementCntl() {
        this.elementList = new WorkoutElementList();
        this.elementUI = new WorkoutElementUI(this);
        this.listPosition = 0;
        updateButtons();
        addFieldListeners();
        validateButtons();
        validateFields();
        if (this.elementList.get(this.listPosition) != null){
            this.elementUI.updatePane(this.elementList.get(this.listPosition));
        }
        this.elementUI.setVisible(true);
    }
    public WorkoutElementCntl(int selectedRow, WorkoutElementList elements) {
        this.elementList = elements;
        this.listPosition = selectedRow;
        this.fromListView = true;
        this.elementUI = new WorkoutElementUI(this);
        updateButtons();
        addFieldListeners();
        validateButtons();
        validateFields();
        if (this.elementList.get(this.listPosition) != null){
            this.elementUI.updatePane(this.elementList.get(this.listPosition));
        }
        this.elementUI.setVisible(true);
    }

    public WorkoutElementCntl(WorkoutElementList elements) {
        this.elementList = elements;
        this.listPosition = -1;
        this.fromListView = true;
        this.elementUI = new WorkoutElementUI(this);
        updateButtons();
        addFieldListeners();
        validateButtons();
        validateFields();
        if (this.elementList.get(this.listPosition) != null){
            this.elementUI.updatePane(this.elementList.get(this.listPosition));
        }
        this.elementUI.setVisible(true);
    }

    public void updateButtons(){
        this.elementUI.previousButton.addActionListener(this);
        this.elementUI.nextButton.addActionListener(this);
        this.elementUI.addButton.addActionListener(this);
        this.elementUI.updateButton.addActionListener(this);
        this.elementUI.quitButton.addActionListener(this);
        this.elementUI.deleteButton.addActionListener(this);
    }

    public void addFieldListeners(){
        this.elementUI.qtyTextField.getDocument().addDocumentListener(this);
        this.elementUI.distTextField.getDocument().addDocumentListener(this);
        this.elementUI.intervalTextField.getDocument().addDocumentListener(this);
    }

    public void validateButtons(){
        if (this.listPosition - 1 >= 0) {
            this.elementUI.previousButton.setEnabled(true);
        } else {
            this.elementUI.previousButton.setEnabled(false);
        }
        if (this.listPosition + 1 < this.elementList.size()) {
            this.elementUI.nextButton.setEnabled(true);
        } else {
            this.elementUI.nextButton.setEnabled(false);
        }
        if (this.elementList.get(this.listPosition) != null){
            this.elementUI.deleteButton.setEnabled(true);
            this.elementUI.updateButton.setEnabled(true);
        } else {
            this.elementUI.deleteButton.setEnabled(false);
            this.elementUI.updateButton.setEnabled(false);
        }
        if (this.elementUI.fieldsAreValid()){
            this.elementUI.addButton.setEnabled(true);
        } else {
            this.elementUI.addButton.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == this.elementUI.previousButton){
            if (this.listPosition - 1 >= 0){
                this.listPosition = this.listPosition - 1;
                this.elementUI.updatePane(this.elementList.get(this.listPosition));
            }
            validateButtons();
        } else if (obj == this.elementUI.nextButton){
            if (this.listPosition + 1 < this.elementList.size()){
                this.listPosition++;
                this.elementUI.updatePane(this.elementList.get(this.listPosition));
            }
            validateButtons();
        } else if (obj == this.elementUI.addButton){
            WorkoutElement newElement = new WorkoutElement(this.elementUI.getQty(), this.elementUI.getDist(), this.elementUI.getInterval(), this.elementUI.getStroke());
            this.elementList.add(newElement);
            this.elementUI.clearFields();
            this.elementUI.updatePane(this.elementList.get(this.listPosition));
            validateButtons();
        } else if (obj == this.elementUI.updateButton){
            WorkoutElement replacementElement = new WorkoutElement(this.elementUI.getQty(), this.elementUI.getDist(), this.elementUI.getInterval(), this.elementUI.getStroke());
            this.elementList.set(this.listPosition, replacementElement);
        } else if (obj == this.elementUI.deleteButton){
            if (this.elementList.get(this.listPosition) != null){
                this.elementList.remove(this.listPosition);
            }
            if (this.listPosition > 0){
                this.listPosition--;
            } else if (this.listPosition < this.elementList.size() - 1){
                this.listPosition++;
            }
            if (this.elementList.get(this.listPosition) != null){
                this.elementUI.updatePane(this.elementList.get(this.listPosition));
            } else {
                this.elementUI.clearFields();
            }

        } else if (obj == this.elementUI.quitButton){
            if (fromListView){
                elementUI.dispose();
                ElementListCtl returnCtl = new ElementListCtl(elementList);
            } else {
                System.exit(0);
            }
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        validateFields();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        validateFields();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        validateFields();
    }

    public void validateFields(){
        if (this.elementUI.fieldsAreValid()){
            this.elementUI.addButton.setEnabled(true);
        } else {
            this.elementUI.addButton.setEnabled(false);
        }
    }

    public boolean getListViewStatus(){
        return this.fromListView;
    }
}
