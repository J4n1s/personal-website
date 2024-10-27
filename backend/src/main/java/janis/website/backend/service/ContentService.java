package janis.website.backend.service;

import com.fasterxml.jackson.databind.JsonNode;
import janis.website.backend.controller.dto.SkillDto;

import java.util.List;

/**
 * Interface representing a service for retrieving various types of content
 * localized to a specific language.
 */
public interface ContentService {

  /**
   * Retrieves the contact form content in the specified language.
   *
   * @param language the language in which the contact form content should be retrieved
   * @return a JsonNode representing the contact form content
   */
  JsonNode getContactFormContent(String language);

  /**
   * Retrieves the resume content in the specified language.
   *
   * @param language the language in which the resume content should be retrieved
   * @return a JsonNode representing the resume content
   */
  JsonNode getResumeContent(String language);

  /**
   * Retrieves the interests content in the specified language.
   *
   * @param language the language in which the interests content should be retrieved
   * @return a JsonNode representing the interests content
   */
  JsonNode getInterestsContent(String language);

  /**
   * Retrieves the footer content in the specified language.
   *
   * @param language the language in which the footer content should be retrieved
   * @return a JsonNode representing the footer content
   */
  JsonNode getFooterContent(String language);

  /**
   * Retrieves the header content in the specified language.
   *
   * @param language the language in which the header content should be retrieved
   * @return a JsonNode representing the header content
   */
  JsonNode getHeaderContent(String language);

  /**
   * Retrieves the not-found content in the specified language.
   *
   * @param language the language in which the not-found content should be retrieved
   * @return a JsonNode representing the not-found content
   */
  JsonNode get404Content(String language);

  /**
   * Retrieves the home-page content in the specified language.
   *
   * @param language the language in which the home-page content should be retrieved
   * @return a JsonNode representing the home-page content
   */
  JsonNode getHomeContent(String language);

  /**
   * Retrieves a list of skills in the specified language.
   *
   * @param language the language in which the skills should be retrieved
   * @return a list of SkillDto representing the skills in the specified language
   */
  List<SkillDto> getSkills(String language);
}
