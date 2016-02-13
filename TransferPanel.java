package Application;


// Name: Clayton Paplaczyk
//  Description: Transfer GUI

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

public class TransferPanel extends JPanel
 {
   private Vector accountList; //a list of bank account objects.
   private JComboBox jcb, jcb1;
   private JLabel instruction, instruction1, transAmount;
   private JLabel outputMsg;
   private JTextField textField;
   private JButton transButton;
   

   //Constructor initialize each component and arrange them using
   //certain layouts
   public TransferPanel(Vector accountList)
     {
      this.accountList = accountList;

      // orgranize components for transfer panel
      
      accountList = new Vector<String>();

      //add few strings inside itemList
      accountList.add(toString());
      
      //The following statement create a combo box with
      //and it set the combo box with blue foreground, white background and the first item selected.
      jcb = new JComboBox(accountList);

      jcb.setForeground(Color.blue);
      jcb.setBackground(Color.white);
      jcb.setSelectedItem("Red");
      
      jcb1 = new JComboBox(accountList);

      //initialize the two labels
      instruction = new JLabel("Please choose FROM Account for a transfer:");
      instruction1 = new JLabel("Please choose TO Account for a trasfer:");
      transAmount = new JLabel("Enter a Transfer Amout:");
      //outputMsg = new JLabel(////);

      textField = new JTextField("");
      
      transButton = new JButton("Transfer!");
      
      //Step3: Register the combo box with the listerner
	  //jcb.addItemListener (new ChoiceListener());

      this.setLayout(new GridLayout(8,1));
      add(instruction);
      add(jcb1);
      add(instruction1);
      add(jcb);
      add(transAmount);
      add(textField);
      add(transButton);
      //add(outputMsg);

      }

    //This method  refreshes the JComboBoxes with
    //updated vector information
    public void updateAccountList()
     {
       //call updateUI() for two combo boxes
    	
     }

 //ButtonListener class listens to see the button "Transfer!" is pushed.
 //A user can choose which bank account to transfer from and another account to transfer to,
 //then choose a transfer amount and push the "Transfer" button.
 //This should update both FROM and TO account balances and display them
 //below the "Transfer!" button
 //(You should make use of the toString( ) method of the Account class. )
 private class ButtonListener implements ActionListener
  {
       public void actionPerformed(ActionEvent event)
        {
    	   
    	   
         // if there is no error, FROM and TO account balances
         // should be updated and displayed below the "Transfer!" button.

        }
  } //end of ButtonListener class

} //end of TransferPanel class