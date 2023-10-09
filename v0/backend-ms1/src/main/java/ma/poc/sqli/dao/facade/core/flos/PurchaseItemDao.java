package ma.poc.sqli.dao.facade.core.flos;

import ma.poc.sqli.zynerator.repository.AbstractRepository;
import ma.poc.sqli.bean.core.flos.PurchaseItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PurchaseItemDao extends AbstractRepository<PurchaseItem,Long>  {

    List<PurchaseItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<PurchaseItem> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);


}
