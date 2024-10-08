package janis.website.backend.controller;

import janis.website.backend.controller.dto.ContactInformationDto;
import janis.website.backend.controller.mapper.ContactInformationMapper;
import janis.website.backend.entity.ContactInformation;
import janis.website.backend.service.ContactInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/contact")
public class ContactInformationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final ContactInformationService contactInformationService;
    private final ContactInformationMapper contactInformationMapper;

    @Autowired
    ContactInformationController(ContactInformationService contactInformationService, ContactInformationMapper contactInformationMapper) {
        this.contactInformationService = contactInformationService;
        this.contactInformationMapper = contactInformationMapper;
    }

    @CrossOrigin
    @GetMapping
    ResponseEntity<List<ContactInformationDto>> all() {
        LOGGER.info("GET api/v1/contact");
        return ResponseEntity.ok(
                contactInformationMapper.contactInformationToContactInformationDto(contactInformationService.getAll())
        );
    }

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ContactInformationDto create(@RequestBody ContactInformationDto contactInformationDto) {
        LOGGER.info("POST api/v1/contact");
        ContactInformation contactInformation = contactInformationMapper.contactInformationDtoToContactInformation(contactInformationDto);
        return contactInformationMapper.contactInformationToContactInformationDto(contactInformationService.create(contactInformation));
    }
}
