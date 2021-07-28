package Business;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class Sala {

    private List<Asiento> asientos;

}
