package CRM;

import CRM.entity.Employee;
import CRM.entity.Skill;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTests {
    @Test
    void employeeShouldBeNotEqualAnotherEmployee(){
        //given
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        //when
        employee1.setPESEL("123123123");
        employee2.setPESEL("1654653462");
        //then
        assertNotEquals(employee1, employee2);
    }
    @Test
    void employeeShouldBeEqualAnotherEmployee(){
        //given
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        //when
        employee1.setName("Daniel");
        employee2.setName("Daniel");
        //then
        assertEquals(employee1, employee2);
    }
    @Test
    void shouldAddOnlyOneNewSkill(){
        //given
        Skill skill1 = new Skill();
        Skill skill2 = new Skill();
        Employee employee = new Employee();
        //when
        employee.addSkill(skill1);
        employee.addSkill(skill2);
        //then
        assertEquals(2,employee.getSkills().size());
    }
    @Test
    void shouldAddNewSkills(){
        //given
        Skill skill1 = new Skill();
        skill1.setName("Drive Licence B");
        Skill skill2 = new Skill();
        skill2.setName("Drive Licence C");
        Employee employee = new Employee();
        //when
        employee.addSkill(skill1);
        employee.addSkill(skill2);
        //then
        assertEquals(2,employee.getSkills().size());
    }
}
