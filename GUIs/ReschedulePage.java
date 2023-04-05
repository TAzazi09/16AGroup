package GUIs;

// imports from the project
import Functionality.ReschedulingFunc;
import Info.General;
import Info.Session;

/**
 * @author Ethan
 */
public class ReschedulePage extends javax.swing.JFrame {
    // Variables declaration
    private javax.swing.JTextField dateInput;
    private javax.swing.JTextField timeInput;

    public ReschedulePage(String oldDate, String oldTime) {
        initComponents(oldDate, oldTime);
    }

    public static void loadPage(String oldDate, String oldTime) {
        if (Session.userID != -1) {
            General.setNimbusLookAndFeel(ReschedulePage.class);

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(() -> new ReschedulePage(oldDate, oldTime).setVisible(true));
        } else {
            GeneralPage.main(null);
        }
    }

    private void initComponents(String oldDate, String oldTime) {

        javax.swing.JLabel dateLabel = new javax.swing.JLabel();
        timeInput = new javax.swing.JTextField("HH:MM");
        dateInput = new javax.swing.JTextField("YYYY-MM-DD");
        javax.swing.JLabel timeLabel = new javax.swing.JLabel();
        javax.swing.JButton submit = new javax.swing.JButton();
        javax.swing.JLabel title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dateLabel.setText("New Date");

        timeLabel.setText("New Time");

        submit.setText("Reschedule");
        submit.addActionListener(evt -> submitButton(evt, oldDate, oldTime));

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

    private void submitButton(java.awt.event.ActionEvent evt, String oldDate, String oldTime) {
        String time = timeInput.getText();
        String date = dateInput.getText();
        // Sends both the new and old date / time
        ReschedulingFunc.sendData(oldDate, oldTime, date, time);
    }
}