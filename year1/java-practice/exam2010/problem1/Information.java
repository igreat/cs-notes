package exam2010.problem1;

public class Information {
    private String address;
    private String phone;
    private String email;

    public Information(String address, String phone, String email) {
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}