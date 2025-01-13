/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accdat.papergames.Modelo;

import accdat.papergames.Modelo.Controllers.*;
import accdat.papergames.Modelo.Persistencia.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author lxxkass
 */
public class ModeloService {
    private EntityManagerFactory emf;
    private VideojuegoJpaController videojuegoJpaC;
    private DlcJpaController dlcJpaC;
    private GeneroJpaController generoJpaC;
    private ModoJuegoJpaController modoJuegoJpaC;
    private PlataformaJpaController plataformaJpaC;

    public ModeloService() {
        emf = Persistence.createEntityManagerFactory("accdat_PaperGames_jar_1.0-SNAPSHOTPU");
        videojuegoJpaC = new VideojuegoJpaController(emf);
        dlcJpaC = new DlcJpaController(emf);
        generoJpaC = new GeneroJpaController(emf);
        modoJuegoJpaC = new ModoJuegoJpaController(emf);
        plataformaJpaC = new PlataformaJpaController(emf);
    }
    /** ***************************
     ******** INSERTORES **********
     *************************** **/
    /**
     * Metodo insertor para Videojuegos
     * @param videojuego 
     */
    public void insertaVideojuego(Videojuego videojuego){
        try {
            videojuegoJpaC.create(videojuego);
            Logger.getLogger(ModeloService.class.getName()).log(Level.INFO, "El videojuego ha sido creado exitosamente: {0}", videojuego);
        } catch (Exception ex) {
            Logger.getLogger(ModeloService.class.getName()).log(Level.SEVERE,"Error al crear el videojuego: " + videojuego, ex);
        }
    }
    /**
     * Metodo insertor para DLCs
     * @param dlc 
     */
    public void insertaDlc(Dlc dlc){
        try {
            dlcJpaC.create(dlc);
            Logger.getLogger(ModeloService.class.getName()).log(Level.INFO, "El dlc ha sido creado exitosamente: {0}", dlc);
        } catch (Exception ex) {
            Logger.getLogger(ModeloService.class.getName()).log(Level.SEVERE,"Error al crear el dlc: " + dlc, ex);
        }
    }
    /**
     * Metodo insertor para Generos
     * @param genero 
     */
    public void insertaGenero(Genero genero){
        try {
            generoJpaC.create(genero);
            Logger.getLogger(ModeloService.class.getName()).log(Level.INFO, "El genero ha sido creado exitosamente: {0}", genero);
        } catch (Exception ex) {
            Logger.getLogger(ModeloService.class.getName()).log(Level.SEVERE,"Error al crear el genero: " + genero, ex);
        }
    }
    /**
     * Metodo insertor para Modos de juego
     * @param modoJuego 
     */
    public void insertaModoJuego(ModoJuego modoJuego){
        try {
            modoJuegoJpaC.create(modoJuego);
            Logger.getLogger(ModeloService.class.getName()).log(Level.INFO, "El Modo de juego ha sido creado exitosamente: {0}", modoJuego);
        } catch (Exception ex) {
            Logger.getLogger(ModeloService.class.getName()).log(Level.SEVERE,"Error al crear el Modo de juego: " + modoJuego, ex);
        }
    }
    /**
     * Metodo insertor para Plataformas
     * @param plataforma 
     */
    public void insertaPlataforma(Plataforma plataforma){
        try {
            plataformaJpaC.create(plataforma);
            Logger.getLogger(ModeloService.class.getName()).log(Level.INFO, "La plataforma ha sido creada exitosamente: {0}", plataforma);
        } catch (Exception ex) {
            Logger.getLogger(ModeloService.class.getName()).log(Level.SEVERE,"Error al crear la plataforma: " + plataforma, ex);
        }
    }
    /** ***************************
     ******** BORRADORES **********
     *************************** **/
    /**
     * Metodo borrador para Videojuegos
     * @param videojuego 
     */
    public void borraVideojuego(Videojuego videojuego){
        try {
            videojuegoJpaC.destroy(videojuego.getIdVideojuego());
            Logger.getLogger(ModeloService.class.getName()).log(Level.INFO, "El videojuego ha sido borrado exitosamente: {0}", videojuego);
        } catch (Exception ex) {
            Logger.getLogger(ModeloService.class.getName()).log(Level.SEVERE,"Error al borrar el videojuego: " + videojuego, ex);
        }
    }
    /**
     * Metodo borrador para DLCs
     * @param dlc 
     */
    public void borraDlc(Dlc dlc){
        try {
            dlcJpaC.destroy(dlc.getIdDlc());
            Logger.getLogger(ModeloService.class.getName()).log(Level.INFO, "El dlc ha sido borrado exitosamente: {0}", dlc);
        } catch (Exception ex) {
            Logger.getLogger(ModeloService.class.getName()).log(Level.SEVERE,"Error al borrar el dlc: " + dlc, ex);
        }
    }
    /**
     * Metodo borrador para Generos
     * @param genero 
     */
    public void borraGenero(Genero genero){
        try {
            generoJpaC.destroy(genero.getNombreGenero());
            Logger.getLogger(ModeloService.class.getName()).log(Level.INFO, "El genero ha sido borrado exitosamente: {0}", genero);
        } catch (Exception ex) {
            Logger.getLogger(ModeloService.class.getName()).log(Level.SEVERE,"Error al borrar el genero: " + genero, ex);
        }
    }
    /**
     * Metodo borrador para Modos de juego
     * @param modoJuego 
     */
    public void borraModoJuego(ModoJuego modoJuego){
        try {
            modoJuegoJpaC.destroy(modoJuego.getNombreModoJuego());
            Logger.getLogger(ModeloService.class.getName()).log(Level.INFO, "El Modo de juego ha sido borrado exitosamente: {0}", modoJuego);
        } catch (Exception ex) {
            Logger.getLogger(ModeloService.class.getName()).log(Level.SEVERE,"Error al borrar el Modo de juego: " + modoJuego, ex);
        }
    }
    /**
     * Metodo borrador para Plataformas
     * @param plataforma 
     */
    public void borraPlataforma(Plataforma plataforma){
        try {
            plataformaJpaC.destroy(plataforma.getNombrePlataforma());
            Logger.getLogger(ModeloService.class.getName()).log(Level.INFO, "La plataforma ha sido borrada exitosamente: {0}", plataforma);
        } catch (Exception ex) {
            Logger.getLogger(ModeloService.class.getName()).log(Level.SEVERE,"Error al borrar la Plataforma: " + plataforma, ex);
        }
    }
    
}
