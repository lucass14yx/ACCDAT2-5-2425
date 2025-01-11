/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package accdat.papergames.Modelo;

import accdat.papergames.Modelo.Controllers.DlcJpaController;
import accdat.papergames.Modelo.Controllers.VideojuegoJpaController;
import accdat.papergames.Modelo.Persistencia.Dlc;
import accdat.papergames.Modelo.Persistencia.Videojuego;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author JGC by Juan Garcia Cazallas
 * version 1.0
 * created on 11 ene 2025
 */
public class FiltrosJPAController {
   // Constantes y atributos ->
  private static EntityManagerFactory emFactory;
  private static FiltrosJPAController instace;
  
  private VideojuegoJpaController videojuegoController;
  private DlcJpaController dlcController;
 
 //------------------------------------------------------------------------------->
   // constructores ->
  private FiltrosJPAController () {
    emFactory = Persistence.createEntityManagerFactory("accdat_PaperGames_jar_1.0-SNAPSHOTPU");
    videojuegoController = new VideojuegoJpaController(emFactory);
    dlcController = new DlcJpaController(emFactory);
  }
  
  public static FiltrosJPAController getInstance () {
    if (instace == null) {
      instace = new FiltrosJPAController();
    }
    return instace;
  }
  
  private void cerrarConexion() {
    emFactory.close();
  }
  
 //------------------------------------------------------------------------------->
   // metodos publicos | consultas de videojuego ->
    // metodo publico | consultaVideojuegoPorNombre =>
  public List<Videojuego> consultaVideojuegoPorNombre (String inputTitulo) {
    List<Videojuego> listaVideojuegos = new ArrayList<>();
    try {
      listaVideojuegos = videojuegoController.findVideojuegoByTitulo(inputTitulo);
    } catch (Exception ex) {
      ex.printStackTrace();
      listaVideojuegos = null;
    } finally {
      cerrarConexion();
    }
    
    return  listaVideojuegos;
  }
  
    // metodo publico | consultaVideojuegoPorAnio =>
  public List<Videojuego> consultaVideojuegoPorAnio (Integer inputAnioMin, Integer inputAnioMax) {
    List<Videojuego> listaVideojuegos = new ArrayList<>();
    try {
      listaVideojuegos = videojuegoController.findVideojuegoByAnio(inputAnioMin, inputAnioMax);
    } catch (Exception ex) {
      ex.printStackTrace();
      listaVideojuegos = null;
    } finally {
      cerrarConexion();
    }
    
    return  listaVideojuegos;
  }
  
    // metodo publico | consultaVideojuegoPorPlataforma =>
  public List<Videojuego> consultaVideojuegoPorPlataforma (List<String> inputPlataformas) {
    List<Videojuego> listaVideojuegos = new ArrayList<>();
    try {
      listaVideojuegos = videojuegoController.findVideojuegoByPlataformas(inputPlataformas);
    } catch (Exception ex) {
      ex.printStackTrace();
      listaVideojuegos = null;
    } finally {
      cerrarConexion();
    }
    
    return  listaVideojuegos;
  }
  
    // metodo publico | consultaVideojuegoPorModoJuego =>
  public List<Videojuego> consultaVideojuegoPorModoJuego (List<String> inputModosJuego) {
    List<Videojuego> listaVideojuegos = new ArrayList<>();
    try {
      listaVideojuegos = videojuegoController.findVideojuegoByModosJuego(inputModosJuego);
    } catch (Exception ex) {
      ex.printStackTrace();
      listaVideojuegos = null;
    } finally {
      cerrarConexion();
    }
    
    return  listaVideojuegos;
  }
  
    // metodo publico | consultaVideojuegoPorPEGI =>
  public List<Videojuego> consultaVideojuegoPorPEGI (List<Integer> inputPEGI) {
    List<Videojuego> listaVideojuegos = new ArrayList<>();
    try {
      listaVideojuegos = videojuegoController.findVideojuegoByPEGI(inputPEGI);
    } catch (Exception ex) {
      ex.printStackTrace();
      listaVideojuegos = null;
    } finally {
      cerrarConexion();
    }
    
    return  listaVideojuegos;
  }
  
 //------------------------------------------------------------------------------->
   // metodos publicos | consultas de dlc ->
    // metodo publico | consultaDLCPorNombre =>
  public List<Dlc> consultaDLCPorNombre (String inputNombreDLC) {
    List<Dlc> listaDlc = new ArrayList<>();
    try {
      listaDlc = dlcController.findDlcByTitulo(inputNombreDLC);
    } catch (Exception ex) {
      ex.printStackTrace();
      listaDlc = null;
    } finally {
      cerrarConexion();
    }
    
    return listaDlc;
  }
  
    // metodo publico | consultaDLCPorNombre =>
  public List<Dlc> consultaDLCPorPrecio (Integer inputPrecioMin, Integer inputPrecioMax) {
    List<Dlc> listaDlc = new ArrayList<>();
    try {
      listaDlc = dlcController.findDlcByPrecio(inputPrecioMin, inputPrecioMax);
    } catch (Exception ex) {
      ex.printStackTrace();
      listaDlc = null;
    } finally {
      cerrarConexion();
    }
    
    return listaDlc;
  }
}
