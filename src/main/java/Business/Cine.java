package Business;

import Security.Administrador;
import Security.Usuario;
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

/*
    public Reserva comprarEntradas(Usuario usr, Funcion funcion, List<Asiento> asientos, List<Producto> productos) {
        float precioAsientos = funcion.comprarAsientos(asientos);

        return reserva;
    }
*/


}
