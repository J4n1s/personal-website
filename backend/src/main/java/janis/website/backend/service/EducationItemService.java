package janis.website.backend.service;

import janis.website.backend.entity.EducationItem;

import java.util.List;

public interface EducationItemService {

    List<EducationItem> getAllByLanguage(String language);
}
