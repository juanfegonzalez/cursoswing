package inicio.layouts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCard extends JFrame implements ActionListener {

    JPanel pCentral, pSur, pUno, pDos, pTres, pCuatro;
    JButton boton1, boton2, boton3, boton4;
    Container container;
    CardLayout cardLayout;

    public VentanaCard() throws HeadlessException {
        instancias();
        initGUI();
        acciones();
    }

    private void acciones() {
        Component[] components = pSur.getComponents();
        for (Component c:components) {
            if (c.getClass()==JButton.class) {
                ((JButton) c).addActionListener(this);
            }
        }
    }

    private void instancias() {
        cardLayout = new CardLayout();
        pCentral = new JPanel();
        pSur = new JPanel();
        pUno = new JPanel();
        pUno.setBackground(Color.BLACK);
        pDos = new JPanel();
        pDos.setBackground(Color.GREEN);
        pTres = new JPanel();
        pTres.setBackground(Color.RED);
        pCuatro = new JPanel();
        pCuatro.setBackground(Color.YELLOW);
        boton1 = new JButton("Panel 1");
        boton2 = new JButton("Panel 2");
        boton3 = new JButton("Panel 3");
        boton4 = new JButton("Panel 4");
        container = getContentPane();
    }

    private void initGUI() {

        //deshabilitar un boton
        boton4.setEnabled(false);
        // poner un tooltip al elemento
        boton4.setToolTipText("Esto es un ejemplo de tooltip");
        container.add(configPanelSur(),BorderLayout.SOUTH);
        container.add(configPanelCentral(),BorderLayout.CENTER);
        setVisible(true);
        setTitle("Configuracion CardLayout");
        setLocationRelativeTo(null);
        pack();
    }

    public JPanel configPanelSur() {
        pSur.setLayout(new GridLayout(1, 4, 10, 10));
        pSur.add(boton1);
        pSur.add(boton2);
        pSur.add(boton3);
        pSur.add(boton4);
        return pSur;
    }

    public JPanel configPanelCentral(){
        pCentral.setLayout(cardLayout);
        pCentral.add(pUno,"panel1");
        pCentral.add(pDos,"panel2");
        pCentral.add(pTres,"panel3");
        pCentral.add(pCuatro,"panel4");
        //((CardLayout)pCentral.getLayout())
        cardLayout.show(pCentral,"panel4");
        cardLayout.setHgap(20);
        cardLayout.setVgap(20);
        return pCentral;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tag = null;
        Component[] components = pCentral.getComponents();
        if (e.getSource() == boton1) {
            //tag = "panel1";
            // mostar panel anterior
            // cardLayout.previous(pCentral);
            // evaluar si un panel está mostrandose
            System.out.println(pUno.isShowing());
            JPanel panel = (JPanel) components[0];
            panel.isShowing();
        }
         else if (e.getSource() == boton2){
            //tag = "panel2";
            // mostar panel siguiente
            // cardLayout.next(pCentral);
            // evaluar si un panel está mostrandose
            System.out.println(pCuatro.isShowing());
            JPanel panel = (JPanel) components[components.length-1];
            panel.isShowing();
            panel.getClass().getSimpleName();

        } else if (e.getSource() == boton3){
            tag = "panel3";
            cardLayout.first(pCentral);
        } else if (e.getSource() == boton4){
            tag = "panel4";
            cardLayout.last(pCentral);

        }
        cardLayout.show(pCentral,tag);
    }
}
