package Business;

import Security.Administrador;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Cine {

    private String nombre;
    private String direccion;
    private List<Administrador> administradores;
    private Map<Sala,List<Funcion>> funciones;

}
