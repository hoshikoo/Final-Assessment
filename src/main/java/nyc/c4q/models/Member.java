package nyc.c4q.models;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hoshiko on 8/30/15.
 */
public class Member {

    private Integer id;
    private String name;
    private Integer dobMonth;
    private Integer dobDay;
    private Integer dobYear;
    private String city;
    private String state;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     *     The dobMonth
     */
    public Integer getDobMonth() {
        return dobMonth;
    }

    /**
     *
     * @param dobMonth
     *     The dob_month
     */
    public void setDobMonth(Integer dobMonth) {
        this.dobMonth = dobMonth;
    }

    /**
     *
     * @return
     *     The dobDay
     */
    public Integer getDobDay() {
        return dobDay;
    }

    /**
     *
     * @param dobDay
     *     The dob_day
     */
    public void setDobDay(Integer dobDay) {
        this.dobDay = dobDay;
    }

    /**
     *
     * @return
     *     The dobYear
     */
    public Integer getDobYear() {
        return dobYear;
    }

    /**
     *
     * @param dobYear
     *     The dob_year
     */
    public void setDobYear(Integer dobYear) {
        this.dobYear = dobYear;
    }

    /**
     *
     * @return
     *     The city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     *     The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     *     The state
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     *     The state
     */
    public void setState(String state) {
        this.state = state;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
