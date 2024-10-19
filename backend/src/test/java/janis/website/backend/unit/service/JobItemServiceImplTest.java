package janis.website.backend.unit.service;

import janis.website.backend.entity.JobItem;
import janis.website.backend.repository.JobItemRepository;
import janis.website.backend.service.JobItemService;
import janis.website.backend.service.LanguageService;
import janis.website.backend.service.impl.JobItemServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@DataJpaTest
public class JobItemServiceImplTest {

    private final String english = Locale.ENGLISH.getLanguage();
    private final String defaultLanguage = LanguageService.DEFAULT_LANGUAGE;

    private final JobItemRepository repository = Mockito.mock(JobItemRepository.class);

    private final JobItemService jobItemService = new JobItemServiceImpl(repository);

    @Test
    void testGetAllByLanguage() {
        List<JobItem> jobItems = new ArrayList<>();
        jobItems.add(new JobItem(2021, 2023, "url"));
        jobItems.add(new JobItem(2024, null, "url"));

        when(repository.findAllByLanguageOrderByStartingYear(english)).thenReturn(jobItems);
        List<JobItem> result = jobItemService.getAllByLanguage(english);

        verify(repository, times(1)).findAllByLanguageOrderByStartingYear(english);
        assertEquals(jobItems, result);
    }

    @Test
    void testGetAllByLanguage_withReturnEmptyList_shouldQueryAgain() {
        List<JobItem> jobItemsEn = new ArrayList<>();
        List<JobItem> jobItemsDe = new ArrayList<>();
        jobItemsDe.add(new JobItem(2021, 2023, "url"));
        jobItemsDe.add(new JobItem(2024, null, "url"));

        when(repository.findAllByLanguageOrderByStartingYear(english)).thenReturn(jobItemsEn);
        when(repository.findAllByLanguageOrderByStartingYear(defaultLanguage)).thenReturn(jobItemsDe);
        List<JobItem> result = jobItemService.getAllByLanguage(english);

        verify(repository, times(1)).findAllByLanguageOrderByStartingYear(english);
        verify(repository, times(1)).findAllByLanguageOrderByStartingYear(defaultLanguage);
        assertEquals(jobItemsDe, result);
    }

    @Test
    void testGetAllByLanguage_withReturnNull_shouldQueryAgain() {
        List<JobItem> jobItemsDe = new ArrayList<>();
        jobItemsDe.add(new JobItem(2021, 2023, "url"));
        jobItemsDe.add(new JobItem(2024, null, "url"));

        when(repository.findAllByLanguageOrderByStartingYear(english)).thenReturn(null);
        when(repository.findAllByLanguageOrderByStartingYear(defaultLanguage)).thenReturn(jobItemsDe);
        List<JobItem> result = jobItemService.getAllByLanguage(english);

        verify(repository, times(1)).findAllByLanguageOrderByStartingYear(english);
        verify(repository, times(1)).findAllByLanguageOrderByStartingYear(defaultLanguage);
        assertEquals(jobItemsDe, result);
    }
}
