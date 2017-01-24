package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Access users in the user table.
 *
 * @author pwaite
 */
public class UserData {

    private final Logger logger = Logger.getLogger(UserData.class);

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;
        String sql = "SELECT * FROM users";

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            logger.info("SearchUser.getAllUsers()...SQL Exception: " + e);
            logger.error("SearchUser.getAllUsers()...SQL Exception: " + e);
        } catch (Exception e) {
            logger.info("SearchUser.getAllUsers()...Exception: " + e);
            logger.error("SearchUser.getAllUsers()...Exception: " + e);
        }
        return users;
    }

    //TODO add a method or methods to return a single user based on search criteria --> complete
    public List<User> getUserById(int userId) {
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;
        String sql = "SELECT * FROM users u WHERE u.id = ?";

        try {
            database.connect();
            connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            logger.info("SearchUser.getUserById()...SQL Exception: " + e);
            logger.error("SearchUser.getUserById()...SQL Exception: " + e);
        } catch (Exception e) {
            logger.info("SearchUser.getUserById()...Exception: " + e);
            logger.error("SearchUser.getUserById()...Exception: " + e);
        }
        return users;
    }

    public List<User> getUserByLastName(String lastName) {
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;
        String sql = "SELECT * FROM users u WHERE u.last_name LIKE ?";

        try {
            database.connect();
            connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + lastName + "%");
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            logger.info("SearchUser.getUserByLastName()...SQL Exception: " + e);
            logger.error("SearchUser.getUserByLastName()...SQL Exception: " + e);
        } catch (Exception e) {
            logger.info("SearchUser.getUserByLastName()...Exception: " + e);
            logger.error("SearchUser.getUserByLastName()...Exception: " + e);
        }
        return users;
    }

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setLastName(results.getString("last_name"));
        // TODO map the remaining fields --> completed
        user.setUserid(results.getString("id"));
        user.setFirstName(results.getString("first_name"));
        user.setDateOfBirth(results.getDate("date_of_birth"));
        logger.info(user.toString());
        return user;
    }

}