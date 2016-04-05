package lt.employees.rest.app.response;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Address response object.
 */
@XmlRootElement
@XmlType(propOrder={"id", "country", "city", "address"})
public class AddressResponse {

	private Long id;

	private String country;

	private String city;

	private String address;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(final String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}
}
