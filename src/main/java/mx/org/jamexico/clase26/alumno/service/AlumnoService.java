package mx.org.jamexico.clase26.alumno.service;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mx.org.jamexico.clase26.alumno.model.Alumno;
import mx.org.jamexico.clase26.alumno.repository.AlumnoRepository;

@Service
public class AlumnoService {

  @Autowired
  private AlumnoRepository alumnoRepository;

  public Alumno altaAlumno(Alumno alumnoRequest) {
    alumnoRequest.setFechaBaja(null);
    alumnoRequest.setActivo(true);
    Alumno alumnoResponse = alumnoRepository.save(alumnoRequest);
    return alumnoResponse;
  }

  public void borrarAlumno(UUID idreq) {
    alumnoRepository.delete(regresaAlumno(idreq));
  }

  public Alumno actualizaAlumno(UUID idreq, Alumno alumnoRequest) {
    Alumno alumnoBD = regresaAlumno(idreq);
    alumnoBD.setNombre(alumnoRequest.getNombre());
    alumnoBD.setApellidoPaterno(alumnoRequest.getApellidoPaterno());
    alumnoBD.setApellidoMaterno(alumnoRequest.getApellidoMaterno());
    alumnoBD.setCurp(alumnoRequest.getCurp());
    alumnoBD.setFechaNacimiento(alumnoRequest.getFechaNacimiento());
    alumnoBD.setGenero(alumnoRequest.getGenero());
    alumnoBD.setTipoSangre(alumnoRequest.getTipoSangre());

    Alumno alumnoResponse = alumnoRepository.save(alumnoBD);
    return alumnoResponse;
  }

  public Alumno regresaAlumno(UUID idreq) {
    Optional<Alumno> alumnoOptional = alumnoRepository.findById(idreq);
    if (!alumnoOptional.isPresent()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No encontré el registro");
    }
    return alumnoOptional.get();
  }

  public List<Alumno> regresaTodosAlumnos() {
    List<Alumno> alumnos = alumnoRepository.findAll();
    return alumnos;
  }
}
