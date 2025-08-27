/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package veterinariaislademello;

/**
 *
 * @author Andres Ortega
 */
public interface MetodosMascotas {
    
    public void anadirMascota();

    public void modificarMascota(String dato, String nuevoDato, String id);
    
    public void eliminarMascota();
    
    public void buscarMascota(String dato, String valor);
    
}
