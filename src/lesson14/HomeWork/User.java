package lesson14.HomeWork;

public class User {
    private long id;
    private String name;
    private String password;
    private String email;
    private String address;
    private String city;
    private int phoneNumber;
    private UserType userType;
    private boolean login;

    public User(long id, String name, String password, String email, String address, String city, int phoneNumber, UserType userType, boolean login) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.login = login;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public UserType getUserType() {
        return userType;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", userType=" + userType +
                ", login=" + login +
                '}';
    }
}
