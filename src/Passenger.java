public class Passenger {
    private String name;
    private String email;
    private String phoneNumber;
    private String gender;
    private int age;

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return this.gender;
    }

    public Passenger (String Name, String Email, String PhoneNumber, String Gender, int Age) {
        name = Name;
        email = Email;
        phoneNumber = PhoneNumber;
        gender = Gender;
        age = Age;
    }
}
