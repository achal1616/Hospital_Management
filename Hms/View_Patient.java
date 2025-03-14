package Hms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class View_Patient extends JFrame implements ActionListener
{
    String x[]={"Name","Username","Email","Father Name","Phone","Material Status","City","gender","Blood Group","Age","DOB","Deceased","Address"};
    JButton bt,bt1;
    String y[][]=new String[20][13];
    int i=0,j=0;
    JTable t;
    JLabel l1,l2;
    JTextField tf1;
    JPanel p1,p2,p3;
    Font f,f1;
    String q;
    
    View_Patient(String p_username, int login_id)
    {
        super("Patient information");
        setSize(1500,400);
        setLocation(1,1);
        f=new Font("MS UI Gothic",Font.BOLD,15);
        try
        {
            ConnectionClass obj=new ConnectionClass();
            if(login_id==3)
            {
                q="Select * from patient where username='"+p_username+"'";
            }
            else
            {
                q="Select * from patient";
            }
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {  
                y[i][j++]=rest.getString("name");
                y[i][j++]=rest.getString("username");
                y[i][j++]=rest.getString("email");
                y[i][j++]=rest.getString("father_name");  
                y[i][j++]=rest.getString("phone"); 
                y[i][j++]=rest.getString("material_status"); 
                y[i][j++]=rest.getString("city");   
                y[i][j++]=rest.getString("gender");
                y[i][j++]=rest.getString("blood");   
                y[i][j++]=rest.getString("age");
                y[i][j++]=rest.getString("dob");
                y[i][j++]=rest.getString("deceased");
                y[i][j++]=rest.getString("address");
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
        
        l1=new JLabel("Delete or Edit any Patient ?");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f1);
        l1.setForeground(Color.YELLOW);
        
        l2=new JLabel("Patient Username");
        l2.setFont(f1);
        l2.setForeground(Color.GRAY);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        tf1=new JTextField();
        
        bt=new JButton("Delete Patient");
        bt1=new JButton("Edit Patient Record");
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
        String username=tf1.getText();
        if(e.getSource()==bt)
        {
            try
            {
                ConnectionClass obj1=new ConnectionClass();
                String q="delete from patient where username='"+username+"'";
                obj1.stm.executeUpdate(q);
                setVisible(false);
//                new View_Patient().setVisible(true);
            }
            catch(Exception evx)
            {
                evx.printStackTrace();
            }
        }
        if(e.getSource()==bt1)
        {
            if(username.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Please fill the Patient Username !");
            }
            else
            {
                setVisible(false);
                new Edit_Patient(username).setVisible(true);
            }
        }
    }
    public static void main(String args[])
    {
//        new View_Patient().setVisible(true);
    }
}
