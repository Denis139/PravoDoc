package ru.gavrish.pravodoc.mapper.impl;

import ru.gavrish.pravodoc.mapper.FamilyMapper;
import ru.gavrish.pravodoc.model.dto.request.FamilyAddRequest;
import ru.gavrish.pravodoc.model.dto.request.FamilyUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.FamilyView;
import ru.gavrish.pravodoc.model.entity.FamilyDisputes;

public class FamilyMapperImpl implements FamilyMapper {

    @Override
    public FamilyDisputes from(FamilyAddRequest source) {
        return new FamilyDisputes()
                .setName(source.getName())
                .setVariable(source.getVariety())
                .setPrice(source.getPrice());
    }

    @Override
    public FamilyView fromRevers(FamilyDisputes source) {
        return new FamilyView()
                .setId(source.getId())
                .setName(source.getName())
                .setVariety(source.getVariable())
                .setPrice(source.getPrice());
    }

    @Override
    public FamilyDisputes merge(FamilyDisputes target, FamilyUpdateRequest source) {
        return target
                .setName(source.getName() == null? target.getName() : source.getName())
                .setVariable(source.getVariety() == null? target.getVariable() : source.getVariety())
                .setName(source.getName() == null? target.getName() : source.getName());
    }
}