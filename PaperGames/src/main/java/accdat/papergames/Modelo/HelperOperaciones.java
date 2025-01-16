/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accdat.papergames.Modelo;

import accdat.papergames.Modelo.Controllers.GeneroJpaController;
import accdat.papergames.Modelo.Controllers.ModoJuegoJpaController;
import accdat.papergames.Modelo.Controllers.PlataformaJpaController;
import accdat.papergames.Modelo.Controllers.VideojuegoJpaController;
import accdat.papergames.Modelo.Persistencia.Videojuego;
import accdat.papergames.Modelo.Persistencia.Plataforma;
import accdat.papergames.Modelo.Persistencia.Genero;
import accdat.papergames.Modelo.Persistencia.ModoJuego;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rezzt
 */
public class HelperOperaciones {
   // constantes & atributos ->
    // instacia | patron singleton =>
  private static HelperOperaciones instance;
  
    // variables necesarias =>
  private EntityManagerFactory emFactory;
  private VideojuegoJpaController vController;
  private PlataformaJpaController pController;
  private GeneroJpaController gController;
  private ModoJuegoJpaController mjController;
  
 //----------------------------------------------------------------------------------------->
   // constructores -> 
  public HelperOperaciones () {
    emFactory = Persistence.createEntityManagerFactory("accdat_PaperGames_jar_1.0-SNAPSHOTPU");
    vController = new VideojuegoJpaController(emFactory);
    pController = new PlataformaJpaController(emFactory);
    gController = new GeneroJpaController(emFactory);
    mjController = new ModoJuegoJpaController(emFactory);
  }
  public static HelperOperaciones getInstance () {
    if (instance == null) {
      instance = new HelperOperaciones();
    }
    
    return instance;
  }
  
  private void cerrarConexion () {
    emFactory.close();
  }
  
 //----------------------------------------------------------------------------------------->
   // metodos publico ->
    // metodo publico | devolverListaVideojuegos =>
  public List<Videojuego> devolverListaVideojuegos () {
    List<Videojuego> listaCompletaVideojuegos = new ArrayList<>();
    
    try {
      listaCompletaVideojuegos = vController.findVideojuegoEntities();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      cerrarConexion();
    }
    
    return listaCompletaVideojuegos;
  }
    // metodo publico | devolverListaPlataformas =>
  public List<Plataforma> devolverListaPlataformas () {
    List<Plataforma> listaCompletaPlataformas = new ArrayList<>();
    try {
      listaCompletaPlataformas = pController.findPlataformaEntities();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      cerrarConexion();
    }
    
    return listaCompletaPlataformas;
  }
    // metodo publico | devolverListaGeneros =>
  public List<Genero> devolverListaGeneros () {
    List<Genero> listaCompletaGeneros = new ArrayList<>();
    try {
      listaCompletaGeneros = gController.findGeneroEntities();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      cerrarConexion();
    }
    
    return listaCompletaGeneros;
  }
  
    // metodo publico | devolverListaModosJuego =>
  public List<ModoJuego> devolverListaModosJuego () {
    List<ModoJuego> listaCompletaModosJuego = new ArrayList<>();
    try {
      listaCompletaModosJuego = mjController.findModoJuegoEntities();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      cerrarConexion();
    }
    
    return listaCompletaModosJuego;
  }
  
    // metodo publico | devolverListaPEGIs =>
  public List<Short> listaCompletaPEGI () {
    List<Short> listaCompletaPEGIs = new ArrayList<>();
    try {
      listaCompletaPEGIs = vController.obtenerListaPEGI();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      cerrarConexion();
    }
    
    return listaCompletaPEGIs;
  }
  
 //----------------------------------------------------------------------------------------->
  public Genero buscarGeneroPorNombre (String inputNombreGenero) {
    return gController.findGenero(inputNombreGenero);
  }
  public Plataforma buscarPlataformaPorNombre (String inputNombrePlataforma) {
    return pController.findPlataforma(inputNombrePlataforma);
  }
  public ModoJuego buscarModoJuegoPorNombre (String inputNombreModoJuego) {
    return mjController.findModoJuego(inputNombreModoJuego);
  }
}
