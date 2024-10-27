package janis.website.backend.service.impl;

import janis.website.backend.service.LanguageService;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

/**
 * Implementation of the LanguageService interface for managing and retrieving language settings.
 * This service retrieves the current language from LocaleContextHolder and checks
 * if it's supported. If not, the default language is returned.
 */
@Service
public class LanguageServiceImpl implements LanguageService {

  @Override
  public String getLanguage() {
    String requestedLanguage = LocaleContextHolder.getLocale().getLanguage();
    if (SUPPORTED_LANGUAGES.contains(requestedLanguage.toLowerCase())) {
      return requestedLanguage;
    }
    return DEFAULT_LANGUAGE;
  }
}
