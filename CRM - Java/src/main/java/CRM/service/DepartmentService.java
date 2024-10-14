package CRM.service;

import CRM.IService.IDepartmentService;
import CRM.entity.Department;
import CRM.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService extends CoreCrudService<Department> implements IDepartmentService {
    private final DepartmentRepository departmentRepository;
    public DepartmentService(DepartmentRepository departmentRepository) {
        super(departmentRepository);
        this.departmentRepository=departmentRepository;
    }
}
