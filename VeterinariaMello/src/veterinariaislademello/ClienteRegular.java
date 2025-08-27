
package veterinariaislademello;


public class ClienteRegular extends Cliente {
    
   // constructor
    public ClienteRegular(String nombre, String cedula, String direccion, String telefono, String correo, String mascota) {
        super(nombre, cedula, direccion, telefono, correo, mascota);
    }
    
    // método para modificar los datos del cliente
    
    public void modificarDatos(String nombre, String direccion, String telefono, String correo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }
    
}

