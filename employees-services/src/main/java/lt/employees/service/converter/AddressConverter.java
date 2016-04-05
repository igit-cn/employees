package lt.employees.service.converter;

import lt.employees.domain.entity.Address;
import lt.employees.service.dto.AddressDTO;

/**
 * Converter class for Address.
 */
public class AddressConverter {

	public static AddressDTO convert(Address address) {
		AddressDTO result = new AddressDTO();
		result.setId(address.getId());
		result.setCountry(address.getCountry());
		result.setCity(address.getCity());
		result.setAddress(address.getAddress());

		return result;
	}

	public static Address convert(AddressDTO address) {
		Address result = new Address();
		result.setId(address.getId());
		result.setCountry(address.getCountry());
		result.setCity(address.getCity());
		result.setAddress(address.getAddress());

		return result;
	}

}
