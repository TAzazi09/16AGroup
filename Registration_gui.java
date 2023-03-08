import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import java.util.Enumeration;
import javax.swing.AbstractButton;
// import javax.swing.ButtonGroup;


/**
 *
 * @author krist
 */
public class Registration_gui extends javax.swing.JFrame {
    private javax.swing.JButton Back_button;
    private javax.swing.JLabel DOB_label;
    private javax.swing.JLabel Details_Label;
    private javax.swing.JLabel Doctor_label;
    private javax.swing.JComboBox<String> Doctor_list;
    private javax.swing.JTextField Firstname_input;
    private javax.swing.JTextField Firstname_input1;
    private javax.swing.JLabel Gender_label;
    private javax.swing.JTextField Phone_input;
    private javax.swing.JLabel Phone_label;
    private javax.swing.JButton Register_button;
    private javax.swing.JLabel Register_title;
    public javax.swing.JTextArea detail_input;
    private javax.swing.JFormattedTextField dob_field;
    private javax.swing.JLabel firstname_label;
    private javax.swing.JRadioButton gender_female_check;
    private javax.swing.JRadioButton gender_male_check;
    private javax.swing.JRadioButton gender_other_check;
    private javax.swing.JRadioButton gender_pnts_check;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel surname_label;
    private javax.swing.JLabel age_label;
    private javax.swing.JTextField age_input;
    public static ButtonGroup totalGroup;

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Registration_gui().setVisible(true);
        });
    }

    public Registration_gui() {
        initComponents();
    }

    public void initComponents() {

        Register_title = new javax.swing.JLabel();
        Firstname_input = new javax.swing.JTextField();
        firstname_label = new javax.swing.JLabel();
        surname_label = new javax.swing.JLabel();
        Firstname_input1 = new javax.swing.JTextField();
        age_label = new javax.swing.JLabel("Age");
        age_input = new javax.swing.JTextField();
        gender_male_check = new javax.swing.JRadioButton();
        Gender_label = new javax.swing.JLabel();
        gender_female_check = new javax.swing.JRadioButton();
        gender_other_check = new javax.swing.JRadioButton();
        gender_pnts_check = new javax.swing.JRadioButton();
        DOB_label = new javax.swing.JLabel();
        Phone_label = new javax.swing.JLabel();
        Phone_input = new javax.swing.JTextField();
        Doctor_label = new javax.swing.JLabel();
        Doctor_list = new javax.swing.JComboBox<>();
        Details_Label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detail_input = new javax.swing.JTextArea();
        Back_button = new javax.swing.JButton();
        Register_button = new javax.swing.JButton();
        dob_field = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 800));
        setPreferredSize(new java.awt.Dimension(900, 800));
        setSize(new java.awt.Dimension(900, 800));

        Register_title.setFont(new java.awt.Font("Monospaced", 0, 48)); // NOI18N
        Register_title.setText("   Register");
        Register_title.setToolTipText("");
        Register_title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Firstname_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Firstname_inputActionPerformed(evt);
            }
        });

        firstname_label.setText("First Name");
        firstname_label.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N

        surname_label.setText("Surname");
        surname_label.setToolTipText("");
        surname_label.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N

        Firstname_input1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Firstname_input1ActionPerformed(evt);
            }
        });

        age_label.setText("Age");
        age_label.setToolTipText("");
        age_label.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N

        age_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Firstname_input1ActionPerformed(evt);
            }
        });

        gender_male_check.setText("Male");
        gender_male_check.setFont(new java.awt.Font("Monospaced", 0, 18));
        gender_male_check.setActionCommand("male");
        gender_male_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gender_male_checkActionPerformed(evt);
            }
        });

        Gender_label.setText("Gender");
        Gender_label.setFont(new java.awt.Font("Monospaced", 0, 18));

        gender_female_check.setText("Female");
        gender_female_check.setFont(new java.awt.Font("Monospaced", 0, 18));
        gender_female_check.setActionCommand("female");
        gender_female_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gender_female_checkActionPerformed(evt);
            }
        });

        gender_other_check.setText("Other");
        gender_other_check.setFont(new java.awt.Font("Monospaced", 0, 18));
        gender_other_check.setActionCommand("other");
        gender_other_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gender_other_checkActionPerformed(evt);
            }
        });

        gender_pnts_check.setText("Prefer not to say");
        gender_pnts_check.setFont(new java.awt.Font("Monospaced", 0, 18));
        gender_pnts_check.setActionCommand("pnts");
        gender_pnts_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gender_pnts_checkActionPerformed(evt);
            }
        });

        ButtonGroup group = new ButtonGroup();
        group.add(gender_female_check);
        group.add(gender_male_check);
        group.add(gender_other_check);
        group.add(gender_pnts_check);
        Registration_gui.totalGroup = group;

        DOB_label.setText("Date of Birth");
        DOB_label.setFont(new java.awt.Font("Monospaced", 0, 18));

        Phone_label.setText("Phone Number");
        Phone_label.setFont(new java.awt.Font("Monospaced", 0, 18));

        Phone_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Phone_inputActionPerformed(evt);
            }
        });

        Doctor_label.setText("Doctor Choosen");
        Doctor_label.setFont(new java.awt.Font("Monospaced", 0, 18));

        Doctor_list.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dr Smith", "Dr Jason", "Dr Andrew" }));
        Doctor_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Doctor_listActionPerformed(evt);
            }
        });

        Details_Label.setText("Details");
        Details_Label.setFont(new java.awt.Font("Monospaced", 0, 18));

        detail_input.setColumns(1);
        detail_input.setLineWrap(true);
        detail_input.setRows(5);
        detail_input.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        detail_input.setDragEnabled(true);
        detail_input.setName(""); // NOI18N
        jScrollPane1.setViewportView(detail_input);

        Back_button.setText("Back");
        Back_button.setFont(new java.awt.Font("Monospaced", 0, 18));
        Back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Back_buttonActionPerformed(evt);
            }
        });

        Register_button.setText("Register");
        Register_button.setFont(new java.awt.Font("Monospaced", 0, 18));
        Register_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Register_buttonActionPerformed(evt);
            }
        });

        dob_field.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/MM/YYYY"))));
        dob_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dob_fieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Register_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Doctor_label)
                    .addComponent(Phone_label)
                    .addComponent(DOB_label)
                    .addComponent(Gender_label)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gender_male_check)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gender_female_check)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gender_other_check)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gender_pnts_check))
                    .addComponent(surname_label)
                    .addComponent(Firstname_input1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstname_label)
                    .addComponent(Firstname_input, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Details_Label)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(dob_field, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(Register_button, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Doctor_list, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Phone_input, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)))))
                .addGap(328, 328, 328))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(Register_title)
                .addGap(18, 18, 18)
                .addComponent(firstname_label)
                .addGap(1, 1, 1)
                .addComponent(Firstname_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(surname_label)
                .addGap(1, 1, 1)
                .addComponent(age_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(age_label)
                .addGap(1, 1, 1)
                .addComponent(Firstname_input1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(Gender_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gender_male_check)
                    .addComponent(gender_female_check)
                    .addComponent(gender_other_check)
                    .addComponent(gender_pnts_check))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DOB_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dob_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Phone_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Phone_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Doctor_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Doctor_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Details_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Register_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(191, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }

    private void Firstname_inputActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void Firstname_input1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void gender_male_checkActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void gender_female_checkActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void gender_other_checkActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void gender_pnts_checkActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void Phone_inputActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void Doctor_listActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void Back_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void Register_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        // String selection = Registration_gui.totalGroup.getSelection().getActionCommand();
        // // System.out.println(selection);
        //     Registration.test(Firstname_input.getText(), Firstname_input1.getText(), selection, age)
        //     String t = Firstname_input.getText();
        //     System.out.println(t);

    }

    private void dob_fieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
}
