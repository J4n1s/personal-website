package janis.website.backend.controller.mapper;

import jakarta.transaction.Transactional;
import janis.website.backend.controller.dto.JobItemDto;
import janis.website.backend.entity.JobItem;
import janis.website.backend.entity.JobItemTranslation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class JobItemMapperImpl implements JobItemMapper {


    @Override
    public JobItemDto entityToDto(JobItem jobItem) {
        JobItemDto dto = new JobItemDto();
        dto.setStartingYear(jobItem.getStartingYear());
        dto.setEndingYear(jobItem.getEndingYear());
        dto.setLogoUrl(jobItem.getLogoUrl());

        JobItemTranslation translation = jobItem.getTranslations().get(0);
        dto.setEmployerName(translation.getEmployerName());
        dto.setJobTitle(translation.getJobTitle());
        dto.setJobDescription(translation.getJobDescription());
        return dto;
    }

    @Override
    public List<JobItemDto> entityToDto(List<JobItem> jobItems) {
        if (jobItems == null) {
            return List.of();
        }

        List<JobItemDto> list = new ArrayList<>();
        for (JobItem jobItem : jobItems) {
            list.add(entityToDto(jobItem));
        }
        return list;
    }
}
