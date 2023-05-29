import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public void createUser(User user) throws SQLException {
        String query = "INSERT INTO users (name, surname, phone_number, username, password, mail, balance) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = MyConnection.connection.prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getPhoneNumber());
            statement.setString(4, user.getUsername());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getMail());
            statement.setBigDecimal(7, user.getBalance());
            statement.executeUpdate();
        }
    }

    public void updateBalanceByUsername(String username, BigDecimal balance) throws SQLException {
        String query = "CALL update_user_balance(?, ?)";
        try (PreparedStatement statement = MyConnection.connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setBigDecimal(2, balance);
            statement.executeUpdate();
        }
    }

        public void divideAndSubtractBalance(BigDecimal input) throws SQLException {
            String query = "CALL divide_and_subtract_balance(?)";
            try (PreparedStatement statement = MyConnection.connection.prepareStatement(query)) {
                statement.setBigDecimal(1, input);
                statement.executeUpdate();
            }
        }


        public List<User> getUsers() throws SQLException {
            List<User> users = new ArrayList<>();
            String query = "SELECT username, name, surname, mail, phone_number, balance FROM users";
            try (PreparedStatement statement = MyConnection.connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String name = resultSet.getString("name");
                    String surname = resultSet.getString("surname");
                    String mail = resultSet.getString("mail");
                    BigDecimal balance = resultSet.getBigDecimal("balance");
                    String phone_number = resultSet.getString("phone_number");
                    User user = new User(username, name, phone_number, surname, mail, balance.doubleValue());
                    users.add(user);
                }
            }
            return users;
        }

    }

