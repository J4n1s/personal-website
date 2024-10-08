package janis.website.backend.controller.mapper;

import janis.website.backend.controller.dto.JobItemDto;
import janis.website.backend.entity.JobItem;

import java.util.List;

public interface JobItemMapper {

    JobItemDto entityToDto(JobItem jobItem);
    List<JobItemDto> entityToDto(List<JobItem> jobItems);
}
