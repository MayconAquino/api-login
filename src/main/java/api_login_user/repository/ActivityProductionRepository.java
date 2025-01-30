package api_login_user.repository;

import api_login_user.model.ActivityProductionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityProductionRepository extends JpaRepository<ActivityProductionModel, Long> {
    ActivityProductionModel findByActivityModelId(Long activityModelId);


}
