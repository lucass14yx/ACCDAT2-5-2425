/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package accdat.papergames;

import accdat.papergames.Controlador.Controlador;
import accdat.papergames.Modelo.Modelo;
import accdat.papergames.Vista.InterfazVista;
import accdat.papergames.Vista.VentanaPrincipalGUI;

/**
 *
 * @author USUARIO
 */
public class PaperGames {

    public static void main(String[] args) {
        InterfazVista vista = new VentanaPrincipalGUI();
        Modelo modelo = new Modelo();
        Controlador control = new Controlador(vista,modelo);
    }
}
