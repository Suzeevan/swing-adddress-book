package Quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Created by Anil Lama on 2/8/2015.
 */
public class CredentialView extends JFrame{

    public JTextField name;
    public JPasswordField password;
    public boolean bool = false;
    private SQL sqlObject;

    public CredentialView(){
        super("DWIT QUIZ");
        setLayout(null);

        sqlObject = new SQL();

        Icon img = new ImageIcon(getClass().getResource("logo.jpg"));
        JLabel logo = new JLabel(img,JLabel.LEFT);
        logo.setSize(40, 45);
        logo.setLocation(10, 10);
        add(logo);

        JLabel heading = new JLabel("WELCOME TO QUIZ APP", JLabel.CENTER);
        heading.setSize(300, 30);
        heading.setLocation(40, 0);

        JLabel heading1 = new JLabel("Created by Anil Lama", JLabel.CENTER);
        heading1.setSize(300, 30);
        heading1.setLocation(165, 135);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setSize(300, 30);
        nameLabel.setLocation(65, 35);
        JLabel pwLabel = new JLabel("Password: ");
        pwLabel.setSize(300, 30);
        pwLabel.setLocation(65, 65);
        final JButton enter = new JButton("Enter");
        enter.setSize(80, 30);
        enter.setLocation(165, 105);

        name = new JTextField(10);
        name.setSize(150, 25);
        name.setLocation(165, 35);

        password = new JPasswordField(10);
        password.setSize(150, 25);
        password.setLocation(165, 65);

        add(nameLabel);
        add(pwLabel);
        add(name);
        add(password);
        add(heading);
        add(heading1);
        add(enter);

        enter.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int dialogButton = 0;
                        if(sqlObject.loginValidate(name.getText(),password.getText())){
//                        if(name.getText().equals("Anil") && password.getText().equals("lama")){
                            dialogButton = 1;
                        }

                        if(dialogButton == 1){
                            Window w = SwingUtilities.getWindowAncestor(enter);
                            if (w != null) {
                                w.setVisible(false);

                                Prototype choice = new Prototype();
                                choice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                choice.setSize(400,200);
                                choice.setVisible(true);
                            }

                        }
                        else if(dialogButton==0){
                            JOptionPane.showMessageDialog(null,String.format("Username and Password mismatch!!\nPlease try again."),"Warning",JOptionPane.WARNING_MESSAGE);
                            setVisible(false);

                            CredentialView one = new CredentialView();
                            one.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            one.setSize(400,200);
                            one.setVisible(true);
                        }

                    }
                }
        );
    }

}
