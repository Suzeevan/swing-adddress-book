package Quiz; /**
 * Created by Anil Lama on 11/18/2014.
 */

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.lang.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Formatter;
import java.io.File;


public class Prototype extends JFrame{

    String instn="";
    int dialogButton = 0,dialogResult;
    int show_hs;

    private Scanner instruction;
    private Scanner hs;

    private JButton Option1;
    private JButton Option2;
    private JButton Option3;
    private JButton Option4;
    private final JButton finish  = new JButton();

    private JLabel entrySentence1;
    private JLabel entrySentence2;


    public Prototype(){
        super("DWIT QUIZ");       //title of dialog-box

        setLayout(null);
        setBackground(Color.WHITE);

        Icon img = new ImageIcon(getClass().getResource("logo.jpg"));
        JLabel logo = new JLabel(img,JLabel.LEFT);
        logo.setSize(40, 45);
        logo.setLocation(10, 10);
        add(logo);

        entrySentence1 = new JLabel("WELCOME TO QUIZ APP",JLabel.CENTER);
        entrySentence1.setSize(300, 30);
        entrySentence1.setLocation(40, 10);
        add(entrySentence1);

        entrySentence2 = new JLabel("\nCreated by Anil Lama",JLabel.CENTER);
        entrySentence2.setSize(300, 30);
        entrySentence2.setLocation(165,135);
        add(entrySentence2);

        Option1 = new JButton("Play");
        Option1.setSize(102, 30);
        Option1.setLocation(75, 50);

        Option2 = new JButton("HighScore");
        Option2.setSize(102, 30);
        Option2.setLocation(205, 50);

        Option3 = new JButton("Instructions");
        Option3.setSize(102, 30);
        Option3.setLocation(75, 90);

        Option4 = new JButton("Quit");
        Option4.setSize(102, 30);
        Option4.setLocation(205, 90);

        add(Option1);
        add(Option2);
        add(Option3);
        add(Option4);

        Option1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int dialogButton = 1;

                        if (dialogButton == 1) {
                            Window w = SwingUtilities.getWindowAncestor(Option1);
                            if (w != null) {
                                w.setVisible(false);

                                PrototypeTesting play = new PrototypeTesting();
                                play.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                play.setSize(450, 250);
                                play.setVisible(true);
                            }
                        }
                    }
                }
        );



        Option2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        highscore();
                    }
                }
        );
        Option3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        instruction();
                    }
                }
        );

        Option4.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        quit(Option4);
                    }

                }
        );
    }

    public void highscore() {
        try {
            hs = new Scanner(new File("C:\\practice\\highscore.txt"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "High score file error occurrence.");
        }
        while (hs.hasNextInt()) {
            show_hs = hs.nextInt();
        }
        JOptionPane.showMessageDialog(null, String.format(" Highscore:     %d", show_hs),"High Score",JOptionPane.PLAIN_MESSAGE);
        hs.close();
    }

    public void instruction() {
        try{
            instruction = new Scanner(new File("C:\\practice\\instruction.txt"));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "\n\t\tINSTRUCTIONS!!\n" +
                    "\n\t# Choose the correct option to win.\n# If chosen the wrong option, you lose.\n");
        }
        while(instruction.hasNext()){
            instn = instn.concat(instruction.nextLine()+"\n");
        }
        JOptionPane.showMessageDialog(null, String.format("%s", instn),"Instructions",JOptionPane.PLAIN_MESSAGE);
        instn = "";
        instruction.close();
    }


    public void quit(JButton finish) {
        dialogButton = JOptionPane.YES_NO_CANCEL_OPTION;
        dialogResult = JOptionPane.showConfirmDialog(null, "            Are you sure you want to exit?", "Quit", dialogButton,JOptionPane.PLAIN_MESSAGE);
        if (dialogResult == JOptionPane.YES_OPTION) {
            dialogButton = 0;
        }
        else if (dialogResult == JOptionPane.NO_OPTION) {
            dialogButton = 1;
        }
        else if (dialogButton == JOptionPane.CANCEL_OPTION) {
            dialogButton = 1;
        }

        if(dialogButton == 0){
            System.exit(0);
        }
    }
}
