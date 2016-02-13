package Application;

// Name: Clayton Paplaczyk
//  Description: The Application class creates a Tabbed Pane with
//               two tabs, one for Account creation and one for
//               Account transfer. and adds it as its Applet content
//               and also sets its size.

import javax.swing.*;
import java.util.*;

public class Application extends JApplet
 {

   private int APPLET_WIDTH = 650, APPLET_HEIGHT = 350;

   private JTabbedPane tPane; //an object of JTabbedPane. It will contain createPanel and transferPanel under each tab.
   private CreatePanel createPanel; //an object of CreatePanel.
   private TransferPanel transferPanel; //an object of TransferPanel.
   private Vector accountList; //list of account objects. It will be used in both createPanel and transferPanel.

   //The method init initializes the Applet with a Pane with two tabs
   public void init()
    {
     //list of accounts to be used in every panel
     accountList = new Vector();

     //register panel uses the list of accounts
     transferPanel = new TransferPanel(accountList);

     createPanel = new CreatePanel(accountList, transferPanel);

     //create a tabbed pane with two tabs
     tPane = new JTabbedPane();
     tPane.addTab("Account creation", createPanel);
     tPane.addTab("Account transfer", transferPanel);

     getContentPane().add(tPane);
     setSize (APPLET_WIDTH, APPLET_HEIGHT); //set Applet size
    }
}
