package team.bahor.service.base;

import team.bahor.mapper.base.BaseGenericMapper;
import team.bahor.repository.base.BaseGenericRepository;
import team.bahor.validator.base.BaseGenericValidator;

public abstract class AbstractService<
        R extends BaseGenericRepository,
        M extends BaseGenericMapper,
        V extends BaseGenericValidator
        > implements BaseGenericService {

    protected final M mapper;
    protected final V validator;
    protected final R repository;

    protected AbstractService(M mapper, V validator, R repository) {
        this.mapper = mapper;
        this.validator = validator;
        this.repository = repository;
    }
}
