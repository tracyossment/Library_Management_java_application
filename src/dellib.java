

import java.sql.*;
import javax.swing.*;  
import java.awt.event.*;  
import java.awt.*;
public class dellib implements ActionListener{  
    JTextField tf1,tf2;
    JLabel l1,l2;  
    JButton b1,b2; 
    JFrame f; 
       dellib(){  
         f= new JFrame();
         l1=new JLabel();  
        l1.setBounds(20,25, 150,20);     
        tf1=new JTextField();  
        tf1.setBounds(50,50,175,20);
        
	
	l1.setText("ID");
	
        b1=new JButton("Delete");  
        b1.setBounds(30,90,120,20);
        b1.addActionListener(this);  
        b2=new JButton("Back");  
        b2.setBounds(160,90,100,20);
        b2.addActionListener(this);  
        f.add(tf1);f.add(b1);f.add(l1);f.add(b2);  
        f.setSize(300,170);  
        f.setLayout(null);  
        f.setVisible(true);  
    }         
    public void actionPerformed(ActionEvent e) {  
      String s1=tf1.getText();
       if(e.getSource()==b1){  
	boolean status=false;
	int status2=0;
	try{
		Connection con=database.getConnection();
		
		PreparedStatement ps=con.prepareStatement("select * from librarian where ID=?");
		ps.setString(1,s1);
	    ResultSet rs=ps.executeQuery();
		status=rs.next();
		if(status)
		{
		ps=con.prepareStatement("delete from librarian where ID=?");
		ps.setString(1,s1);
	    status2=ps.executeUpdate();
	   
	    
			JOptionPane.showMessageDialog(f,
				    "librarian "+ s1 + " has been deleted ",
				    "Deletion Successful",
				    JOptionPane.PLAIN_MESSAGE);
			//JOptionPane.showInputDialog(Close.this,"Welcome to UEM bank, your account number is ");
			adminmenu.main(new String[]{});
			f.dispose();
		}
		else
		{JOptionPane.showMessageDialog(f, "Sorry, Librarian was not found","Error!", JOptionPane.ERROR_MESSAGE);
		tf1.setText("");}
		con.close();
	}catch(Exception ee){System.out.println(ee);
		JOptionPane.showMessageDialog(f, "Sorry, Librarian was not deleted","Error!", JOptionPane.ERROR_MESSAGE);
		tf1.setText("");	}
	}
       else if(e.getSource()==b2) 
       {adminmenu.main(new String[]{});
       f.dispose();}
	//System.out.println(status);
          
				
				
			
               
           
        }
      
   // }  
public static void main(String[] args) {  
    new dellib();  
} }  
