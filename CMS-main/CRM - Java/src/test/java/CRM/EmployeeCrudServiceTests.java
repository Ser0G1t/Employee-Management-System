package CRM;

import CRM.entity.Employee;
import CRM.entity.Skill;
import CRM.enums.SkillLevel;
import CRM.exceptionHandling.EntityNotFoundException;
import CRM.repository.EmployeeRepository;
import CRM.service.EmployeeCrudService;
import CRM.service.SkillCrudService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeCrudServiceTests {
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private SkillCrudService skillCrudService;
    @InjectMocks
    private EmployeeCrudService employeeCrudService;

    @Test
    void shouldThrowNotFoundExceptionWhileSearchingEmployee() {
        //when
        when(employeeRepository.findById(1L)).thenThrow(EntityNotFoundException.class);
        //then
        assertThrows(EntityNotFoundException.class, ()-> {
            employeeCrudService.addNewSkill(1L,1L);
        });
    }
    @Test
    void shouldCorrectlySaveEmployeeAfterAddNewSkill(){
        //given
        Employee employee = new Employee();
        Skill skill = new Skill();
        //when
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        when(skillCrudService.findById(1L)).thenReturn(skill);
        employeeCrudService.addNewSkill(1L, 1L);
        //then
        assertEquals(1, employee.getSkills().size());
        verify(employeeRepository).save(employee);
    }

    @Test
    void shouldCallFindByIdMethodInAddNewSkill() {
        Employee employee = new Employee();
        Skill skill = new Skill();
        //when
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        when(skillCrudService.findById(1L)).thenReturn(skill);
        employeeCrudService.addNewSkill(1L,1L);
        //then
        verify(employeeRepository).findById(1L);
        verify(skillCrudService).findById(1L);
    }
    @Test
    void shouldUpdateSkillLevel(){
        //given
        Employee employee = new Employee();
        Skill skill = new Skill();
        //when
        skill.setId(1L);
        employee.addSkill(skill);
        when(employeeRepository.findById(1L))
                .thenReturn(Optional.of(employee));
        employeeCrudService
                .updateSkillLevel(1L, 1L, SkillLevel.EXPERT);
        //then
        assertEquals(SkillLevel.EXPERT, skill.getSkillLevel());
    }
}
