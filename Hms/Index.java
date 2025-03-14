package Hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Index extends JFrame implements ActionListener {
    JFrame f;
    JLabel backgroundLabel, textLabel1, textLabel2;
    JButton b1, b2, b3, b4;
    int loginid;

    Index() {
        f = new JFrame("Index Page");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 600);
        f.setMinimumSize(new Dimension(400, 300));

        backgroundLabel = new JLabel();
        backgroundLabel.setLayout(new GridBagLayout());

        textLabel1 = new JLabel("Binary Breakers Group");
        textLabel1.setFont(new Font("Arial", Font.BOLD, 30));
        textLabel1.setForeground(Color.BLACK);

        textLabel2 = new JLabel("Provide the best quality healthcare for you");
        textLabel2.setFont(new Font("Arial", Font.BOLD, 13));
        textLabel2.setForeground(Color.BLACK);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);
        textPanel.add(textLabel1);
        textPanel.add(textLabel2);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        backgroundLabel.add(textPanel, gbc);

        b1 = new JButton("Doctor");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);

        b2 = new JButton("Patient");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);

        b3 = new JButton("Receptionist");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);

        b4 = new JButton("Admin");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setOpaque(false);
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(b4);

        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.SOUTH;
        backgroundLabel.add(buttonPanel, gbc);

        f.add(backgroundLabel);
        f.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeComponents();
            }
        });
        f.setVisible(true);
        f.setResizable(true);
        changeImage("Hms/Icons/first page.jpg"); // Initial image
        resizeComponents(); // Initial resizing
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            loginid = 4;
            changeImage("Hms/Icons/doctor_image.jpg");
            new LoginPage(loginid).setVisible(true);
            f.setVisible(false);
        } else if (ae.getSource() == b2) {
            loginid = 3;

            // Connect to the SignUpPage for patients
            SwingUtilities.invokeLater(() -> {
                new SignUpPage(this).createAndShowGUI();
                f.setVisible(false);
            });
        } else if (ae.getSource() == b3) {
            loginid = 2;
            changeImage("Hms/Icons/receptionist_image.jpg");
            new LoginPage(loginid).setVisible(true);
            f.setVisible(false);
        } else if (ae.getSource() == b4) {
            loginid = 1;
            changeImage("Hms/Icons/admin_image.jpg");
            new LoginPage(loginid).setVisible(true);
            f.setVisible(false);
        }
    }

//    // Placeholder method, replace with your LandingPage logic
//    private void openLandingPage() {
//        // Replace this with the actual logic to open the LandingPage
//        LandingPage landingPage = new LandingPage();
////        landingPage.createAndShowGUI();
//    SwingUtilities.invokeLater(() -> {
//        LandingPage landingPage = new LandingPage();
//        landingPage.createAndShowGUI();
//        // You might also want to dispose of the current frame if needed
//        f.dispose();
//    }

    private void changeImage(String imagePath) {
        try {
            ImageIcon img = new ImageIcon(ClassLoader.getSystemResource(imagePath));
            if (img != null) {
                Image i1 = img.getImage().getScaledInstance(backgroundLabel.getWidth(), backgroundLabel.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon img1 = new ImageIcon(i1);
                backgroundLabel.setIcon(img1);
            } else {
                System.err.println("Image not found: " + imagePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void resizeComponents() {
        textLabel1.setSize(backgroundLabel.getWidth(), textLabel1.getHeight());
        textLabel2.setSize(backgroundLabel.getWidth(), textLabel2.getHeight());
        backgroundLabel.setIcon(null); // Clear the icon to ensure correct resizing
        changeImage("Hms/Icons/first page.jpg");
    }

    public static void main(String[] args) {
        new Index();
    }
}
