package Business;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Combo implements Producto {

    private List<Producto> productos;

}
