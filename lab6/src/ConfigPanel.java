import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JLabel labelSize;
    JSpinner sidesField; //number of sides
    JComboBox colorCombo; //color of the shape
    JComboBox shapeCombo;
    JSpinner shapeSize;

    public ConfigPanel(MainFrame frame){
        this.frame = frame;
        init();
    }

    private void init(){
        label = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0,0, 100, 1));
        sidesField.setValue(6);

        //labelSize = new JLabel("Size:");
        //shapeSize = new JSpinner((new SpinnerNumberModel(0,0,500,1)));
        //shapeSize.setValue(100);

        String[] colors = {"Black", "Random"};
        colorCombo = new JComboBox(colors);

        String[] shapes = {"Polygons", "Ellipses"};
        shapeCombo = new JComboBox(shapes);


        add(label);
        add(sidesField);
        //add(labelSize);
        //add(shapeSize);
        add(colorCombo);
        add(shapeCombo);


    }
}
