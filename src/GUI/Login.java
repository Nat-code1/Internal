package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends Window {

    private JPanel panel1;
    private JLabel lPassword;
    private JLabel lLogin;
    private JButton btnLogin;
    private JButton PASSWORDButton;
    private JButton CLEARButton;
    private JTextField tfLogin;
    private JTextField tfPassword;
    private JPanel mainPanel;
    private JButton btnLogIn;
    private JButton closeButton;

    public Login() {
        super();
        setContentPane(mainPanel);
        setVisible(true);



        btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = tfLogin.getText();
                String password = tfPassword.getText();
                user = getUser(login, password);
            }

            User user;

            private User getUser(String login, String password) {
                User user = null;
                ConnectonSettings settings = new ConnectonSettings();
                try {
                    Connection connection = DriverManager.getConnection(settings.url, settings.user, settings.pwd);

                    PreparedStatement statement = connection.prepareStatement("SELECT L_login, L_password FROM Login WHERE L_login=? AND L_password=?");
                    statement.setString(1, login);
                    statement.setString(2, password);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        user = new User();
                        user.login = resultSet.getString("L_login");
                        user.password = resultSet.getString("L_password");
                        JOptionPane.showMessageDialog(btnLogin, "You have successfully logged in");


                    } else {
                        JOptionPane.showMessageDialog(btnLogin, "Wrong Username & Password");
                    }
                    statement.close();
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                return user;
            }
        });


    }
}



