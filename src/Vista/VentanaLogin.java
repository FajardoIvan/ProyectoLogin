package Vista;

import Modelo.MetodosValidacion;
import Vista.PanelLogin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author ivanfajardo
 */
public class VentanaLogin extends JFrame{
      
    //MetodosValidacion validar;
    private PanelLogin login;
    
    public VentanaLogin(){
        setTitle("Login");
        setSize(520,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        CrearVentana();
        setVisible(true);
        MetodosValidacion validar =new MetodosValidacion(login);
    }
    
    public void CrearVentana(){
        PanelCabeceraLogin cabecera= new PanelCabeceraLogin();
        login= new PanelLogin();
        
        
       JPanel  panelPrincipal = new JPanel();
       panelPrincipal.setPreferredSize(new Dimension (510,590));
       panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
       panelPrincipal.setBackground(Color.WHITE);
       
       JPanel  panelArriba = new JPanel();
       panelArriba.setMaximumSize(new Dimension (520,140));
       panelArriba.setBackground(new Color(230,240,255));
       panelArriba.add(cabecera);
       panelPrincipal.add(panelArriba);
       
       
       JPanel  panelMed = new JPanel();
       panelMed.setPreferredSize(new Dimension (500,560));
       panelMed.setMaximumSize(new Dimension (500,560));
       panelMed.setBackground(Color.WHITE);
       panelMed.add(login);
       panelPrincipal.add(panelMed);
       
       JPanel  panelAbajo = new JPanel();
       panelAbajo.setLayout(new FlowLayout(FlowLayout.CENTER));
       panelAbajo.setBackground(new Color(245,245,245));
       panelAbajo.setBorder(new EmptyBorder(30,0,0,0));
       JLabel elaborado = new JLabel("<html><p>2025 Elaborado por Ivan Fajardo</p></html>");
       
       elaborado.setForeground(Color.DARK_GRAY);
       panelAbajo.add(elaborado);
       panelPrincipal.add(panelAbajo, BorderLayout.SOUTH);
       
       setContentPane(panelPrincipal);
       
       
     }
    
    
}
