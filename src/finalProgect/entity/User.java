package finalProgect.entity;

import finalProgect.exceptions.FormatDataInDatabaseException;

import java.util.Date;
import java.util.Random;

public class User {
    private long id;
    private String userName;
    private String password;
    private String country;
    private UserType userType;

    public User(String userName, String password, String country) {
        long random = new Random().nextInt(1000) + 100;
        this.id = random;
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.userType = UserType.USER;
    }

    private User(long id, String userName, String password, String country, UserType userType) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.userType = userType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }



    @Override
    public String toString() {
        return id + "," + userName + "," + password + "," + country + "," + userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return userName != null ? userName.equals(user.userName) : user.userName == null;
    }

    @Override
    public int hashCode() {
        return userName != null ? userName.hashCode() : 0;
    }

    public static User createObjectFromString(String stringUser) throws FormatDataInDatabaseException {
        String[] userFields = stringUser.split(",");
        if (userFields.length != 5) throw new FormatDataInDatabaseException("Please check data in DB");

            long id = Long.parseLong(userFields[0]);
            String name = userFields[1];
            String password =  userFields[2];
            String country = userFields[3];
            UserType type =  UserType.valueOf(userFields[4]);


            User resultUser = new User(id, name, password, country, type);
            return resultUser;

    }
}
