package sbtl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sbtl.model.Uebung;

@Repository
public interface FitRepository extends CrudRepository<Uebung, Long> {

}
