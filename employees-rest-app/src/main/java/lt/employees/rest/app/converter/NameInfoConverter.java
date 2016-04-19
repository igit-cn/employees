package lt.employees.rest.app.converter;

import java.util.ArrayList;
import java.util.List;

import lt.employees.rest.app.response.NameInfoResponse;
import lt.employees.service.dto.NameInfoDTO;

/**
 * Converter for name info.
 */
public class NameInfoConverter {

	public static NameInfoResponse convert(NameInfoDTO nameInfo) {
		NameInfoResponse result = new NameInfoResponse();
		result.setId(nameInfo.getId());
		result.setFirstName(nameInfo.getFirstName());
		result.setLastName(nameInfo.getLastName());

		return result;
	}

	public static List<NameInfoResponse> convertToResponse(List<NameInfoDTO> nameInfoLst) {
		List<NameInfoResponse> result = new ArrayList<NameInfoResponse>();
		for (NameInfoDTO nameInfo : nameInfoLst) {
			result.add(convert(nameInfo));
		}

		return result;
	}

	public static NameInfoDTO convert(NameInfoResponse nameInfo) {
		NameInfoDTO result = new NameInfoDTO();
		result.setId(nameInfo.getId());
		result.setFirstName(nameInfo.getFirstName());
		result.setLastName(nameInfo.getLastName());

		return result;
	}

	public static List<NameInfoDTO> convertToDTO(List<NameInfoResponse> nameInfoLst) {
		List<NameInfoDTO> result = new ArrayList<NameInfoDTO>();
		for (NameInfoResponse nameInfo : nameInfoLst) {
			result.add(convert(nameInfo));
		}

		return result;
	}

}
