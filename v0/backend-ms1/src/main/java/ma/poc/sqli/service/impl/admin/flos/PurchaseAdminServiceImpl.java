package ma.poc.sqli.service.impl.admin.flos;


import ma.poc.sqli.bean.core.flos.Purchase;
import ma.poc.sqli.dao.criteria.core.flos.PurchaseCriteria;
import ma.poc.sqli.dao.facade.core.flos.PurchaseDao;
import ma.poc.sqli.dao.specification.core.flos.PurchaseSpecification;
import ma.poc.sqli.service.facade.admin.flos.PurchaseAdminService;
import ma.poc.sqli.zynerator.service.AbstractServiceImpl;
import ma.poc.sqli.zynerator.service.Attribute;
import ma.poc.sqli.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;



import ma.poc.sqli.zynerator.dto.ScheduleDto;

import ma.poc.sqli.zynerator.util.VelocityPdf;
import ma.poc.sqli.ws.dto.flos.PurchaseDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.poc.sqli.service.facade.admin.flos.PurchaseItemAdminService ;
import ma.poc.sqli.bean.core.flos.PurchaseItem ;
import ma.poc.sqli.service.facade.admin.commun.ClientAdminService ;
import ma.poc.sqli.bean.core.commun.Client ;

    import java.time.LocalDateTime;
import java.util.List;
@Service
public class PurchaseAdminServiceImpl extends AbstractServiceImpl<Purchase, PurchaseCriteria, PurchaseDao> implements PurchaseAdminService {
    public static final String TEMPLATE = "template/purchase.vm";
    public static final String FILE_NAME = "purchase.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("reference"));



    ATTRIBUTES.add(new Attribute("image"));

    ATTRIBUTES.add(new Attribute("etat","Boolean"));

    ATTRIBUTES.add(new Attribute("total","BigDecimal"));

    ATTRIBUTES.add(new Attribute("description"));


    }

    @Override
    public HttpEntity<byte[]> createPdf(PurchaseDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Purchase create(Purchase t) {
        super.create(t);
        if (t.getPurchaseItems() != null) {
                t.getPurchaseItems().forEach(element-> {
                    element.setPurchase(t);
                    purchaseItemService.create(element);
            });
        }
        return t;
    }

    public Purchase findWithAssociatedLists(Long id){
        Purchase result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setPurchaseItems(purchaseItemService.findByPurchaseId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        purchaseItemService.deleteByPurchaseId(id);
    }


    public void updateWithAssociatedLists(Purchase purchase){
    if(purchase !=null && purchase.getId() != null){
            List<List<PurchaseItem>> resultPurchaseItems= purchaseItemService.getToBeSavedAndToBeDeleted(purchaseItemService.findByPurchaseId(purchase.getId()),purchase.getPurchaseItems());
            purchaseItemService.delete(resultPurchaseItems.get(1));
            ListUtil.emptyIfNull(resultPurchaseItems.get(0)).forEach(e -> e.setPurchase(purchase));
            purchaseItemService.update(resultPurchaseItems.get(0),true);
    }
    }




    public List<Purchase> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }



    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public List<ScheduleDto> findSchedule(LocalDateTime start, LocalDateTime end) {
        List<ScheduleDto> results = dao.findSchedule(start, end);
            return results;
    }
    public void configure() {
        super.configure(Purchase.class, PurchaseSpecification.class);
    }


    @Autowired
    private PurchaseItemAdminService purchaseItemService ;
    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public PurchaseAdminServiceImpl(PurchaseDao dao) {
        super(dao);
    }

}
