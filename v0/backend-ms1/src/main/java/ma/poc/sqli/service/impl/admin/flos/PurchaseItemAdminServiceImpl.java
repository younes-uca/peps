package ma.poc.sqli.service.impl.admin.flos;


import ma.poc.sqli.bean.core.flos.PurchaseItem;
import ma.poc.sqli.dao.criteria.core.flos.PurchaseItemCriteria;
import ma.poc.sqli.dao.facade.core.flos.PurchaseItemDao;
import ma.poc.sqli.dao.specification.core.flos.PurchaseItemSpecification;
import ma.poc.sqli.service.facade.admin.flos.PurchaseItemAdminService;
import ma.poc.sqli.zynerator.service.AbstractServiceImpl;
import ma.poc.sqli.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.poc.sqli.service.facade.admin.flos.PurchaseAdminService ;
import ma.poc.sqli.bean.core.flos.Purchase ;
import ma.poc.sqli.service.facade.admin.commun.ProductAdminService ;
import ma.poc.sqli.bean.core.commun.Product ;

import java.util.List;
@Service
public class PurchaseItemAdminServiceImpl extends AbstractServiceImpl<PurchaseItem, PurchaseItemCriteria, PurchaseItemDao> implements PurchaseItemAdminService {






    public List<PurchaseItem> findByProductId(Long id){
        return dao.findByProductId(id);
    }
    public int deleteByProductId(Long id){
        return dao.deleteByProductId(id);
    }
    public List<PurchaseItem> findByPurchaseId(Long id){
        return dao.findByPurchaseId(id);
    }
    public int deleteByPurchaseId(Long id){
        return dao.deleteByPurchaseId(id);
    }






    public void configure() {
        super.configure(PurchaseItem.class, PurchaseItemSpecification.class);
    }


    @Autowired
    private PurchaseAdminService purchaseService ;
    @Autowired
    private ProductAdminService productService ;

    public PurchaseItemAdminServiceImpl(PurchaseItemDao dao) {
        super(dao);
    }

}
