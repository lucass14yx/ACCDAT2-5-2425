/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accdat.papergames.Modelo;

import accdat.papergames.Modelo.Controllers.*;
import accdat.papergames.Modelo.Persistencia.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lxxkass & JorgeHerrera
 */
public class ModeloService {

    private final EntityManagerFactory emf;
    private final VideojuegoJpaController videojuegoJpaC;
    private final DlcJpaController dlcJpaC;
    private final GeneroJpaController generoJpaC;
    private final ModoJuegoJpaController modoJuegoJpaC;
    private final PlataformaJpaController plataformaJpaC;

    public ModeloService() {
        emf = Persistence.createEntityManagerFactory("accdat_PaperGames_jar_1.0-SNAPSHOTPU");
        videojuegoJpaC = new VideojuegoJpaController(emf);
        dlcJpaC = new DlcJpaController(emf);
        generoJpaC = new GeneroJpaController(emf);
        modoJuegoJpaC = new ModoJuegoJpaController(emf);
        plataformaJpaC = new PlataformaJpaController(emf);
    }

    /** *************************
     ******** LECTORES **********    JorgeHerrera
     ************************ **/
    
    /**
     * Te muestra un listado de todos los videojuegos
     */
    public void listarVideojuegos() {
        List<Videojuego> videojuegosListado = videojuegoJpaC.findVideojuegoEntities();

        videojuegosListado.forEach(v -> 
            System.out.println("Nombre del videojuego: " + v.getTitulo())
        );
    }
    
    /**
     * Lista los modos de juego asociados a un videojuego
     * @param idVideojuego Id del videojuego del que vamos a extraer los modos de juego
     */
    public void listarVideojuegoModoJuego(int idVideojuego) {
        Videojuego videojuego = videojuegoJpaC.findVideojuego((long) idVideojuego);

        if (videojuego != null) {
            Collection<ModoJuego> listaVideojuegos = videojuego.getModoJuegoCollection();
            listaVideojuegos.forEach(v -> 
                System.out.println("Modo de juego: " + v.getNombreModoJuego())
            );
        } else {
            System.out.println("El videojuego con ID " + idVideojuego + " no existe.");
        }
    }
    
    /**
     * Te muestra videojuegos en listas de un numero que le especifiques tú
     */
    public void listarVideojuegosPorTramos() {
        System.out.println("TODOS LOS DEPARTAMENTOS");
        listarVideojuegos();
        System.out.println("--------------------------------------------------------------");

        //***********************************************************************************
        System.out.println("Trae 3 registros empezando en la posición 0");
        List<Videojuego> videojuegoListado = videojuegoJpaC.findVideojuegoEntities(3, 0);

        videojuegoListado.forEach(v -> 
            System.out.println("Nombre videojuego: " + v.getTitulo())
        );
        System.out.println("--------------------------------------------------------------");
    }
    
    /**
     * Lista solo 1 videojuego
     * @param idVideojuego Id del videojuego que queremos extraer
     */
    public void listarUnVideojuego(int idVideojuego) {
        Videojuego videojuego = videojuegoJpaC.findVideojuego((long) idVideojuego);

        if (videojuego != null) {
            System.out.println(videojuego.getTitulo());
        } else {
            System.out.println("El videojuego con ID " + idVideojuego + " no existe.");
        }
    }

    /** ***************************
     ******** INSERTORES **********    lxxkass
     ************************** **/
    /**
     * Metodo insertor para Videojuegos
     * @param videojuego 
     */
    public void insertaVideojuego(Videojuego videojuego) {
        try {
            videojuegoJpaC.create(videojuego);
            Logger.getLogger(ModeloService.class.getName())
                    .log(Level.INFO, "El videojuego ha sido creado exitosamente: {0}", videojuego);
        } catch (Exception ex) {
            Logger.getLogger(ModeloService.class.getName())
                    .log(Level.SEVERE, "Error al crear el videojuego: " + videojuego, ex);
        }
    }

    /**
     * Metodo insertor para DLCs
     * @param dlc 
     */
    public void insertaDlc(Dlc dlc) {
        try {
            dlcJpaC.create(dlc);
            Logger.getLogger(ModeloService.class.getName())
                    .log(Level.INFO, "El DLC ha sido creado exitosamente: {0}", dlc);
        } catch (Exception ex) {
            Logger.getLogger(ModeloService.class.getName())
                    .log(Level.SEVERE, "Error al crear el DLC: " + dlc, ex);
        }
    }

    // Métodos de inserción para Generos, Modos de juego y Plataformas...
    // [Sin cambios adicionales]

    /** ***************************
     ******** BORRADORES **********   lxxkass
     ************************** **/
    /**
     * Metodo borrador para Videojuegos
     * @param videojuego 
     */
    public void borraVideojuego(Videojuego videojuego) {
        try {
            videojuegoJpaC.destroy(videojuego.getIdVideojuego());
            Logger.getLogger(ModeloService.class.getName())
                    .log(Level.INFO, "El videojuego ha sido borrado exitosamente: {0}", videojuego);
        } catch (Exception ex) {
            Logger.getLogger(ModeloService.class.getName())
                    .log(Level.SEVERE, "Error al borrar el videojuego: " + videojuego, ex);
        }
    }

    // Métodos de borrado para DLCs, Generos, Modos de juego y Plataformas...
    // [Sin cambios adicionales]

    /** *****************************
     ******** MODIFICADORES **********    JorgeHerrera
     ***************************** **/
    /**
     * Modifica un videojuego
     * @param idVideojuego Id del videojuego que vamos a modificar (este id no se modifica)
     * @param titulo título nuevo del videojuego
     * @param descripcion descripción nueva del videojuego
     * @param año año nuevo del videojuego
     * @param pegi PEGI nuevo del videojuego
     * @param nombrePlataforma nombrePlataforma nueva del videojuego
     * @param nombreGenero nombreGenero nuevo del videojuego
     */
    public void modificarVideojuego(int idVideojuego, String titulo, String descripcion, short año, short pegi, Plataforma nombrePlataforma, Genero nombreGenero) {
        Videojuego videojuego = videojuegoJpaC.findVideojuego((long) idVideojuego);

        if (videojuego != null) {
            videojuego.setTitulo(titulo);
            videojuego.setDescripcion(descripcion);
            videojuego.setAño(año);
            videojuego.setPegi(pegi);
            videojuego.setNombrePlataforma(nombrePlataforma);
            videojuego.setNombreGenero(nombreGenero);
            Logger.getLogger(ModeloService.class.getName())
                    .log(Level.INFO, "El videojuego ha sido modificado exitosamente: {0}", videojuego);
        } else {
            Logger.getLogger(ModeloService.class.getName())
                    .log(Level.WARNING, "El videojuego con ID {0} no existe y no se puede modificar.", idVideojuego);
        }
    }
}
