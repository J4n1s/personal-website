package janis.website.backend.controller.mapper;

import janis.website.backend.controller.dto.ContactInformationDto;
import janis.website.backend.entity.ContactInformation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ContactInformationMapper {

    /**
     * Maps ContactInformationDto to ContactInformation object
     *
     * @param contactInformationDto ContactInformationDto that will be mapped
     * @return Mapped ContactInformation object
     */
    ContactInformation dtoToEntity(ContactInformationDto contactInformationDto);

    /**
     * Maps ContactInformation object to ContactInformationDto
     * @param contactInformation ContactInformation object that will be mapped
     * @return Mapped ContactInformationDto
     */
    ContactInformationDto entityToDto(ContactInformation contactInformation);

    /**
     * Maps a list of ContactInformation objects to a list of ContactInformationDtos
     * @param contactInformation List of ContactInformation objects that will be mapped
     * @return Mapped list of ContactInformationDtos
     */
    List<ContactInformationDto> entityToDto(List<ContactInformation> contactInformation);
}
