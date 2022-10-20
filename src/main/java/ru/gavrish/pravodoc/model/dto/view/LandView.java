package ru.gavrish.pravodoc.model.dto.view;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.gavrish.pravodoc.model.entity.LandEnum;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class LandView {

    private UUID id;

    private String name;

    private LandEnum variety;

    private BigDecimal price;
}
