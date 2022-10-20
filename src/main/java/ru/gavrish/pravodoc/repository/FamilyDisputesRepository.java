package ru.gavrish.pravodoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gavrish.pravodoc.model.entity.FamilyDisputes;

import java.util.UUID;

public interface FamilyDisputesRepository extends JpaRepository<FamilyDisputes, UUID> {
}
