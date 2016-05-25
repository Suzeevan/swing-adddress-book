import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Pratik on 5/8/2016.
 */
public class AddressBook extends JFrame{

   Label headerLabel = new Label();

    public AddressBook(){
        JFrame mainFrame = new JFrame("Address Book");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(2,1));

        headerLabel.setText("Welcome to address book");
        mainFrame.add(headerLabel);




        // button panel
        JPanel buttonPanel = new JPanel();

        buttonPanel.setSize(400,100);
        final JButton addButton = new JButton("Add New");
        final JButton searchButton = new JButton("Search");

//        addButton.setActionCommand("add");
//        searchButton.setActionCommand("search");

        buttonPanel.add(addButton);
        buttonPanel.add(searchButton);


        mainFrame.add(headerLabel);
        mainFrame.add(buttonPanel);
        mainFrame.setVisible(true);


        addButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Window w = SwingUtilities.getWindowAncestor(addButton);
                        if(w != null){
                            w.setVisible(false);
                            AddInfo addInfo = new AddInfo();
                        }
                    }
                }
        );

        searchButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Window w = SwingUtilities.getWindowAncestor(searchButton);
                        if (w != null){
                            w.setVisible(false);
                            SearchInfo searchInfo = new SearchInfo();
                        }
                    }
                }
        );
    }


    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();

    }

}
