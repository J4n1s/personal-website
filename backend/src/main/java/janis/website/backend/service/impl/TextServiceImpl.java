package janis.website.backend.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import janis.website.backend.exception.NotFoundException;
import janis.website.backend.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
        String fileBasename = "contact_form_text";
        return getJsonContent(fileBasename, language);
    }

    @Override
    public JsonNode getResumeText(String language) {
        String fileBasename = "resume_text";
        return getJsonContent(fileBasename, language);
    }

    @Override
    public JsonNode getInterestsText(String language) {
        String fileBasename = "interests_text";
        return getJsonContent(fileBasename, language);
    }

    private JsonNode getJsonContent(String fileBasename, String language) {
        String filename = DATA_PATH + fileBasename + "_" + language + ".json";
        try {
            String jsonContent = Files.readString(Paths.get(filename));
            return objectMapper.readTree(jsonContent);
        } catch (IOException e) {
            return getJsonContentOfAnyLanguage(fileBasename, e);
        }
    }

    private JsonNode getJsonContentOfAnyLanguage(String fileBasename, Exception e) {
        Path dataDir = Paths.get(DATA_PATH);
        File[] jsonFiles = dataDir.toFile().listFiles((dir, name) -> name.startsWith(fileBasename) && name.endsWith(".json"));

        if (jsonFiles != null && jsonFiles.length > 0) {
            File jsonFile = jsonFiles[0];
            try {
                String content = Files.readString(jsonFile.toPath());
                return objectMapper.readTree(content);
            } catch (IOException exception) {
                throw new NotFoundException(exception);
            }
        }
        throw new NotFoundException(e);
    }
}
