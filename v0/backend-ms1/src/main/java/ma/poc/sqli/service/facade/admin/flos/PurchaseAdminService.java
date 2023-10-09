package ma.poc.sqli.service.facade.admin.flos;

import java.util.List;
import ma.poc.sqli.bean.core.flos.Purchase;
import ma.poc.sqli.dao.criteria.core.flos.PurchaseCriteria;
import ma.poc.sqli.zynerator.service.IService;
import ma.poc.sqli.zynerator.dto.ScheduleDto;

import ma.poc.sqli.ws.dto.flos.PurchaseDto;
import org.springframework.http.HttpEntity;

import java.time.LocalDateTime;

public interface PurchaseAdminService extends  IService<Purchase,PurchaseCriteria>  {

    List<Purchase> findByClientId(Long id);
    int deleteByClientId(Long id);

    List<ScheduleDto> findSchedule(LocalDateTime start, LocalDateTime end);

    HttpEntity<byte[]> createPdf(PurchaseDto dto) throws Exception;

}
