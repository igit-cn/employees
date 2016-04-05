package lt.employees.rest.app.converter;

import lt.employees.rest.app.response.AddressResponse;
import lt.employees.service.dto.AddressDTO;

/**
 * Address Response converter class.
 */
public class AddressResponseConverter {

	public static AddressResponse convert (AddressDTO address) {
		AddressResponse result = new AddressResponse();
		result.setId(address.getId());
		result.setCountry(address.getCountry());
		result.setCity(address.getCity());
		result.setAddress(address.getAddress());

		return result;
	}

	public static AddressDTO convert(AddressResponse addressResponse) {
		AddressDTO result = new AddressDTO();
		result.setId(addressResponse.getId());
		result.setCountry(addressResponse.getCountry());
		result.setCity(addressResponse.getCity());
		result.setAddress(addressResponse.getAddress());

		return result;
	}

}
