
package bank.management.system;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {
    JButton deposit,withdrawal,fastcash,ministatement,pinchange,balan,exit;
    String pinnumber;
    Transaction(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT );
        ImageIcon i3= new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Please Select your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawal=new JButton("Cash Withdrawal");
        withdrawal.setBounds(355,415,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement=new JButton("Mini statement");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange=new JButton("Pin change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balan=new JButton("Balance Enquiry");
        balan.setBounds(355,485,150,30);
        balan.addActionListener(this);
        image.add(balan);
        
        exit=new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }

    
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()== exit){
           System.exit(0);
    }else if(ae.getSource()==deposit){
        setVisible(false);
        new Deposit(pinnumber).setVisible(true);
    }else if(ae.getSource()== withdrawal){
        setVisible(false);
        new Withdrawal(pinnumber).setVisible(true);
    }else if(ae.getSource()== fastcash){
        setVisible(false);
        new FastCash(pinnumber).setVisible(true);
    }else if(ae.getSource()== pinchange){
        setVisible(false);
        new PinChange(pinnumber).setVisible(true);
    }else if(ae.getSource()== balan){
        setVisible(false);
        new BalanceEnquiry(pinnumber).setVisible(true);
    }else if(ae.getSource()== ministatement){
        //setVisible(false);
        new MiniStatement(pinnumber).setVisible(true);
       
    }
    }

    public static void main(String a[]){
        new Transaction("");
    }
    
}
