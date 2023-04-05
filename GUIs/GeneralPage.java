package GUIs;

// imports from the project
import Functionality.DBConnectionFunc;
import Info.General;
import Databases.DatabaseDB;

/**
 * @author Nikola
 * @functional changes by Ethan
 */
public class GeneralPage extends javax.swing.JFrame {
    public GeneralPage() {
        initComponents();
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            DBConnectionFunc.main(null);

            // Initialize the database
            if (DBConnectionFunc.connected) {
                DatabaseDB.initDB();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (DBConnectionFunc.connected) {
            General.setNimbusLookAndFeel(GeneralPage.class);

            //Create and display the form 
            java.awt.EventQueue.invokeLater(() -> new GeneralPage().setVisible(true));
        }
    }

    private void initComponents() {
        javax.swing.JPanel generalPanel = new javax.swing.JPanel();
        javax.swing.JLabel helloLabel = new javax.swing.JLabel("Hello!");
        javax.swing.JButton logButton = new javax.swing.JButton("Log-in");
        javax.swing.JButton regButton = new javax.swing.JButton("Register");

        // Login button - opens the login page
        logButton.addActionListener(evt -> {
            LoginPage.loadPage();
            dispose();
        });

        // Registration button - opens the registration page
        regButton.addActionListener(evt -> {
            RegistrationPage.loadPage();
            dispose(); // Close the current JFrame
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        generalPanel.setBackground(General.WHITE);

        helloLabel.setFont(General.font(36));

        logButton.setBackground(General.BUTTON_BLUE);
        logButton.setFont(General.font(18));

        regButton.setBackground(General.BUTTON_BLUE);
        regButton.setFont(General.font(18));

        // Panel layout code section (below)
        // -----------------------------------------------------------------------------------------------------------------------------------
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(generalPanel);
        generalPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout
                                                .createSequentialGroup()
                                                .addGap(270, 270, 270)
                                                .addComponent(logButton,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        135,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(regButton,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        135,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout
                                                .createSequentialGroup()
                                                .addGap(350, 350, 350)
                                                .addComponent(helloLabel)))
                                .addContainerGap(320, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(300, 300, 300)
                                .addComponent(helloLabel)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(logButton,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(regButton,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(445, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(generalPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(generalPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }
}