package janis.website.backend.service;

import janis.website.backend.entity.JobItem;

import java.util.List;

public interface JobItemService {

    List<JobItem> getAllByLanguage(String language);
}
