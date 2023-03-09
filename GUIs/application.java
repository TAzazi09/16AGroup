package GUIs;
import Functionality.LoginCheck;
/**
 * @author nik
 */

public class application extends javax.swing.JFrame {
    private javax.swing.JPanel loginPanel;
    private javax.swing.JLabel usernameLabel, passwordLabel;
    private javax.swing.JTextField usernameText;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton backButton;

    public application() {
        initComponents();
    }

    private void initComponents() {
        loginPanel = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel("Username: ");
        usernameText = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel("Password: ");
        passwordText = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        loginPanel.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setBackground(new java.awt.Color(255, 255, 255));

        usernameLabel.setFont(new java.awt.Font("Monospaced", 0, 18));
        passwordLabel.setFont(new java.awt.Font("Monospaced", 0, 18));

        usernameText.setFont(new java.awt.Font("Monospaced", 0, 18));
        usernameText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        passwordText.setFont(new java.awt.Font("Monospaced", 0, 18));
        passwordText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        // Log-in button functionality
        loginButton.setFont(new java.awt.Font("Monospaced", 0, 12));
        loginButton.setBackground(new java.awt.Color(65, 175, 255, 1));
        // couldn't make the button look exactly like I wanted
        // loginButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        loginButton.setText("Log-in");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        //Back button 
        backButton.setFont(new java.awt.Font("Monospaced", 0, 12));
        backButton.setBackground(new java.awt.Color(65, 175, 255, 1));
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        // NetBeans' panel layout code section (below)
        // -----------------------------------------------------------------------------------------------------------------------------------
        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGroup(loginPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(loginPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(loginPanelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(usernameLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(passwordLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(loginPanelLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(passwordText)
                                                        .addComponent(usernameText,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 176,
                                                                Short.MAX_VALUE)))
                                        .addGroup(loginPanelLayout.createSequentialGroup()
                                                .addGap(67, 67, 67)
                                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                               // .addGap(67, 67, 67)
                                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(11, Short.MAX_VALUE)));
        loginPanelLayout.setVerticalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(
                                        loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(usernameLabel)
                                                .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(
                                        loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(passwordLabel)
                                                .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                            //    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                               // .addComponent(loginButton)
                                //.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(backButton)
                                .addComponent(loginButton))));
                               // .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(120, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(110, Short.MAX_VALUE)));

        pack();
    }
    // -----------------------------------------------------------------------------------------------------------------------------------

    // Button functionality
    // When clicked, the username and password are extracted and sent for verification
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String username = usernameText.getText();
       String password = passwordText.getText();

        LoginCheck.testFunction(username, password);
    }

    private void backButtonActionPerformed (java.awt.event.ActionEvent evt) 
    {
        new GeneralPage().setVisible(true);
        dispose();
    }



//     public JPanel close() {
//         return loginPanel;
//     }
    public static void main(String args[]) {
        // NetBeans' Nimbus feel exception checks
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(application.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(application.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(application.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(application.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
        new application().setVisible(true);
            }
        });
        
    
    }
}