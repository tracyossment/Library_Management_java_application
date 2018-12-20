
import java.sql.*;
import javax.swing.*;  
import java.awt.event.*;  
import java.awt.*;
public class returnbook implements ActionListener{  
    JTextField tf1;
    JLabel l1;  
    JButton b1,b2; 
    JFrame f; 
        returnbook(){  
         f= new JFrame();
         l1=new JLabel();  
        l1.setBounds(20,25, 150,20);     
        tf1=new JTextField();  
        tf1.setBounds(50,50,150,20);
        
       
	l1.setText("issue ID");
	
        b1=new JButton("Return");  
        b1.setBounds(30,200,75,20);
        b1.addActionListener(this);  
        b2=new JButton("back");  
        b2.setBounds(120,200,75,20);
        b2.addActionListener(this);  
        f.add(tf1);f.add(b1);f.add(l1);f.add(b2);
        f.setSize(300,300);  
        f.setLayout(null);  
        f.setVisible(true);  
    }         
    public void actionPerformed(ActionEvent e) {  
      String s1=tf1.getText();
     
    if(e.getSource()==b1){  
	boolean status=false;
	boolean statusb =false;
	int status2= 0;
	 int k = 0;
	 try{
		 Connection con=database.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM `issue` WHERE `issueID` = ? ;");
			ps.setString(1,s1);			
		    ResultSet rs=ps.executeQuery();
		    status = rs.next();
		   
		    if (status) {
		    	String bk =rs.getString("bookID");
		    	Connection conb=database.getConnection();
				PreparedStatement psb=conb.prepareStatement("SELECT * FROM `books` WHERE `ID` = ? ;");
				psb.setString(1,bk);				
			    ResultSet rsb=psb.executeQuery();
			    statusb = rsb.next();
			   if(statusb) {
				   ps=con.prepareStatement("DELETE FROM `issue` WHERE `issue`.`issueID` = ?");
					ps.setString(1,s1);
					status2 = ps.executeUpdate(); 
					

		    		String sa = rsb.getString("Quantity");	 	   
		 			int a=rsb.getInt("Quantity");
		 			a = a +1;
		 			String saa= Integer.toString(a);
		 			 psb=conb.prepareStatement("UPDATE `books` SET `Quantity` = ? WHERE `books`.`ID` = ?;");
		 			psb.setString(1,saa);
		 			psb.setString(2,bk);
		 			status2=psb.executeUpdate();
		 			k++;
		 			JOptionPane.showMessageDialog(f,
						    "issue ID is "+ s1 + "has been deleted",
						    "UEM Library ",
						    JOptionPane.PLAIN_MESSAGE);
		 			libmenu.main(new String[]{});
		 			f.dispose();
			   }
			   
			   else {
				   JOptionPane.showMessageDialog(f, "Sorry,issue was not deleted","Error!", JOptionPane.ERROR_MESSAGE);
					tf1.setText("");
					
			   }
		    }
		 
		    else {
				   JOptionPane.showMessageDialog(f, "Sorry,issue was not deleted","Error!", JOptionPane.ERROR_MESSAGE);
					tf1.setText("");
					
			   }
		 
			
			    
				
		 			    
			con.close();
		}
	catch(Exception ee){System.out.println(ee);
		JOptionPane.showMessageDialog(f, "Sorry,book was not returned","Error!", JOptionPane.ERROR_MESSAGE);
		tf1.setText("");
		}}
	
	
		
	
       else if(e.getSource()==b2) 
       {libmenu.main(new String[]{});
       f.dispose();}
	//System.out.println(status);
          
				
				
			
               
           
        }
      
   // }  
public static void main(String[] args) {  
    new returnbook();  
} }  
