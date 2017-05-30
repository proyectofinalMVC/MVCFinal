package org.foobarspam.proyectofinal.repository;

import org.foobarspam.proyectofinal.model.Conductor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by palliser on 27/05/2017.
 */
@Repository
public interface ConductorRepository extends CrudRepository<Conductor, Long> {

	Conductor findFirstByOcupado(Boolean ocupado);
}
