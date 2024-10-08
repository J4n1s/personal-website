package janis.website.backend.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import janis.website.backend.controller.dto.SkillDto;
import janis.website.backend.exception.NotFoundException;
import janis.website.backend.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    private static final String DATA_PATH = "src/main/resources/static/";

    private final ObjectMapper objectMapper;

    @Autowired
    public ResumeServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
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
}
