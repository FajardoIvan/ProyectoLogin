package Modelo;

import Vista.PanelLogin;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author ivanfajardo
 */
public class MetodosValidacion {
    
    private PanelLogin login;
    private static final Pattern letraMayuscula = Pattern.compile(".*[A-Z].*");
    private static final Pattern letraMinuscula = Pattern.compile(".*[a-z].*");
    private static final Pattern numero = Pattern.compile(".*[0-9].*");
    private static final Pattern caracterEspecial = Pattern.compile(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");

    
    public MetodosValidacion(PanelLogin login2){
        this.login=login2;
    }
    
    /////////////////////////////////////////////METODOS/////////////////////////////////////////////////////////////////////

    public Boolean validarUsuario(String usuario){ //Metodo que valida si el usuario cumple con los requisitos
         return usuario != null && usuario.length() >= 8 && usuario.length() <= 20 && letraMayuscula.matcher(usuario).matches();
        
    }
    
      public boolean realizarValidacion() {
              String usuario = login.getUsuario();
              String password = login.getContrasena();
              StringBuilder erroresUsuario = new StringBuilder();
        
        
// Validación de Longitud
        if (usuario.length() < 8 || usuario.length() > 20) {
            erroresUsuario.append("- Debe tener entre 8 y 20 caracteres.\n");
        }
        
        // Validación de Mayúscula
        if (!letraMayuscula.matcher(usuario).matches()) {
            erroresUsuario.append("- Debe contener al menos una letra mayúscula.\n");
        }

        if (erroresUsuario.length() > 0) {
            JOptionPane.showMessageDialog(login, 
                "El usuario presenta los siguientes errores:\n" + erroresUsuario.toString(), 
                "Error en Usuario", JOptionPane.ERROR_MESSAGE);
            return false;
        }
      
      // --- VALIDACIÓN DETALLADA DE LA CONTRASEÑA ---

        StringBuilder erroresPassword = new StringBuilder();
        
        // Validación de Longitud (Mínimo 8)
        if (password.length() < 8) {
             erroresPassword.append("- Debe tener al menos 8 caracteres.\n");
        }
        
        // Validación de Mayúscula
        if (!letraMayuscula.matcher(password).matches()) {
            erroresPassword.append("- Debe contener al menos una mayúscula.\n");
        }
        
        // Validación de Minúscula
        if (!letraMinuscula.matcher(password).matches()) {
            erroresPassword.append("- Debe contener al menos una minúscula.\n");
        }
        
        // Validación de Dígito
        if (!numero.matcher(password).matches()) {
            erroresPassword.append("- Debe contener al menos un dígito numérico.\n");
        }
        
        // Validación de Carácter Especial
        if (!caracterEspecial.matcher(password).matches()) {
            erroresPassword.append("- Debe contener al menos un carácter especial.\n");
        }

        if (erroresPassword.length() > 0) {
            JOptionPane.showMessageDialog(login, 
                "La contraseña presenta los siguientes errores:\n" + erroresPassword.toString(), 
                "Error en Contraseña", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // --- LÓGICA DE ÉXITO Y TRANSFERENCIA ---
        //login.setInsertarUsuarioEnContraseña(usuario);
        
        JOptionPane.showMessageDialog(login, 
         "¡Credenciales válidas! Acceso concedido.");
        return true;
      }
      
        
}