package ma.poc.sqli.service.impl.admin.commun;


import ma.poc.sqli.bean.core.commun.Product;
import ma.poc.sqli.dao.criteria.core.commun.ProductCriteria;
import ma.poc.sqli.dao.facade.core.commun.ProductDao;
import ma.poc.sqli.dao.specification.core.commun.ProductSpecification;
import ma.poc.sqli.service.facade.admin.commun.ProductAdminService;
import ma.poc.sqli.zynerator.service.AbstractServiceImpl;
import ma.poc.sqli.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ProductAdminServiceImpl extends AbstractServiceImpl<Product, ProductCriteria, ProductDao> implements ProductAdminService {





    public Product findByReferenceEntity(Product t){
        return  dao.findByCode(t.getCode());
    }







    public void configure() {
        super.configure(Product.class, ProductSpecification.class);
    }



    public ProductAdminServiceImpl(ProductDao dao) {
        super(dao);
    }

}
