package lt.employees.rest.app.response;

/**
 * Contact Info response.
 */
public class ContactInfoResponse {

	private Long id;

	private AddressResponse address;

	public AddressResponse getAddress() {
		return address;
	}

	public void setAddress(final AddressResponse address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}
}
