
import javax.swing.*;  
import java.awt.event.*;  
import java.awt.*;
public class adminmenu implements ActionListener{  
    
     
    JButton b1,b2,b3,b4,b5,b6,b7; 
    JFrame f;
    adminmenu(){  
         f= new JFrame();
	  
        
        b1=new JButton("Add Librarian");  
        b1.setBounds(50,20,150,20);  
        b1.addActionListener(this);  
        
        b2=new JButton("Delete Librarian");  
        b2.setBounds(50,50,150,20);  
        b2.addActionListener(this);  
        
        b3=new JButton("View Librarian");  
        b3.setBounds(50,80,150,20);  
        b3.addActionListener(this);  
        
        b4=new JButton("Log out");  
        b4.setBounds(50,110,150,20);  
        b4.addActionListener(this);  
        
       
        
        f.add(b1); f.add(b2); f.add(b3); f.add(b4); 
        f.setSize(270,220);  
        f.setLayout(null);  
        f.setVisible(true);  
    }         
   
	public void actionPerformed(ActionEvent e) {  
        if(e.getSource()==b1){            
        addlib.main(new String[]{});
		f.dispose();
        }
        
        else  if(e.getSource()==b2){  
            dellib.main(new String[]{});
    		f.dispose();
            }
        
        else  if(e.getSource()==b3){            
            viewlib.main(new String[]{});
    		f.dispose();
            }
     
        else  if(e.getSource()==b4){            
            login.main(new String[]{});
    		f.dispose();
            }
        
       
    }  
public static void main(String[] args) { 
    new adminmenu();  
} }  