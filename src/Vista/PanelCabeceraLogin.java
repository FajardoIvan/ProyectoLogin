package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ivanfajardo
 */
public class PanelCabeceraLogin extends JPanel{
    
    public PanelCabeceraLogin(){
        CrearCabecera();        
    }
    
    public void CrearCabecera(){
       JPanel  panelCabecera = new JPanel();
        Dimension panelSize=new Dimension(520,140);
        setMaximumSize(panelSize);
        setPreferredSize(panelSize);
       panelCabecera.setBackground(new Color(230,240,255));
       
       JLabel bienvenido= new JLabel("¡¡Bienvenido!!");
       bienvenido.setFont(new Font("Arial", Font.BOLD,24));// Esta Linea Establece La Fuente, la pone en negrita y le da un tamaño de 24
       panelCabecera.add(bienvenido);
       add(panelCabecera);
       
    }
    
}
