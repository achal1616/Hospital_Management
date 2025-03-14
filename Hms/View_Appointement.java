package Hms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class View_Appointement extends JFrame implements ActionListener
{
    String x[]={"Appointement Id","Username","Name","Email","Father Name","Phone","Material Status","City","gender","Blood Group","Age","DOB","Deceased","Doctor","Appointment Date","Appointment Time","Appointement Status"};
    JButton bt,bt1;
    String y[][]=new String[20][17];
    int i=0,j=0;
    JTable t;
    JLabel l1,l2;
    JTextField tf1;
    JPanel p1,p2,p3;
    Font f,f1;
    String q;
    
    View_Appointement(String doctorusername,int login__id)
    {
        super("Appointement information");
        setSize(1500,400);
        setLocation(1,1);
        f=new Font("MS UI Gothic",Font.BOLD,15);
        try
        {
            ConnectionClass obj=new ConnectionClass();
            if(login__id==4)
            {
                q="Select * from appointement where doctor_username='"+doctorusername +"'";   
            }
            else if(login__id==3)
            {
                q="Select * from appointement where p_username='"+doctorusername +"'";   
            }
            else
            {
              q="Select * from appointement";  
            }
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {  
                y[i][j++]=rest.getString("app_id");
                y[i][j++]=rest.getString("p_username");
                y[i][j++]=rest.getString("name");
                y[i][j++]=rest.getString("email");
                y[i][j++]=rest.getString("fname");  
                y[i][j++]=rest.getString("phone"); 
                y[i][j++]=rest.getString("material_status"); 
                y[i][j++]=rest.getString("city");   
                y[i][j++]=rest.getString("gender");
                y[i][j++]=rest.getString("blood");   
                y[i][j++]=rest.getString("age");
                y[i][j++]=rest.getString("dob");
                y[i][j++]=rest.getString("deceased");
                y[i][j++]=rest.getString("doctor_username");
                y[i][j++]=rest.getString("appointement_date");
                y[i][j++]=rest.getString("appointement_time");
                y[i][j++]=rest.getString("appointement_status");
                i++;
                j=0;
            }
            t=new JTable(y,x);
            t.setFont(f);
            t.setBackground(Color.BLACK);
            t.setForeground(Color.WHITE);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        JScrollPane sp=new JScrollPane(t);
        f1=new Font("Lucida Fax",Font.BOLD,25);
        
        l1=new JLabel("Complete or Cancelled any Appointement Status?");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f1);
        l1.setForeground(Color.YELLOW);
        
        l2=new JLabel("Appointment ID");
        l2.setFont(f1);
        l2.setForeground(Color.GRAY);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        tf1=new JTextField();
        
        bt=new JButton("Complete Appointment");
        bt1=new JButton("Cancel Appointment");
        tf1.setFont(f);
        bt.setFont(f);
        bt1.setFont(f);
        
        
        bt.setBackground(Color.BLACK);
        bt.setForeground(Color.RED);
        bt.addActionListener(this);
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.RED);
        bt1.addActionListener(this);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(1,4,10,10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(bt);
        p2.add(bt1);
        
        p3=new JPanel();
        p3.setLayout(new GridLayout(2,1,10,10));
        p3.add(p1);
        p3.add(p2);
        
        p1.setBackground(Color.BLACK);
        p2.setBackground(Color.BLACK);
        p3.setBackground(Color.BLACK);
        
        add(p3,"South");
        add(sp);
    }
    public void actionPerformed(ActionEvent e)
    {
        String app_id=tf1.getText();
        if(e.getSource()==bt1)
        {
            if(app_id.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Please fill the Appointement ID");
            }
            else
            {
                try
                {
                    ConnectionClass obj1=new ConnectionClass();
                    String q2="update appointement set appointement_status='Cancel' where app_id='"+app_id+"'";
                    int a=obj1.stm.executeUpdate(q2);
                    if(a==1)
                    {
                        setVisible(false);
//                        new View_Appointement().setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Appointement ID not found");
                    }
                    
                }
                catch(Exception evx)
                {
                    evx.printStackTrace();
                }
            }
        }
        if(e.getSource()==bt)
        {
            if(app_id.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Please fill the Appointement ID");
            }
            else
            {
                try
                {
                    ConnectionClass obj1=new ConnectionClass();
                    String q2="update appointement set appointement_status='Complete' where app_id='"+app_id+"'";
                    int aa=obj1.stm.executeUpdate(q2);
                    if(aa==1)
                    {
                        setVisible(false);
//                        new View_Appointement().setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Appointement ID not found");
                    }
                }
                catch(Exception evx)
                {
                    evx.printStackTrace();
                }
            }
        }
    }
    public static void main(String args[])
    {
//        new View_Appointement().setVisible(true);
    }
}
