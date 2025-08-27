package ModuloEmpleados;


import DBCon.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EstivenQ
 */
public class Buscar {

    public void MostarEmpleados(JTable Tabla) {

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
        Tabla.setModel(modelo);
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

            Tabla.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }

    }

    public void BuscarCed(JTextField CedBusc, JTextField NomResult, JTextField ApellResult, JTextField CedResult, JTextField EdadResult, JTextField SalResult, JTextField PLaboralResult, JTextField CorreoResult, JTextField TelfResult) {

        String Consulta = "select Nombre,Apellidos,Cedula,Edad,Salario,PuestoLaboral,Correo,Telefono From Empleados Where Empleados.Cedula=(?) ";

        Conexion conexion = new Conexion();

        try {
            CallableStatement cs = conexion.getConnection().prepareCall(Consulta);

            cs.setString(1, CedBusc.getText());
            cs.execute();

            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Empleado encontrado");
                NomResult.setText(rs.getString("Nombre"));
                ApellResult.setText(rs.getString("Apellidos"));
                CedResult.setText(rs.getString("Cedula"));
                EdadResult.setText(rs.getString("Edad"));
                SalResult.setText(rs.getString("Salario"));
                PLaboralResult.setText(rs.getString("PuestoLaboral"));
                CorreoResult.setText(rs.getString("Correo"));
                TelfResult.setText(rs.getString("Telefono"));

            } else {
                JOptionPane.showMessageDialog(null, "Empleado no encotrado");
                NomResult.setText(rs.getString(" "));
                ApellResult.setText(rs.getString(" "));
                CedResult.setText(rs.getString(" "));
                EdadResult.setText(rs.getString(" "));
                SalResult.setText(rs.getString(" "));
                PLaboralResult.setText(rs.getString(" "));
                CorreoResult.setText(rs.getString(" "));
                TelfResult.setText(rs.getString(" "));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar la base de datos");

        }

    }

    public void SeleccionEmpleados(JTable tabla, JTextField NomResult, JTextField ApellResult, JTextField CedResult, JTextField EdadResult, JTextField SalResult, JTextField PLaboralResult, JTextField CorreoResult, JTextField TelefonoResult) {

        try {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {

                NomResult.setText(tabla.getValueAt(fila, 0).toString());
                ApellResult.setText(tabla.getValueAt(fila, 1).toString());
                CedResult.setText(tabla.getValueAt(fila, 2).toString());
                EdadResult.setText(tabla.getValueAt(fila, 3).toString());
                SalResult.setText(tabla.getValueAt(fila, 4).toString());
                PLaboralResult.setText(tabla.getValueAt(fila, 5).toString());
                CorreoResult.setText(tabla.getValueAt(fila, 6).toString());
                TelefonoResult.setText(tabla.getValueAt(fila, 7).toString());

            } else {
                JOptionPane.showMessageDialog(null, "Empleado no seleccionado");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la seleccion");
        }
    }

}
