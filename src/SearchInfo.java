import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Pratik on 5/9/2016.
 */
public class SearchInfo extends JFrame{

    JPanel taskPanel = new JPanel();
    JLabel title = new JLabel("Search Content");
    JButton search = new JButton("Search");
    JTextArea searchText = new JTextArea();
    JButton homeButton = new JButton("Home");

    public SearchInfo(){
        JFrame searchFrame = new JFrame("Search Information");

        taskPanel.setLayout(new GridLayout(4, 1));

        taskPanel.add(title);

        taskPanel.add(searchText);
        taskPanel.add(search);
        taskPanel.add(homeButton);

        searchFrame.add(taskPanel);
        searchFrame.setSize(400,400);
        searchFrame.setVisible(true);


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
