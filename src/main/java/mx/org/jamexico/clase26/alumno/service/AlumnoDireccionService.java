package mx.org.jamexico.clase26.alumno.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mx.org.jamexico.clase26.alumno.model.Alumno;
import mx.org.jamexico.clase26.alumno.model.Direccion;
import mx.org.jamexico.clase26.alumno.repository.DireccionRepository;
import mx.org.jamexico.clase26.alumno.resource.AlumnoDireccionResource;

@Service
public class AlumnoDireccionService {

  @Autowired
  private DireccionRepository direccionRepository;
  @Autowired
  private AlumnoService alumnoService;

  public AlumnoDireccionResource altaAlumnoDireccion(UUID idAlumno, Direccion direccionReq) {
    Alumno alumno = alumnoService.regresaAlumno(idAlumno);
    direccionReq.setAlumno(alumno);
    Direccion direccion = direccionRepository.save(direccionReq);
    AlumnoDireccionResource response = contruirAlumnoDireccionResource(alumno, direccion);
    return response;
  }

  private AlumnoDireccionResource contruirAlumnoDireccionResource(Alumno alumno, Direccion direccion) {
    AlumnoDireccionResource response = new AlumnoDireccionResource();
    response.setNombre(alumno.getNombre());
    response.setApellidoPaterno(alumno.getApellidoPaterno());
    response.setApellidoMaterno(alumno.getApellidoMaterno());
    response.setCalle(direccion.getCalle());
    response.setColonia(direccion.getColonia());
    response.setNumeroExterior(direccion.getNumeroExterior());
    response.setNumeroInterior(direccion.getNumeroInterior());
    response.setCodigoPostal(direccion.getCodigoPostal());
    response.setMunicipio(direccion.getMunicipio());
    response.setEstado(direccion.getEstado());
    response.setPais(direccion.getPais());
    return response;
  }

  public AlumnoDireccionResource regresaAlumnoDireccion(UUID idAlumno) {
    Alumno alumno = alumnoService.regresaAlumno(idAlumno);
    if (alumno.getDireccion() == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El alumno no tiene dirección");
    }
    Direccion direccion = alumno.getDireccion();
    return contruirAlumnoDireccionResource(alumno, direccion);
  }

}
