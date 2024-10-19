package janis.website.backend.service.impl;

import janis.website.backend.service.LanguageService;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

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
