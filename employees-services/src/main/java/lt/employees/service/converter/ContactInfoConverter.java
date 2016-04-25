package lt.employees.service.converter;

import lt.employees.domain.entity.ContactInfo;
import lt.employees.service.dto.ContactInfoDTO;

/**
 * Converter for Contact Info.
 */
public class ContactInfoConverter {

	public static ContactInfoDTO convert(ContactInfo contactInfo) {
		ContactInfoDTO result = new ContactInfoDTO();
		result.setId(contactInfo.getId());
		if (contactInfo.getAddress() != null) {
			result.setAddress(AddressConverter.convert(contactInfo.getAddress()));
		}

		return result;
	}

	public static ContactInfo convert(ContactInfoDTO contactInfo) {
		ContactInfo result = new ContactInfo();
		result.setId(contactInfo.getId());
		if (contactInfo.getAddress() != null) {
			result.setAddress(AddressConverter.convert(contactInfo.getAddress()));
		}

		return result;
	}

}
