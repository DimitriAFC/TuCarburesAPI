package com.company.TuCarbures.Repositories;

import com.company.TuCarbures.GasStation;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface GasStationRepository extends CrudRepository<GasStation, String> {
}
