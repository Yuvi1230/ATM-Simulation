
package bank.management.system;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;


public class Login extends JFrame implements ActionListener {
    JButton signup,login,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){
        setTitle("ATM JUBI");
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT );
        ImageIcon i3= new ImageIcon (i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        getContentPane().setBackground(Color.CYAN);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        
        JLabel text= new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,39));
        add(text);
        text.setBounds(200,40,400,40);
        
        JLabel cardno= new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,29));
        add(cardno);
        cardno.setBounds(120,150,400,40);
         
        clear =new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setForeground(Color.BLACK);
        clear.setBackground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup =new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setForeground(Color.BLACK);
        signup.setBackground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        login =new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setForeground(Color.BLACK);
        login.setBackground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
        cardTextField= new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.ITALIC,14));
        add(cardTextField);
        
        JLabel pin= new JLabel("PIN:");
        pin.setFont(new Font("Osward",Font.BOLD,29));
        add(pin);
        pin.setBounds(120,220,250,40);
        
        pinTextField= new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
      
        getContentPane().setBackground(Color.WHITE);
       
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()== signup){
            setVisible(false);
            new SignuUp().setVisible(true);
        }
        else if(ae.getSource()==login){
           Conn conn =new Conn();
           String cardnumber=cardTextField.getText();
           String pinnumber=pinTextField.getText();
           String query="select * from login where cardnumber= '"+cardnumber+"'and pinnumber = '"+pinnumber+"'";        
           try{
              ResultSet rs= conn.s.executeQuery(query);
              if(rs.next()){
                  setVisible(false);
              new Transaction(pinnumber).setVisible(true);
              }else{
                  JOptionPane.showMessageDialog(null, "Incorrerct Card Number or Pin");
              }
           }catch(Exception e){
               System.out.println(e);
           } 
        
        
    }
    }
    public static void main(String a[]){
       new Login();
        
    }
    
}
