package dao;

class Customer implements java.io.Serializable {
    int CustomerNumber;
    String name;
    String email;
    String address;
    String city;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCustomerNumber() {
        return CustomerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        CustomerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}