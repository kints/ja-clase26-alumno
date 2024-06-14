package mx.org.jamexico.clase26.alumno.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.org.jamexico.clase26.alumno.model.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, UUID> {

}
