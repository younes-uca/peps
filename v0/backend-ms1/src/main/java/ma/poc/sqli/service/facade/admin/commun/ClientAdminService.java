package ma.poc.sqli.service.facade.admin.commun;

import java.util.List;
import ma.poc.sqli.bean.core.commun.Client;
import ma.poc.sqli.dao.criteria.core.commun.ClientCriteria;
import ma.poc.sqli.zynerator.service.IService;

import ma.poc.sqli.ws.dto.commun.ClientDto;
import org.springframework.http.HttpEntity;


public interface ClientAdminService extends  IService<Client,ClientCriteria>  {

    List<Client> findByClientCategoryId(Long id);
    int deleteByClientCategoryId(Long id);


    HttpEntity<byte[]> createPdf(ClientDto dto) throws Exception;

}
