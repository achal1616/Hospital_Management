package Hms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ChangePassword extends JFrame implements ActionListener
{
    JPanel panel;
    JFrame f;
    JLabel l1,l2,l3,l4,l5;
    JTextField t1;
    JPasswordField pf1;
    JButton b1,b2,b3;
    public int login__id;
    String q2;
    
    ChangePassword()
    {
        
    }
    ChangePassword(String admin_id, int login_id)
    {
        f=new JFrame("Change My Password");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        login__id=login_id;
        
        l1=new JLabel();
        l1.setBounds(0,0,580,350);
        l1.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Hms/Icons/admin login.jpg"));
        Image i1=img.getImage().getScaledInstance(580,350,Image.SCALE_SMOOTH);
        ImageIcon img1=new ImageIcon(i1);
        l1.setIcon(img1);
        
        l2=new JLabel("Change My Password");
        l2.setBounds(115,30,500,50);
        l2.setFont(new Font("Airal",Font.BOLD,30));
        l2.setForeground(Color.BLACK);
        l1.add(l2);
        f.add(l1);
        
        l5=new JLabel(admin_id);
        l5.setBounds(270,75,500,50);
        l5.setFont(new Font("Airal",Font.PLAIN,15));
        l5.setForeground(Color.BLACK);
        l1.add(l5);
        
        l3=new JLabel("Old Password : ");
        l3.setBounds(130,120,155,30);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Arial",Font.BOLD,20));
        l1.add(l3);
        
        t1=new JTextField();
        t1.setBounds(310,120,150,30);
        l1.add(t1);
        
        l4 = new JLabel("New Password : ");
        l4.setBounds(130,170,170,30);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Airal",Font.BOLD,20));
        l1.add(l4);

        pf1 = new JPasswordField();
        pf1.setBounds(310,170,150,30);
        l1.add(pf1);
        
        b1 = new JButton("Change Password");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(130,220,150,40);
        
        l1.add(b1);
        
        b2=new JButton("Close");   
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
            String ad_id=l5.getText();
            String oldpass=t1.getText();
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String newpass=pf1.getText();
                if(login__id==1)
                {
                    q2="update admin set password='"+newpass+"' where admin_id='"+ad_id+"' and password='"+oldpass+"'";
                }
                else if(login__id==2)
                {
                    q2="update receptionist set password='"+newpass+"' where res_id='"+ad_id+"' and password='"+oldpass+"'";
                }
                else if(login__id==3)
                {
                    q2="update patient set password='"+newpass+"' where pat_id='"+ad_id+"' and password='"+oldpass+"'";
                }
                else if(login__id==4)
                {
                    q2="update doctor set password='"+newpass+"' where doc_id='"+ad_id+"' and password='"+oldpass+"'";
                }
                int ss=obj.stm.executeUpdate(q2);
                if(ss==1)
                {
                    JOptionPane.showMessageDialog(null,"Your Password Successfully Updated");
                    f.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"You have entered Wrong old Password !"); 
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
        }
    }
    public static void main(String[] args) 
    {
        new ChangePassword();
    }
}
