package GUIs;

import java.awt.Window;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.time.LocalDate;

import Functionality.DatabaseConnectionFunc;
import Functionality.LoginCheck;
import javax.swing.JOptionPane;
import Databases.DoctorsDB;

/**
 *
 * @author ks818
 * @functionality Ethan
 */
public class ViewBookingPage extends javax.swing.JFrame {
    public static Connection connection;
    public static Statement statement;
    public String userId = LoginCheck.getFirstName();

    public ViewBookingPage() {
        super("View Bookings");
        initComponents();
        logged_user_text.setText("User: " + userId);
    }

    private void initComponents() {
        Title = new javax.swing.JLabel();
        date_selected_text = new javax.swing.JLabel();
        Confirm_button = new javax.swing.JButton();
        logged_user_text = new javax.swing.JLabel();
        Month_Selector = new javax.swing.JComboBox<>();
        yearInput = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        resultBookings = new javax.swing.JComboBox<>();
        list = new ArrayList<>();
        reschedule = new javax.swing.JButton();
        viewPastBooking = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Title.setFont(new java.awt.Font("Monospaced", 0, 24));
        Title.setText("View your bookings");

        date_selected_text.setFont(new java.awt.Font("Monospaced", 0, 18));
        date_selected_text.setText("Month   |   Year");

        viewPastBooking.setText("View booking details");
        viewPastBooking.setVisible(false);
        resultBookings.addActionListener(evt -> {
            reschedule.setVisible(true);
            if (resultBookings.getSelectedItem() != null) {
                String[] split = resultBookings.getSelectedItem().toString().split("~");
                String dateInput = split[1].split(" ")[1];
                LocalDate inputDate = LocalDate.parse(dateInput);
                LocalDate currentDate = LocalDate.now();
                if (inputDate.isBefore(currentDate)) {
                    viewPastBooking.setVisible(true);
                } else {
                    viewPastBooking.setVisible(false);
                }
            }
        });

        reschedule.setText("Reschedule");
        reschedule.setVisible(false);
        reschedule.addActionListener(evt -> {
            String currentSelected = resultBookings.getSelectedItem().toString();
            String[] split = currentSelected.split("~");
            String dateInput = split[1].split(" ")[1];
            String timeInput = split[2].trim();
            GUIs.ReschedulePage.main(dateInput, timeInput);

        });

        Confirm_button.setText("Confirm");
        Confirm_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultBookings.setVisible(false);
                String Year = (String) yearInput.getText();
                String Month = (String) Month_Selector.getSelectedItem();
                // Check the input is in the right form (4 digits)
                if (!(Year.matches("\\d{4}"))) {
                    JOptionPane.showMessageDialog(null, "Invalid year!");
                } else {
                    String combination = Year + "-" + Month;
                    try {
                        connection = DatabaseConnectionFunc.getConnection();
                        statement = connection.createStatement();
                        // Gets the required information about the booking where the date contains the
                        // year and month
                        ResultSet results = statement.executeQuery(
                                "SELECT DoctorID, Date, Time FROM bookings WHERE Date LIKE '%" + combination + "%';");
                        // Clears the dropdown and the array of bookings.
                        // Also sets all tempory objects as invisible.
                        list.clear();
                        resultBookings.removeAllItems();
                        resultBookings.setVisible(false);
                        reschedule.setVisible(false);
                        while (results.next()) {
                            // Sets tempory objects as true
                            resultBookings.setVisible(true);
                            reschedule.setVisible(true);
                            list.add((DoctorsDB.getDoctorName(results.getInt("DoctorID"))) + " ~ "
                                    + results.getString("Date") + " ~ " + results.getString("Time"));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < list.size(); i++) {
                        resultBookings.addItem(list.get(i));
                    }
                }
            }
        });

        back.setText("Back");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Window[] windows = Window.getWindows();

                // Close all windows in the array
                for (Window window : windows) {
                    window.dispose();
                }
                MenuPage.main(null);
            }
        });

        logged_user_text.setFont(new java.awt.Font("Monospaced", 0, 14));
        logged_user_text.setText("User: ");
        resultBookings.setVisible(false);
        Month_Selector.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(logged_user_text, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(250, 250, 250)
                                                .addComponent(Confirm_button)
                                                .addComponent(back))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(211, 211, 211)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(Month_Selector,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(54, 54, 54)
                                                                .addComponent(yearInput,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(date_selected_text)))
                                        .addGap(50, 50, 50)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(150, 150, 150)
                                                .addComponent(resultBookings, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                        )
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(back)
                                                .addComponent(reschedule)
                                                .addComponent(viewPastBooking)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Title)
                                        .addComponent(logged_user_text))
                                .addGap(18, 18, 18)
                                .addComponent(date_selected_text)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Month_Selector, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(yearInput, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Confirm_button)
                                        .addComponent(back))
                                .addComponent(resultBookings)
                                .addGap(10, 10, 10)
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(reschedule)
                                        .addComponent(viewPastBooking))

                                .addContainerGap(86, Short.MAX_VALUE)));

        pack();
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ViewBookingPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBookingPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBookingPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBookingPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null,
                    ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBookingPage().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton Confirm_button;
    private javax.swing.JComboBox<String> Month_Selector;
    private javax.swing.JLabel Title;
    private javax.swing.JTextField yearInput;
    private javax.swing.JLabel date_selected_text;
    private javax.swing.JLabel logged_user_text;
    private javax.swing.JButton back;
    private javax.swing.JComboBox<String> resultBookings;
    private java.util.ArrayList<String> list;
    private javax.swing.JButton reschedule;
    private javax.swing.JButton viewPastBooking;
}