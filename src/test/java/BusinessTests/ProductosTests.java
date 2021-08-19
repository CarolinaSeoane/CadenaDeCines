package BusinessTests;

import Resources.TestResources;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/* Precios cargados en los tests:

                      | GASEOSAS | POCHOCLOS | NACHOS              |           COMBO 1          |         |           COMBO 2          |         |           COMBO 3          |
            ..........................................             | ...........................|         | ...........................|         | ...........................|
            CHICO     |          |   $300    |                     | 1 Pochoclo grande     $550 |         | 1 Pochoclo chico      $300 |         | 1 Pochoclo grande     $550 |
            MEDIANO   |          |           | $400                | 1 Gaseosa grande      $300 |         | 1 Nachos medianos     $400 |         | 2 Gaseosa grande      $600 |
            GRANDE    |  $300    |   $550    |                     | - Descuento        -$127,5 |         | 1 Gaseosa grande      $300 |         | - Descuento        -$172.5 |
                                                                   |............................|         | - Descuento          -$150 |         | ...........................|
                                                                   | TOTAL: $723                |         | ...........................|         | TOTAL: $978                |
                                                                                                          | TOTAL: $850                |

    Recordar que se redondea al mayor
*/

public class ProductosTests extends TestResources {

    @Before
    public void inicializar() {
        this.inicializarProductos();
        this.inicializarCadena();
    }

    @Test
    public void elCombo1Vale723() {
        Assert.assertEquals(723, combo1.getPrecio());
    }

    @Test
    public void elCombo2Vale850() {
        Assert.assertEquals(850, combo2.getPrecio());
    }

    @Test
    public void elCombo3Vale978() {
        Assert.assertEquals(978, combo3.getPrecio());
    }
}
