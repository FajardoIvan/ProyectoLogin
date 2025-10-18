
package Vista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPasswordField;

/**
 *
 * @author ivanfajardo
 */
public class ActionMostrarPassword extends MouseAdapter {
    
    private JPasswordField password;
    PanelLogin login= new PanelLogin();

    public ActionMostrarPassword(JPasswordField casillaContraseña) {
        this.password=casillaContraseña;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        password.setEchoChar((char)0);
        
    }

  
    @Override
    public void mouseReleased(MouseEvent e) {
        password.setEchoChar('*');
    }
}
