package ma.poc.sqli.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.poc.sqli.zynerator.repository.AbstractRepository;
import ma.poc.sqli.bean.core.commun.Client;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ClientDao extends AbstractRepository<Client,Long>  {

    List<Client> findByClientCategoryId(Long id);
    int deleteByClientCategoryId(Long id);

    @Query("SELECT NEW Client(item.id,item.fullName) FROM Client item")
    List<Client> findAllOptimized();

}
