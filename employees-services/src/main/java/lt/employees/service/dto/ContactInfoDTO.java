package lt.employees.service.dto;

/**
 * Data transfer object for contact info.
 */
public class ContactInfoDTO {

	private Long id;

	private AddressDTO address;

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(final AddressDTO address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}
}
