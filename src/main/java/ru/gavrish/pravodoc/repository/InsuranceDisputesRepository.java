package ru.gavrish.pravodoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gavrish.pravodoc.model.entity.InsuranceDisputes;

import java.util.UUID;

public interface InsuranceDisputesRepository extends JpaRepository<InsuranceDisputes, UUID> {
}
