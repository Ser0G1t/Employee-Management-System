package CRM.service;

import CRM.entity.CoreEntity;
import CRM.exceptionHandling.EntityNotFoundException;
import CRM.repository.CoreRepository;

import java.util.Optional;

abstract class CoreCrudService<T extends CoreEntity> {
    protected CoreRepository<T> repository;
    public CoreCrudService(CoreRepository<T> repository){
        this.repository=repository;
    }
    public void create(T entity){
        repository.save(entity);
    }
    public void delete(long id){
        var entity = findById(id);
        repository.delete(entity);


    }
    public T findById(long id){
        return repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Entity with this ID can't be found"));
    }
}
