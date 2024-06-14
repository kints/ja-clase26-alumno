package mx.org.jamexico.clase26.alumno.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mx.org.jamexico.clase26.alumno.model.Direccion;
import mx.org.jamexico.clase26.alumno.resource.AlumnoDireccionResource;
import mx.org.jamexico.clase26.alumno.service.AlumnoDireccionService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/alumnoDireccion/")
public class AlumnoDireccionController {

  @Autowired
  private AlumnoDireccionService alumnoDireccionService;

  @PostMapping("alta/{idAlumno}")
  public ResponseEntity<AlumnoDireccionResource> altaDireccionAlumno(@PathVariable UUID idAlumno,
      @RequestBody Direccion direccion) {
    AlumnoDireccionResource alumnoDireccionResource = alumnoDireccionService.altaAlumnoDireccion(idAlumno, direccion);
    return ResponseEntity.ok(alumnoDireccionResource);
  }

  @GetMapping("encuentra/{idAlumno}")
  public ResponseEntity<AlumnoDireccionResource> regresaAlumnoDireccion(@PathVariable UUID idAlumno) {
    return ResponseEntity.ok(alumnoDireccionService.regresaAlumnoDireccion(idAlumno));
  }

}
