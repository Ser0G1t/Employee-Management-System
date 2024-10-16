package CRM.controller;

import CRM.IService.ISkillCrudService;
import CRM.entity.Skill;
import CRM.messages.WebMessage;
import CRM.service.SkillCrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static CRM.constants.CrudAnnouncements.*;

@RestController
@RequestMapping("skills")
public class SkillCrudController {
    private final ISkillCrudService skillCrudService;

    public SkillCrudController(SkillCrudService skillCrudService) {
        this.skillCrudService = skillCrudService;
    }
    @GetMapping("/")
    public ResponseEntity<Skill> getSkillById(@PathVariable long id){
        var skill = skillCrudService.getSkillById(id);
        return ResponseEntity.ok(skill);
    }
    @PostMapping
    public ResponseEntity<WebMessage> createSkill(Skill skill){
        return ResponseEntity.ok(new WebMessage(CREATED));
    };
    public ResponseEntity<WebMessage> updateSkill(Skill skill){
        skillCrudService.updateSkill(skill);
        return ResponseEntity.ok(new WebMessage(UPDATED));
    }
}
