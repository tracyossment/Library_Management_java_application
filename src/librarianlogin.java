
import java.sql.*;
import javax.swing.*;  
import java.awt.event.*;  
import java.awt.*;
public class librarianlogin implements ActionListener{  
    JTextField tf1;
    JLabel l1,l2;  
    JButton b1,b2; 
    JFrame f; 
     JPasswordField p;
    static String s1;
    librarianlogin(){  
         f= new JFrame();
	l1=new JLabel();  
        l1.setBounds(20,25,150,20);     
        tf1=new JTextField();  
        tf1.setBounds(50,50,150,20);
	l2=new JLabel();  
        l2.setBounds(20,75, 150,20);  
        p=new JPasswordField();  
        p.setBounds(50,100,150,20);
	l1.setText("Username");   
        l2.setText("Password");
        b1=new JButton("login"); 
        b2=new JButton("back");  
        b1.setBounds(20,135,75,30);          
        b1.addActionListener(this);  
        
         
        b2.setBounds(150,135,75,30);          
        b2.addActionListener(this);  
        
        
        f.add(tf1);f.add(p);f.add(b1);f.add(l1); f.add(l2);f.add(b2); 
        f.setSize(235,225);  
        f.setLayout(null);  
        f.setVisible(true);  
    }         
    public void actionPerformed(ActionEvent e) {  
       s1=tf1.getText();  
        String s2=String.valueOf(p.getPassword()); 
        
        if(e.getSource()==b1){  
	boolean status=false;
	try{
		Connection con=database.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from librarian where ID=? and password=?");
		ps.setString(1,s1);
		ps.setString(2,s2);
	    ResultSet rs=ps.executeQuery();
		status=rs.next();
		con.close();
	}catch(Exception ee){System.out.println(ee);}
	System.out.println(status);
           if(status)
           {libmenu.main(new String[]{});
				f.dispose();
			
               
           }
           else {  tf1.setText("");
           		p.setText("");
           }
        }
        else if(e.getSource()==b2){  
	   		login.main(new String[] {});
			f.dispose();
		
           
       }
      
    }  
public static void main(String[] args) {  
    new librarianlogin();  
} }  