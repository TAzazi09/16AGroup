package GUIs;

// imports from the java library
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.time.LocalDate;
import javax.swing.JOptionPane;

// imports from the project
import Session.*;
import Databases.DoctorsDB;

/**
 * @author ks818
 * @functionality and GUI improvement by Ethan
 */
public class ViewBookingPage extends javax.swing.JFrame {
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
    public static Connection connection;
    public String userId = Info.firstname;

    public ViewBookingPage() {
        super("View Bookings");
        initComponents();
        logged_user_text.setText("User: " + userId);
    }

    public static void loadPage() {
        if (Info.userID != -1) {
            General.setNimbusLookAndFeel(ViewBookingPage.class);

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ViewBookingPage().setVisible(true);
                }
            });
        } else {
            General.closeAllWindows();
            LoginPage.loadPage();
        }
    }

    private void initComponents() {
        getContentPane().setBackground(General.WHITE);

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
        viewPastBooking.addActionListener(evt -> {
            String[] split = resultBookings.getSelectedItem().toString().split("~");
            String doctorName = split[0].trim();
            String date = split[1];
            String time = split[2];
            GUIs.PastBookingsPage.loadPage(doctorName, date, time);
        });

        resultBookings.addActionListener(evt -> {
            reschedule.setVisible(true);
            if (resultBookings.getSelectedItem() != null) {
                String[] split = resultBookings.getSelectedItem().toString().split("~");
                String date = split[1].split(" ")[1];
                LocalDate inputDate = LocalDate.parse(date);
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
            GUIs.ReschedulePage.loadPage(dateInput, timeInput);

        });

        Confirm_button.setText("Confirm");
        Confirm_button.setFont(General.font(12));
        Confirm_button.setBackground(General.BUTTON_BLUE);
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
                        // Gets the required information about the booking where the date contains the
                        // year and month
                        ResultSet results = Info.statement.executeQuery(
                                "SELECT DoctorID, Date, Time FROM Bookings WHERE Date LIKE '%" + combination + "%';");

                        // Clears the dropdown and the array of bookings.
                        // Also sets all tempory objects as invisible.
                        list.clear();
                        resultBookings.removeAllItems();
                        resultBookings.setVisible(false);
                        viewPastBooking.setVisible(false);
                        reschedule.setVisible(false);

                        while (results.next()) {
                            // Sets tempory objects as true
                            resultBookings.setVisible(true);
                            reschedule.setVisible(true);

                            list.add(DoctorsDB.getDoctorName(results.getInt("DoctorID")) + " ~ "
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
        back.setFont(General.font(12));
        back.setBackground(General.BUTTON_BLUE);
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                General.closeAllWindows();

                MenuPage.loadPage();
                ;
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
                                .addGap(175, 175, 175)
                                .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                .addGap(20, 20, 20)
                                .addComponent(logged_user_text, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(220, 220, 220)
                                                .addComponent(Confirm_button)
                                                .addComponent(back))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(210, 210, 210)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(Month_Selector,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(50, 50, 50)
                                                                .addComponent(yearInput,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(date_selected_text)))
                                        .addGap(50, 50, 50)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(150, 150, 150)
                                                .addComponent(resultBookings, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10))
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
                                .addGap(20, 20, 20)
                                .addComponent(date_selected_text)
                                .addGap(20, 20, 20)
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
}