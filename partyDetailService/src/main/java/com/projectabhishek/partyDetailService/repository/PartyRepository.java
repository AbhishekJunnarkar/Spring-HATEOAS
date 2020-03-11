package com.projectabhishek.partyDetailService.repository;

import com.projectabhishek.partyDetailService.domain.Party;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Creating new instances
 * <p>
 * Updating existing ones
 * <p>
 * Deleting
 * <p>
 * Finding (one, all, by simple or complex properties)
 */
public interface PartyRepository extends JpaRepository<Party, Long> {

}