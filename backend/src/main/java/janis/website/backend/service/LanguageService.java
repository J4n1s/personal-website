package janis.website.backend.service;

import java.util.List;
import java.util.Locale;

/**
 * Service interface for managing language settings and configuring supported languages.
 */
public interface LanguageService {
  String DEFAULT_LANGUAGE = Locale.GERMAN.getLanguage();
  List<String> SUPPORTED_LANGUAGES = List.of(DEFAULT_LANGUAGE, Locale.ENGLISH.getLanguage());

  /**
   * Retrieves the current language setting.
   *
   * @return the currently set language as a String
   */
  String getLanguage();
}
