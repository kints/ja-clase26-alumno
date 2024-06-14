package mx.org.jamexico.clase26.alumno.resource;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AlumnoDireccionResource {
  private String nombre;
  private String apellidoPaterno;
  private String apellidoMaterno;
  private String calle;
  private String numeroExterior;
  private String numeroInterior;
  private String colonia;
  private String municipio;
  private String estado;
  private String pais;
  private String codigoPostal;
}
