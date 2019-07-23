import javax.swing.*;
import java.awt.*;

public class StatusWindow {
    Occupant creature;
    JFrame frame;
    JPanel renamePanel, namePanel, energyPanel;
    JLabel nameLabel, energyLabel;
    JTextField renameField;
    JButton renameButton, closeButton;

    StatusWindow(Occupant creature){
        this.creature = creature;
        frame = new JFrame(creature.name + " Status");
        renamePanel = new JPanel();
        namePanel = new JPanel();
        energyPanel = new JPanel();
        nameLabel = new JLabel("Name: " + creature.name);
        renameField = new JTextField("Enter new name here");
        renameButton = new JButton("Rename");
        energyLabel = new JLabel(("Energy: " + creature.energy));

        namePanel.add(nameLabel);
        renamePanel.add(renameField);
        renamePanel.add(renameButton);
        energyPanel.add(energyLabel);


        frame.add(namePanel, BorderLayout.PAGE_START);
        frame.add(energyPanel);
        frame.add(renamePanel, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        renameButton.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            creature.rename(this.getNewName());
        }));
    }

    public String getNewName(){
        return renameField.getText();
    }

}
