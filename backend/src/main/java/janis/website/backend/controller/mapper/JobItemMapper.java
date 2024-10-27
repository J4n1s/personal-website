package janis.website.backend.controller.mapper;

import janis.website.backend.controller.dto.JobItemDto;
import janis.website.backend.entity.JobItem;

import java.util.List;

/**
 * Interface for mapping JobItem entities to JobItemDto objects.
 */
public interface JobItemMapper {

  /**
   * Maps a JobItem entity to a JobItemDto object.
   *
   * @param jobItem the JobItem entity to map from
   * @return the mapped JobItemDto object
   */
  JobItemDto entityToDto(JobItem jobItem);

  /**
   * Converts a list of JobItem entities to a list of JobItemDto objects.
   *
   * @param jobItems the list of JobItem entities to convert
   * @return a list of converted JobItemDto objects
   */
  List<JobItemDto> entityToDto(List<JobItem> jobItems);
}
