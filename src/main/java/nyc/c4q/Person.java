package nyc.c4q;

public class Person {
    public static String firstName;
    public static String lastName;
    public House house;

    public Person(String firstName, String lastName, House house) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.house     = house;
    }



    public static String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
