package GUIs;

import Functionality.*;

/**
 *
 * @author range
 */
public class ReschedulingPage extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public ReschedulingPage() {
        initComponents();
    }

    private void initComponents() {

        dateLabel = new javax.swing.JLabel();
        timeInput = new javax.swing.JFormattedTextField();
        dateInput = new javax.swing.JFormattedTextField();
        timeLabel = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dateInput.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
                new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        dateLabel.setText("New Date");

        timeInput.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
                new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));

        timeLabel.setText("New Time");

        submit.setText("Reschedule");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButton(evt);
            }
        });

        title.setText("Please enter your new date and time:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(title)
                                        .addComponent(submit)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(timeLabel)
                                                        .addComponent(dateLabel))
                                                .addGap(56, 56, 56)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(timeInput,
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 75,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(dateInput,
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 75,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(135, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(title)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(timeLabel)
                                        .addComponent(timeInput, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dateLabel)
                                        .addComponent(dateInput, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addComponent(submit)
                                .addContainerGap(135, Short.MAX_VALUE)));

        pack();
    }

    private void submitButton(java.awt.event.ActionEvent evt) {
        String time = timeInput.getText();
        String date = dateInput.getText();
        ReschedulingFunc.resechduleBooking(time, date);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReschedulingPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReschedulingPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReschedulingPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReschedulingPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null,
                    ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReschedulingPage().setVisible(true);
            }
        });
    }

    private javax.swing.JButton submit;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel title;
    private javax.swing.JFormattedTextField dateInput;
    private javax.swing.JFormattedTextField timeInput;
    // End of variables declaration
}
