package inicio.layouts;

import javax.swing.*;

public class Entrada {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //VentanaCard v = new VentanaCard();
                //VentanaGridFlowBorder v = new VentanaGridFlowBorder();
                //VentanaBox v = new VentanaBox();
                //GridBagVentana v = new GridBagVentana();

                GridBagEjemplo v = new GridBagEjemplo();
            }
        });
    }
}
