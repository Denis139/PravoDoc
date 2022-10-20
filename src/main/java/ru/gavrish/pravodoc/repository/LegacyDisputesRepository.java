package ru.gavrish.pravodoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gavrish.pravodoc.model.entity.LegacyDisputes;

import java.util.UUID;

public interface LegacyDisputesRepository extends JpaRepository<LegacyDisputes, UUID> {
}
