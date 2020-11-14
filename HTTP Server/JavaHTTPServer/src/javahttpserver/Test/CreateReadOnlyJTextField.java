/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahttpserver.Test;


import java.awt.FlowLayout;
 
import javax.swing.JFrame;
import javax.swing.JTextField;
 
public class CreateReadOnlyJTextField extends JFrame {
 
    private static final long serialVersionUID = 1L;
 
    public CreateReadOnlyJTextField() {
 
        // set flow layout for the frame
        this.getContentPane().setLayout(new FlowLayout());
 
        // create JTextField
        JTextField field = new JTextField();
        field.setText("Java Code Geeks");
 
        // Sets the specified boolean to indicate whether or not
        // this textfield should be editable.
        field.setEditable(false);
 
        // add textfield to frame
        add(field);
 
    }
 
    private static void createAndShowGUI() {
 
  //Create and set up the window.
 
  JFrame frame = new CreateReadOnlyJTextField();
 
  //Display the window.
 
  frame.pack();
 
  frame.setVisible(true);
 
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    }
 
    public static void main(String[] args) {
 
  //Schedule a job for the event-dispatching thread:
 
  //creating and showing this application's GUI.
 
  javax.swing.SwingUtilities.invokeLater(new Runnable() {
 
public void run() {
 
    createAndShowGUI(); 
 
}
 
  });
    }
 
}

