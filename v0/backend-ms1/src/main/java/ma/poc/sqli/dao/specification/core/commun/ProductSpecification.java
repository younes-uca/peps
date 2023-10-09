package  ma.poc.sqli.dao.specification.core.commun;

import ma.poc.sqli.zynerator.specification.AbstractSpecification;
import ma.poc.sqli.dao.criteria.core.commun.ProductCriteria;
import ma.poc.sqli.bean.core.commun.Product;


public class ProductSpecification extends  AbstractSpecification<ProductCriteria, Product>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
    }

    public ProductSpecification(ProductCriteria criteria) {
        super(criteria);
    }

    public ProductSpecification(ProductCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
