/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accdat.papergames.Controlador;

import accdat.papergames.Vista.InterfazVista;


/**
 *
 * @author USUARIO
 */
public class Controlador{
    private final InterfazVista vista;
    

    public Controlador(InterfazVista vista) {
        this.vista = vista;
       
        
        this.vista.setControlador(this);
        this.vista.arranca();
    }
    
    
    
   
}
