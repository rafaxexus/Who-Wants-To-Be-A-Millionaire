import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;




public class JeapordyGUI extends JPanel implements ActionListener{
 

 JButton startbutton, instructionbutton;  // startbutton and instructionbutton
 boolean starts = false;
 public static QuestionWindowPanel  p; // the panel for question window
  
 public  JPanel startmenupanel(){ // start menu
 
   
 
  
 startbutton = new JButton ("Start"); // creates start button 
 startbutton.setPreferredSize(new Dimension(0,40)); // gives the buttons its size
 startbutton.addActionListener (this); // adds action listener
 
 instructionbutton = new JButton ("Instructions"); // creates instructions button 
 instructionbutton.addActionListener(this); // adds action listener
 instructionbutton.setPreferredSize(new Dimension(0,40)); // gives the buttons its size
 
 //startmenu panel
 JPanel startmenu = new JPanel(); //creates panel to put buttons on to
 startmenu.setBackground(Color.blue); // gives the startmenu panel a background of blue
 
 
 GridLayout startmenulayout = new GridLayout(1,2,30,0); // creates a new GridLayout
 
 startmenu.setLayout(startmenulayout); // sets the startmenu panel layout to startmenulayout which is a gridlayout
 
 startmenu.add(startbutton); // adds start button and the position of the button on the panel
 
 startmenu.add(instructionbutton) ; // adds instruction button and the position of the button on the panel

 return startmenu; // returns startmenu
 }
  
 
 public JPanel backgrounds(){// background Jpanel
  
  JPanel backgrounds = new JPanel(); //creates panel to put background stuff on to
  backgrounds.setBackground(Color.blue); // makes the panel background blue
  
  return backgrounds; //returns this panel
  
 }
 
 public void actionPerformed (ActionEvent e){ // creates action listeners

  //instruction button action listener
  if (e.getSource() == instructionbutton) 
  {
   JOptionPane.showMessageDialog(null, "Instructions:\nWarning: In order to play this game, you need a good understanding of GUI." +
            "\n\nTo advance towards the next levels, you need to answer questions correctly, after each " +
            "correctly answered question,\n you will need to decide to keep your score and leave or to keep " +
            "going to next rounds.\n\nYou win when you reach one million dollars.\n\nThere are lifelines to help you in case" +
            " you become stuck (Use them wisely).","Instructions", JOptionPane.INFORMATION_MESSAGE); // displays the instructions message (a popup)
  }

  // startmenu button action listener
  else if (e.getSource() == startbutton) 
  {
   starts = true; // turns starts boolean in to true when this is pressed
  }

 }
 
 
 private void createAndShowGUI(){
  //creates and sets up the window
  
  JFrame frame = new JFrame("IMPROVISED - JEA" +
    "PORDY"); // creates a frame with the name of IMPROVISED - JEAPORDY
  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exits the program when closed
  
  frame.setLayout(new BorderLayout()); // creates a new border layout for the frame
  
  frame.setSize(650,500); // sets frame to this size 
  
  //content added to window
  
  frame.add (backgrounds()); // adds the backgrounds panel (a panel for the backgroun)
  frame.add (startmenupanel(), BorderLayout.SOUTH); // adds the start menu panale ( includes buttons)
  
  StartMenuGraphics drawing = new StartMenuGraphics();
  frame.add(drawing); // adds this drawing to the frame.
  
  QuestionDeck qd = new QuestionDeck ();// creates new question deck
  if (starts = true) // when it turns true, other things happen to the frame.
  {
   
   qd.fill(); // fills the qd questiondeck
   p = new QuestionWindowPanel(qd); // creates new questions window panel with question deck 
   
     p.setSize(600, 200); // sets panel size
     
     frame.add(p); // adds the p to the frame.
  }  
  
  
  //displays Frame/Window 
  frame.setVisible (true);
  
 }
 
 public static void main (String[] args){
  
  
  JeapordyGUI jg = new JeapordyGUI();
    jg.createAndShowGUI();
 }
 

}



