package GUIs;

// imports from the java library
import java.sql.ResultSet;

// imports from the project
import Databases.DoctorsDB;
import Session.*;
import Functionality.ChangeDoctorFunc;

/**
 * @author Nikola
 */
public class ChangeDoctorPage extends javax.swing.JFrame {
    private javax.swing.JComboBox<String> newDocBox;

    public ChangeDoctorPage() {
        initComponents();
    }

    private void initComponents() {
        getContentPane().setBackground(General.WHITE);

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel changeDocLabel = new javax.swing.JLabel("Change your doctor");
        newDocBox = new javax.swing.JComboBox<>();
        javax.swing.JLabel curDocLabel = new javax.swing.JLabel("Current doctor: ");
        javax.swing.JLabel newDocLabel = new javax.swing.JLabel("New doctor: ");
        javax.swing.JLabel curDocName = new javax.swing.JLabel("doc name");
        javax.swing.JButton backButton = new javax.swing.JButton("Back");
        javax.swing.JButton submitButton = new javax.swing.JButton("Submit");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(General.WHITE);

        changeDocLabel.setFont(General.font(36));

        newDocBox.setFont(General.font(18));
        newDocBox.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose a doctor" }));

        curDocLabel.setFont(General.font(18));

        newDocLabel.setFont(General.font(18));

        curDocName.setFont(General.font(18));

        int curDocID;
        String curDoc = "";
        try {
            // Get the patient's doctor
            ResultSet currentDoctor = Info.statement
                    .executeQuery("SELECT DoctorID FROM Patients WHERE patientID = '" + Info.userID + "';");
            currentDoctor.next();
            curDocID = Integer.parseInt(currentDoctor.getString("DoctorID"));
            curDoc = DoctorsDB.getDoctorName(curDocID);

            // Get the list of doctors without the current patient's doctor (for the drop-down menu)
            ResultSet doctors = Info.statement
                    .executeQuery("SELECT * FROM Doctors WHERE DoctorID != '" + curDocID + "';");
            while (doctors.next()) {
                newDocBox.addItem(doctors.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        curDocName.setText(curDoc);

        backButton.setFont(General.font(18));
        backButton.setBackground(General.BUTTON_BLUE);
        backButton.addActionListener(this::backButtonActionPerformed);

        submitButton.setFont(General.font(18));
        submitButton.setBackground(General.BUTTON_BLUE);
        submitButton.addActionListener(this::submitButtonActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(changeDocLabel)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(backButton)
                                                        .addGroup(jPanel1Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(curDocLabel)
                                                                .addComponent(newDocLabel)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(newDocBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(curDocName)
                                                        .addComponent(submitButton))))
                                .addGap(25, 25, 25)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(changeDocLabel)
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(curDocLabel)
                                        .addComponent(curDocName))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(newDocLabel)
                                        .addComponent(newDocBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(backButton)
                                        .addComponent(submitButton))
                                .addContainerGap(20, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(200, 200, 200)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(310, Short.MAX_VALUE)));

        pack();
    }

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (newDocBox.getSelectedItem() != null) {
            String newDocName = newDocBox.getSelectedItem().toString();
            ChangeDoctorFunc.changeDoctor(newDocName);
        }
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        MenuPage.main(null);
        dispose();
    }

    public static void main(String[] args) {
        General.setNimbusLookAndFeel(ChangeDoctorFunc.class);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ChangeDoctorPage().setVisible(true));
    }
}