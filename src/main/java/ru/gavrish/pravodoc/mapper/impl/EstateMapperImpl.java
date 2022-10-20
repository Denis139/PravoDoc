package ru.gavrish.pravodoc.mapper.impl;

import ru.gavrish.pravodoc.mapper.EstateMapper;
import ru.gavrish.pravodoc.model.dto.request.EstateAddRequest;
import ru.gavrish.pravodoc.model.dto.request.EstateUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.EstateView;
import ru.gavrish.pravodoc.model.entity.EstateDisputes;

public class EstateMapperImpl implements EstateMapper {

    @Override
    public EstateDisputes from(EstateAddRequest source) {
        return new EstateDisputes()
                .setName(source.getName())
                .setVariety(source.getVariety())
                .setPrice(source.getPrice());
    }

    @Override
    public EstateView fromRevers(EstateDisputes source) {
        return new EstateView()
                .setId(source.getId())
                .setName(source.getName())
                .setVariety(source.getVariety())
                .setPrice(source.getPrice());
    }

    @Override
    public EstateDisputes merge(EstateDisputes target, EstateUpdateRequest source) {
        return target
                .setName(source.getName() == null? target.getName() : source.getName())
                .setVariety(source.getVariety() == null? target.getVariety() : source.getVariety())
                .setPrice(source.getPrice() == null? target.getPrice() : source.getPrice());
    }
}
