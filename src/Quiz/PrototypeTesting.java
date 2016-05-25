package Quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Anil Lama on 2/11/2015.
 */
public class PrototypeTesting extends JFrame {

    String opt1, opt2, opt3, opt4, qstn, ans;

    int dialogButton = 0, dialogResult;
    int count;
    int highestScore;

    static int question_number = 1;

    static int score = 0;
    static int state = 0;

    private Scanner hs;
    private Scanner question;
    private Scanner option;
    private Scanner answer;

    private Formatter highscore;
    private SQL sqlObject;

    public PrototypeTesting() {
        super("DWIT QUIZ");
        setLayout(null);

        String[] lifelines = {"Lifelines", "50 : 50"};
        sqlObject = new SQL();

        Icon img = new ImageIcon(getClass().getResource("logo.jpg"));
        JLabel logo = new JLabel(img, JLabel.LEFT);
        logo.setSize(40, 45);
        logo.setLocation(10, 10);
        add(logo);

        JLabel scoreLabel = new JLabel(String.format("Score: %d", score), JLabel.RIGHT);
        scoreLabel.setSize(300, 30);
        scoreLabel.setLocation(95, 0);

        questionGenerator();
        optionGenerator();
        answerGenerator();

        JLabel questionLabel = new JLabel(String.format("%d: %s", question_number, qstn), JLabel.CENTER);
        questionLabel.setSize(300, 30);
        questionLabel.setLocation(50, 50);

        final JButton Option1 = new JButton(String.format("%s", opt1));
        Option1.setToolTipText(opt1);
        Option1.setSize(170, 40);
        Option1.setLocation(25, 90);
        Option1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (opt1.equals(ans)) {

                            Option1.setBackground(Color.GREEN);
                            JOptionPane.showMessageDialog(null, "Correct Answer", "Result", JOptionPane.PLAIN_MESSAGE);
                            scoreIncrementer(question_number);
                            question_number++;
                            //setVisible(false);

                            if (question_number > 10) {
                                highScoreMechanism(score);
                                JOptionPane.showMessageDialog(null, String.format("Perfect!! Good Player\nFinal score: %d", score), "Result", JOptionPane.PLAIN_MESSAGE);
                                JOptionPane.showMessageDialog(null, "Thanks for playing", "Result", JOptionPane.PLAIN_MESSAGE);
                                setVisible(false);
                                question_number = 1;
                                score = 0;

                                Prototype choice = new Prototype();
                                choice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                choice.setSize(400, 200);
                                choice.setVisible(true);
                            } else {
                                setVisible(false);
                                PrototypeTesting again = new PrototypeTesting();
                                again.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                again.setSize(450, 250);
                                again.setVisible(true);
                            }

                        } else {
                            Option1.setBackground(Color.RED);
                            highScoreMechanism(score);
                            question_number = 1;
                            JOptionPane.showMessageDialog(null, String.format("Incorrect Answer\nFinal score: %d", score), "Result", JOptionPane.PLAIN_MESSAGE);
                            score = 0;
                            Window w = SwingUtilities.getWindowAncestor(Option1);
                            if (w != null) {
                                w.setVisible(false);
                                state = 0;

                                Prototype choice = new Prototype();
                                choice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                choice.setSize(400, 200);
                                choice.setVisible(true);
                            }

                        }

                    }
                }
        );

        final JButton Option2 = new JButton(String.format("%s", opt2));
        Option2.setToolTipText(opt2);
        Option2.setSize(170, 40);
        Option2.setLocation(238, 90);
        Option2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (opt2.equals(ans)) {
                            Option2.setBackground(Color.GREEN);
                            JOptionPane.showMessageDialog(null, "Correct Answer", "Result", JOptionPane.PLAIN_MESSAGE);
                            scoreIncrementer(question_number);
                            question_number++;
                            //setVisible(false);

                            if (question_number > 10) {
                                highScoreMechanism(score);
                                JOptionPane.showMessageDialog(null, String.format("Perfect!! Good Player\nFinal score: %d", score), "Result", JOptionPane.PLAIN_MESSAGE);
                                JOptionPane.showMessageDialog(null, "Thanks for playing", "Result", JOptionPane.PLAIN_MESSAGE);
                                setVisible(false);
                                question_number = 1;
                                score = 0;

                                Prototype choice = new Prototype();
                                choice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                choice.setSize(400, 200);
                                choice.setVisible(true);
                            } else {
                                setVisible(false);
                                PrototypeTesting again = new PrototypeTesting();
                                again.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                again.setSize(450, 250);
                                again.setVisible(true);
                            }
                        } else {
                            Option2.setBackground(Color.RED);
                            highScoreMechanism(score);
                            question_number = 1;
                            JOptionPane.showMessageDialog(null, String.format("Incorrect Answer\nFinal score: %d", score), "Result", JOptionPane.PLAIN_MESSAGE);
                            score = 0;
                            Window w = SwingUtilities.getWindowAncestor(Option2);
                            if (w != null) {
                                w.setVisible(false);
                                state = 0;

                                Prototype choice = new Prototype();
                                choice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                choice.setSize(400, 200);
                                choice.setVisible(true);
                            }


                        }
                    }
                }
        );

        final JButton Option3 = new JButton(String.format("%s", opt3));
        Option3.setToolTipText(opt3);
        Option3.setSize(170, 40);
        Option3.setLocation(25, 140);
        Option3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (opt3.equals(ans)) {
                            Option3.setBackground(Color.GREEN);
                            JOptionPane.showMessageDialog(null, "Correct Answer", "Result", JOptionPane.PLAIN_MESSAGE);
                            scoreIncrementer(question_number);
                            question_number++;
                            //setVisible(false);

                            if (question_number > 10) {
                                highScoreMechanism(score);
                                JOptionPane.showMessageDialog(null, String.format("Perfect!! Good Player\nFinal score: %d", score), "Result", JOptionPane.PLAIN_MESSAGE);
                                JOptionPane.showMessageDialog(null, "Thanks for playing!!", "Result", JOptionPane.PLAIN_MESSAGE);
                                setVisible(false);
                                question_number = 1;
                                score = 0;

                                Prototype choice1 = new Prototype();
                                choice1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                choice1.setSize(400, 200);
                                choice1.setVisible(true);
                            } else {
                                setVisible(false);
                                PrototypeTesting again = new PrototypeTesting();
                                again.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                again.setSize(450, 250);
                                again.setVisible(true);
                            }

                        } else {
                            Option3.setBackground(Color.RED);
                            highScoreMechanism(score);
                            question_number = 1;
                            JOptionPane.showMessageDialog(null, String.format("Incorrect Answer\nFinal score: %d", score), "Result", JOptionPane.PLAIN_MESSAGE);
                            score = 0;
                            Window w = SwingUtilities.getWindowAncestor(Option3);
                            if (w != null) {
                                w.setVisible(false);
                                state = 0;

                                Prototype choice = new Prototype();
                                choice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                choice.setSize(400, 200);
                                choice.setVisible(true);
                            }

                        }
                    }
                }
        );

        final JButton Option4 = new JButton(String.format("%s", opt4));
        Option4.setToolTipText(opt4);
        Option4.setSize(170, 40);
        Option4.setLocation(238, 140);
        Option4.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (opt4.equals(ans)) {
                            Option4.setBackground(Color.GREEN);
                            JOptionPane.showMessageDialog(null, "Correct Answer", "Result", JOptionPane.PLAIN_MESSAGE);
                            scoreIncrementer(question_number);
                            question_number++;
                            //setVisible(false);

                            if (question_number > 10) {
                                highScoreMechanism(score);
                                JOptionPane.showMessageDialog(null, String.format("Perfect!! Fantastic Player\nFinal score: %d", score), "Score", JOptionPane.PLAIN_MESSAGE);
                                JOptionPane.showMessageDialog(null, "Thanks for playing");
                                setVisible(false);
                                question_number = 1;
                                score = 0;

                                Prototype choice = new Prototype();
                                choice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                choice.setSize(400, 200);
                                choice.setVisible(true);
                            } else {
                                setVisible(false);
                                PrototypeTesting again = new PrototypeTesting();
                                again.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                again.setSize(450, 250);
                                again.setVisible(true);
                            }

                        } else {
                            Option4.setBackground(Color.RED);
                            highScoreMechanism(score);
                            question_number = 1;
                            JOptionPane.showMessageDialog(null, String.format("Incorrect Answer\nFinal score: %d", score), "Result", JOptionPane.PLAIN_MESSAGE);
                            score = 0;
                            Window w = SwingUtilities.getWindowAncestor(Option4);
                            if (w != null) {
                                w.setVisible(false);
                                state = 0;

                                Prototype choice = new Prototype();
                                choice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                choice.setSize(400, 200);
                                choice.setVisible(true);
                            }

                        }
                    }
                }
        );

        final JButton quit = new JButton(String.format("Quit to main menu"));
        quit.setToolTipText("Quit to main menu.");
        quit.setSize(70, 20);
        quit.setLocation(363, 190);
        quit.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        quit(quit);
                    }
                }
        );

        add(Option1);
        add(Option2);
        add(Option3);
        add(Option4);
        add(quit);
        add(scoreLabel);
        add(questionLabel);

        final JComboBox box = new JComboBox(lifelines);
        box.setSize(110, 30);
        box.setLocation(140, 5);
        add(box);
        box.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int rtnum1, rtnum2;
                        int i;
                        if (state == 0) {
                            if (box.getSelectedIndex() == 1) {
                                if (opt1.equals(ans)) {
                                    i = 1;
                                    rtnum1 = randomGenerator(i);
                                    rtnum2 = randomGenerator(i);
                                    if (rtnum1 == rtnum2) {
                                        do {
                                            rtnum2 = randomGenerator(i);
                                        } while (rtnum1 == rtnum2);
                                    }
                                    if (rtnum1 == 2) {
                                        Option2.setVisible(false);
                                    } else if (rtnum1 == 3) {
                                        Option3.setVisible(false);
                                    } else if (rtnum1 == 4) {
                                        Option4.setVisible(false);
                                    }

                                    if (rtnum2 == 2) {
                                        Option2.setVisible(false);
                                    } else if (rtnum2 == 3) {
                                        Option3.setVisible(false);
                                    } else if (rtnum2 == 4) {
                                        Option4.setVisible(false);
                                    }
                                } else if (opt2.equals(ans)) {

                                    i = 2;
                                    rtnum1 = randomGenerator(i);
                                    rtnum2 = randomGenerator(i);
                                    if (rtnum1 == rtnum2) {
                                        do {
                                            rtnum2 = randomGenerator(i);
                                        } while (rtnum1 == rtnum2);
                                    }

                                    if (rtnum1 == 1) {
                                        Option1.setVisible(false);
                                    } else if (rtnum1 == 3) {
                                        Option3.setVisible(false);
                                    } else if (rtnum1 == 4) {
                                        Option4.setVisible(false);
                                    }

                                    if (rtnum2 == 1) {
                                        Option1.setVisible(false);
                                    } else if (rtnum2 == 3) {
                                        Option3.setVisible(false);
                                    } else if (rtnum2 == 4) {
                                        Option4.setVisible(false);
                                    }
                                } else if (opt3.equals(ans)) {

                                    i = 3;
                                    rtnum1 = randomGenerator(i);
                                    rtnum2 = randomGenerator(i);
                                    if (rtnum1 == rtnum2) {
                                        do {
                                            rtnum2 = randomGenerator(i);
                                        } while (rtnum1 == rtnum2);
                                    }

                                    if (rtnum1 == 1) {
                                        Option1.setVisible(false);
                                    } else if (rtnum1 == 2) {
                                        Option2.setVisible(false);
                                    } else if (rtnum1 == 4) {
                                        Option4.setVisible(false);
                                    }

                                    if (rtnum2 == 1) {
                                        Option1.setVisible(false);
                                    } else if (rtnum2 == 2) {
                                        Option2.setVisible(false);
                                    } else if (rtnum2 == 4) {
                                        Option4.setVisible(false);
                                    }
                                } else if (opt4.equals(ans)) {

                                    i = 4;
                                    rtnum1 = randomGenerator(i);
                                    rtnum2 = randomGenerator(i);
                                    if (rtnum1 == rtnum2) {
                                        do {
                                            rtnum2 = randomGenerator(i);
                                        } while (rtnum1 == rtnum2);
                                    }

                                    if (rtnum1 == 1) {
                                        Option1.setVisible(false);
                                    } else if (rtnum1 == 2) {
                                        Option2.setVisible(false);
                                    } else if (rtnum1 == 3) {
                                        Option3.setVisible(false);
                                    }

                                    if (rtnum2 == 1) {
                                        Option1.setVisible(false);
                                    } else if (rtnum2 == 2) {
                                        Option2.setVisible(false);
                                    } else if (rtnum2 == 3) {
                                        Option3.setVisible(false);
                                    }
                                }
                                state = 1;
                            }
                        }

                    }
                }
        );

    }

    public void quit(JButton finish) {
        dialogButton = JOptionPane.YES_NO_CANCEL_OPTION;
        dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit to main menu?", "Quit", dialogButton, JOptionPane.PLAIN_MESSAGE);
        if (dialogResult == JOptionPane.YES_OPTION) {
            dialogButton = 0;
        } else if (dialogResult == JOptionPane.NO_OPTION) {
            dialogButton = 1;
        } else if (dialogButton == JOptionPane.CANCEL_OPTION) {
            dialogButton = 1;
        }

        if (dialogButton == 0) {
            highScoreMechanism(score);
            JOptionPane.showMessageDialog(null, String.format("Final score: %d", score), "Score", JOptionPane.PLAIN_MESSAGE);


            score = 0;
            question_number = 1;
            state = 0;
            int dialogButton = 1;

            if (dialogButton == 1) {
                Window w = SwingUtilities.getWindowAncestor(finish);
                if (w != null) {
                    w.setVisible(false);

                    Prototype choice = new Prototype();
                    choice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    choice.setSize(400, 200);
                    choice.setVisible(true);
                }
            }
        }
    }

    public void questionGenerator() {
        //QUESTION GENERATOR
        try {
//            question = new Scanner(new File("C:\\practice\\question.txt"));
            qstn = sqlObject.selectQuestion(question_number);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Couldn't find the question file.");
        }
    }

    public void optionGenerator() {
        //OPTION GENERATOR
        try {

            String[] options = sqlObject.selectOption(question_number);
            opt1 = options[0];
            opt2 = options[1];
            opt3 = options[2];
            opt4 = options[3];


        } catch (Exception e) {
            System.out.println("Option File not found!!");
        }
    }

    public void answerGenerator() {
        //ANSWER GENERATOR
        try {
            ans = sqlObject.selectAnswer(question_number);
        } catch (Exception e) {
            System.out.println("Couldn't find the solution file.");
        }
    }

    public void scoreIncrementer(int qstn_no) {
        if (qstn_no == 1) {
            score += 2000;
        } else if (qstn_no == 2) {
            score += 3000;
        } else if (qstn_no == 3) {
            score += 5000;
        } else if (qstn_no == 4) {
            score += 10000;
        } else if (qstn_no == 5) {
            score += 20000;
        } else if (qstn_no == 6) {
            score += 40000;
        } else if (qstn_no == 7) {
            score += 80000;
        } else if (qstn_no == 8) {
            score += 160000;
        } else if (qstn_no == 9) {
            score += 320000;
        } else if (qstn_no == 10) {
            score += 360000;
        }
    }

    public int randomGenerator(int i) {
        Random rand = new Random();
        int number = rand.nextInt(4);
        number = number + 1;

        if (number == i) {
            do {
                number = rand.nextInt(4);
                number = number + 1;
            } while (number == i);
        }
        return number;
    }

    //working for highest score.
    public void highScoreMechanism(int nowScore) {
        try {
            hs = new Scanner(new File("C:\\practice\\highscore.txt"));
            highscore = new Formatter(new File("C:\\practice\\highscore.txt"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "High score file error occurrence.");
        }
        if (hs.hasNextInt() == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        while (hs.hasNextInt()) {
            highestScore = hs.nextInt();
        }

        if (nowScore > highestScore) {
            System.out.printf("wrongplace: %d\n", highestScore);
            highscore.format("%d", nowScore);
        }

        highscore.close();
        hs.close();
    }

}
