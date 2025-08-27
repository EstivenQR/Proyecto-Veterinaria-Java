
package veterinariaislademello;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import DBCon.Conexion;

public class Registro {
    
    public void Registar(JTextField txtnombre,JTextField txtcedula, JTextField txtdireccion, JTextField txttelefono, JTextField txtcorreo, JTextField txtmascota){
        
        Conexion con = new Conexion();
        Cliente cli = new Cliente();
    
        cli.setNombre(txtnombre.getText());
        cli.setCedula(txtcedula.getText());
        cli.setDireccion(txtdireccion.getText());
        cli.setTelefono(txttelefono.getText());
        cli.setCorreo(txtcorreo.getText());
        cli.setMascota(txtmascota.getText());
    
        String Usuario= "INSERT INTO clientes(Nombre, Cedula, Direccion, Telefono, Correo, Mascota) VALUES(?,?,?,?,?,?)";
        
        try{
           CallableStatement cs=con.getConnection().prepareCall(Usuario);
            cs.setString(1, cli.getNombre());
             cs.setString(2, cli.getCedula());
              cs.setString(3, cli.getDireccion());
               cs.setString(4, cli.getTelefono());
                cs.setString(5, cli.getCorreo());
                 cs.setString(6, cli.getMascota());
                  cs.execute();
        }catch(Exception e){
            System.out.println(e);
        
        }
    }
}
