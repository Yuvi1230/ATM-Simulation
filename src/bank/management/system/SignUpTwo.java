package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener {
    
   long random;
   JTextField pan,aadhar;
   JRadioButton syes,sno,eyes,eno ;
   JComboBox religion,category,occupation,education,income;
   String formno;
   JButton next;
  
   SignUpTwo(String formno){
       this.formno=formno;
       
       
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 2");
       // Random ran= new Random();
       // long random=Math.abs((ran.nextLong()% 9000L) + 1000L);
        
        
        JLabel additionaldetails=new JLabel("Page 2: Additional Details ");
        additionaldetails.setFont( new Font("Raleway",Font.BOLD,22));
        additionaldetails.setBounds(290,80, 400, 30);
        add(additionaldetails);
        
        JLabel name=new JLabel("Religion:");
        name.setFont( new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140, 100, 30);
        add(name);
        
        String valReligion[]={"Hindu","Muslim","Sikh","others"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);
        
        JLabel fname=new JLabel("Category");
        fname.setFont( new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190, 200, 30);
        add(fname);
        
        String valcategory[]={"General","OBC","ST","ST","Others"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        add(category);
        
        
        JLabel dob=new JLabel("Income:");
        dob.setFont( new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,240, 200, 30);
        add(dob);
      
        
        String valincome[]={"1000+","10000+","100000+","none"};
        income = new JComboBox(valincome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);
        
        JLabel gender=new JLabel("Education");
        gender.setFont( new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290, 200, 30);
        add(gender);
        
        String eduval[] = {"Non-Graduate" , "Graduate","PG","Doctorate","Other"};
        education=new JComboBox(eduval);
        education.setBounds(300,315, 400, 30);
        add(education);
        
        JLabel qualification=new JLabel("Qualification:");
        qualification.setFont( new Font("Raleway",Font.BOLD,22));
        qualification.setBounds(100,315, 200, 30);
        add(qualification);
        
        JLabel marital=new JLabel("Occupaton:");
        marital.setFont( new Font("Raleway",Font.BOLD,22));
        marital.setBounds(100,390, 200, 30);
        add(marital);
        
        String occuval[] = {"Salaried" , "Non-Salaried","Bussines","Student","Retired"};
        occupation=new JComboBox(occuval);
        occupation.setBounds(300, 390, 400, 30);
        add(occupation);
        
        JLabel pannumber=new JLabel("Pan Number:");
        pannumber.setFont( new Font("Raleway",Font.BOLD,22));
        pannumber.setBounds(100,440, 200, 30);
        add(pannumber);
        
        pan= new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        
        JLabel city=new JLabel("Aadhar Number:");
        city.setFont( new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,490, 200, 30);
        add(city);
        
        aadhar= new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);
        
        JLabel state=new JLabel("Senior Citizen:");
        state.setFont( new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,540, 200, 30);
        add(state);
        
        syes =new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        add(syes);
        
        sno =new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        add(sno);
        
        ButtonGroup seniorciti = new ButtonGroup();
        seniorciti.add(syes);
        seniorciti.add(sno);
        
        JLabel exisacct=new JLabel("Existing Account:");
        exisacct.setFont( new Font("Raleway",Font.BOLD,22));
        exisacct.setBounds(100,590, 200, 30);
        add(exisacct);
        
        eyes =new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        add(eyes);
        
        eno =new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        add(eno);
        
        ButtonGroup ex = new ButtonGroup();
        ex.add(eyes);
        ex.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
        getContentPane().setBackground(Color.white);
    
    
}
   public void actionPerformed(ActionEvent ae){
       String formno = "" + random;
       String sreligion = (String)religion.getSelectedItem();
       String scategory = (String)category.getSelectedItem();
       String sincome=(String)income.getSelectedItem();
       String squal= (String)education.getSelectedItem();
    
       String soccu= (String)occupation.getSelectedItem();
       String seniorcitizen=null;
       if(syes.isSelected()){
           seniorcitizen="Yes";
       }else if(sno.isSelected()){
           seniorcitizen="No";
       }
       String exisacct=null;
       if(eyes.isSelected()){
           exisacct="Yes";
       }else if(eno.isSelected()){
           exisacct="No";
       }
       String span=pan.getText();
       String saadhar=aadhar.getText();

       
       try{
         
           Conn c =new Conn();
           String query ="insert into signuptwo values('"+formno+"', '"+sreligion+"','"+scategory+"','"+sincome+"','"+squal+"','"+soccu+"','"+seniorcitizen+"','"+exisacct+"','"+span+"','"+saadhar+"')";
           c.s.executeUpdate(query);
           
           setVisible(false);
           new SignUpThree(formno).setVisible(true);
       
       }catch(Exception e){
           System.out.println(e);
           
       }
   }
   
    public static void main(String a[]){
        new SignUpTwo("");
    }
}