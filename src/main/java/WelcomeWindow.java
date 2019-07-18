import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is the welcoming window that is used to get initial user input that
 * sets the parameters of the simulation world.
 * */

public class WelcomeWindow {
    JFrame frame;
    JPanel fieldsPanel, buttonPanel;
    JLabel rowsLabel, colsLabel, plantsLabel, cowsLabel;
    JTextField rowsField, colsField, plantsField, cowsField;
    JButton startButton;

    WelcomeWindow(){
        frame = new JFrame("Welcome to Nature!");
        fieldsPanel = new JPanel();
        buttonPanel = new JPanel();
        rowsLabel = new JLabel("Number of rows: ");
        colsLabel = new JLabel("Number of columns: ");
        plantsLabel = new JLabel("Number of plants: ");
        cowsLabel = new JLabel("Number of cows: ");
        rowsField = new JTextField("");
        colsField = new JTextField("");
        plantsField = new JTextField("");
        cowsField = new JTextField("");
        startButton = new JButton("Start!");

        //add functionality to fields and buttons

        startButton.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            World world = new World(getStartRows(), getStartCols(), getStartPlants(), getStartCows());
            frame.setVisible(false);
            frame.dispose();
            //world.debugInfo();
        }));

        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));
        buttonPanel.setLayout(new FlowLayout());

        fieldsPanel.add(rowsLabel);
        fieldsPanel.add(rowsField);
        fieldsPanel.add(colsLabel);
        fieldsPanel.add(colsField);
        fieldsPanel.add(plantsLabel);
        fieldsPanel.add(plantsField);
        fieldsPanel.add(cowsLabel);
        fieldsPanel.add(cowsField);
        buttonPanel.add(startButton);

        frame.add(fieldsPanel, BorderLayout.PAGE_START);
        frame.add(buttonPanel, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Gets the number of starting rows from the correct textbox.
     * @return The user's desired number of starting rows.
     * */

    public int getStartRows() {
        return Integer.parseInt(rowsField.getText());
    }

    /**
     * Gets the number of starting columns from the correct textbox.
     * @return The user's desired number of starting columns.
     * */

    public int getStartCols() {
        return Integer.parseInt(colsField.getText());
    }

    /**
     * Gets the number of starting plants from the correct textbox.
     * @return The user's desired number of starting plants.
     * */

    public int getStartPlants() {
        return Integer.parseInt(plantsField.getText());
    }

    /**
     * Gets the number of starting cows from the correct textbox.
     * @return The user's desired number of starting cows.
     * */

    public int getStartCows() {
        return Integer.parseInt(cowsField.getText());
    }
}
