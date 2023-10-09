package ma.poc.sqli.service.impl.admin.commun;


import ma.poc.sqli.bean.core.commun.Client;
import ma.poc.sqli.dao.criteria.core.commun.ClientCriteria;
import ma.poc.sqli.dao.facade.core.commun.ClientDao;
import ma.poc.sqli.dao.specification.core.commun.ClientSpecification;
import ma.poc.sqli.service.facade.admin.commun.ClientAdminService;
import ma.poc.sqli.zynerator.service.AbstractServiceImpl;
import ma.poc.sqli.zynerator.service.Attribute;
import ma.poc.sqli.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.poc.sqli.zynerator.util.VelocityPdf;
import ma.poc.sqli.ws.dto.commun.ClientDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;

import ma.poc.sqli.service.facade.admin.commun.ClientCategoryAdminService ;
import ma.poc.sqli.bean.core.commun.ClientCategory ;

import java.util.List;
@Service
public class ClientAdminServiceImpl extends AbstractServiceImpl<Client, ClientCriteria, ClientDao> implements ClientAdminService {
    public static final String TEMPLATE = "template/client.vm";
    public static final String FILE_NAME = "client.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("fullName"));

    }

    @Override
    public HttpEntity<byte[]> createPdf(ClientDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }





    public List<Client> findByClientCategoryId(Long id){
        return dao.findByClientCategoryId(id);
    }
    public int deleteByClientCategoryId(Long id){
        return dao.deleteByClientCategoryId(id);
    }



    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(Client.class, ClientSpecification.class);
    }


    @Autowired
    private ClientCategoryAdminService clientCategoryService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public ClientAdminServiceImpl(ClientDao dao) {
        super(dao);
    }

}
