package ma.poc.sqli.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.poc.sqli.zynerator.repository.AbstractRepository;
import ma.poc.sqli.bean.core.commun.ClientCategory;
import org.springframework.stereotype.Repository;
import ma.poc.sqli.bean.core.commun.ClientCategory;
import java.util.List;


@Repository
public interface ClientCategoryDao extends AbstractRepository<ClientCategory,Long>  {
    ClientCategory findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW ClientCategory(item.id,item.reference) FROM ClientCategory item")
    List<ClientCategory> findAllOptimized();

}
