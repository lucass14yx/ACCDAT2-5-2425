/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accdat.papergames.Modelo;

import accdat.papergames.Modelo.Controllers.GeneroJpaController;
import accdat.papergames.Modelo.Controllers.PlataformaJpaController;
import accdat.papergames.Modelo.Controllers.VideojuegoJpaController;
import accdat.papergames.Modelo.Persistencia.Videojuego;
import accdat.papergames.Modelo.Persistencia.Plataforma;
import accdat.papergames.Modelo.Persistencia.Genero;
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
  
 //----------------------------------------------------------------------------------------->
   // constructores -> 
  public HelperOperaciones () {
    emFactory = Persistence.createEntityManagerFactory("accdat_PaperGames_jar_1.0-SNAPSHOTPU");
    vController = new VideojuegoJpaController(emFactory);
    pController = new PlataformaJpaController(emFactory);
    gController = new GeneroJpaController(emFactory);
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
}
