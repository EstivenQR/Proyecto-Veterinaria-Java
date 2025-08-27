package ModuloEmpleados;


import ModuloEmpleados.Empleado;
import DBCon.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author EstivenQ
 */
public class Registro extends Conexion{
    
    public void Registar(JTextField TxtNombre, JTextField TxtApellidos, JTextField TxtCedula, JTextField TxtEdad, JTextField TxtSalario, JTextField TxtPLaboral, JTextField TxtCorreo, JTextField TxtTelefono){
       Conexion con=new Conexion();
        Empleado emp=new Empleado();
       
       emp.setNombre(TxtNombre.getText());
       emp.setApellidos(TxtApellidos.getText());
       emp.setCedula(Integer.parseInt(TxtCedula.getText()));
       emp.setEdad(Integer.parseInt(TxtEdad.getText()));
       emp.setSalario(Double.parseDouble(TxtSalario.getText()));
        emp.setPuestoLaboral(TxtPLaboral.getText());
        emp.setCorreo(TxtCorreo.getText());
        emp.setTelefono(Integer.parseInt(TxtTelefono.getText()));
        
        String Usuarios="INSERT INTO Empleados(Nombre,Apellidos,Cedula,Edad,Salario,PuestoLaboral,Correo,Telefono) VALUES(?,?,?,?,?,?,?,?)";
        try{
            
            CallableStatement cs=con.getConnection().prepareCall(Usuarios);
            cs.setString(1, emp.getNombre());
            cs.setString(2, emp.getApellidos());
            cs.setInt(3, emp.getCedula());
            cs.setInt(4, emp.getEdad());
            cs.setDouble(5, emp.getSalario());
            cs.setString(6, emp.getPuestoLaboral());
            cs.setString(7, emp.getCorreo());
            cs.setInt(8, emp.getTelefono());
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Empleado agregado");

        }catch(Exception e){
            System.out.println(e);
          
            
        }
    }
    
}
