package lt.employees.rest.app.response;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Response object with name info.
 */
@XmlRootElement
@XmlType(propOrder={"id", "firstName", "lastName"})
public class NameInfoResponse {

	private Long id;

	private String firstName;

	private String lastName;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}
}
