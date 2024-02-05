package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class Withdrawal extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton withdrawal,back;
    String pinnumber;
    
    Withdrawal(String pinnumber){
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT );
        ImageIcon i3= new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text= new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);
        
        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
       // amount.addActionListener(this);
        image.add(amount);  
        
        withdrawal=new JButton("withdraw");
        withdrawal.setBounds(355,485,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        back=new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == withdrawal)
       {
            String num=amount.getText();
            Date date=new Date();
            if(num.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            }else{
                try{
                Conn conn=new Conn();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawal','"+num+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs"+num+"Withdrawed Succesfully");
            }catch(Exception e){
                System.out.println(e);
            }
       }
       }else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
        
        
    public static void main(String a[]){
        new Withdrawal("");
    }
}