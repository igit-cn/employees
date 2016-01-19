package lt.employees.domain.entity;

import javax.persistence.*;

/**
 * Entity holds employee address info
 */
@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue
    private Integer id;

    private String country;

    private String city;

    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return country + ", " + city + ", " + address;
    }

}
