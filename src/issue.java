
import java.sql.*;
import javax.swing.*;  
import java.awt.event.*;  
import java.awt.*;
public class issue implements ActionListener{  
    JTextField tf1, tf2;
    JLabel l1,l2;  
    JButton b1,b2; 
    JFrame f; 
        issue(){  
         f= new JFrame();
         l1=new JLabel();  
        l1.setBounds(20,25, 150,20);     
        tf1=new JTextField();  
        tf1.setBounds(50,50,150,20);
        l2=new JLabel();  
        l2.setBounds(20,75, 150,20);     
        tf2=new JTextField();  
        tf2.setBounds(50,100,150,20);
       
	l1.setText("student ID");
	l2.setText("Book ID"); 
        b1=new JButton("Add");  
        b1.setBounds(30,200,75,20);
        b1.addActionListener(this);  
        b2=new JButton("back");  
        b2.setBounds(120,200,75,20);
        b2.addActionListener(this);  
        f.add(tf1);f.add(b1);f.add(l1);f.add(l2);f.add(tf2);f.add(b2);
        f.setSize(300,300);  
        f.setLayout(null);  
        f.setVisible(true);  
    }         
    public void actionPerformed(ActionEvent e) {  
      String s1=tf1.getText();
      String s2=tf2.getText();
       if(e.getSource()==b1){  
	boolean status=false;
	int status2 =0;
	 int k = 0;
	try{
		Connection con=database.getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM `books` WHERE `ID` = ? ;");
		ps.setString(1,s2);
		
	    ResultSet rs=ps.executeQuery();
	    status = rs.next();
	   
	    if (status) {
	    	 
	    		String sa = rs.getString("Quantity");	 	   
	 			int a=rs.getInt("Quantity");
	 			a = a -1;
	 			String saa= Integer.toString(a);
	 			 ps=con.prepareStatement("UPDATE `books` SET `Quantity` = ? WHERE `books`.`ID` = ?;");
	 			ps.setString(1,saa);
	 			ps.setString(2,s2);
	 			status2=ps.executeUpdate();
	 			k++;	 			
	 			libmenu.main(new String[]{});
	 			f.dispose();
	 		}	    
		con.close();
	}catch(Exception ee){System.out.println(ee);
		JOptionPane.showMessageDialog(f, "Sorry,issue was not added","Error!", JOptionPane.ERROR_MESSAGE);
		tf1.setText("");
		tf2.setText("");
		}
	
	if (k>0) {
		try{
			Connection con=database.getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO `issue` (`issueID`, `studentID`, `bookID`) VALUES (NULL, ?, ?);");
			ps.setString(1,s1);
			ps.setString(2,s2);
		    
		    status2 = ps.executeUpdate();  
		    	 
		    	PreparedStatement ps2=con.prepareStatement("SELECT `issueID` FROM `issue` WHERE `studentID` = ? AND `bookID` = ?;");
				ps2.setString(1,s1);
				ps2.setString(2,s2);
				
			    ResultSet rs2=ps2.executeQuery();
			    status= rs2.next();
			    int sar = rs2.getInt("issueID");
				JOptionPane.showMessageDialog(f,
					    "issue ID is "+ sar,
					    "UEM Library ",
					    JOptionPane.PLAIN_MESSAGE);
		 			    
			con.close();
		}catch(Exception ee){System.out.println(ee);
			JOptionPane.showMessageDialog(f, "Sorry,issue was not added","Error!", JOptionPane.ERROR_MESSAGE);
			tf1.setText("");
			tf2.setText("");
			}
	}
	}
       else if(e.getSource()==b2) 
       {libmenu.main(new String[]{});
       f.dispose();}
	//System.out.println(status);
          
				
				
			
               
           
        }
      
   // }  
public static void main(String[] args) {  
    new issue();  
} }  
