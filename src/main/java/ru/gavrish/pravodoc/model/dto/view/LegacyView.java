package ru.gavrish.pravodoc.model.dto.view;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.gavrish.pravodoc.model.entity.LegacyEnum;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class LegacyView {

    private UUID id;

    private String name;

    private LegacyEnum variety;

    private BigDecimal price;
}
