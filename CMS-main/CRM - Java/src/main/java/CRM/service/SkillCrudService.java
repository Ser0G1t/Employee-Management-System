package CRM.service;

import CRM.IService.ISkillService;
import CRM.entity.Skill;
import CRM.repository.CoreRepository;
import CRM.repository.SkillRepository;
import org.springframework.stereotype.Service;

@Service
public class SkillCrudService extends CoreCrudService<Skill> implements ISkillService {
    private final SkillRepository skillRepository;

    public SkillCrudService(SkillRepository skillRepository) {
        super(skillRepository);
        this.skillRepository = skillRepository;
    }

    public void updateSkill(Skill skill){
        skill.setName(skill.getName());
        skillRepository.save(skill);
    }
}
