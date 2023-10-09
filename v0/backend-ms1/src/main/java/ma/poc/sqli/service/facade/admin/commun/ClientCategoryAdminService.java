package ma.poc.sqli.service.facade.admin.commun;

import java.util.List;
import ma.poc.sqli.bean.core.commun.ClientCategory;
import ma.poc.sqli.dao.criteria.core.commun.ClientCategoryCriteria;
import ma.poc.sqli.zynerator.service.IService;

import ma.poc.sqli.ws.dto.commun.ClientCategoryDto;
import org.springframework.http.HttpEntity;


public interface ClientCategoryAdminService extends  IService<ClientCategory,ClientCategoryCriteria>  {



    HttpEntity<byte[]> createPdf(ClientCategoryDto dto) throws Exception;

}
