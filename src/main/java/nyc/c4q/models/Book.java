package nyc.c4q.models;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hoshiko on 8/30/15.
 */
public class Book {
    private Integer id;
    private String title;
    private String author;
    private String isbn;
    private String isbn13;
    private String publisher;
    private Integer publishyear;
    private Boolean checkedout;
    private Integer checkedoutby;
    private Integer checkoutdateyear;
    private Integer checkoutdatemonth;
    private Integer checkoutdateday;
    private Integer duedateyear;
    private Integer duedatemonth;
    private Integer duedateday;
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
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     *     The author
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     *     The author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @return
     *     The isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     *
     * @param isbn
     *     The isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     *
     * @return
     *     The isbn13
     */
    public String getIsbn13() {
        return isbn13;
    }

    /**
     *
     * @param isbn13
     *     The isbn13
     */
    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    /**
     *
     * @return
     *     The publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     *
     * @param publisher
     *     The publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     *
     * @return
     *     The publishyear
     */
    public Integer getPublishyear() {
        return publishyear;
    }

    /**
     *
     * @param publishyear
     *     The publishyear
     */
    public void setPublishyear(Integer publishyear) {
        this.publishyear = publishyear;
    }

    /**
     *
     * @return
     *     The checkedout
     */
    public Boolean getCheckedout() {
        return checkedout;
    }

    /**
     *
     * @param checkedout
     *     The checkedout
     */
    public void setCheckedout(Boolean checkedout) {
        this.checkedout = checkedout;
    }

    /**
     *
     * @return
     *     The checkedoutby
     */
    public Integer getCheckedoutby() {
        return checkedoutby;
    }

    /**
     *
     * @param checkedoutby
     *     The checkedoutby
     */
    public void setCheckedoutby(Integer checkedoutby) {
        this.checkedoutby = checkedoutby;
    }

    /**
     *
     * @return
     *     The checkoutdateyear
     */
    public Integer getCheckoutdateyear() {
        return checkoutdateyear;
    }

    /**
     *
     * @param checkoutdateyear
     *     The checkoutdateyear
     */
    public void setCheckoutdateyear(Integer checkoutdateyear) {
        this.checkoutdateyear = checkoutdateyear;
    }

    /**
     *
     * @return
     *     The checkoutdatemonth
     */
    public Integer getCheckoutdatemonth() {
        return checkoutdatemonth;
    }

    /**
     *
     * @param checkoutdatemonth
     *     The checkoutdatemonth
     */
    public void setCheckoutdatemonth(Integer checkoutdatemonth) {
        this.checkoutdatemonth = checkoutdatemonth;
    }

    /**
     *
     * @return
     *     The checkoutdateday
     */
    public Integer getCheckoutdateday() {
        return checkoutdateday;
    }

    /**
     *
     * @param checkoutdateday
     *     The checkoutdateday
     */
    public void setCheckoutdateday(Integer checkoutdateday) {
        this.checkoutdateday = checkoutdateday;
    }

    /**
     *
     * @return
     *     The duedateyear
     */
    public Integer getDuedateyear() {
        return duedateyear;
    }

    /**
     *
     * @param duedateyear
     *     The duedateyear
     */
    public void setDuedateyear(Integer duedateyear) {
        this.duedateyear = duedateyear;
    }

    /**
     *
     * @return
     *     The duedatemonth
     */
    public Integer getDuedatemonth() {
        return duedatemonth;
    }

    /**
     *
     * @param duedatemonth
     *     The duedatemonth
     */
    public void setDuedatemonth(Integer duedatemonth) {
        this.duedatemonth = duedatemonth;
    }

    /**
     *
     * @return
     *     The duedateday
     */
    public Integer getDuedateday() {
        return duedateday;
    }

    /**
     *
     * @param duedateday
     *     The duedateday
     */
    public void setDuedateday(Integer duedateday) {
        this.duedateday = duedateday;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
