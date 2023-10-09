package ma.poc.sqli.service.impl.admin.commun;


import ma.poc.sqli.bean.core.commun.ClientCategory;
import ma.poc.sqli.dao.criteria.core.commun.ClientCategoryCriteria;
import ma.poc.sqli.dao.facade.core.commun.ClientCategoryDao;
import ma.poc.sqli.dao.specification.core.commun.ClientCategorySpecification;
import ma.poc.sqli.service.facade.admin.commun.ClientCategoryAdminService;
import ma.poc.sqli.zynerator.service.AbstractServiceImpl;
import ma.poc.sqli.zynerator.service.Attribute;
import ma.poc.sqli.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.poc.sqli.zynerator.util.VelocityPdf;
import ma.poc.sqli.ws.dto.commun.ClientCategoryDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ClientCategoryAdminServiceImpl extends AbstractServiceImpl<ClientCategory, ClientCategoryCriteria, ClientCategoryDao> implements ClientCategoryAdminService {
    public static final String TEMPLATE = "template/clientCategory.vm";
    public static final String FILE_NAME = "clientCategory.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("reference"));

    ATTRIBUTES.add(new Attribute("code"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(ClientCategoryDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }




    public ClientCategory findByReferenceEntity(ClientCategory t){
        return  dao.findByCode(t.getCode());
    }




    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(ClientCategory.class, ClientCategorySpecification.class);
    }


    @Autowired
    private VelocityPdf velocityPdf;

    public ClientCategoryAdminServiceImpl(ClientCategoryDao dao) {
        super(dao);
    }

}
