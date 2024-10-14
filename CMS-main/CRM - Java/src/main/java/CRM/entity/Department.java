package CRM.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Department extends CoreEntity{
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    //TODO : DO SPRAWDZENIA CZY USUNIE SIE PRACOWNIK JAKO ENCJA PRZY TYM CASCADETYPE
    private Set<Employee> employees = new HashSet<>();
    public Department(){

    }

    public String getName() {
        return name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department dprt)) return false;
        return Objects.equals(name, dprt.name) && Objects.equals(employees, dprt.employees) && Objects.equals(getId(), dprt.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, employees, getId());
    }
}
