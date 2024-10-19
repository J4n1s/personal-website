package janis.website.backend.unit.service;

import janis.website.backend.entity.EducationItem;
import janis.website.backend.repository.EducationItemRepository;
import janis.website.backend.service.EducationItemService;
import janis.website.backend.service.impl.EducationItemServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DataJpaTest
public class EducationItemServiceImplTest {

    private final EducationItemRepository educationItemRepository = Mockito.mock(EducationItemRepository.class);

    private final EducationItemService educationItemService = new EducationItemServiceImpl(educationItemRepository);

    @Test
    void testGetAllByLanguage() {
        List<EducationItem> educationItems = new ArrayList<>();
        educationItems.add(new EducationItem(2021, 2023, "url"));
        educationItems.add(new EducationItem(2024, null, "url"));

        when(educationItemRepository.findAllByLanguageOrderByStartingYear("en")).thenReturn(educationItems);
        List<EducationItem> result = educationItemService.getAllByLanguage("en");

        verify(educationItemRepository, times(1)).findAllByLanguageOrderByStartingYear("en");
        assertEquals(educationItems, result);
    }

    @Test
    void testGetAllByLanguage_withReturnEmptyList_shouldQueryAgain() {
        List<EducationItem> educationItemsEn = new ArrayList<>();
        List<EducationItem> educationItemsDe = new ArrayList<>();
        educationItemsDe.add(new EducationItem(2021, 2023, "url"));
        educationItemsDe.add(new EducationItem(2024, null, "url"));

        when(educationItemRepository.findAllByLanguageOrderByStartingYear("en")).thenReturn(educationItemsEn);
        when(educationItemRepository.findAllByLanguageOrderByStartingYear("de")).thenReturn(educationItemsDe);
        List<EducationItem> result = educationItemService.getAllByLanguage("en");

        verify(educationItemRepository, times(1)).findAllByLanguageOrderByStartingYear("en");
        verify(educationItemRepository, times(1)).findAllByLanguageOrderByStartingYear("de");
        assertEquals(educationItemsDe, result);
    }

    @Test
    void testGetAllByLanguage_withReturnNull_shouldQueryAgain() {
        List<EducationItem> educationItemsDe = new ArrayList<>();
        educationItemsDe.add(new EducationItem(2021, 2023, "url"));
        educationItemsDe.add(new EducationItem(2024, null, "url"));

        when(educationItemRepository.findAllByLanguageOrderByStartingYear("en")).thenReturn(null);
        when(educationItemRepository.findAllByLanguageOrderByStartingYear("de")).thenReturn(educationItemsDe);
        List<EducationItem> result = educationItemService.getAllByLanguage("en");

        verify(educationItemRepository, times(1)).findAllByLanguageOrderByStartingYear("en");
        verify(educationItemRepository, times(1)).findAllByLanguageOrderByStartingYear("de");
        assertEquals(educationItemsDe, result);
    }
}
