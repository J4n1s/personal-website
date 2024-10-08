package janis.website.backend.service.impl;

import janis.website.backend.service.LanguageService;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {

    private static final List<String> SUPPORTED_LANGUAGES = List.of("de", "en");
    private static final String DEFAULT_LANGUAGE = "de";

    @Override
    public String getLanguage() {
        String requestedLanguage = LocaleContextHolder.getLocale().getLanguage();
        if (SUPPORTED_LANGUAGES.contains(requestedLanguage.toLowerCase())) {
            return requestedLanguage;
        }
        return DEFAULT_LANGUAGE;
    }
}
