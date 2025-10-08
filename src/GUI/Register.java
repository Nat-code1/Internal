package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Register extends Window{
    private JPanel mainPanel;
    private JPanel pName;
    private JPanel pUsername;
    private JPanel pPassword;
    private JTextField tfPassword;
    private JTextField tfLogin;
    private JTextField tfName;
    private JLabel lName;
    private JLabel lLogin;
    private JLabel lPassword;
    private JTextField tfSurname;
    private JLabel lSurname;
    private JButton loginButton;
    private JButton registerButton;

    Window window;
    ConnectonSettings connectionSettings=null;

    public Register() {

        super();
        setContentPane(mainPanel);
        setVisible(true);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String Name = tfName.getText();
                String Surname = tfSurname.getText();
                String Login = tfLogin.getText();
                String Password = tfPassword.getText();
                user=addUsertoDatabase(Name,Surname,Login,Password);
                }
                User user;
            private User addUsertoDatabase(String name, String surname, String login, String password) {
                User user = null;
                ConnectonSettings settings = new ConnectonSettings();
                try {
                    Connection connection = DriverManager.getConnection(settings.url, settings.user, settings.pwd);

                    PreparedStatement statement = connection.prepareStatement("INSERT INTO register (r_name, r_surname,r_login, r_password)"+"VALUES(?,?,?,?)");
                    statement.setString(1, name);
                    statement.setString(2, surname);
                    statement.setString(3, login);
                    statement.setString(4, password);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        user = new User();
                        user.name = resultSet.getString("r_name");
                        user.surname = resultSet.getString("r_surname");
                        user.login = resultSet.getString("r_login");
                        user.password = resultSet.getString("r_password");
                        JOptionPane.showMessageDialog(loginButton, "You have successfully logged in");

                    } else {
                        JOptionPane.showMessageDialog(loginButton, "You have successfully logged in");
                    }
                    statement.close();
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                return user;
            }
            });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }

        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }



}





