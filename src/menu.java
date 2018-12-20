
import javax.swing.*;  
import java.awt.event.*;  
import java.awt.*;
public class menu implements ActionListener{  
    
    JLabel l1;  
    JButton b1,b2,b3,b4,b5,b6,b7; 
    JFrame f;
    public void actionPerformed(ActionEvent e) {  
        if(e.getSource()==b1){            
        open.main(new String[]{});
		f.dispose();
        }
        
        else  if(e.getSource()==b2){  
            Close.main(new String[]{});
    		f.dispose();
            }
        
        else  if(e.getSource()==b3){            
            Deposit.main(new String[]{});
    		f.dispose();
            }
     
        else  if(e.getSource()==b4){            
            Withdraw.main(new String[]{});
    		f.dispose();
            }
        
        else  if(e.getSource()==b5){            
            Check.main(new String[]{});
    		f.dispose();
            }
        
        else  if(e.getSource()==b6){            
            Transaction.main(new String[]{});
    		f.dispose();
            }
        else  if(e.getSource()==b7){            
            Banklogin.main(new String[]{});
    		f.dispose();
            }
    }  
public static void main(String[] args) { 
    new Bankmenu(Banklogin.s1);  
} }  