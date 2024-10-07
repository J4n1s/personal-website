package janis.website.backend.controller.mapper;

import janis.website.backend.controller.dto.EducationItemDto;
import janis.website.backend.entity.EducationItem;

import java.util.List;

public interface EducationItemMapper {

    EducationItemDto entityToDto(EducationItem educationItem);
    List<EducationItemDto> entityToDto(List<EducationItem> educationItemList);
}
