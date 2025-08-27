package ModuloEmpleados;


import DBCon.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author EstivenQ
 */
public class Editar {

    public void MostarEmpleados(JTable TablaEmpleados) {

        String Busc = "select * from Empleados";
        Statement st;
        Conexion objconexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Cedula");
        modelo.addColumn("Edad");
        modelo.addColumn("Salario");
        modelo.addColumn("Puesto Laboral");
        modelo.addColumn("Correo");
        modelo.addColumn("Telefono");
        TablaEmpleados.setModel(modelo);
        String[] Datos = new String[8];

        try {
            st = objconexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(Busc);

            while (rs.next()) {
                Datos[0] = rs.getString(1);
                Datos[1] = rs.getString(2);
                Datos[2] = rs.getString(3);
                Datos[3] = rs.getString(4);
                Datos[4] = rs.getString(5);
                Datos[5] = rs.getString(6);
                Datos[6] = rs.getString(7);
                Datos[7] = rs.getString(8);
                modelo.addRow(Datos);

            }//fin del while

            TablaEmpleados.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }

    }

    public void SeleccionEmpleados(JTable TablaEmpleados, JTextField TxtNombre, JTextField TxtApellidos, JTextField TxtCedula, JTextField TxtEdad, JTextField TxtSalario, JTextField TxtPLaboral, JTextField TxtCorreo, JTextField TxtTelefono) {

        try {
            int fila = TablaEmpleados.getSelectedRow();
            if (fila >= 0) {

                TxtNombre.setText(TablaEmpleados.getValueAt(fila, 0).toString());
                TxtApellidos.setText(TablaEmpleados.getValueAt(fila, 1).toString());
                TxtCedula.setText(TablaEmpleados.getValueAt(fila, 2).toString());
                TxtEdad.setText(TablaEmpleados.getValueAt(fila, 3).toString());
                TxtSalario.setText(TablaEmpleados.getValueAt(fila, 4).toString());
                TxtPLaboral.setText(TablaEmpleados.getValueAt(fila, 5).toString());
                TxtCorreo.setText(TablaEmpleados.getValueAt(fila, 6).toString());
                TxtTelefono.setText(TablaEmpleados.getValueAt(fila, 7).toString());

            } else {
                JOptionPane.showMessageDialog(null, "Empleado no seleccionado");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la seleccion");
        }
    }

    public void ModificarEmpleado(JTextField TxtNombre, JTextField TxtApellidos, JTextField TxtCedula, JTextField TxtEdad, JTextField TxtSalario, JTextField TxtPLaboral, JTextField TxtCorreo, JTextField TxtTelefono) {
        Conexion con = new Conexion();
        Connection cn = Conexion.getConnection();
        try {
            PreparedStatement ps = cn.prepareStatement("UPDATE Empleados Set Nombre='" + TxtNombre.getText() + " ',empleados.Apellidos='" + TxtApellidos.getText()+ " ',empleados.Edad='" + TxtEdad.getText() + " ',empleados.Salario='" + TxtSalario.getText() + " ',empleados.PuestoLaboral='" + TxtPLaboral.getText() + " ',empleados.Correo='" + TxtCorreo.getText() + " ',empleados.Telefono='" + TxtTelefono.getText() + " ' where empleados.Cedula='" + TxtCedula.getText() + "'");
            int indice = ps.executeUpdate();
            if (indice > 0) {
                JOptionPane.showMessageDialog(null, "Datos actualizados");
            } else {
                JOptionPane.showMessageDialog(null,"Selecione un empleado" );
            }
        } catch (SQLException e) {
            System.out.println(e);

        }

    }

    public void BuscarCed(JTextField BuscCed, JTextField TxtNombre, JTextField TxtApellidos, JTextField TxtCedula, JTextField TxtEdad, JTextField TxtSalario, JTextField TxtPLaboral, JTextField TxtCorreo, JTextField TxtTelefono) {

        String Consulta = "select Nombre,Apellidos,Cedula,Edad,Salario,PuestoLaboral,Correo,Telefono From Empleados Where Empleados.Cedula=(?) ";

        Conexion conexion = new Conexion();

        try {
            java.sql.CallableStatement cs = conexion.getConnection().prepareCall(Consulta);

            cs.setString(1, BuscCed.getText());
            cs.execute();

            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Empleado encontrado");
                TxtNombre.setText(rs.getString("Nombre"));
                TxtApellidos.setText(rs.getString("Apellidos"));
                TxtCedula.setText(rs.getString("Cedula"));
                TxtEdad.setText(rs.getString("Edad"));
                TxtSalario.setText(rs.getString("Salario"));
                TxtPLaboral.setText(rs.getString("PuestoLaboral"));
                TxtCorreo.setText(rs.getString("Correo"));
                TxtTelefono.setText(rs.getString("Telefono"));

            } else {
                JOptionPane.showMessageDialog(null, "Empleado no encotrado");
                TxtNombre.setText(rs.getString(" "));
                TxtApellidos.setText(rs.getString(" "));
                TxtCedula.setText(rs.getString(" "));
                TxtEdad.setText(rs.getString(" "));
                TxtSalario.setText(rs.getString(" "));
                TxtPLaboral.setText(rs.getString(" "));
                TxtCorreo.setText(rs.getString(" "));
                TxtTelefono.setText(rs.getString(" "));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar la base de datos");

        }

    }

    public void eliminar(JTextField TxtCedula) {
        Conexion con = new Conexion();
        Connection cn = Conexion.getConnection();

        try {
            PreparedStatement ps = cn.prepareStatement("DELETE FROM Empleados Where Empleados.Cedula='" + TxtCedula.getText() + "'");
            int indice = ps.executeUpdate();
            if (indice > 0) {
                JOptionPane.showMessageDialog(null, "Datos actualizados");
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }
        } catch (SQLException e) {
            System.out.println(e);

        }

    }
}
