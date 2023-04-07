package GUIs;

import java.sql.ResultSet;
import Databases.DoctorsDB;
import Info.*;

/**
 * @author Ethan
 * @code-quality by Nikola
 */
public class PastBookingsPage extends javax.swing.JFrame {
    public PastBookingsPage(String DoctorID, String Date, String Time) {
        initComponents(DoctorID, Date, Time);
    }

    public static void loadPage(String DoctorID, String Date, String Time) {
        if (Session.userID != -1) {
            General.setNimbusLookAndFeel(PastBookingsPage.class);

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new PastBookingsPage(DoctorID, Date, Time).setVisible(true);
                }
            });
        } else {
            General.closeAllWindows();
            GeneralPage.main(null);
        }
    }

    private void initComponents(String DoctorID, String Date, String Time) {
        javax.swing.JLabel title = new javax.swing.JLabel();
        javax.swing.JLabel detailsLabel = new javax.swing.JLabel();
        javax.swing.JLabel prescriptionLabel = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        javax.swing.JTextArea detailsOutput = new javax.swing.JTextArea();
        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        javax.swing.JTextArea prescriptionOuput = new javax.swing.JTextArea();
        javax.swing.JButton back = new javax.swing.JButton();
        String Details = new String();
        String Prescription = new String();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Integer name = DoctorsDB.getDoctorID(DoctorID);
            ResultSet results = Session.statement
                    .executeQuery("SELECT Detail, Prescription FROM Bookings WHERE DoctorID LIKE '%"
                            + name
                            + "%' AND Date = '" + Date + "' AND Time = '" + Time + "'");
            results.next();
            Details = results.getString("Detail");
            Prescription = results.getString("Prescription");

        } catch (Exception e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setText("Details about booking on " + Date + " " + Time + "");

        detailsLabel.setText("Details");

        prescriptionLabel.setText("Prescription");
        if (Details == "null") {
            detailsOutput.setText(Details);
        } else {
        }
        detailsOutput.setEditable(false);
        detailsOutput.setColumns(20);
        detailsOutput.setLineWrap(true);
        detailsOutput.setRows(5);
        jScrollPane1.setViewportView(detailsOutput);

        if (Prescription == "null") {
            prescriptionOuput.setText(Prescription);
        } else {
        }
        prescriptionOuput.setEditable(false);
        prescriptionOuput.setColumns(20);
        prescriptionOuput.setLineWrap(true);
        prescriptionOuput.setRows(5);
        jScrollPane2.setViewportView(prescriptionOuput);

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(back)
                                        .addComponent(title,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                295,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(detailsLabel)
                                                                .addGap(40, 40, 40))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                layout
                                                                        .createSequentialGroup()
                                                                        .addComponent(prescriptionLabel)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                                .addGroup(layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane2,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(62, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(title,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        39,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(detailsLabel)
                                        .addComponent(jScrollPane1,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(prescriptionLabel)
                                        .addComponent(jScrollPane2,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(back)
                                .addContainerGap(18, Short.MAX_VALUE)));

        pack();
    }

    private void backActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }
}