package setgenie.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ElementTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Quantity", "Distance", "Stroke", "Interval"};
    private ArrayList<WorkoutElement> elementList;
    public ElementTableModel(ArrayList<WorkoutElement> newElementList){this.elementList = newElementList;}

    @Override
    public int getRowCount() {
        return elementList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> (Object) elementList.get(rowIndex).getElementQuantity();
            case 1 -> (Object) elementList.get(rowIndex).getElementDistance();
            case 2 -> (Object) elementList.get(rowIndex).getElementStroke();
            case 3 -> (Object) elementList.get(rowIndex).getElementInterval();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int col){return columnNames[col];}
}
