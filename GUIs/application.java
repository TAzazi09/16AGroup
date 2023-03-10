package GUIs;

/**
 * @author nik
 */

import Functionality.LoginCheck;

public class application extends javax.swing.JFrame {
    // Variables declaration
    private javax.swing.JPanel loginPanel;
    private javax.swing.JLabel usernameLabel, passwordLabel;
    private javax.swing.JTextField usernameText;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton backButton;

    public application() {
        initComponents();
    }

    public static void main(String args[]) {
        // NetBeans' Nimbus feel exception checks
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(application.class.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(application.class.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(application.class.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(application.class.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new application().setVisible(true);
            }
        });
    }

    private void initComponents() {
        // Initialise the components
        loginPanel = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel("Username: ");
        usernameText = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel("Password: ");
        passwordText = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton("Log-in");
        backButton = new javax.swing.JButton("Back");

        // Set the layout of the components
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        loginPanel.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setBackground(new java.awt.Color(255, 255, 255));

        // Set the font and size of the components
        usernameLabel.setFont(new java.awt.Font("Monospaced", 0, 18));
        passwordLabel.setFont(new java.awt.Font("Monospaced", 0, 18));

        usernameText.setFont(new java.awt.Font("Monospaced", 0, 18));
        usernameText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        passwordText.setFont(new java.awt.Font("Monospaced", 0, 18));
        passwordText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        loginButton.setFont(new java.awt.Font("Monospaced", 0, 12));
        loginButton.setBackground(new java.awt.Color(65, 175, 255, 1));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
 
        backButton.setFont(new java.awt.Font("Monospaced", 0, 12));
        backButton.setBackground(new java.awt.Color(65, 175, 255, 1));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

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
                                .addGap(10, 10, 10)
                                .addGroup(
                                        loginPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(passwordLabel)
                                                .addComponent(passwordText,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(loginPanelLayout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(backButton)
                                        .addComponent(loginButton))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(260, 260, 260)
                                .addComponent(loginPanel,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(120, Short.MAX_VALUE)));
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
        String password = passwordText.getText();

        LoginCheck.testFunction(username, password);
    }

    // Back button - returns to the general page
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new GeneralPage().setVisible(true);
        dispose();
    }
}