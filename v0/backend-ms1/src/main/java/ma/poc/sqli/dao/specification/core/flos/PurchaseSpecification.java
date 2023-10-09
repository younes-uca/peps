package  ma.poc.sqli.dao.specification.core.flos;

import ma.poc.sqli.zynerator.specification.AbstractSpecification;
import ma.poc.sqli.dao.criteria.core.flos.PurchaseCriteria;
import ma.poc.sqli.bean.core.flos.Purchase;


public class PurchaseSpecification extends  AbstractSpecification<PurchaseCriteria, Purchase>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("purchaseStartDate", criteria.getPurchaseStartDate(), criteria.getPurchaseStartDateFrom(), criteria.getPurchaseStartDateTo());
        addPredicate("purchaseEndDate", criteria.getPurchaseEndDate(), criteria.getPurchaseEndDateFrom(), criteria.getPurchaseEndDateTo());
        addPredicate("image", criteria.getImage(),criteria.getImageLike());
        addPredicateBool("etat", criteria.getEtat());
        addPredicateBigDecimal("total", criteria.getTotal(), criteria.getTotalMin(), criteria.getTotalMax());
        addPredicateFk("client","id", criteria.getClient()==null?null:criteria.getClient().getId());
        addPredicateFk("client","id", criteria.getClients());
    }

    public PurchaseSpecification(PurchaseCriteria criteria) {
        super(criteria);
    }

    public PurchaseSpecification(PurchaseCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
