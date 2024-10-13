package CRM.service;

import CRM.entity.CoreEntity;
import CRM.repository.CoreRepository;

abstract class CoreCrudService<T extends CoreEntity> {
    private CoreRepository<T> repository;
    public void create(T entity){
        repository.save(entity);
    }
    public void delete(long id){
        repository.deleteById(id);
    }
}
