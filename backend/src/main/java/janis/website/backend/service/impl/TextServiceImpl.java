package janis.website.backend.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import janis.website.backend.exception.NotFoundException;
import janis.website.backend.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class TextServiceImpl implements TextService {

    private static final String DATA_PATH = "src/main/resources/static/";
    private final ObjectMapper objectMapper;

    @Autowired
    public TextServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public JsonNode getContactFormText(String language) {
        String filename = DATA_PATH + "contact_form_text_" + language + ".json";
        try {
            String jsonContent = Files.readString(Paths.get(filename));
            return objectMapper.readTree(jsonContent);
        } catch (IOException e) {
            throw new NotFoundException(e);
        }

    }

    @Override
    public JsonNode getResumeText(String language) {
        String filename = DATA_PATH + "resume_text_" + language + ".json";
        try {
            String jsonContent = Files.readString(Paths.get(filename));
            return objectMapper.readTree(jsonContent);
        } catch (IOException e) {
            throw new NotFoundException(e);
        }
    }
}
