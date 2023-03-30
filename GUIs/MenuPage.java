package GUIs;

// imports from the java library
import java.sql.ResultSet;

// imports from the project
import Functionality.DatabaseConnectionFunc;
import Session.*;

/**
 * @author Ethan
 * @minor code quality changes by Nikola
 */
public class MenuPage extends javax.swing.JFrame {
    public MenuPage() {
        initComponents();
    }

    private void initComponents() {
        javax.swing.JLabel welcomeLabel = new javax.swing.JLabel();
        javax.swing.JButton createBooking = new javax.swing.JButton();
        javax.swing.JButton changeDoctor = new javax.swing.JButton();
        javax.swing.JButton viewBookings = new javax.swing.JButton();
        javax.swing.JButton viewBookingDetails = new javax.swing.JButton();
        javax.swing.JButton viewAllDoctors = new javax.swing.JButton();
        javax.swing.JButton viewDoctorButton = new javax.swing.JButton();
        javax.swing.JButton printAllLogsButton = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        javax.swing.JTextArea patientMessages = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        welcomeLabel.setText("Welcome " + Info.firstname + " " + Info.surname + "!");

        createBooking.setText("Create a booking");
        createBooking.addActionListener(this::createBookingAction);

        viewBookings.setText("View bookings");
        viewBookings.addActionListener(this::viewBookingsActionPerformed);

        viewBookingDetails.setText("View past booking");

        viewDoctorButton.setText("View current doctor");

        changeDoctor.setText("Change your doctor");
        changeDoctor.addActionListener(this::changeDoctorActionPerformed);

        viewAllDoctors.setText("View all doctors");

        printAllLogsButton.setText("Print all logs");
        printAllLogsButton.addActionListener(this::printAllLogsActionPerformed);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        patientMessages.setColumns(20);
        patientMessages.setRows(5);
        patientMessages.setEditable(false);
        patientMessages.setLineWrap(true);
        patientMessages.setWrapStyleWord(true);

        try {
            //Selects messages for the patient
            ResultSet message = Info.statement
                    .executeQuery("select messages from patients where patientID = '" + Info.userID + "'");
            while (message.next()) {
                //Adds the messages to the unmodifiable text area
                patientMessages.append(" - " + message.getString("messages") + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        jScrollPane1.setViewportView(patientMessages);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(createBooking)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(viewBookings))
                                        .addComponent(viewDoctorButton)
                                        .addComponent(welcomeLabel)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(viewDoctorButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(changeDoctor))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(viewAllDoctors)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
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
                                                        .addComponent(createBooking)
                                                        .addComponent(viewBookings))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(viewDoctorButton)
                                                        .addComponent(changeDoctor))
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(viewAllDoctors))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(viewDoctorButton)))
                                .addContainerGap(30, Short.MAX_VALUE)));

        pack();
    }

    private void createBookingAction(java.awt.event.ActionEvent evt) {
        dispose();
        BookingPage.main(null);
    }

    private void viewBookingsActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        ViewBookingPage.main(null);
    }

    private void changeDoctorActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        ChangeDoctorPage.main(null);
    }

    //     private void viewAllDoctorsActionPerformed(java.awt.event.ActionEvent evt) {
    //         dispose();
    //         DoctorsDetails.main(null);
    //     }

    private void printAllLogsActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            System.out.println("LogChecker.main() called");
        
            ResultSet allLogs = Info.statement.executeQuery("SELECT * FROM logs;");
    
            while (allLogs.next()) {
                System.out.println(allLogs.getString("LogID") + " " + allLogs.getString("PatientID") + " "
                        + allLogs.getString("Timestamp") + " " + allLogs.getString("Action"));
            }
        } catch (Exception e) {
            System.out.println("Error (LogChecker.main())");
        }
    }

    public static void main(String[] args) {
        if (DatabaseConnectionFunc.connected) {
            General.setNimbusLookAndFeel(MenuPage.class);

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(() -> new MenuPage().setVisible(true));
        } else {
            GeneralPage.main(null);
        }
    }
}