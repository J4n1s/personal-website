package janis.website.backend.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface TextService {

    JsonNode getContactFormText(String language);

    JsonNode getResumeText(String language);

    JsonNode getInterestsText(String language);
}
