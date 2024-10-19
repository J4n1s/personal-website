package janis.website.backend.unit.mapper;

import janis.website.backend.controller.dto.JobItemDto;
import janis.website.backend.controller.mapper.JobItemMapper;
import janis.website.backend.controller.mapper.JobItemMapperImpl;
import janis.website.backend.entity.JobItem;
import janis.website.backend.entity.JobItemTranslation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class JobItemMapperTest {

    private final JobItemMapper jobItemMapper = new JobItemMapperImpl();
    private JobItem jobItem;

    @BeforeEach
    public void setUp() {
        jobItem = new JobItem(1986, 1999, "url/to/logo");
        JobItemTranslation translation = new JobItemTranslation(Locale.ENGLISH.getLanguage(), "APG", "System Administrator", "Job Description");
        translation.setJobItem(jobItem);
        jobItem.setTranslations(List.of(translation));
    }

    @Test
    void testMapEntityToDto() {
        JobItemDto jobItemDto = jobItemMapper.entityToDto(jobItem);
        JobItemTranslation jobItemTranslation = jobItem.getTranslations().get(0);

        assertAll(
                () -> assertEquals(jobItem.getStartingYear(), jobItemDto.getStartingYear()),
                () -> assertEquals(jobItem.getEndingYear(), jobItemDto.getEndingYear()),
                () -> assertEquals(jobItem.getLogoUrl(), jobItemDto.getLogoUrl()),
                () -> assertEquals(jobItemTranslation.getEmployerName(), jobItemDto.getEmployerName()),
                () -> assertEquals(jobItemTranslation.getJobTitle(), jobItemDto.getJobTitle()),
                () -> assertEquals(jobItemTranslation.getJobDescription(), jobItemDto.getJobDescription())
        );
    }

    @Test
    void testMapEntityListToDtoList() {
        List<JobItemDto> jobItemDtos = jobItemMapper.entityToDto(List.of(jobItem));
        assertEquals(1, jobItemDtos.size());

        JobItemTranslation jobItemTranslation = jobItem.getTranslations().get(0);
        JobItemDto jobItemDto = jobItemDtos.get(0);

        assertAll(
                () -> assertEquals(jobItem.getStartingYear(), jobItemDto.getStartingYear()),
                () -> assertEquals(jobItem.getEndingYear(), jobItemDto.getEndingYear()),
                () -> assertEquals(jobItem.getLogoUrl(), jobItemDto.getLogoUrl()),
                () -> assertEquals(jobItemTranslation.getEmployerName(), jobItemDto.getEmployerName()),
                () -> assertEquals(jobItemTranslation.getJobTitle(), jobItemDto.getJobTitle()),
                () -> assertEquals(jobItemTranslation.getJobDescription(), jobItemDto.getJobDescription())
        );
    }

    @Test
    void testMapEntityListToDtoList_withEmptyList() {
        List<JobItemDto> jobItemDtos = jobItemMapper.entityToDto(List.of());
        assertEquals(0, jobItemDtos.size());
    }

    @Test
    void testMapEntityListToDtoList_withListNull() {
        List<JobItem> jobItems = null;
        List<JobItemDto> jobItemDtos = jobItemMapper.entityToDto(jobItems);
        assertEquals(0, jobItemDtos.size());
    }
}
