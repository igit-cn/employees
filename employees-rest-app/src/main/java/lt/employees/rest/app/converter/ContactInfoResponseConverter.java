package lt.employees.rest.app.converter;

import lt.employees.domain.entity.ContactInfo;
import lt.employees.rest.app.response.ContactInfoResponse;

/**
 * Converter for Contact Info.
 */
public class ContactInfoResponseConverter {

	public static ContactInfoResponse convert(ContactInfo contactInfo) {
		ContactInfoResponse result = new ContactInfoResponse();
		result.setId(contactInfo.getId());
		if (contactInfo.getAddress() != null) {
			result.setAddress(AddressResponseConverter.convert(contactInfo.getAddress()));
		}

		return result;
	}

	public static ContactInfo convert(ContactInfoResponse contactInfo) {
		ContactInfo result = new ContactInfo();
		result.setId(contactInfo.getId());
		if (contactInfo.getAddress() != null) {
			result.setAddress(AddressResponseConverter.convert(contactInfo.getAddress()));
		}

		return result;
	}

}
