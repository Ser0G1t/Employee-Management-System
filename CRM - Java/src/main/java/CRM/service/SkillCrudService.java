package CRM.service;

import CRM.entity.Skill;
import CRM.repository.SkillRepository;
import org.springframework.stereotype.Service;

@Service
public class SkillCrudService extends CoreCrudService<Skill> {
    private final SkillRepository skillRepository;

    public SkillCrudService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }
    public void updateSkill(Skill skill){
        skill.setName(skill.getName());
        skillRepository.save(skill);
    }
}
