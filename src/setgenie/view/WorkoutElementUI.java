package setgenie.view;

import setgenie.controller.WorkoutElementCntl;
import setgenie.model.WorkoutElement;

import javax.swing.*;

public class WorkoutElementUI extends JFrame{
    private JPanel panel1;
    private JLabel titleLabel;
    private JLabel quantityLabel;
    private JLabel distanceLabel;
    private JLabel strokeLabel;
    private JLabel intervalLabel;
    private JLabel totalDistanceLabel;
    private JLabel courseLabel;
    private JLabel totalTimeLabel;
    private JLabel totalTimeVal;
    private JLabel totalDistVal;
    public JButton previousButton;
    public JButton nextButton;
    public JButton quitButton;
    public JButton addButton;
    public JButton updateButton;
    public JButton deleteButton;
    public JTextField qtyTextField;
    public JTextField distTextField;
    public JTextField intervalTextField;
    private JComboBox strokeDropdown;

    private WorkoutElementCntl elementCtl;

    public WorkoutElementUI(WorkoutElementCntl ctl) {
        this.elementCtl = ctl;
        this.strokeDropdown.setModel(new DefaultComboBoxModel(WorkoutElement.STROKE.values()));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(850, 300);
        add(panel1);
    }

    public void updatePane(WorkoutElement e){
        if (e != null){
            this.qtyTextField.setText(Integer.toString(e.getElementQuantity()));
            this.distTextField.setText(Integer.toString(e.getElementDistance()));
            this.intervalTextField.setText((Integer.toString(e.getElementInterval())));
            this.strokeDropdown.setSelectedItem(e.getElementStroke());
            this.totalDistVal.setText(Integer.toString(e.getElementTotalDistance()));
            this.totalTimeVal.setText(Integer.toString(e.getElementTotalDuration()));
        }
    }

    public int getQty(){
        return Integer.parseInt(qtyTextField.getText());
    }

    public int getDist(){
        return Integer.parseInt(distTextField.getText());
    }

    public WorkoutElement.STROKE getStroke(){
        return (WorkoutElement.STROKE) strokeDropdown.getSelectedItem();
    }

    public int getInterval() {
        return Integer.parseInt(intervalTextField.getText());
    }

    public boolean fieldsAreValid(){
        return !qtyTextField.getText().equals("") && !distTextField.getText().equals("") && !intervalTextField.getText().equals("");
    }

    public void clearFields(){
        qtyTextField.setText("");
        distTextField.setText("");
        intervalTextField.setText("");
    }

}
