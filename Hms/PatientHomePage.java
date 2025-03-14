package Hms;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PatientHomePage extends JFrame implements ActionListener
{
    JLabel l1;
    Font f,f1,f2;
    public String id;
    public int login__id;
    String patient_username;
    
    PatientHomePage(String patientname, String patientid, int login_id, String patientusername)
    {
        super("Patient Home Page");
        setLocation(0,0);
        setSize(1350,700);
        
        id=patientid;
        login__id=login_id;
        patient_username=patientusername;
        
        f=new Font("Lucida Fax",Font.BOLD,20);
        f2=new Font("Gadugi",Font.BOLD,35);
        f1=new Font("MS UI Gothic",Font.BOLD,18);
        
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("Hms/Icons/patient.jpg"));
        Image img=ic.getImage().getScaledInstance(1350,700,Image.SCALE_SMOOTH);
        ImageIcon ic1=new ImageIcon(img);
        l1=new JLabel(ic1);
        
        JMenuBar m1=new JMenuBar();
        JMenu men1=new JMenu("Doctor");
//        JMenuItem ment1=new JMenuItem("Add Doctor");
        JMenuItem ment2=new JMenuItem("View Doctor");
        
        JMenu men2=new JMenu("Patient");
//        JMenuItem ment3=new JMenuItem("Add Patient");
        JMenuItem ment4=new JMenuItem("View Patient");
        
//        JMenu men3=new JMenu("Receptionist");
////        JMenuItem ment5=new JMenuItem("Add Receptionist");
//        JMenuItem ment6=new JMenuItem("View Receptionist");
        
        JMenu men4=new JMenu("Appointment");
        JMenuItem ment7=new JMenuItem("Add Appointment");
        JMenuItem ment8=new JMenuItem("View Appointment");
        
        JMenu men5=new JMenu("Hello, ("+patientname+")");
        JMenuItem ment9=new JMenuItem("My Profile");
        JMenuItem ment10=new JMenuItem("Change Password");
        
        JMenu men8=new JMenu("Exit");
        JMenuItem ment14=new JMenuItem("Exit");
        
//        men1.add(ment1);
        men1.add(ment2);
//        men2.add(ment3);
        men2.add(ment4);
//        men3.add(ment5);
//        men3.add(ment6);
        men4.add(ment7);
        men4.add(ment8);
        men5.add(ment9);        
        men5.add(ment10);
        men8.add(ment14);
        
        m1.add(men1);
        m1.add(men2);
//        m1.add(men3);
        m1.add(men4);
        m1.add(men5);
        m1.add(men8);
        
        men1.setFont(f);
        men2.setFont(f);
//        men3.setFont(f);
        men4.setFont(f);
        men5.setFont(f);
        men8.setFont(f);
        
//        ment1.setFont(f1);
        ment2.setFont(f1);
//        ment3.setFont(f1);
        ment4.setFont(f1);
//        ment5.setFont(f1);
//        ment6.setFont(f1);
        ment7.setFont(f1);
        ment8.setFont(f1);
        ment9.setFont(f1);
        ment10.setFont(f1);
        ment14.setFont(f1);
        
        m1.setBackground(Color.BLACK);
        
        men1.setForeground(Color.GRAY);
        men2.setForeground(Color.GRAY);
//        men3.setForeground(Color.GRAY);
        men4.setForeground(Color.GRAY);
        men5.setForeground(Color.GRAY);
        men8.setForeground(Color.RED);
        
//        ment1.setBackground(Color.BLACK);        
//        ment3.setBackground(Color.BLACK);          
//        ment5.setBackground(Color.BLACK);
        ment7.setBackground(Color.BLACK);
        ment9.setBackground(Color.BLACK);
        ment14.setBackground(Color.BLACK);

//        ment1.setForeground(Color.YELLOW);       
//        ment3.setForeground(Color.YELLOW);       
//        ment5.setForeground(Color.YELLOW);        
        ment7.setForeground(Color.YELLOW);        
        ment9.setForeground(Color.YELLOW);
        ment14.setForeground(Color.RED);
        
//        ment1.addActionListener(this);
        ment2.addActionListener(this);
//        ment3.addActionListener(this);
        ment4.addActionListener(this);
//        ment5.addActionListener(this);
//        ment6.addActionListener(this);
        ment7.addActionListener(this);
        ment8.addActionListener(this);
        ment9.addActionListener(this);
        ment10.addActionListener(this);
        ment14.addActionListener(this);
        
        setJMenuBar(m1);
        add(l1);
    }
    public void actionPerformed(ActionEvent e) 
    {
        String comnd=e.getActionCommand();
        if(comnd.equals("Add Doctor"))
        {
            new Add_Doctor();
        }
        else if(comnd.equals("View Doctor"))
        {
            new View_Doctor(login__id).setVisible(true);
        }
        else if(comnd.equals("Add Patient"))
        {
            new Add_Patient();
        }
        else if(comnd.equals("View Patient"))
        {
            new View_Patient(patient_username,login__id).setVisible(true);
        }
//        else if(comnd.equals("Add Receptionist"))
//        {
//            new Add_Receptionist();
//        }
//        else if(comnd.equals("View Receptionist"))
//        {
//            new View_Receptionist(login__id).setVisible(true);
//        }
        else if(comnd.equals("Add Appointment"))
        {
            new AddAppointment(patient_username,login__id).setVisible(true);
        }
        else if(comnd.equals("View Appointment"))
        {
            new View_Appointement(patient_username,login__id).setVisible(true);
        }
        else if(comnd.equals("My Profile"))
        {
            new CheckMyProfile(id,login__id).setVisible(true);
        }
        else if(comnd.equals("Change Password"))
        {
            new ChangePassword(id,login__id).setVisible(true);
        }
        else if(comnd.equals("Exit"))
        {
            this.setVisible(false);
            new Index();
        }
    }
}
