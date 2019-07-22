import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatusWindow {
    Occupant creature;
    JFrame frame;
    JPanel fieldsPanel, buttonsPanel;
    JLabel nameLabel;
    JTextField renameField;
    JButton renameButton, closeButton;

    StatusWindow(Occupant creature){
        this.creature = creature;
        frame = new JFrame(creature.name + " Status");
        fieldsPanel = new JPanel();
        buttonsPanel = new JPanel();
        nameLabel = new JLabel("Name: " + creature.name);
        renameField = new JTextField("Enter new name here");
        renameButton = new JButton("Rename");

        fieldsPanel.add(nameLabel);
        fieldsPanel.add(renameField);
        buttonsPanel.add(renameButton);

        frame.add(fieldsPanel, BorderLayout.PAGE_START);
        frame.add(buttonsPanel, BorderLayout.PAGE_END);
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
