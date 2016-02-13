package Application;

// Created by Clayton Paplaczyk
//  Description: GUI

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

public class CreatePanel extends JPanel
 {
   private Vector accountList; //a list of Account objects.
   private JButton button1;
   private TransferPanel transferPanel; //an object of TransferPanel.
   private JLabel label1, label2, outputMessage;
   private JPanel leftPanel;
   private JPanel subPanel1, subPanel2;
   private JTextArea area;
   private JTextField textField1, textField2;

   private JScrollPane scrollPane;
   
   String message = "";
   String accountInput;

 //Constructor initializes components and organize them using certain layouts
 public CreatePanel(Vector accountList, TransferPanel tPanel)
  {
    this.accountList = accountList;
    this.transferPanel = tPanel;
    
    this.setLayout(new GridLayout(1,2));

    //set up the leftPanel. leftPanel contains a message, subPanel1 and subPanel2
    leftPanel = new JPanel(new GridLayout(3, 1));

    //String message = "";
    outputMessage = new JLabel(message);
    outputMessage.setForeground(Color.red);

    //set up subPanel1. subPanel1 contains two JLabel (label1 & label2) and
    //two JTextField (textField1 & textField2)
    subPanel1 = new JPanel(new GridLayout(2,2));
    label1 = new JLabel("Account ID");
    label2 = new JLabel("Amount");
    textField1 = new JTextField("");
    textField2 = new JTextField("");

    //add label1, label2, textField1 & textField2 to subPanel1. Note the order.
    subPanel1.add(label1);
    subPanel1.add(textField1);
    subPanel1.add(label2);
    subPanel1.add(textField2);

    //set up subPanel2. subPanel2 contains only one button, by default it is flowLayout
    subPanel2 = new JPanel();
    button1 = new JButton("Create an account");
    subPanel2.add(button1);
    button1.addActionListener(new ButtonListener());
    
    //add message, subPanel1 & subPanel2 to leftPanel
    leftPanel.add(outputMessage);
    leftPanel.add(subPanel1);
    leftPanel.add(subPanel2);

    //set up the right part, it contains a JTextArea only

    area = new JTextArea(accountInput);

    area.setEditable(false);

    //in case there are more text showing than the height of the text area, a scroll
    //will be added to the text area.
    scrollPane = new JScrollPane(area);

    //add leftPanel and scrollPane to TabbedPanel2
    this.add(leftPanel);
    this.add(scrollPane);
    

  }


  //ButtonListener is a listener class that listens to
  //see if the button "Create an account" is pushed.
  //When the event occurs, it adds an account information from
  //the text fields to the text. It also creates an Account object
  //using these two information and add it to the accountList.
  //It also does error checking.
 
 
  private class ButtonListener implements ActionListener
   {
    public void actionPerformed(ActionEvent event)
     {
    	String name = textField1.getText();
    	String inamount = textField2.getText();
    	
    	double amount = Double.parseDouble(inamount);
    	
    	Account account_input = new Account(name, amount);
        accountInput = accountList.add(account_input);
        account_input.toString();
    	// if there is no error, add an account to account list
         // otherwise, show an error message
    	
    	if (inamount == "" )
    		message = ("Please fill both id and amount");
    	else if (inamount == "");
    		message = ("Please enter a number for the amount");
    	//else
    		//message = ("Account added.");
    			
     } //end of actionPerformed method
  } //end of ButtonListener class

} //end of CreatePanel class