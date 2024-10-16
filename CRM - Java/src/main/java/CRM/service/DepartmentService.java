package CRM.service;

import CRM.IService.IDepartmentCrudService;
import CRM.entity.Department;
import CRM.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService extends CoreCrudService<Department> implements IDepartmentCrudService {
    private final DepartmentRepository departmentRepository;
    public DepartmentService(DepartmentRepository departmentRepository) {
        super(departmentRepository);
        this.departmentRepository=departmentRepository;
    }
}
