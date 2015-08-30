package nyc.c4q;

/**
 * Created by Hoshiko on 8/30/15.
 */
public class Member {

    int id;
    String name;
    String city;
    String state;
    int dob_month;
    int dob_date;
    int dob_year;

    public Member(int id, String name, String city, String state, int dob_month, int dob_date, int dob_year) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.state = state;
        this.dob_month = dob_month;
        this.dob_date = dob_date;
        this.dob_year = dob_year;
    }

    public Member() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getDob_month() {
        return dob_month;
    }

    public void setDob_month(int dob_month) {
        this.dob_month = dob_month;
    }

    public int getDob_date() {
        return dob_date;
    }

    public void setDob_date(int dob_date) {
        this.dob_date = dob_date;
    }

    public int getDob_year() {
        return dob_year;
    }

    public void setDob_year(int dob_year) {
        this.dob_year = dob_year;
    }


}
