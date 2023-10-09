package ma.poc.sqli.dao.facade.core.flos;

import ma.poc.sqli.zynerator.repository.AbstractRepository;
import ma.poc.sqli.bean.core.flos.Purchase;
import org.springframework.stereotype.Repository;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;
import ma.poc.sqli.zynerator.dto.ScheduleDto;

@Repository
public interface PurchaseDao extends AbstractRepository<Purchase,Long>  {

    List<Purchase> findByClientId(Long id);
    int deleteByClientId(Long id);


    @Query("SELECT NEW ma.poc.sqli.zynerator.dto.ScheduleDto(s.reference, s.purchaseStartDate, s.purchaseEndDate ,s.id) from Purchase s where s.purchaseStartDate >= :start and s.purchaseEndDate <= :end")
    List<ScheduleDto> findSchedule(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
