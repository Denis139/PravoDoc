package ru.gavrish.pravodoc.mapper.impl;

import ru.gavrish.pravodoc.mapper.InsuranceMapper;
import ru.gavrish.pravodoc.model.dto.request.InsuranceAddRequest;
import ru.gavrish.pravodoc.model.dto.request.InsuranceUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.InsuranceView;
import ru.gavrish.pravodoc.model.entity.InsuranceDisputes;

public class InsuranceMapperImpl implements InsuranceMapper {

    @Override
    public InsuranceDisputes from(InsuranceAddRequest source) {
        return new InsuranceDisputes()
                .setName(source.getName())
                .setVariety(source.getVariety())
                .setPrice(source.getPrice());
    }

    @Override
    public InsuranceView fromRevers(InsuranceDisputes source) {
        return new InsuranceView()
                .setId(source.getId())
                .setName(source.getName())
                .setVariety(source.getVariety())
                .setPrice(source.getPrice());
    }

    @Override
    public InsuranceDisputes merge(InsuranceDisputes target, InsuranceUpdateRequest source) {
        return target
                .setName(source.getName() == null? target.getName() : source.getName())
                .setVariety(source.getVariety() == null? target.getVariety() : source.getVariety())
                .setPrice(source.getPrice() == null? target.getPrice() : source.getPrice());
    }
}
