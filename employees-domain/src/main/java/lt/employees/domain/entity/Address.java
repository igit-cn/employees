package lt.employees.domain.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity holds employee address info
 */
@Entity
@Table(name = "Address")
public class Address extends AbstractEntity {

    private String country;

    private String city;

    private String address;

    @OneToOne
    private Employee employee;

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return country + ", " + city + ", " + address;
    }

}
