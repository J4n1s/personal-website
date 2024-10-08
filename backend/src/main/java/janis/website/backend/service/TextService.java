package janis.website.backend.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface TextService {

    JsonNode getContactFormText(String language);
}
