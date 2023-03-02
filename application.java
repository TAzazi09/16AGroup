import javax.swing.*;

public class application {
    static JLabel l;
    static JTextField username;
    static JTextField password;
    static JButton submit;
    public static void main(String[] args) {
        JFrame f = new JFrame("login");
        username = new JTextField(5);
        password = new JTextField(5);
        submit = new JButton("submit");
        submit.addActionListener(e -> setLabel());
        JPanel p = new JPanel();
        l = new JLabel("Basic");
        p.add(username);
        p.add(password);
        p.add(submit);
        p.add(l);
        f.add(p);
        f.setSize(100,100);
        f.setVisible(true);

    }
    public static void setLabel() {
            l.setText(username.getText() + " " + password.getText());
            code.main(username.getText(), password.getText());
    }
}
