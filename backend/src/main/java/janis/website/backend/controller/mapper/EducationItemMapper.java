package janis.website.backend.controller.mapper;

import janis.website.backend.controller.dto.EducationItemDto;
import janis.website.backend.entity.EducationItem;

import java.util.List;


/**
 * Interface for mapping EducationItem entities to EducationItemDto.
 */
public interface EducationItemMapper {

  /**
   * Maps an EducationItem entity to its corresponding EducationItemDto.
   *
   * @param educationItem the EducationItem object to be converted
   * @return the corresponding EducationItemDto object
   */
  EducationItemDto entityToDto(EducationItem educationItem);

  /**
   * Converts a list of EducationItem entities to a list of EducationItemDto.
   *
   * @param educationItemList the list of EducationItem entities to be converted
   * @return the list of resulting EducationItemDto objects
   */
  List<EducationItemDto> entityToDto(List<EducationItem> educationItemList);
}
