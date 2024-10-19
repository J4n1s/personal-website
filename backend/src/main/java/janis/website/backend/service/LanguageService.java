package janis.website.backend.service;

import java.util.List;
import java.util.Locale;

public interface LanguageService {
    String DEFAULT_LANGUAGE = Locale.GERMAN.getLanguage();
    List<String> SUPPORTED_LANGUAGES = List.of(DEFAULT_LANGUAGE, Locale.ENGLISH.getLanguage());

    String getLanguage();
}
