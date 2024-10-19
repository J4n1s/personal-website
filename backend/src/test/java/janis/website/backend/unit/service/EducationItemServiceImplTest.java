package janis.website.backend.unit.service;

import janis.website.backend.entity.EducationItem;
import janis.website.backend.repository.EducationItemRepository;
import janis.website.backend.service.EducationItemService;
import janis.website.backend.service.LanguageService;
import janis.website.backend.service.impl.EducationItemServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DataJpaTest
public class EducationItemServiceImplTest {

    private final String english = Locale.ENGLISH.getLanguage();

    private final EducationItemRepository educationItemRepository = Mockito.mock(EducationItemRepository.class);

    private final EducationItemService educationItemService = new EducationItemServiceImpl(educationItemRepository);

    @Test
    void testGetAllByLanguage() {
        List<EducationItem> educationItems = new ArrayList<>();
        educationItems.add(new EducationItem(2021, 2023, "url"));
        educationItems.add(new EducationItem(2024, null, "url"));

        when(educationItemRepository.findAllByLanguageOrderByStartingYear(english)).thenReturn(educationItems);
        List<EducationItem> result = educationItemService.getAllByLanguage(english);

        verify(educationItemRepository, times(1)).findAllByLanguageOrderByStartingYear(english);
        assertEquals(educationItems, result);
    }

    @Test
    void testGetAllByLanguage_withReturnEmptyList_shouldQueryAgain() {
        List<EducationItem> educationItemsEn = new ArrayList<>();
        List<EducationItem> educationItemsDe = new ArrayList<>();
        educationItemsDe.add(new EducationItem(2021, 2023, "url"));
        educationItemsDe.add(new EducationItem(2024, null, "url"));

        when(educationItemRepository.findAllByLanguageOrderByStartingYear(english)).thenReturn(educationItemsEn);
        when(educationItemRepository.findAllByLanguageOrderByStartingYear(LanguageService.DEFAULT_LANGUAGE)).thenReturn(educationItemsDe);
        List<EducationItem> result = educationItemService.getAllByLanguage(english);

        verify(educationItemRepository, times(1)).findAllByLanguageOrderByStartingYear(english);
        verify(educationItemRepository, times(1)).findAllByLanguageOrderByStartingYear(LanguageService.DEFAULT_LANGUAGE);
        assertEquals(educationItemsDe, result);
    }

    @Test
    void testGetAllByLanguage_withReturnNull_shouldQueryAgain() {
        List<EducationItem> educationItemsDe = new ArrayList<>();
        educationItemsDe.add(new EducationItem(2021, 2023, "url"));
        educationItemsDe.add(new EducationItem(2024, null, "url"));

        when(educationItemRepository.findAllByLanguageOrderByStartingYear(english)).thenReturn(null);
        when(educationItemRepository.findAllByLanguageOrderByStartingYear(LanguageService.DEFAULT_LANGUAGE)).thenReturn(educationItemsDe);
        List<EducationItem> result = educationItemService.getAllByLanguage(english);

        verify(educationItemRepository, times(1)).findAllByLanguageOrderByStartingYear(english);
        verify(educationItemRepository, times(1)).findAllByLanguageOrderByStartingYear(LanguageService.DEFAULT_LANGUAGE);
        assertEquals(educationItemsDe, result);
    }
}
