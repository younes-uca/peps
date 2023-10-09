package ma.poc.sqli.zynerator.service;

import ma.poc.sqli.zynerator.audit.AuditBusinessObjectEnhanced;
import ma.poc.sqli.zynerator.criteria.BaseCriteria;
import ma.poc.sqli.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, CRITERIA extends BaseCriteria, REPO extends AbstractRepository<T, Long>> extends AbstractServiceImpl<T, CRITERIA, REPO> {

    public AbstractReferentielServiceImpl(REPO dao) {
        super(dao);
    }

}
