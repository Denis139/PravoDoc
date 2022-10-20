package ru.gavrish.pravodoc.mapper.impl;

import ru.gavrish.pravodoc.mapper.LandMapper;
import ru.gavrish.pravodoc.model.dto.request.LandAddRequest;
import ru.gavrish.pravodoc.model.dto.request.LandUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.LandView;
import ru.gavrish.pravodoc.model.entity.LandDisputes;

public class LandMapperImpl implements LandMapper {

    @Override
    public LandDisputes from(LandAddRequest source) {
        return new LandDisputes()
                .setName(source.getName())
                .setVariety(source.getVariety())
                .setPrice(source.getPrice());
    }

    @Override
    public LandView fromRevers(LandDisputes source) {
        return new LandView()
                .setId(source.getId())
                .setName(source.getName())
                .setVariety(source.getVariety())
                .setPrice(source.getPrice());
    }

    @Override
    public LandDisputes merge(LandDisputes target, LandUpdateRequest source) {
        return target
                .setName(source.getName() == null? target.getName() : source.getName())
                .setVariety(source.getVariety() == null? target.getVariety() : source.getVariety())
                .setPrice(source.getPrice() == null? target.getPrice() : source.getPrice());
    }
}
