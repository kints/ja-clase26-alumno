package mx.org.jamexico.clase26.alumno.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import mx.org.jamexico.clase26.alumno.model.Alumno;
import mx.org.jamexico.clase26.alumno.service.AlumnoService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

  @Autowired
  AlumnoService alumnoService;

  @GetMapping("/{id}")
  public ResponseEntity<Alumno> regresaAlumno(@PathVariable UUID id) {
    return ResponseEntity.ok(alumnoService.regresaAlumno(id));
  }

  @GetMapping("todos/")
  public ResponseEntity<List<Alumno>> regresaTodosAlumnos() {
    if (alumnoService.regresaTodosAlumnos().isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
    return ResponseEntity.ok().body(alumnoService.regresaTodosAlumnos());
  }

  @PostMapping("/alta")
  public ResponseEntity<Alumno> altaAlumno(@RequestBody Alumno alumnoRequest) {
    return ResponseEntity.ok(alumnoService.altaAlumno(alumnoRequest));
  }

  // jamexico.org.mx/alumno/654654-654654-654654-654654 PathVariable
  // jamexico.org.mx/alumno?id=34523452345-23452345-2345&sortby=ASC&fechaNacimiento=2024-05-05
  @PutMapping("actualiza/{id}")
  public ResponseEntity<Alumno> actualizaAlumno(@PathVariable UUID id,
      @RequestBody Alumno alumnoReq) {
    return ResponseEntity.ok(alumnoService.actualizaAlumno(id, alumnoReq));
  }

  @DeleteMapping("borrar/{id}")
  public ResponseEntity<?> borrarAlumno(@PathVariable UUID id) {
    alumnoService.borrarAlumno(id);
    return ResponseEntity.noContent().build();
  }

}
