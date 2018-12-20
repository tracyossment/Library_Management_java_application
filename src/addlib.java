
import java.sql.*;
import javax.swing.*;  
import java.awt.event.*;  
import java.awt.*;
public class addlib implements ActionListener{  
    JTextField tf1,tf3;
    JPasswordField tf2;
    JLabel l1,l2,l3;  
    JButton b1,b2; 
    JFrame f; 
        addlib(){  
         f= new JFrame();
         l1=new JLabel();  
        l1.setBounds(20,25, 150,20);     
        tf1=new JTextField();  
        tf1.setBounds(50,50,150,20);
        l2=new JLabel();  
        l2.setBounds(20,75, 150,20);     
        tf2=new JPasswordField();  
        tf2.setBounds(50,100,150,20);
        l3=new JLabel();  
        l3.setBounds(20,125, 150,20);     
        tf3=new JTextField();  
        tf3.setBounds(50,150,150,20);
	
	l1.setText("Name of librarian");
	l2.setText("Password"); 
	l3.setText("aadhar"); 
        b1=new JButton("Add");  
        b1.setBounds(30,200,75,20);
        b1.addActionListener(this);  
        b2=new JButton("back");  
        b2.setBounds(120,200,75,20);
        b2.addActionListener(this);  
        f.add(tf1);f.add(b1);f.add(l1);f.add(l2);f.add(tf2);f.add(b2);f.add(l3);f.add(tf3);  
        f.setSize(300,300);  
        f.setLayout(null);  
        f.setVisible(true);  
    }         
    public void actionPerformed(ActionEvent e) {  
      String s1=tf1.getText();
      String s2=tf2.getText();
      String s3=tf3.getText();
       if(e.getSource()==b1){  
	int status=0;
	try{
		Connection con=database.getConnection();
		PreparedStatement ps=con.prepareStatement("INSERT INTO `librarian` (`ID`, `password`, `name`,`aadhar`) VALUES (NULL, ?, ?, ?);");
		ps.setString(1,s1);
		ps.setString(2,s2);
		ps.setString(3,s3);
	    status=ps.executeUpdate();
	    ps=con.prepareStatement("SELECT `ID` FROM `librarian` WHERE `aadhar`= ?;");
	    ps.setString(1,s3);
	    ResultSet rs=ps.executeQuery();
	    if(rs.next()){
			int a=rs.getInt("ID");
			System.out.println(a);
			JOptionPane.showMessageDialog(f,
				    "Your account ID "+a,
				    "UEM Library "+s2,
				    JOptionPane.PLAIN_MESSAGE);
			
			adminmenu.main(new String[]{});
			f.dispose();
		}
		con.close();
	}catch(Exception ee){System.out.println(ee);
		JOptionPane.showMessageDialog(f, "Sorry,Librarian was not added","Error!", JOptionPane.ERROR_MESSAGE);
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");}
	}
       else if(e.getSource()==b2) 
       {adminmenu.main(new String[]{});
       f.dispose();}
	//System.out.println(status);
          
				
				
			
               
           
        }
      
   // }  
public static void main(String[] args) {  
    new addlib();  
} }  
