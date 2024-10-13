package janis.website.backend.controller.mapper;

import jakarta.transaction.Transactional;
import janis.website.backend.controller.dto.ContactInformationDto;
import janis.website.backend.entity.ContactInformation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class ContactInformationMapperImpl implements ContactInformationMapper {

    @Override
    public ContactInformation dtoToEntity(ContactInformationDto contactInformationDto) {
        ContactInformation contactInformation = new ContactInformation();
        contactInformation.setName(contactInformationDto.getName());
        contactInformation.setMail(contactInformationDto.getMail());
        contactInformation.setPhone(contactInformationDto.getPhone());
        contactInformation.setMessage(contactInformationDto.getMessage());
        return contactInformation;
    }

    @Override
    public ContactInformationDto entityToDto(ContactInformation contactInformation) {
        ContactInformationDto contactInformationDto = new ContactInformationDto();
        contactInformationDto.setName(contactInformation.getName());
        contactInformationDto.setMail(contactInformation.getMail());
        contactInformationDto.setPhone(contactInformation.getPhone());
        contactInformationDto.setMessage(contactInformation.getMessage());
        return contactInformationDto;
    }

    @Override
    public List<ContactInformationDto> entityToDto(List<ContactInformation> contactInformationList) {
        if (contactInformationList == null) {
            return List.of();
        }

        List<ContactInformationDto> contactInformationDtos = new ArrayList<>(contactInformationList.size());
        for (ContactInformation contactInformation : contactInformationList) {
            contactInformationDtos.add(entityToDto(contactInformation));
        }
        return contactInformationDtos;
    }
}
