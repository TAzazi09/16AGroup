import javax.swing.*;

public class application {
    private static JLabel l;
    private static JTextField username;
    private static JTextField password;
    private static JButton submit;

    public static void main(String[] args) {
        // Ethan's code:
        // JFrame f = new JFrame("login");
        // username = new JTextField(5);
        // password = new JTextField(5);
        // submit = new JButton("submit");
        // submit.addActionListener(e -> setLabel());
        // JPanel p = new JPanel();
        // l = new JLabel("Basic");
        // p.add(username);
        // p.add(password);
        // p.add(submit);
        // p.add(l);
        // f.add(p);
        // f.setSize(100,100);
        // f.setVisible(true);

        login();
    }

    public static void setLabel() {
            l.setText(username.getText() + " " + password.getText());
            code.main(username.getText(), password.getText());
    }

    public static void login() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        JLabel labelUsername = new JLabel("Username: ");
        labelUsername.setBounds(10, 20, 80, 25);
        panel.add(labelUsername);

        JTextField textUsername = new JTextField();
        textUsername.setBounds(100, 20, 165, 25);
        panel.add(textUsername);

        JLabel labelPassword = new JLabel("Password: ");
        labelPassword.setBounds(10, 50, 80, 25);
        panel.add(labelPassword);

        JPasswordField textPassword = new JPasswordField();
        textPassword.setBounds(100, 50, 165, 25);
        panel.add(textPassword);

        frame.setVisible(true);
    }
}
