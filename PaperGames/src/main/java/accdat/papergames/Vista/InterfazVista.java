/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package accdat.papergames.Vista;

import accdat.papergames.Controlador.Controlador;

/**
 *
 * @author USUARIO
 */
public interface InterfazVista {
    void setControlador(Controlador c);
    void arranca();
    
    void haceAlgo(String s);

    static final String PRUEBA1 = "Prueba1";
    static final String PRUEBA2 = "Prueba2";
}
