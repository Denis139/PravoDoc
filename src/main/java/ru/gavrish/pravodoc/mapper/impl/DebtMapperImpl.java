package ru.gavrish.pravodoc.mapper.impl;

import ru.gavrish.pravodoc.mapper.DebtMapper;
import ru.gavrish.pravodoc.model.dto.request.DebtAddRequest;
import ru.gavrish.pravodoc.model.dto.request.DebtUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.DebtView;
import ru.gavrish.pravodoc.model.entity.DebtDisputes;

public class DebtMapperImpl implements DebtMapper {

    @Override
    public DebtDisputes from(DebtAddRequest source) {
        return new DebtDisputes()
                .setName(source.getName())
                .setVariety(source.getVariety())
                .setPrice(source.getPrice());
    }

    @Override
    public DebtView fromRevers(DebtDisputes source) {
        return new DebtView()
                .setId(source.getId())
                .setName(source.getName())
                .setVariety(source.getVariety())
                .setPrice(source.getPrice());
    }

    @Override
    public DebtDisputes merge(DebtDisputes target, DebtUpdateRequest source) {
        return target
                .setName(source.getName() == null? target.getName() : source.getName())
                .setVariety(source.getVariety() == null? target.getVariety() : source.getVariety())
                .setPrice(source.getPrice() == null? target.getPrice() : source.getPrice());

    }
}
