package CRM.entity;

import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class Department extends CoreEntity{
    private String name;

    public Department(){

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
        if (!(o instanceof Department dprt)) return false;
        return Objects.equals(name, dprt.name)  && Objects.equals(getId(), dprt.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getId());
    }
}
