package janis.website.backend.controller;

import janis.website.backend.controller.dto.ContactInformationDto;
import janis.website.backend.controller.mapper.ContactInformationMapper;
import janis.website.backend.entity.ContactInformation;
import janis.website.backend.service.ContactInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;

/**
 * REST controller for managing contact information.
 * Provides an endpoint for creating contact details.
 */
@RestController
@RequestMapping(value = "/api/v1/contact")
public class ContactInformationController {

  private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
  private final ContactInformationService contactInformationService;
  private final ContactInformationMapper contactInformationMapper;

  @Autowired
  ContactInformationController(ContactInformationService contactInformationService,
                               ContactInformationMapper contactInformationMapper) {
    this.contactInformationService = contactInformationService;
    this.contactInformationMapper = contactInformationMapper;
  }

  @CrossOrigin
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  ContactInformationDto create(@RequestBody ContactInformationDto contactInformationDto) {
    LOGGER.info("POST api/v1/contact");
    ContactInformation contactInformation = contactInformationMapper.dtoToEntity(contactInformationDto);
    return contactInformationMapper.entityToDto(contactInformationService.create(contactInformation));
  }
}
