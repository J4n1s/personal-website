package janis.website.backend.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface ContentService {

    JsonNode getContactFormContent(String language);

    JsonNode getResumeContent(String language);

    JsonNode getInterestsContent(String language);
}
