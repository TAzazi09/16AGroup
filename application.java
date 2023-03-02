import javax.swing.*;

public class Application {
    // Ethan's code:
 
    // private static JLabel l;
    // private static JTextField username;
    // private static JTextField password;
    // private static JButton submit;
    // public static void main(String[] args) {
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
    // }

    // public static void setLabel() {
    //     l.setText(username.getText() + " " + password.getText());
    //     LoginCheck.main(username.getText(), password.getText());
    // }

    public static void main(String[] args) {
        login();
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

        JButton button = new JButton("Log in");
        button.setBounds(10, 80, 80, 25);
        // button.addActionListener(new application());
        panel.add(button);

        JLabel success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);

        frame.setVisible(true);

        // success.setText("You logged in successfuly");
    }
}
