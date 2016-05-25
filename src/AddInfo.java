import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Pratik on 5/9/2016.
 */
public class AddInfo extends JFrame{

    JLabel stat = new JLabel();
    JLabel headerLabel;
    JLabel nameLabel = new JLabel();
    JLabel addressLabel = new JLabel();
    JLabel numberLabel = new JLabel();
    JPanel taskPanel = new JPanel();
    TextArea nameTextarea = new TextArea();
    TextArea addressTextarea = new TextArea();
    TextArea numberTextarea = new TextArea();
    JButton addButton = new JButton("Add");
    JButton homeButton = new JButton("Home");

    public AddInfo(){
        JFrame addInfo = new JFrame("Add Information");

        taskPanel.setSize(800,700);
        taskPanel.setLayout(new GridLayout(4,2));

        nameLabel.setText("Name:   ");
        taskPanel.add(nameLabel);
        taskPanel.add(nameTextarea);
        addressLabel.setText("Address:   ");
        taskPanel.add(addressLabel);
        taskPanel.add(addressTextarea);
        numberLabel.setText("Number:   ");
        taskPanel.add(numberLabel);
        taskPanel.add(numberTextarea);
        taskPanel.add(addButton);
        taskPanel.add(homeButton);


        addInfo.add(taskPanel);
        addInfo.setVisible(true);
        addInfo.setSize(400,400);


        homeButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Window w = SwingUtilities.getWindowAncestor(homeButton);
                        if(w != null){
                            w.setVisible(false);

                            AddressBook addressBook = new AddressBook();
                        }
                    }
                }
        );




    }

}
