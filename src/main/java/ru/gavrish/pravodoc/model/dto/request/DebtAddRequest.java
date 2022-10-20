package ru.gavrish.pravodoc.model.dto.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;
import ru.gavrish.pravodoc.model.entity.DebtEnum;
import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class DebtAddRequest {

    @NotBlank(message = "Field [name] must be present")
    private String name;

    @javax.validation.constraints.NotNull(message = "Field [price] mustn't be null")
    private DebtEnum variety;

    @javax.validation.constraints.NotNull(message = "Field [price] mustn't be null")
    private BigDecimal price;
}
