package GUIs;

// imports from the project
import Functionality.LoginFunc;
import Functionality.DatabaseConnectionFunc;
import Session.General;

/**
 * @author Nikola
 */
public class LoginPage extends javax.swing.JFrame {
    // Variables declaration
    private javax.swing.JTextField usernameText;
    private javax.swing.JPasswordField passwordText;

    public LoginPage() {
        initComponents();
    }

    public static void loadPage() {
        if (DatabaseConnectionFunc.connected) {
            General.setNimbusLookAndFeel(LoginPage.class);

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(() -> new LoginPage().setVisible(true));
        } else {
            GeneralPage.main(null);
        }
    }

    private void initComponents() {
        // Initialise the components
        javax.swing.JPanel loginPanel = new javax.swing.JPanel();
        javax.swing.JLabel usernameLabel = new javax.swing.JLabel("Username: ");
        usernameText = new javax.swing.JTextField();
        javax.swing.JLabel passwordLabel = new javax.swing.JLabel("Password: ");
        passwordText = new javax.swing.JPasswordField();
        javax.swing.JButton loginButton = new javax.swing.JButton("Log-in");
        javax.swing.JButton backButton = new javax.swing.JButton("Back");

        // Set the layout of the components
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        loginPanel.setBackground(General.WHITE);
        getContentPane().setBackground(General.WHITE);

        // Set the font and size of the components
        usernameLabel.setFont(General.font(18));
        passwordLabel.setFont(General.font(18));

        usernameText.setFont(General.font(18));
        usernameText.setBorder(javax.swing.BorderFactory.createLineBorder(General.BLACK));

        passwordText.setFont(General.font(18));
        passwordText.setBorder(javax.swing.BorderFactory.createLineBorder(General.BLACK));

        loginButton.setFont(General.font(12));
        loginButton.setBackground(General.BUTTON_BLUE);
        loginButton.addActionListener(this::loginButtonActionPerformed);

        backButton.setFont(General.font(12));
        backButton.setBackground(General.BUTTON_BLUE);
        backButton.addActionListener(this::backButtonActionPerformed);

        // Panel layout code section below
        // -----------------------------------------------------------------------------------------------------------------------------------
        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGroup(loginPanelLayout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(loginPanelLayout
                                                .createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(loginPanelLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(usernameLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                        .addComponent(passwordLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE))
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(loginPanelLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(passwordText)
                                                        .addComponent(usernameText,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                175,
                                                                Short.MAX_VALUE)))
                                        .addGroup(loginPanelLayout
                                                .createSequentialGroup()
                                                .addGap(0, 0, 0)
                                                .addComponent(backButton,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        150,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(loginButton,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        150,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(200, Short.MAX_VALUE)));
        loginPanelLayout.setVerticalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(
                                        loginPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(usernameLabel)
                                                .addComponent(usernameText,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10) // gap between username and password
                                .addGroup(
                                        loginPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(passwordLabel)
                                                .addComponent(passwordText,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10) // gap between password and buttons
                                .addGroup(loginPanelLayout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(backButton)
                                        .addComponent(loginButton))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(260, 260, 260) // gap between left side of the screen and the panel
                                .addComponent(loginPanel,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(120, Short.MAX_VALUE))); // gap between right side of the screen and the panel
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(350, 350, 350) // Vertical position of the panel
                                .addComponent(loginPanel,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(400, Short.MAX_VALUE)));

        pack();
    }
    // -----------------------------------------------------------------------------------------------------------------------------------

    // Button actions
    // Login button - the username and password are extracted and sent for verification
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String username = usernameText.getText();
        String password = new String(passwordText.getPassword());

        LoginFunc.sendData(username, password);
    }

    // Back button - returns to the general page
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new GeneralPage().setVisible(true);
        dispose();
    }
}