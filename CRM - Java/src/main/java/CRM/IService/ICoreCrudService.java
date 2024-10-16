package CRM.IService;

interface ICoreCrudService<T> {
    void create(T entity);
    void delete(long id);
    T findById(long id);
}
