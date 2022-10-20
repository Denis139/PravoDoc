package ru.gavrish.pravodoc.model.dto.view;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.gavrish.pravodoc.model.entity.DebtEnum;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class DebtView {

    private UUID id;

    private String name;

    private DebtEnum variety;

    private BigDecimal price;
}
