package CRM.controller;

import CRM.IService.IEmployeeCrudService;
import CRM.entity.Employee;
import CRM.messages.WebMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static CRM.constants.CrudAnnouncements.*;
@RestController
@RequestMapping("employees")
public class EmployeeCrudController {
    private final IEmployeeCrudService employeeService;

    public EmployeeCrudController(IEmployeeCrudService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        //TODO : check try should be here
        var employee = employeeService.findById(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/create")
    public ResponseEntity<WebMessage> createEmployee(@RequestBody Employee employee) {
        employeeService.create(employee);
        return ResponseEntity.ok(new WebMessage(CREATED));
    }

    @PutMapping("/update")
    public ResponseEntity<WebMessage> updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return ResponseEntity.ok(new WebMessage(UPDATED));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<WebMessage> deleteEmployee(long id) {
        employeeService.delete(id);
        return ResponseEntity.ok(new WebMessage(DELETED));
    }
    @PatchMapping("/add_skill/{employeeId}")
    public ResponseEntity<WebMessage> addNewSkill(@PathVariable long employeeId, @RequestParam long skillId){
        String message = "Skill has been added";
        employeeService.addNewSkill(employeeId, skillId);
        return ResponseEntity.ok(new WebMessage(message));
    }
}
