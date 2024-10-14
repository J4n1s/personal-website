package janis.website.backend.service;

import com.fasterxml.jackson.databind.JsonNode;
import janis.website.backend.controller.dto.SkillDto;

import java.util.List;

public interface ContentService {

    JsonNode getContactFormContent(String language);

    JsonNode getResumeContent(String language);

    JsonNode getInterestsContent(String language);

    List<SkillDto> getSkills(String language);
}
