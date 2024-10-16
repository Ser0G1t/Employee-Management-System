package CRM.IService;

import CRM.entity.Skill;

public interface ISkillCrudService extends ICoreCrudService<Skill> {
    void updateSkill(Skill skill);
    void createSkill(Skill skill);
    Skill getSkillById(long id);
}
