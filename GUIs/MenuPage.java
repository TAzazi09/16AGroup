package GUIs;

import java.sql.ResultSet;
import Info.*;

/**
 * @author Ethan
 * @code quality review by Nikola
 */
public class MenuPage extends javax.swing.JFrame {
    public MenuPage() {
        initComponents();
    }

    public static void loadPage() {
        if (Session.userID != -1) {
            General.setNimbusLookAndFeel(MenuPage.class);

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(() -> new MenuPage().setVisible(true));
        } else {
            GeneralPage.main(null);
        }
    }

    private void initComponents() {
        getContentPane().setBackground(General.WHITE);

        // Initialises the components
        javax.swing.JLabel welcomeLabel = new javax.swing.JLabel();
        javax.swing.JButton createBooking = new javax.swing.JButton();
        javax.swing.JButton changeDoctor = new javax.swing.JButton();
        javax.swing.JButton viewBookings = new javax.swing.JButton();
        javax.swing.JButton viewBookingDetails = new javax.swing.JButton();
        javax.swing.JButton viewAllDoctors = new javax.swing.JButton();
        javax.swing.JButton viewDoctorButton = new javax.swing.JButton();
        javax.swing.JButton printAllLogsButton = new javax.swing.JButton();
        javax.swing.JButton logout = new javax.swing.JButton();

        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        javax.swing.JTextArea patientMessages = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        welcomeLabel.setText("Welcome " + Session.firstname + " " + Session.surname + "!");
        welcomeLabel.setFont(General.font(24));

        createBooking.setText("Create booking");
        createBooking.addActionListener(this::createBookingAction);
        createBooking.setFont(General.font(18));
        createBooking.setBackground(General.BUTTON_BLUE);

        viewBookings.setText("View bookings");
        viewBookings.addActionListener(this::viewBookingsActionPerformed);
        viewBookings.setFont(General.font(18));
        viewBookings.setBackground(General.BUTTON_BLUE);

        viewBookingDetails.setText("View past booking");
        viewBookingDetails.setFont(General.font(18));

        viewDoctorButton.setText("View my doctor");
        viewDoctorButton.setBackground(General.WHITE);
        viewDoctorButton.setFont(General.font(18));

        changeDoctor.setText("Change doctor");
        changeDoctor.addActionListener(this::changeDoctorActionPerformed);
        changeDoctor.setFont(General.font(18));
        changeDoctor.setBackground(General.BUTTON_BLUE);

        viewAllDoctors.setText("See all doctors");
        viewAllDoctors.setBackground(General.WHITE);
        viewAllDoctors.setFont(General.font(18));

        printAllLogsButton.setText("Print logs");
        printAllLogsButton.addActionListener(this::printAllLogsActionPerformed);
        printAllLogsButton.setFont(General.font(18));
        printAllLogsButton.setBackground(General.BUTTON_BLUE);

        logout.setText("Log out");
        logout.addActionListener(this::logoutActionPerformed);
        logout.setFont(General.font(18));
        logout.setBackground(General.BUTTON_BLUE);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        patientMessages.setColumns(20);
        patientMessages.setRows(5);
        patientMessages.setEditable(false);
        patientMessages.setLineWrap(true);
        patientMessages.setWrapStyleWord(true);
        patientMessages.setFont(General.font(14));

        try {
            // Selects messages for the patient
            ResultSet message = Session.statement
                    .executeQuery("SELECT messages FROM Patients WHERE patientID = '" + Session.userID + "'");
            while (message.next()) {
                // Adds the messages to the unmodifiable text area
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
                                .addGap(80, 80, 80)
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
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(printAllLogsButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(logout)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70,
                                        Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(welcomeLabel)
                                                .addGap(60, 60, 60)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(createBooking)
                                                        .addComponent(viewBookings))
                                                .addGap(20, 20, 20)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(viewDoctorButton)
                                                        .addComponent(changeDoctor))
                                                .addGap(20, 20, 20)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(viewAllDoctors)
                                                        .addComponent(printAllLogsButton))
                                                .addGap(20, 20, 20)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(logout))))
                                .addContainerGap(150, Short.MAX_VALUE)));
        pack();
    }

    private void createBookingAction(java.awt.event.ActionEvent evt) {
        dispose();
        BookingPage.loadPage();
    }

    private void viewBookingsActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        ViewBookingsPage.loadPage();
    }

    private void changeDoctorActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        ChangeDoctorPage.loadPage();
    }

    // This is the code for the "View all doctors" button which is currently not
    // working as it is not yet implemented (Tare hasn't provided the code for it yet)
    // private void viewAllDoctorsActionPerformed(java.awt.event.ActionEvent evt) {
    // dispose();
    // DoctorsDetails.main(null);
    // }

    private void printAllLogsActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            System.out.println("LogChecker.main() called");

            ResultSet allLogs = Session.statement.executeQuery("SELECT * FROM Logs;");

            while (allLogs.next()) {
                System.out.println(allLogs.getString("LogID") + " " + allLogs.getString("PatientID") + " "
                        + allLogs.getString("Timestamp") + " " + allLogs.getString("Action"));
            }
        } catch (Exception e) {
            System.out.println("Error (LogChecker.main())");
        }
    }

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {
        Session.userID = -1;
        dispose();
        GeneralPage.main(null);
    }
}