package ma.poc.sqli.service.facade.admin.flos;

import java.util.List;
import ma.poc.sqli.bean.core.flos.PurchaseItem;
import ma.poc.sqli.dao.criteria.core.flos.PurchaseItemCriteria;
import ma.poc.sqli.zynerator.service.IService;



public interface PurchaseItemAdminService extends  IService<PurchaseItem,PurchaseItemCriteria>  {

    List<PurchaseItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<PurchaseItem> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);



}
