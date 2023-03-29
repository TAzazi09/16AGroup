package GUIs;

// imports from the project
import Functionality.BookingFunc;
import Functionality.DatabaseConnectionFunc;
import Session.General;

/**
 * @author Nikola
 */
public class BookingPage extends javax.swing.JFrame {
    private javax.swing.JTextField timeInput, dateInput;

    public BookingPage() {
        initComponents();
    }

    public static void main(String[] args) {
        if (DatabaseConnectionFunc.connected) {
            /* Set the Nimbus look and feel */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(BookingPage.class.getName()).log(java.util.logging.Level.SEVERE,
                        null,
                        ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(BookingPage.class.getName()).log(java.util.logging.Level.SEVERE,
                        null,
                        ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(BookingPage.class.getName()).log(java.util.logging.Level.SEVERE,
                        null,
                        ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(BookingPage.class.getName()).log(java.util.logging.Level.SEVERE,
                        null,
                        ex);
            }

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(() -> new BookingPage().setVisible(true));
        } else {
            GeneralPage.main(null);
        }
    }

    // Button actions
    private void arrangeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String time = timeInput.getText();
        String date = dateInput.getText();
        BookingFunc.arrangeBooking(time, date);
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        MenuPage.main(null);
        dispose();
    }

    private void initComponents() {
        getContentPane().setBackground(General.WHITE);

        // initialise the components
        javax.swing.JPanel panel = new javax.swing.JPanel();
        javax.swing.JButton backButton = new javax.swing.JButton("Back");
        javax.swing.JButton arrangeButton = new javax.swing.JButton("Arrange");
        javax.swing.JLabel timeLabel = new javax.swing.JLabel("Time");
        timeInput = new javax.swing.JTextField("HH:MM");
        javax.swing.JLabel dateLabel = new javax.swing.JLabel("Date");
        dateInput = new javax.swing.JTextField("YYYY-MM-DD");
        javax.swing.JLabel mainLabel = new javax.swing.JLabel("Arrange a booking");
        javax.swing.JLabel instructionLabel = new javax.swing.JLabel("Please enter your desired date and time");

        // set the properties of the frame
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(General.WHITE);
        setForeground(General.WHITE);

        panel.setBackground(General.WHITE);

        // set font for all labels and buttons
        mainLabel.setFont(General.font(36));
        instructionLabel.setFont(General.font(18));

        timeLabel.setFont(General.font(18));
        timeInput.setFont(General.font(18));
        timeInput.setBorder(javax.swing.BorderFactory.createLineBorder(General.BLACK));
        timeInput.setFont(General.font(18));

        dateLabel.setFont(General.font(18));
        dateInput.setFont(General.font(18));
        dateInput.setBorder(javax.swing.BorderFactory.createLineBorder(General.BLACK));


        backButton.setBackground(General.BUTTON_BLUE);
        backButton.setFont(General.font(18));
        backButton.setPreferredSize(new java.awt.Dimension(68, 27));
        backButton.addActionListener(this::backButtonActionPerformed);

        arrangeButton.setBackground(General.BUTTON_BLUE);
        arrangeButton.setFont(General.font(18));
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
                                                                .addComponent(dateInput,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(panelLayout.createSequentialGroup()
                                                                .addComponent(timeLabel)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(timeInput,
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
                                        .addComponent(dateInput, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dateLabel))
                                .addGap(10, 10, 10)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(timeLabel)
                                        .addComponent(timeInput, javax.swing.GroupLayout.PREFERRED_SIZE,
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