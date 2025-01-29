package api_login_user.repository;

import api_login_user.model.ActivityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityModel, Long> {
    ActivityModel findByName(String name);
}
