/*Kellen Haas
  CPSC 2150
  Lab12
  11/20/20
 */


/*No contracts necessary*/

package cpsc2150.mortgages;

import java.util.*;
import java.lang.*;

public class MortgageApp {

    public static void main(String [] args)
    {
        IMortgageView view = new MortgageView();
        IMortgageController controller = new MortgageController(view);
        view.setController(controller);
    }
}
