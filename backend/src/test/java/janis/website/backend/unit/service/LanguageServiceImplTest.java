package janis.website.backend.unit.service;

import janis.website.backend.service.LanguageService;
import janis.website.backend.service.impl.LanguageServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class LanguageServiceImplTest {

    private final LanguageService languageService = new LanguageServiceImpl();

    @Test
    void testGetLanguage() {
        LocaleContextHolder.setLocale(Locale.GERMANY);
        assertEquals("de", languageService.getLanguage());

        LocaleContextHolder.setLocale(Locale.ENGLISH);
        assertEquals("en", languageService.getLanguage());
    }

    @Test
    void testGetLanguage_withUnsupportedLanguage_shouldReturnDefault() {
        LocaleContextHolder.setLocale(Locale.FRANCE);
        assertEquals("de", languageService.getLanguage());
    }
}
