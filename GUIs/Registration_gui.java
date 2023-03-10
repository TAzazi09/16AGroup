package GUIs;

/**
 * @author krist
 * @cosmetic changes by nik
 * @functional changes by ethan
 */

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import Functionality.Registration;

public class Registration_gui extends javax.swing.JFrame {
    // Variables declaration
    private javax.swing.JButton backButton;
    private javax.swing.JLabel detailsLabel;
    private javax.swing.JLabel doctorLabel;
    private javax.swing.JComboBox<String> doctorList;
    private javax.swing.JTextField firstnameInput;
    private javax.swing.JTextField surnameInput;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JTextField phoneInput;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JButton regButton;
    private javax.swing.JLabel regLabel;
    private javax.swing.JTextArea detailsInput;
    private javax.swing.JLabel firstnameLabel;
    private javax.swing.JRadioButton femaleCheck;
    private javax.swing.JRadioButton maleCheck;
    private javax.swing.JRadioButton otherCheck;
    private javax.swing.JRadioButton pntsCheck;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JTextField ageInput;
    public static ButtonGroup totalGroup;

    public Registration_gui() {
        initComponents();
    }

    public static void main(String args[]) {
        // NetBeans' exception checks
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
                new Registration_gui().setVisible(true);
            }
        });
    }

    private void initComponents() {
        // Initialise components
        regLabel = new javax.swing.JLabel("Register");

        firstnameLabel = new javax.swing.JLabel("First Name");
        firstnameInput = new javax.swing.JTextField();

        surnameLabel = new javax.swing.JLabel("Surname");
        surnameInput = new javax.swing.JTextField();

        ageLabel = new javax.swing.JLabel("Age");
        ageInput = new javax.swing.JTextField();

        genderLabel = new javax.swing.JLabel("Gender");
        maleCheck = new javax.swing.JRadioButton("Male");
        femaleCheck = new javax.swing.JRadioButton("Female");
        otherCheck = new javax.swing.JRadioButton("Other");
        pntsCheck = new javax.swing.JRadioButton("Prefer not to say");

        phoneLabel = new javax.swing.JLabel("Phone Number");
        phoneInput = new javax.swing.JTextField();

        doctorLabel = new javax.swing.JLabel("Doctor Choosen");
        doctorList = new javax.swing.JComboBox<>();

        detailsLabel = new javax.swing.JLabel("Details");
        detailsInput = new javax.swing.JTextArea();

        jScrollPane1 = new javax.swing.JScrollPane();
        backButton = new javax.swing.JButton("Back");
        regButton = new javax.swing.JButton("Register");

        // Set up the form
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 900));
        setPreferredSize(new java.awt.Dimension(900, 900));
        setSize(new java.awt.Dimension(900, 900));

        // Set up the components
        regLabel.setFont(new java.awt.Font("Monospaced", 0, 48));
        regLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        firstnameLabel.setFont(new java.awt.Font("Monospaced", 0, 18));

        surnameLabel.setToolTipText("");
        surnameLabel.setFont(new java.awt.Font("Monospaced", 0, 18));

        ageLabel.setToolTipText("");
        ageLabel.setFont(new java.awt.Font("Monospaced", 0, 18));

        genderLabel.setFont(new java.awt.Font("Monospaced", 0, 18));
        maleCheck.setFont(new java.awt.Font("Monospaced", 0, 18));
        maleCheck.setActionCommand("male");
        femaleCheck.setFont(new java.awt.Font("Monospaced", 0, 18));
        femaleCheck.setActionCommand("female");
        otherCheck.setFont(new java.awt.Font("Monospaced", 0, 18));
        otherCheck.setActionCommand("other");
        pntsCheck.setFont(new java.awt.Font("Monospaced", 0, 18));
        pntsCheck.setActionCommand("pnts");

        ButtonGroup group = new ButtonGroup();
        group.add(femaleCheck);
        group.add(maleCheck);
        group.add(otherCheck);
        group.add(pntsCheck);
        Registration_gui.totalGroup = group;

        phoneLabel.setFont(new java.awt.Font("Monospaced", 0, 18));

        doctorLabel.setFont(new java.awt.Font("Monospaced", 0, 18));
        doctorList
                .setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dr Smith", "Dr Jason", "Dr Andrew" }));
        doctorList.setFont(new java.awt.Font("Monospaced", 0, 18));

        detailsLabel.setFont(new java.awt.Font("Monospaced", 0, 18));
        detailsInput.setColumns(1);
        detailsInput.setLineWrap(true);
        detailsInput.setRows(5);
        detailsInput.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        detailsInput.setDragEnabled(true);
        detailsInput.setName("");
        jScrollPane1.setViewportView(detailsInput);

        // Set up the buttons
        backButton.setFont(new java.awt.Font("Monospaced", 0, 18));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Back_buttonActionPerformed(evt);
            }
        });

        regButton.setFont(new java.awt.Font("Monospaced", 0, 18));
        regButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Register_buttonActionPerformed(evt);
            }
        });

        // Panel layout code section below
        // -----------------------------------------------------------------------------------------------------------------------------------
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(300, 300, 300)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(regLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(doctorLabel)
                                        .addComponent(phoneLabel)
                                        .addComponent(genderLabel)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(maleCheck)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(femaleCheck)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(otherCheck)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pntsCheck))
                                        .addComponent(surnameLabel)
                                        .addComponent(surnameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 254,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(firstnameLabel)
                                        .addComponent(firstnameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 254,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ageLabel)
                                        .addComponent(ageInput, javax.swing.GroupLayout.PREFERRED_SIZE, 254,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(detailsLabel)
                                        .addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(backButton,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 125,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(4, 4, 4)
                                                                .addComponent(regButton,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 125,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        false)
                                                                .addComponent(jScrollPane1,
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(doctorList,
                                                                        javax.swing.GroupLayout.Alignment.LEADING, 0,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(phoneInput,
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE, 254,
                                                                        Short.MAX_VALUE)))))
                                .addGap(328, 328, 328)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)

                                .addComponent(regLabel)
                                .addGap(30, 30, 30)

                                .addComponent(firstnameLabel)
                                .addGap(1, 1, 1)
                                .addComponent(firstnameInput, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)

                                .addComponent(surnameLabel)
                                .addGap(1, 1, 1)
                                .addComponent(surnameInput, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

                                .addComponent(ageLabel)
                                .addGap(1, 1, 1)
                                .addComponent(ageInput, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)

                                .addComponent(genderLabel)
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(maleCheck)
                                        .addComponent(femaleCheck)
                                        .addComponent(otherCheck)
                                        .addComponent(pntsCheck))
                                .addGap(20, 20, 20)

                                .addComponent(phoneLabel)
                                .addGap(1, 1, 1)
                                .addComponent(phoneInput, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)

                                .addComponent(doctorLabel)
                                .addGap(1, 1, 1)
                                .addComponent(doctorList, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)

                                .addComponent(detailsLabel)
                                .addGap(1, 1, 1)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)

                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(regButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(191, Short.MAX_VALUE)));

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }
    // -----------------------------------------------------------------------------------------------------------------------------------

    // Button actions
    // Back button - returns to the general page
    private void Back_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        new GeneralPage().setVisible(true);
        dispose();
    }

    // Register button - checks if all fields are filled in and sends the data to Registration class for further processing
    private void Register_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if ((firstnameInput == null) || (surnameInput == null) || (Registration_gui.totalGroup.getSelection() == null)
                ||
                (ageInput.getText() == null) || (doctorList.getSelectedItem() == null)) {
            JOptionPane.showMessageDialog(null, "Some fields are missing data!");

        } else {
            String selection = Registration_gui.totalGroup.getSelection().getActionCommand();
            boolean outcome = Registration.test(firstnameInput.getText(), surnameInput.getText(), selection,
                    Integer.parseInt(ageInput.getText()), phoneInput.getText(),
                    String.valueOf(doctorList.getSelectedItem()), detailsInput.getText());
            if (outcome == true) {
                Registration.sendData(firstnameInput.getText(), surnameInput.getText(), selection,
                        Integer.parseInt(ageInput.getText()), phoneInput.getText(),
                        String.valueOf(doctorList.getSelectedItem()), detailsInput.getText());
                dispose();
            } else {

            }
        }
    }
}