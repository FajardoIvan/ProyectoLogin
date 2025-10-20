package Vista;

import Controlador.ValidarUsuario;
import Controlador.ActionMostrarPassword;
import Controlador.ActionIniciarSecion;
import Modelo.MetodosValidacion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author ivanfajardo
 */
public class PanelLogin extends JPanel{
    
    JTextField casillaUsuario;
    JPasswordField casillaContraseña;
    PanelLogin thisPanel=this;
    MetodosValidacion valida = new MetodosValidacion(thisPanel);
   
    
    public PanelLogin(){
        casillaContraseña= new JPasswordField();
        crearComponentes();
        
        
    }
    
    public void crearComponentes(){
        
        setBorder(new EmptyBorder(20,50,20,50));
        Dimension panelSize=new Dimension(480,540);
        setMaximumSize(panelSize);
        setPreferredSize(panelSize);
        setBackground(Color.WHITE);
    
///////////////////////////////////////////////////USUARIO/////////////////////////////////////////////////////////////////////
    
        JPanel pUsuario = new JPanel();
        JPanel pcasillaUsuario= new JPanel();
        
        pUsuario.setLayout(new BorderLayout());
        pUsuario.setBackground(Color.WHITE);
                
        JLabel usuario = new JLabel("Usuario:");
        usuario.setBorder(new EmptyBorder(10,0,10,0));
                
        casillaUsuario= new JTextField();
        casillaUsuario.setBorder(null);
        casillaUsuario.setPreferredSize(new Dimension(400,20));
        casillaUsuario.setMaximumSize(new Dimension(400,20));
        casillaUsuario.addKeyListener(new ValidarUsuario(casillaContraseña,valida));
        
        pcasillaUsuario.add(casillaUsuario);
        pcasillaUsuario.setPreferredSize(new Dimension(400,24));
        pcasillaUsuario.setMaximumSize(new Dimension(400,24));
        pcasillaUsuario.setBackground(Color.WHITE);
        pUsuario.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.DARK_GRAY));
        
        pUsuario.add(usuario,BorderLayout.NORTH);
        pUsuario.add(pcasillaUsuario,BorderLayout.CENTER);
        add(pUsuario);
        
////////////////////////////////////////////////////CONTRASEÑA/////////////////////////////////////////////////////////////////           
        
        JPanel pContraseña = new JPanel();
        pContraseña.setLayout(new BorderLayout());        
        pContraseña.setBackground(Color.WHITE);
        
        Dimension tama= new Dimension(400,48);
        Dimension tama2= new Dimension(360,20);
        
        JLabel labelContraseña = new JLabel("Contraseña:");    
        labelContraseña.setBorder(new EmptyBorder(10,0,10,0));
        
        //casillaContraseña= new JPasswordField();
        casillaContraseña.setPreferredSize(tama2);
        casillaContraseña.setMaximumSize(tama2);
        casillaContraseña.setBorder(null);
        casillaContraseña.setEnabled(false);
        
        ImageIcon iconoUno = new ImageIcon(getClass().getResource("/Vista/imagenes/1.1.jpg"));
        JButton ojito= new JButton(iconoUno);
        ojito.setPreferredSize(new Dimension(32,30));
        ojito.setFont(new Font("Segoe UI Emoji", Font.PLAIN,16));
        ojito.setMargin(new Insets(2,2,2,2));
        ojito.setFocusable(false);        
        ojito.setBorderPainted(false);
        ojito.setContentAreaFilled(false);
        ojito.addMouseListener(new ActionMostrarPassword(casillaContraseña, ojito));
                
        JPanel pojo= new JPanel();
        pojo.setLayout(new BorderLayout(0,0));
        pojo.setBackground(Color.WHITE);
        pojo.add(casillaContraseña, BorderLayout.WEST);
        pojo.add(ojito, BorderLayout.EAST);
        pojo.setPreferredSize(new Dimension(400,26));
        pojo.setMaximumSize(new Dimension(400,26));
        pojo.setBackground(Color.WHITE);
        pojo.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.DARK_GRAY));
        
        pContraseña.add(labelContraseña,BorderLayout.NORTH);
        pContraseña.add(pojo,BorderLayout.CENTER);
        add(pContraseña);
        
        JPanel panelBot= new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
        panelBot.setBorder(new EmptyBorder(20,0,0,0));
        panelBot.setBackground(Color.WHITE);
        
        JButton boton= new JButton("Iniciar Sesion");
        boton.setBackground(Color.BLUE);
        boton.setForeground(Color.BLACK);
        boton.setPreferredSize(new Dimension(260,40));
        boton.setMaximumSize(new Dimension(260,40));
        boton.setBackground(new Color(51,153,255));
        boton.setForeground(Color.WHITE);
        panelBot.add(boton);
        add(panelBot);
        valida = new MetodosValidacion(this);
        boton.addActionListener(new ActionIniciarSecion(this,valida));
        
        JLabel olvido= new JLabel("<html>Olvidaste la Contraseña? </html>");
        olvido.setBorder(new EmptyBorder(20,0,0,0));
        olvido.setForeground(Color.BLACK);
        olvido.setCursor(new Cursor(Cursor.HAND_CURSOR));
        olvido.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(olvido);
        add(Box.createVerticalGlue());
    }
    
    /////////////////////////////////////////METODOS////////////////////////////////
    
    public void setUsuario(String Usuario){
        casillaUsuario.setText(Usuario);
    }
    
    public String getUsuario(){
        return casillaUsuario.getText();
    }
    
        
    public void setContrasena(String contra){
        casillaContraseña.setText(contra);
    }
    
    public String getContrasena(){
        char[] passwordChar=casillaContraseña.getPassword();
        String contra = new String(passwordChar);
        return contra;
    }
    
    public JPasswordField getcasContraseña(){
        return casillaContraseña;
        
    }
    
}
        