package ru.gavrish.pravodoc.model.entity;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode()
@TypeDef(name = "pgsql_enum", typeClass = PostgreSQLEnumType.class)
@Table(name = "debt_disputes")
public class DebtDisputes extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Type(type = "pgsql_enum")
    @Enumerated(value = EnumType.STRING)
    @Column(name = "variety", nullable = false)
    private DebtEnum variety;

    @Column(name = "price", nullable = false)
    private BigDecimal price;
}
