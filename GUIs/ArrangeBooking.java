package GUIs;

import java.awt.Font;

/**
 * @author Nikola
 */
public class ArrangeBooking extends javax.swing.JFrame {

    public ArrangeBooking() {
        initComponents();
    }

    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(ArrangeBooking.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArrangeBooking.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArrangeBooking.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArrangeBooking.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ArrangeBooking().setVisible(true));
    }

    // Button actions
    private void arrangeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void initComponents() {
        getContentPane().setBackground(new java.awt.Color(255, 255, 255));

        // initialise the components
        javax.swing.JPanel panel = new javax.swing.JPanel();
        javax.swing.JButton backButton = new javax.swing.JButton("Back");
        javax.swing.JButton arrangeButton = new javax.swing.JButton("Arrange");
        javax.swing.JLabel timeLabel = new javax.swing.JLabel("Time");
        javax.swing.JTextField timeText = new javax.swing.JTextField();
        javax.swing.JTextField dateText = new javax.swing.JTextField();
        javax.swing.JLabel dateLabel = new javax.swing.JLabel("Date");
        javax.swing.JLabel mainLabel = new javax.swing.JLabel("Arrange a booking");
        javax.swing.JLabel instructionLabel = new javax.swing.JLabel("Please enter your desired date and time");

        // set the properties of the frame
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(java.awt.Color.white);

        panel.setBackground(new java.awt.Color(255, 255, 255));

        // set font for all labels and buttons
        mainLabel.setFont(new java.awt.Font("Monospaced", Font.PLAIN, 36));
        instructionLabel.setFont(new java.awt.Font("Monospaced", Font.PLAIN, 18));

        timeLabel.setFont(new java.awt.Font("Monospaced", Font.PLAIN, 18));
        timeText.setFont(new java.awt.Font("Monospaced", Font.PLAIN, 18));
        timeText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        dateLabel.setFont(new java.awt.Font("Monospaced", Font.PLAIN, 18));
        dateText.setFont(new java.awt.Font("Monospaced", Font.PLAIN, 18));
        dateText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        backButton.setBackground(new java.awt.Color(65, 175, 255));
        backButton.setFont(new java.awt.Font("Monospaced", Font.PLAIN, 18));
        backButton.setPreferredSize(new java.awt.Dimension(68, 27));
        arrangeButton.addActionListener(this::arrangeButtonActionPerformed);

        arrangeButton.setBackground(new java.awt.Color(65, 175, 255));
        arrangeButton.setFont(new java.awt.Font("Monospaced", Font.PLAIN, 18));
        arrangeButton.setPreferredSize(new java.awt.Dimension(68, 27));
        arrangeButton.addActionListener(this::arrangeButtonActionPerformed);

        // Panel layout code section (below)
        // -----------------------------------------------------------------------------------------------------------------------------------
        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(mainLabel)
                                                .addGap(20, 20, 20))
                                        .addComponent(instructionLabel))
                                .addGap(27, 27, 27))
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(arrangeButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addGroup(panelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(panelLayout.createSequentialGroup()
                                                                .addComponent(dateLabel)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(dateText,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(panelLayout.createSequentialGroup()
                                                                .addComponent(timeLabel)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(timeText,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(70, 70, 70)));
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addComponent(mainLabel)
                                .addGap(5, 5, 5)
                                .addComponent(instructionLabel)
                                .addGap(75, 75, 75)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dateLabel))
                                .addGap(10, 10, 10)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(timeLabel)
                                        .addComponent(timeText, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(arrangeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(225, 225, 225)
                                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 429,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(225, 225, 225)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(245, 245, 245)
                                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(300, 300, 300)));

        pack();
    }
}