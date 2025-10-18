package Controlador;

import Modelo.MetodosValidacion;
import Vista.PanelLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author ivanfajardo
 */
public class ActionIniciarSecion implements ActionListener {

    private PanelLogin login;
    private MetodosValidacion validador;

    public ActionIniciarSecion(PanelLogin iniciar, MetodosValidacion validando) {
        this.login=iniciar;
        this.validador=validando;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (validador.realizarValidacion()){
           JOptionPane.showMessageDialog(login,"Validacion Exitosa");
        } 
        
        
    }
    
}
