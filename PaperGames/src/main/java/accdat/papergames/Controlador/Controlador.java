/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accdat.papergames.Controlador;

import accdat.papergames.Modelo.Modelo;
import accdat.papergames.Vista.InterfazVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 *
 * @author USUARIO
 */
public class Controlador implements ActionListener{
    private final InterfazVista vista;
    private final Modelo modelo;
    

    public Controlador(InterfazVista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
       
        
        this.vista.setControlador(this);
        this.vista.arranca();
    }
    

    @Override
    public void actionPerformed(ActionEvent evento) {
        switch (evento.getActionCommand()){
            case InterfazVista.PRUEBA1 -> vista.haceAlgo("has pulsado el primer boton");
            case InterfazVista.PRUEBA2 -> vista.haceAlgo("has pulsado el segundo boton");
        }

    }
   
}
