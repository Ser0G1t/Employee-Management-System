package CRM;

import CRM.entity.Employee;
import CRM.repository.EmployeeRepository;
import CRM.repository.SkillRepository;
import CRM.service.EmployeeCrudService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeeCrudServiceTests {
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private SkillRepository skillRepository;
    @InjectMocks
    private EmployeeCrudService employeeCrudService;

    @Test
    void shouldThrowNotFoundExceptionWhileSearchingEmployee(){
        //given
        Employee employee = new Employee();
//        //when
//        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
//        when(employeeCrudService.addNewSkill(2L, 1L)).thenCallRealMethod();
        //then


    }
    @Test
    void shouldCallFindByIdMethodInAddNewSkill(){

    }
}
