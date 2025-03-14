package Hms;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener
{
    JPanel panel;
    JFrame f;
    JLabel l1,l2,l3,l4,l5;
    JTextField t1;
    JPasswordField pf1;
    JButton b1,b2,b3;
    public int loginid;
    
    LoginPage(int login_id)
    {
        f=new JFrame("Login Page");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        loginid=login_id;
        
        l1=new JLabel();
        l1.setBounds(0,0,580,350);
        l1.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Hms/Icons/admin login.jpg"));
        Image i1=img.getImage().getScaledInstance(580,350,Image.SCALE_SMOOTH);
        ImageIcon img1=new ImageIcon(i1);
        l1.setIcon(img1);
        
        l2=new JLabel("Login Page");
        l2.setBounds(198,30,500,50);
        l2.setFont(new Font("Airal",Font.BOLD,30));
        l2.setForeground(Color.BLACK);
        l1.add(l2);
        f.add(l1);
        
        l3=new JLabel("Username : ");
        l3.setBounds(130,120,150,30);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Arial",Font.BOLD,20));
        l1.add(l3);
        
        t1=new JTextField();
        t1.setBounds(310,120,150,30);
        l1.add(t1);
        
        l4 = new JLabel("Password : ");
        l4.setBounds(130,170,150,30);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Airal",Font.BOLD,20));
        l1.add(l4);

        pf1 = new JPasswordField();
        pf1.setBounds(310,170,150,30);
        l1.add(pf1);
        
        b1 = new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(130,220,150,40);
        
        l1.add(b1);
        
        b2=new JButton("Back");   
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(310,220,150,40);
        
        l1.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(580,350);
        f.setLocation(300,100);
        f.setResizable(false);        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String name=t1.getText();
                String pass=pf1.getText();
                if(loginid==1)
                {
                    String q="select * from admin where username='"+name+"' and password='"+pass+"'";
                    ResultSet rs=obj.stm.executeQuery(q);

                    if(rs.next())
                    {
                        String adminname=rs.getString("name");
                        String adminid=rs.getString("admin_id");
                        new AdminHomePage(adminname,adminid,loginid).setVisible(true);
                        f.setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"You have entered Wrong Username and Password !");
                        f.setVisible(false);
                        f.setVisible(true);   
                    }
                }
                else if(loginid==2)
                {
                    String q="select * from receptionist where username='"+name+"' and password='"+pass+"'";
                    ResultSet rs=obj.stm.executeQuery(q);

                    if(rs.next())
                    {
                        String receptionist_name=rs.getString("name");
                        String receptionist_id=rs.getString("res_id");
                        new ReceptionistHomePage(receptionist_name,receptionist_id,loginid).setVisible(true);
                        f.setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"You have entered Wrong Username and Password !");
                        f.setVisible(false);
                        f.setVisible(true);   
                    }
                }
                else if(loginid==3)
                {
                    String q="select * from patient where username='"+name+"' and password='"+pass+"'";
                    ResultSet rs=obj.stm.executeQuery(q);

                    if(rs.next())
                    {
                        String patient_name=rs.getString("name");
                        String patient_id=rs.getString("pat_id");
                        String patient_username=rs.getString("username");
                        new PatientHomePage(patient_name,patient_id,loginid,patient_username).setVisible(true);
                        f.setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"You have entered Wrong Username and Password !");
                        f.setVisible(false);
                        f.setVisible(true);   
                    }
                }
                else if(loginid==4)
                {
                    String q="select * from doctor where username='"+name+"' and password='"+pass+"'";
                    ResultSet rs=obj.stm.executeQuery(q);

                    if(rs.next())
                    {
                        String doctor_name=rs.getString("name");
                        String doctor_id=rs.getString("doc_id");
                        String doctor_username=rs.getString("username");
                        new DoctorHomePage(doctor_name,doctor_id,loginid,doctor_username).setVisible(true);
                        f.setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"You have entered Wrong Username and Password !");
                        f.setVisible(false);
                        f.setVisible(true);   
                    }
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        if(ae.getSource()==b2)
        {
            this.f.setVisible(false);
            new Index();
        }
    }
//    public static void main(String[] args) 
//    {
//        new LoginPage().setVisible(false);
//    }
}
