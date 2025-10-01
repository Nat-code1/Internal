package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

public class Login extends JWindow{


    private JPanel mainpanel;
    private JLabel LLogin;
    private JLabel LPassword;
    private JTextField tfLogin;
    private JPasswordField tfPassword;
    private JButton btnRegister;
    private JButton btnClose;
    private JButton btnLogIn;

    public Login (){
        super();
        setContentPane();
        setVisible();

        btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = tfLogin.getText();
                String password=String.valueOf(tfPassword.getText());
                user=getUser(login, password);
            }



            User user;
            private User getUser(String login, String password){
                User user = null;
                ConnectionSettings settings= new ConnectionSettings();
                try {
                    Connection connection = DriverManager.getConnection(settings.url,settings.user, settings.pwd);

                    PreparedStatement statement = connection.prepareStatement("SELECT L_login, L_password FROM nat_test WHERE u_login=? AND u_password=?");
                    statement.setString(1, login);
                    statement.setString(2, password);
                    ResultSet resultSet= statement.executeQuery();

                    if(resultSet.next()){
                        user= new User();
                        user.login=resultSet.getString("u_login");
                        user.password=resultSet.getString("u_password");
                        JOptionPane.showMessageDialog(btnLogin,"You have successfully logged in");

                    }
                    else {
                        JOptionPane.showMessageDialog(btnLogin,"Wrong Username & Password");
                    }
                    statement.close();
                    connection.close();
                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


                return user;
            }
        });
    }
}
