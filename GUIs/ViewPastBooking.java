package GUIs;

import java.sql.ResultSet;

// imports from the project
import Session.*;

/**
 * @author Ethan
 */
public class ViewPastBooking extends javax.swing.JFrame {
    /**
     * Creates new form NewJFrame1
     */
    public ViewPastBooking(String DoctorID, String Date, String Time) {
        initComponents(DoctorID, Date, Time);
    }

    private void initComponents(String DoctorID, String Date, String Time) {
        title = new javax.swing.JLabel();
        detailsLabel = new javax.swing.JLabel();
        prescriptionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailsOutput = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        prescriptionOuput = new javax.swing.JTextArea();
        back = new javax.swing.JButton();
        Details = new String();
        Prescription = new String();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ResultSet results = Info.statement
                    .executeQuery("SELECT Details, Prescription FROM Bookings WHERE DoctorID = '" + DoctorID
                            + "' AND Date = '" + Date + "' AND Time = '" + Time + "'");
            Details = results.getString("Details");
            Prescription = results.getString("Messages");

        } catch (Exception e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setText("Details about booking on " + Date + " " + Time + "");

        detailsLabel.setText("Details");

        prescriptionLabel.setText("Prescription");

        detailsOutput.setText(Details);
        detailsOutput.setEditable(false);
        detailsOutput.setColumns(20);
        detailsOutput.setLineWrap(true);
        detailsOutput.setRows(5);
        jScrollPane1.setViewportView(detailsOutput);

        prescriptionOuput.setText(Prescription);
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(back)
                                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 295,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(detailsLabel)
                                                                .addGap(40, 40, 40))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(prescriptionLabel)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(detailsLabel)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(prescriptionLabel)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(back)
                                .addContainerGap(18, Short.MAX_VALUE)));

        pack();

    }

    // </editor-fold>

    private void backActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        MenuPage.loadPage();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String DoctorID, String Date, String Time) {
        if (Info.userID != -1) {
            General.setNimbusLookAndFeel(ViewPastBooking.class);

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ViewPastBooking(DoctorID, Date, Time).setVisible(true);
                }
            });
        } else {
            General.closeAllWindows();
            GeneralPage.main(null);
        }
    }

    // Variables declaration
    private javax.swing.JButton back;
    private javax.swing.JLabel detailsLabel;
    private javax.swing.JTextArea detailsOutput;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel prescriptionLabel;
    private javax.swing.JTextArea prescriptionOuput;
    private javax.swing.JLabel title;
    private String Details;
    private String Prescription;
}
