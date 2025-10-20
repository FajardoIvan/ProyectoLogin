
package Controlador;

import Vista.PanelLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;

/**
 *
 * @author ivanfajardo
 */
public class ActionMostrarPassword extends MouseAdapter {
    
    private JPasswordField password;
    private JButton boton;
    private Boolean visible=false;
    private final ImageIcon iconoUno;
    private final ImageIcon iconoDos;
    
    public ActionMostrarPassword(JPasswordField casillaContraseña, JButton ojito) {
        this.password=casillaContraseña;
        this.boton= ojito;
        iconoUno = new ImageIcon(getClass().getResource("/Vista/imagenes/1.1.jpg"));
        iconoDos = new ImageIcon(getClass().getResource("/Vista/imagenes/2.2.jpg"));
    }

        
     @Override
    public void mousePressed(MouseEvent e) {
        
        password.setEchoChar((char)0);
        boton.setIcon(iconoDos);
        
    }

  
    @Override
    public void mouseReleased(MouseEvent e) {
        password.setEchoChar('*');
         boton.setIcon(iconoUno);
    }
}
