package api_login_user.repository;

import api_login_user.model.StockModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockModel,Long> {
    StockModel findByNameItem(String nameItem);
}
