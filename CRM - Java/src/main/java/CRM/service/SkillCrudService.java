package CRM.service;

import CRM.IService.ISkillCrudService;
import CRM.entity.Skill;
import CRM.repository.SkillRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SkillCrudService extends CoreCrudService<Skill> implements ISkillCrudService {
    private final SkillRepository skillRepository;

    public SkillCrudService(SkillRepository skillRepository) {
        super(skillRepository);
        this.skillRepository = skillRepository;
    }

    public void updateSkill(Skill skill){
        skill.setName(skill.getName());
        skillRepository.save(skill);
    }
    public void createSkill(Skill skill){
        skillRepository.save(skill);
    }
    public Skill getSkillById(long id){
        return skillRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Entity (Skill) with this ID can't be found"));
    }
}
