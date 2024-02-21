package reserver.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import reserver.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "alerts", path = "alerts")
public interface AlertRepository
    extends PagingAndSortingRepository<Alert, Long> {}
