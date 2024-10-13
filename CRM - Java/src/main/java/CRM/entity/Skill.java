package CRM.entity;

import CRM.enums.SkillLevel;

import java.util.Objects;

public class Skill extends CoreEntity{
    private String name;
    private SkillLevel skillLevel;
    public Skill(){

    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill skill)) return false;
        return Objects.equals(name, skill.name) && skillLevel == skill.skillLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, skillLevel);
    }
}
