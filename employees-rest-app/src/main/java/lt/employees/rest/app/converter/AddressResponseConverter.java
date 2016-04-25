package lt.employees.rest.app.converter;

import lt.employees.domain.entity.Address;
import lt.employees.rest.app.response.AddressResponse;

/**
 * Address Response converter class.
 */
public class AddressResponseConverter {

	public static AddressResponse convert (Address address) {
		AddressResponse result = new AddressResponse();
		result.setId(address.getId());
		result.setCountry(address.getCountry());
		result.setCity(address.getCity());
		result.setAddress(address.getAddress());

		return result;
	}

	public static Address convert(AddressResponse addressResponse) {
		Address result = new Address();
		result.setId(addressResponse.getId());
		result.setCountry(addressResponse.getCountry());
		result.setCity(addressResponse.getCity());
		result.setAddress(addressResponse.getAddress());

		return result;
	}

}
