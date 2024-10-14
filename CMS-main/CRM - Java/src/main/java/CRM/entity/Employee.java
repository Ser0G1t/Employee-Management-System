package CRM.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Employee extends CoreEntity{
    private String name;
    private String lastName;
    @Column(unique = true)
    private String PESEL;
    private int age;
    @ManyToMany(mappedBy = "employees", cascade = CascadeType.ALL)

    private Set<Skill> skills = new HashSet<>();
    public Employee(){

    }
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public long getId() {
        return super.getId();
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void setId(long id) {
        super.setId(id);
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }
    public void addSkill(Skill skill){
        skills.add(skill);
    }
    public Optional<Skill> getSkill(long id){
        return skills.stream().filter(el->el.getId()==id).findFirst();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return age == employee.age && Objects.equals(name, employee.name) && Objects.equals(lastName, employee.lastName) && Objects.equals(PESEL, employee.PESEL) && Objects.equals(getId(), employee.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, PESEL, age, getId());
    }
}
