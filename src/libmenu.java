
import javax.swing.*;  
import java.awt.event.*;  
import java.awt.*;
public class libmenu implements ActionListener{  
    
     
    JButton b1,b2,b3,b4,b5,b6,b7; 
    JFrame f;
    libmenu(){  
         f= new JFrame();
	  
        
        b1=new JButton("Add Books");  
        b1.setBounds(50,20,150,20);  
        b1.addActionListener(this);  
        
        b2=new JButton("View Books");  
        b2.setBounds(50,50,150,20);  
        b2.addActionListener(this);  
        
        b3=new JButton("Issue Book");  
        b3.setBounds(50,80,150,20);  
        b3.addActionListener(this);  
        
        b4=new JButton("View Issued Books");  
        b4.setBounds(50,110,150,20);  
        b4.addActionListener(this);  
        
        b5=new JButton("Return Book");  
        b5.setBounds(50,140,150,20);  
        b5.addActionListener(this);  
        
        b6=new JButton("Log Out");  
        b6.setBounds(50,170,150,20);  
        b6.addActionListener(this);  
        
       
        
        f.add(b1); f.add(b2); f.add(b3); f.add(b4);f.add(b5); f.add(b6); 
        f.setSize(270,270);  
        f.setLayout(null);  
        f.setVisible(true);  
    }         
   
	public void actionPerformed(ActionEvent e) {  
        if(e.getSource()==b1){            
        addbook.main(new String[]{});
		f.dispose();
        }
        
        else  if(e.getSource()==b2){  
            viewbook.main(new String[]{});
    		f.dispose();
            }
        
        else  if(e.getSource()==b3){            
            issue.main(new String[]{});
    		f.dispose();
            }
     
        else  if(e.getSource()==b4){            
          viewissue.main(new String[]{});
    		f.dispose();
            }
        
        else  if(e.getSource()==b5){            
            returnbook.main(new String[]{});
      		f.dispose();
              }
        else  if(e.getSource()==b6){            
            login.main(new String[]{});
      		f.dispose();
              }
       
    }  
public static void main(String[] args) { 
    new libmenu();  
} }  