import javax.swing.*;
import java.awt.*;

public class StatusWindow {
    Occupant creature;
    JFrame frame;
    JPanel renamePanel, namePanel;
    JLabel nameLabel;
    JTextField renameField;
    JButton renameButton, closeButton;

    StatusWindow(Occupant creature){
        this.creature = creature;
        frame = new JFrame(creature.name + " Status");
        renamePanel = new JPanel();
        namePanel = new JPanel();
        nameLabel = new JLabel("Name: " + creature.name);
        renameField = new JTextField("Enter new name here");
        renameButton = new JButton("Rename");

        namePanel.add(nameLabel);
        renamePanel.add(renameField);
        renamePanel.add(renameButton);


        frame.add(namePanel, BorderLayout.PAGE_START);
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
