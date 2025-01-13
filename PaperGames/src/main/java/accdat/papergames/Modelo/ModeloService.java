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
    /** *************************
     ******** LECTORES **********    JorgeHerrera
     ************************ **/
    
    /**
     * Te muestra un listado de todos los videojuegos
     */
    public void listarVideojuegos(){
        List<Videojuego> videojuegosListado;
        
        videojuegosListado = videojuegoJpaC.findVideojuegoEntities();
        
        for (Videojuego v: videojuegosListado){
            System.out.println("Nombre del videojuego: "+ v.getTitulo());
        }
    }
    
    
    /**
     * Lista los modos de juego asociados a un videojuego
     * @param idVideojuego Id del videojuego del que vamos a extrar los modos de juego
     */
    public void listarVideojuegoModoJuego(int idVideojuego){
        Videojuego videojuego = videojuegoJpaC.findVideojuego((long)idVideojuego );
        
        Collection<ModoJuego>listaVideojuegos = videojuego.getModoJuegoCollection();
        
        for (ModoJuego v: listaVideojuegos){
            System.out.println("Modo de juego: "+ v.getNombreModoJuego());
        }
    }
    
    
    /**
     * Te muestra videojuegos en listas de un numero que le especifiques tu
     */
    public void listarVideojuegosPorTramos(){
        List<Videojuego> videojuegoListado;

        
        System.out.println("TODOS LOS DEPARTAMENTOS");
        listarVideojuegos();
        System.out.println("--------------------------------------------------------------");
        
        //***********************************************************************************
        System.out.println("Trae 3 registros empezando en la pos 0");
        
        // 3 = NUMERO DE REGISTROS MAXIMO
        // 0 = POS PARRTIR DE LA CUAL LO QUEIRO
        videojuegoListado = videojuegoJpaC.findVideojuegoEntities(3,0);
        
        for (Videojuego v: videojuegoListado){
            System.out.println("Nombre videojuego: "+ v.getTitulo());
        }
        System.out.println("--------------------------------------------------------------");
        
    }
    
    /**
     * Lista solo 1 videojuego
     * @param idVideojuego Id del videojuego que queremos extraer
     */
    public void listarUnVideojuego(int idVideojuego){
        Videojuego videojuego = videojuegoJpaC.findVideojuego( (long)idVideojuego );
        
        System.out.println(videojuego.getTitulo());

    }
    
    
    
    
    /** ***************************
     ******** INSERTORES **********    lxxkass
     ************************** **/
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
     ******** BORRADORES **********   lxxkass
     ************************** **/
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
    
     /** *****************************
     ******** MODIFICADORES **********    JorgeHerrera
     ***************************** **/
    /**
     * Modifica un videojuego
     * @param idVideojuego Id del videojuego que vamos a modificar (este id no se modifica
     * @param titulo titulo nuevo del videojuego
     * @param descripcion descripcion nueva del videojuego
     * @param año año nuevo del videojuego
     * @param pegi pegi nuevo del videojuego
     * @param nombrePlataforma nombrePlataforma nueva del videojuego
     * @param nombreGenero nombreGenero nuevo del videojuego
     */
    public void modificarDepartamento(int idVideojuego, String titulo, String descripcion, short año, short pegi, Plataforma nombrePlataforma, Genero nombreGenero){
        Videojuego videojuego = videojuegoJpaC.findVideojuego( (long)idVideojuego );
        
        videojuego.setIdVideojuego( (long)idVideojuego );
        videojuego.setTitulo(titulo);
        videojuego.setDescripcion(descripcion);
        videojuego.setAño(año);
        videojuego.setPegi(pegi);
        videojuego.setNombrePlataforma(nombrePlataforma);
        videojuego.setNombreGenero(nombreGenero);
    }
    
}
