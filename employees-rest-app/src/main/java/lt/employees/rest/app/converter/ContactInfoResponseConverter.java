package lt.employees.rest.app.converter;

import lt.employees.rest.app.response.ContactInfoResponse;
import lt.employees.service.dto.ContactInfoDTO;

/**
 * Converter for Contact Info.
 */
public class ContactInfoResponseConverter {

	public static ContactInfoResponse convert(ContactInfoDTO contactInfo) {
		ContactInfoResponse result = new ContactInfoResponse();
		result.setId(contactInfo.getId());
		if (contactInfo.getAddress() != null) {
			result.setAddress(AddressResponseConverter.convert(contactInfo.getAddress()));
		}

		return result;
	}

	public static ContactInfoDTO convert(ContactInfoResponse contactInfo) {
		ContactInfoDTO result = new ContactInfoDTO();
		result.setId(contactInfo.getId());
		if (contactInfo.getAddress() != null) {
			result.setAddress(AddressResponseConverter.convert(contactInfo.getAddress()));
		}

		return result;
	}

}
