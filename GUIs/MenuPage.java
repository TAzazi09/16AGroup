package GUIs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import Functionality.*;

/**
 * @author Ethan
 * @code quality changes by Nikola
 */
public class MenuPage extends javax.swing.JFrame {
    public MenuPage() {
        initComponents();
    }

    private void initComponents() {
        welcomeLabel = new javax.swing.JLabel();
        createBooking = new javax.swing.JButton();
//rescheduleBooking = new javax.swing.JButton();
        changeDoctor = new javax.swing.JButton();
        viewBookings = new javax.swing.JButton();
        viewBookingDetails = new javax.swing.JButton();
        viewAllDoctors = new javax.swing.JButton();
        viewDoctorButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        welcomeLabel.setText("Welcome " + LoginCheck.getFirstName() + " " + LoginCheck.getSurname() + "!");

        createBooking.setText("Create a booking");
        createBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBookingAction(evt);
            }
        });

        // rescheduleBooking.setText("Reschedule a booking");
        // rescheduleBooking.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         rescheduleBookingAction(evt);
        //     }
        // });

        changeDoctor.setText("Change your doctor");
        changeDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeDoctorActionPerformed(evt);
            }
        });

        viewBookings.setText("View bookings");
        viewBookings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBookingsActionPerformed(evt);
            }
        });

        viewBookingDetails.setText("View past booking");

        viewAllDoctors.setText("View all doctors");

        viewDoctorButton.setText("View doctor?");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEditable(false);
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Connects to the database
            Connection connection = DatabaseConnectionFunc.getConnection();
            Statement statement = connection.createStatement();
            ResultSet message = statement
                    .executeQuery("select messages from patients where patientID = '" + LoginCheck.getID() + "'");
            while (message.next()) {
                jTextArea1.append(" - " + message.getString("messages") + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(viewBookingDetails)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(viewAllDoctors))
                                        .addComponent(viewDoctorButton)
                                        .addComponent(welcomeLabel)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(changeDoctor)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(createBooking))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(viewBookings)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                              //  .addComponent(rescheduleBooking)
                                              ))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63,
                                        Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(welcomeLabel)
                                                .addGap(26, 26, 26)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(changeDoctor)
                                                        .addComponent(createBooking))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(viewBookings)
                                                    //    .addComponent(rescheduleBooking)
                                                    )
                                               // .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(viewBookingDetails)
                                                        .addComponent(viewAllDoctors))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(viewDoctorButton)))
                                .addContainerGap(30, Short.MAX_VALUE)));

        pack();
    }

    private void createBookingAction(java.awt.event.ActionEvent evt) {
        dispose();
        ArrangeBooking.main(null);
    }

    // private void rescheduleBookingAction(java.awt.event.ActionEvent evt) {
    //     dispose();
    //     ReschedulingPage.main(null);
    // }

    private void changeDoctorActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        ChangeDoctorPage.main(null);
    }

    private void viewBookingsActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        viewBooking.main(null);
    }

    public static void main(String args[]) {
        if (DatabaseConnectionFunc.connected) {
            /* Set the Nimbus look and feel */
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
             * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
             */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(MenuPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                        ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(MenuPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                        ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(MenuPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                        ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(MenuPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                        ex);
            }

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new MenuPage().setVisible(true);
                }
            });
        } else {
            GeneralPage.main(null);
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton createBooking;
   // private javax.swing.JButton rescheduleBooking;
    private javax.swing.JButton changeDoctor;
    private javax.swing.JButton viewBookings;
    private javax.swing.JButton viewBookingDetails;
    private javax.swing.JButton viewAllDoctors;
    private javax.swing.JButton viewDoctorButton;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration                   
}
