package janis.website.backend.service;

import janis.website.backend.controller.dto.SkillDto;

import java.util.List;

public interface ResumeService {

    List<SkillDto> getSkills(String language);
}
