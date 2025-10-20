/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.MetodosValidacion;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ivanfajardo
 */
public class ValidarUsuario extends KeyAdapter {
    private final JPasswordField contra;
    private final MetodosValidacion valida;

    public ValidarUsuario(JPasswordField casillaContraseña, MetodosValidacion valido) {
        this.contra=casillaContraseña;
        this.valida=valido;
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            JTextField usuario=(JTextField) e.getSource();
            String usu= usuario.getText().trim();

            boolean valido= valida.realizarValidacionUsuario(usu,this.contra);
            
            if(valido){
                contra.setEnabled(true);
                contra.requestFocus();
            }else{
                contra.setEnabled(false);
            }
        }
    }
    
    
    
}
