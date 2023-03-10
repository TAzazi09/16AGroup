package GUIs;

/**
 * @author nik
 * @functional changes by ethan
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class GeneralPage extends javax.swing.JFrame {
    // Variables declaration
    private javax.swing.JButton logButton;
    private javax.swing.JButton regButton;
    private javax.swing.JLabel helloLabel;
    private javax.swing.JPanel generalPanel;
    private static Connection connection;
    private static Statement statement;

    public GeneralPage() {
        initComponents();
    }

    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/?user=root&password=***");
            statement = connection.createStatement();

            // Lines below are used for creating tables
            statement.executeUpdate("DROP DATABASE IF EXISTS NHS;");
            statement.executeUpdate("CREATE DATABASE NHS");
            statement.executeUpdate("use NHS");
            statement.executeUpdate("DROP TABLE IF EXISTS patients;");
            statement.execute("CREATE TABLE patients (" +
                    "PatientID int not null auto_increment," +
                    "FirstName VARCHAR(15) not null, " +
                    "Surname varchar(15) NOT NULL," +
                    "PRIMARY KEY (patientID), " +
                    "Gender varchar(10) not null," +
                    "Age int (3) not null," +
                    "PhoneNumber varchar(12) ," +
                    "DoctorChosen varchar(25) not null,  " +
                    "Details varchar(100) " +
                    ");");
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GeneralPage.class.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeneralPage.class.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeneralPage.class.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeneralPage.class.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeneralPage().setVisible(true);
            }
        });
    }

    private void initComponents() {
        generalPanel = new javax.swing.JPanel();
        helloLabel = new javax.swing.JLabel("Hello!");
        logButton = new javax.swing.JButton("Log-in");
        regButton = new javax.swing.JButton("Register");

        // Login button - opens the login page
        logButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                application.main(null);
                dispose();
            }
        });

        // Registration button - opens the registration page
        regButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registration_gui.main(null);
                dispose(); // Close the current JFrame
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        generalPanel.setBackground(new java.awt.Color(255, 255, 255));

        helloLabel.setFont(new java.awt.Font("Monospaced", 0, 36));

        logButton.setBackground(new java.awt.Color(65, 175, 255));
        logButton.setFont(new java.awt.Font("Monospaced", 0, 18));

        regButton.setBackground(new java.awt.Color(65, 175, 255));
        regButton.setFont(new java.awt.Font("Monospaced", 0, 18));

        // Panel layout code section (below)
        // -----------------------------------------------------------------------------------------------------------------------------------
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(generalPanel);
        generalPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout
                                                .createSequentialGroup()
                                                .addGap(270, 270, 270)
                                                .addComponent(logButton,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        135,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(regButton,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        135,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout
                                                .createSequentialGroup()
                                                .addGap(350, 350, 350)
                                                .addComponent(helloLabel)))
                                .addContainerGap(320, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(300, 300, 300)
                                .addComponent(helloLabel)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(logButton,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(regButton,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(445, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(generalPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(generalPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }
}