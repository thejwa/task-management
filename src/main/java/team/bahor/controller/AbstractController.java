package team.bahor.controller;

import team.bahor.service.base.BaseGenericService;

public abstract class AbstractController<S extends BaseGenericService> {
    protected final S service;


    public AbstractController(S service) {
        this.service = service;
    }
}
