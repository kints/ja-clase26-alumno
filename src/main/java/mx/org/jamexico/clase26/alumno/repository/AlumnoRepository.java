package mx.org.jamexico.clase26.alumno.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.org.jamexico.clase26.alumno.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, UUID> {

}
