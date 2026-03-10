
import java.awt.Robot;
import java.awt.event.InputEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author AABC2
 */
public class Main {
    static boolean isOn = false;
    public static void main(String[] args) {

        // create the jframe buttons
        JFrame frame = new JFrame("Autoclicker");
        JButton onButton = new JButton("ON");
        JButton offButton = new JButton("OFF");

        onButton.setBounds(100,50,100,100);
        offButton.setBounds(200,50,100,100);

        // check if the button is press 
        onButton.addActionListener(e ->{
            try {
                On(100);  // the speed of the clicker
            } catch (Exception ex) {
                ex.printStackTrace();
            }
         });

        offButton.addActionListener(e -> Off());

        // setting the Jframe window
        frame.add(onButton);
        frame.add(offButton);

        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        
    }

    public static void Off() {
        isOn=false;
        System.out.println("Autoclicker off");
    }

    public static void On(int speed) throws Exception{
        isOn = true;

        Robot robot = new Robot();
        
        Thread.sleep(5000); // delay on each activation
        System.out.println("Autoclicker on");

        for (int i = 0; i < 100 && isOn; i++){
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(speed);
        }
    }

}
