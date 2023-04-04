package GUIs;

// imports from the java library
import java.sql.ResultSet;

// imports from the project
import Session.*;

/**
 * @author Ethan
 * @minor code quality changes by Nikola
 */
public class MenuPage extends javax.swing.JFrame {
    public MenuPage() {
        initComponents();
    }

    public static void loadPage() {
        if (Info.userID != -1) {
            General.setNimbusLookAndFeel(MenuPage.class);

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(() -> new MenuPage().setVisible(true));
        } else {
            GeneralPage.main(null);
        }
    }

    private void initComponents() {

        // Initialises the components
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
        createBooking.setFont(General.font(18));

        viewBookings.setText("View bookings");
        viewBookings.addActionListener(this::viewBookingsActionPerformed);
        viewBookings.setFont(General.font(18));

        viewBookingDetails.setText("View past booking");
        viewBookingDetails.setFont(General.font(18));

        viewDoctorButton.setText("View current doctor");
        viewDoctorButton.setBackground(new java.awt.Color(255, 255, 255));
        viewDoctorButton.setFont(General.font(18));

        changeDoctor.setText("Change your doctor");
        changeDoctor.addActionListener(this::changeDoctorActionPerformed);
        changeDoctor.setFont(General.font(18));

        viewAllDoctors.setText("View all doctors");
        viewAllDoctors.setBackground(new java.awt.Color(255, 255, 255));
        viewAllDoctors.setFont(General.font(18));

        printAllLogsButton.setText("Print all logs");
        printAllLogsButton.addActionListener(this::printAllLogsActionPerformed);
        printAllLogsButton.setFont(General.font(18));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        patientMessages.setColumns(20);
        patientMessages.setRows(5);
        patientMessages.setEditable(false);
        patientMessages.setLineWrap(true);
        patientMessages.setWrapStyleWord(true);

        try {
            //Selects messages for the patient
            ResultSet message = Info.statement
                    .executeQuery("SELECT messages FROM Patients WHERE patientID = '" + Info.userID + "'");
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
                                .addGap(70, 70, 70)
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
                                                .addComponent(printAllLogsButton)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70,
                                        Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(welcomeLabel)
                                                .addGap(30, 30, 30)
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
                                                        .addComponent(viewAllDoctors)
                                                        .addComponent(printAllLogsButton))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(viewDoctorButton)))
                                .addContainerGap(30, Short.MAX_VALUE)));
        pack();
    }

    private void createBookingAction(java.awt.event.ActionEvent evt) {
        dispose();
        BookingPage.loadPage();
    }

    private void viewBookingsActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        ViewBookingPage.loadPage();
    }

    private void changeDoctorActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        ChangeDoctorPage.loadPage();
    }

    //     private void viewAllDoctorsActionPerformed(java.awt.event.ActionEvent evt) {
    //         dispose();
    //         DoctorsDetails.main(null);
    //     }

    private void printAllLogsActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            System.out.println("LogChecker.main() called");

            ResultSet allLogs = Info.statement.executeQuery("SELECT * FROM Logs;");

            while (allLogs.next()) {
                System.out.println(allLogs.getString("LogID") + " " + allLogs.getString("PatientID") + " "
                        + allLogs.getString("Timestamp") + " " + allLogs.getString("Action"));
            }
        } catch (Exception e) {
            System.out.println("Error (LogChecker.main())");
        }
    }
}