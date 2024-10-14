package CRM.repository;

import CRM.entity.CoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreRepository<T extends CoreEntity> extends JpaRepository<T, Long> {
}
