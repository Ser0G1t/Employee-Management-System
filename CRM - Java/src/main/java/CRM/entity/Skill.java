package CRM.entity;

import CRM.enums.SkillLevel;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Skill extends CoreEntity{
    private String name;
    private SkillLevel skillLevel;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "employee_skill", // Nazwa tabeli łączącej
            joinColumns = @JoinColumn(name = "skill_id"), // Kolumna w tabeli employee_skill, która odnosi się do id w Skill
            inverseJoinColumns = @JoinColumn(name = "employee_id") // Kolumna w tabeli employee_skill, która odnosi się do id w Employee
    )
    private Set<Employee> employees = new HashSet<>();
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
        return Objects.equals(name, skill.name) && skillLevel == skill.skillLevel && Objects.equals(getId(), skill.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, skillLevel, getId());
    }
}
