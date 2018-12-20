


import java.io.*;
import java.sql.*;
import javax.swing.*;  
import java.awt.event.*;  
import java.awt.*;
public class viewlib implements ActionListener{  
    JTextField tf1;
    JLabel l1,l2,l3;  
    JButton b1,b2; 
    JFrame f; 
        viewlib(){  
     f= new JFrame();
	l1= new JLabel();
	l2= new JLabel();
	l3= new JLabel();
	 l1.setBounds(20,25, 100,20);     
     tf1=new JTextField();  
     tf1.setBounds(125,25,150,20);
    
     b1=new JButton("View Details");  
     b1.setBounds(20,65,120,20);
     b1.addActionListener(this);  
     b2=new JButton("Back");  
     b2.setBounds(160,65,120,20);
     b2.addActionListener(this);  
    
     l2.setBounds(20,105, 150,20);
     l1.setText("Librarian ID");
     l2.setText("Name:");
     l3.setBounds(20,130, 150,20);
     l3.setText("Aadhar No.");
    
 	
       
        f.add(tf1);f.add(b1);f.add(l1);f.add(b2);f.add(l3);f.add(l2);  
        f.setSize(315,200);  
        f.setLayout(null);  
        f.setVisible(true);  
    }         
    public void actionPerformed(ActionEvent e) {  
      String s1=tf1.getText();
            
      if(e.getSource()==b2) 
      {adminmenu.main(new String[]{});
      f.dispose();}
      
      else if(e.getSource()==b1){  
	boolean status=false;
	int status2=0;
	try{
		Connection con=database.getConnection();
		
		PreparedStatement ps=con.prepareStatement("select * from librarian where ID=?");
		ps.setString(1,s1);
	    ResultSet rs=ps.executeQuery();
		status=rs.next();
		if(status)
		{int a = rs.getInt("aadhar");
		String n= rs.getString("name");
		l3.setText("Aadhar No."+ a);
		l2.setText("Name : "+ n);
		
		
	   
	    
			
		}
		else
		{JOptionPane.showMessageDialog(f, "Sorry, Librarian was not found","Error!", JOptionPane.ERROR_MESSAGE);
		tf1.setText("");
		}
		con.close();
	}catch(Exception ee){System.out.println(ee);
		JOptionPane.showMessageDialog(f, "Sorry, Some error occured ","Error!", JOptionPane.ERROR_MESSAGE);
		tf1.setText("");
		}
	}
      
			
               
           
        }
      
   // }  
public static void main(String[] args) {  
    new viewlib();  
} }  
