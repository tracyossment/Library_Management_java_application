import java.sql.*;
import javax.swing.*;  
import java.awt.event.*;  
import java.awt.*;
public class login implements ActionListener{  
    JLabel l1;  
    JButton b1,b2; 
    JFrame f; 
   
    login(){  
    f= new JFrame();
	l1=new JLabel();  
     l1.setBounds(20,50,150,20);     
        
	l1.setText("Login as :");        
        b1=new JButton("Admin");  
        b1.setBounds(50,75,100,30);  
        b1.addActionListener(this);  
        
        b2=new JButton("Librarian");  
        b2.setBounds(50,120,100,30);  
        b2.addActionListener(this);  
        f.add(b2);f.add(b1);f.add(l1); 
        f.setSize(235,225);  
        f.setLayout(null);  
        f.setVisible(true);  
    }         
    public void actionPerformed(ActionEvent e) {  
       
        
        if(e.getSource()==b1){  
	
           adminlogin.main(new String[]{});
				f.dispose();
			
               
           }
           else if(e.getSource()==b2) { 
        	   librarianlogin.main(new String[]{});
        	   f.dispose();
   			
           }
        }
      
     
public static void main(String[] args) {  
    new login();  
} }  
