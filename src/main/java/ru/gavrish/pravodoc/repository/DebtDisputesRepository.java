package ru.gavrish.pravodoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gavrish.pravodoc.model.entity.DebtDisputes;

import java.util.UUID;

public interface DebtDisputesRepository extends JpaRepository<DebtDisputes, UUID> {
}
