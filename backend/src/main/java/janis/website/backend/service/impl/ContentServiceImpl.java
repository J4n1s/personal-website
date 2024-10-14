package janis.website.backend.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import janis.website.backend.controller.dto.SkillDto;
import janis.website.backend.exception.NotFoundException;
import janis.website.backend.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    private static final String DATA_PATH = "src/main/resources/static/";
    private final ObjectMapper objectMapper;

    @Autowired
    public ContentServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public JsonNode getContactFormContent(String language) {
        String fileBasename = "contact_form_content";
        return getJsonContent(fileBasename, language);
    }

    @Override
    public JsonNode getResumeContent(String language) {
        String fileBasename = "resume_content";
        return getJsonContent(fileBasename, language);
    }

    @Override
    public JsonNode getInterestsContent(String language) {
        String fileBasename = "interests_content";
        return getJsonContent(fileBasename, language);
    }

    @Override
    public List<SkillDto> getSkills(String language) {
        String filename = DATA_PATH + "skills_" + language + ".json";
        try {
            List<SkillDto> skills = objectMapper.readValue(
                    Paths.get(filename).toFile(),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, SkillDto.class)
            );

            skills = skills.stream().sorted((skill1, skill2) -> skill1.getName().compareToIgnoreCase(skill2.getName())).toList();
            return skills;
        } catch (IOException e) {
            throw new NotFoundException(e);
        }
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
