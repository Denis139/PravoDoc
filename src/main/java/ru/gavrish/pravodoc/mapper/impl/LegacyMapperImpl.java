package ru.gavrish.pravodoc.mapper.impl;

import ru.gavrish.pravodoc.mapper.LegacyMapper;
import ru.gavrish.pravodoc.model.dto.request.LegacyAddRequest;
import ru.gavrish.pravodoc.model.dto.request.LegacyUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.LegacyView;
import ru.gavrish.pravodoc.model.entity.LegacyDisputes;

public class LegacyMapperImpl implements LegacyMapper {

    @Override
    public LegacyDisputes from(LegacyAddRequest source) {
        return new LegacyDisputes()
                .setName(source.getName())
                .setVariety(source.getVariety())
                .setPrice(source.getPrice());
    }

    @Override
    public LegacyView fromRevers(LegacyDisputes source) {
        return new LegacyView()
                .setId(source.getId())
                .setName(source.getName())
                .setVariety(source.getVariety())
                .setPrice(source.getPrice());
    }

    @Override
    public LegacyDisputes merge(LegacyDisputes target, LegacyUpdateRequest source) {
        return target
                .setName(source.getName() == null? target.getName() : source.getName())
                .setVariety(source.getVariety() == null? target.getVariety() : source.getVariety())
                .setPrice(source.getPrice() == null? target.getPrice() : source.getPrice());
    }
}
