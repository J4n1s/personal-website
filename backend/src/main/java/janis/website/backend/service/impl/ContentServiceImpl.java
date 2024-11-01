package janis.website.backend.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import janis.website.backend.controller.dto.SkillDto;
import janis.website.backend.exception.NotFoundException;
import janis.website.backend.service.ContentService;
import janis.website.backend.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * ContentServiceImpl is a service implementation for retrieving various types
 * of content localized to a specific language.
 */
@Service
public class ContentServiceImpl implements ContentService {

  private static final String DATA_PATH = "src/main/resources/static/";
  private final ObjectMapper objectMapper;
  private final ResourceLoader resourceLoader;

  /**
   * Constructs a new ContentServiceImpl with the specified ObjectMapper.
   *
   * @param objectMapper an ObjectMapper instance used for parsing JSON content
   */
  @Autowired
  public ContentServiceImpl(ObjectMapper objectMapper, ResourceLoader resourceLoader) {
    this.objectMapper = objectMapper;
    this.resourceLoader = resourceLoader;
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
  public JsonNode getFooterContent(String language) {
    String fileBasename = "footer_content";
    return getJsonContent(fileBasename, language);
  }

  @Override
  public JsonNode getHeaderContent(String language) {
    String fileBasename = "header_content";
    return getJsonContent(fileBasename, language);
  }

  @Override
  public JsonNode get404Content(String language) {
    String fileBasename = "error_404";
    return getJsonContent(fileBasename, language);
  }

  @Override
  public JsonNode getHomeContent(String language) {
    String fileBasename = "home_content";
    return getJsonContent(fileBasename, language);
  }

  @Override
  public List<SkillDto> getSkills(String language) {
    String filename = "skills_" + language + ".json";
    Resource resource = resourceLoader.getResource("classpath:static/" + filename);
    try {
      List<SkillDto> skills = objectMapper.readValue(
          Files.readString(Paths.get(resource.getURI())),
          objectMapper.getTypeFactory().constructCollectionType(List.class, SkillDto.class)
      );

      skills = skills.stream().sorted(
          (skill1, skill2) -> skill1.getName().compareToIgnoreCase(skill2.getName())
      ).toList();
      return skills;
    } catch (IOException e) {
      throw new NotFoundException(e);
    }
  }

  private JsonNode getJsonContent(String fileBasename, String language) {
    String filename =  fileBasename + "_" + language + ".json";
    Resource resource = resourceLoader.getResource("classpath:static/" + filename);
    try {
      String jsonContent = Files.readString(Paths.get(resource.getURI()));
      return objectMapper.readTree(jsonContent);
    } catch (IOException e) {
      return getJsonContentOfDefaultLanguage(fileBasename, e);
    }
  }

  private JsonNode getJsonContentOfDefaultLanguage(String fileBasename, IOException e) {
    String filename =  fileBasename + "_" + LanguageService.DEFAULT_LANGUAGE + ".json";
    Resource resource = resourceLoader.getResource("classpath:static/" + filename);
    try {
      String jsonContent = Files.readString(Paths.get(resource.getURI()));
      return objectMapper.readTree(jsonContent);
    } catch (IOException eNew) {
      throw new NotFoundException(e);
    }
  }
}
