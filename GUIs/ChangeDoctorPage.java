package GUIs;

import java.awt.Font;
import java.awt.Color;

/**
 * @author Nikola
 */
public class ChangeDoctorPage extends javax.swing.JFrame {
    private javax.swing.JButton backButton;
    private javax.swing.JLabel changeDocLabel;
    private javax.swing.JLabel curDocLabel;
    private javax.swing.JLabel curDocName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> newDocBox;
    private javax.swing.JLabel newDocLabel;
    private javax.swing.JButton submitButton;

    public ChangeDoctorPage() {
        initComponents();
    }

    private void initComponents() {
        getContentPane().setBackground(new java.awt.Color(255, 255, 255));

        jPanel1 = new javax.swing.JPanel();
        changeDocLabel = new javax.swing.JLabel("Change your doctor");
        newDocBox = new javax.swing.JComboBox<>();
        curDocLabel = new javax.swing.JLabel("Current doctor: ");
        newDocLabel = new javax.swing.JLabel("New doctor: ");
        curDocName = new javax.swing.JLabel("doc name");
        backButton = new javax.swing.JButton("Back");
        submitButton = new javax.swing.JButton("Submit");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        changeDocLabel.setFont(new java.awt.Font("Monospaced", Font.PLAIN, 36));

        newDocBox.setFont(new java.awt.Font("Monospaced", Font.PLAIN, 18));
        newDocBox.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        curDocLabel.setFont(new java.awt.Font("Monospaced", Font.PLAIN, 18));

        newDocLabel.setFont(new java.awt.Font("Monospaced", Font.PLAIN, 18));

        curDocName.setFont(new java.awt.Font("Monospaced", Font.PLAIN, 18));
        String curDoc = "Dr. " + "name";
        // curDocName.setText();

        Color buttonBlue = new java.awt.Color(65, 175, 255, 1);

        backButton.setFont(new java.awt.Font("Monospaced", Font.PLAIN, 18));
        backButton.setBackground(buttonBlue);
        backButton.addActionListener(this::backButtonActionPerformed);

        submitButton.setFont(new java.awt.Font("Monospaced", Font.PLAIN, 18));
        submitButton.setBackground(buttonBlue);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

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
        // TODO add your handling code here:
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        MenuPage.main(null);
        dispose();
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChangeDoctorPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeDoctorPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeDoctorPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeDoctorPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangeDoctorPage().setVisible(true);
            }
        });
    }
}