package janis.website.backend.controller.mapper;

import jakarta.transaction.Transactional;
import janis.website.backend.controller.dto.EducationItemDto;
import janis.website.backend.entity.EducationItem;
import janis.website.backend.entity.EducationItemTranslation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class EducationItemMapperImpl implements EducationItemMapper {


  @Override
  public EducationItemDto entityToDto(EducationItem educationItem) {
    EducationItemDto dto = new EducationItemDto();
    dto.setStartingYear(educationItem.getStartingYear());
    dto.setEndingYear(educationItem.getEndingYear());
    dto.setLogoUrl(educationItem.getLogoUrl());

    EducationItemTranslation educationItemTranslation = educationItem.getTranslations().get(0);
    dto.setSchoolName(educationItemTranslation.getSchoolName());
    dto.setSchoolNameAbbreviation(educationItemTranslation.getSchoolNameAbbreviation());
    dto.setStudyTitle(educationItemTranslation.getStudyTitle());
    dto.setDescription(educationItemTranslation.getDescription());
    return dto;
  }

  @Override
  public List<EducationItemDto> entityToDto(List<EducationItem> educationItemList) {
    if (educationItemList == null) {
      return List.of();
    }

    List<EducationItemDto> list = new ArrayList<>(educationItemList.size());
    for (EducationItem educationItem : educationItemList) {
      list.add(entityToDto(educationItem));
    }
    return list;
  }
}
