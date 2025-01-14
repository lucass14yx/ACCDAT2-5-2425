/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accdat.papergames;

import accdat.papergames.Modelo.Controllers.DlcJpaController;
import accdat.papergames.Modelo.Controllers.GeneroJpaController;
import accdat.papergames.Modelo.Controllers.ModoJuegoJpaController;
import accdat.papergames.Modelo.Controllers.PlataformaJpaController;
import accdat.papergames.Modelo.Controllers.VideojuegoJpaController;
import accdat.papergames.Modelo.Persistencia.Genero;
import accdat.papergames.Modelo.Persistencia.ModoJuego;
import accdat.papergames.Modelo.Persistencia.Plataforma;
import accdat.papergames.Modelo.Persistencia.Dlc;
import accdat.papergames.Modelo.Persistencia.Videojuego;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rezzt
 * utilizar solo la primera vez que se incie el proyecto, para cargar los datos en la bbdd
 */
public class CollectData {
   // constantes & variables ->
    // entityManager =>
  
  EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("accdat_PaperGames_jar_1.0-SNAPSHOTPU");
  
    // controladores persistencia =>
  DlcJpaController dlcController = new DlcJpaController(emFactory);
  GeneroJpaController genController = new GeneroJpaController(emFactory);
  ModoJuegoJpaController modoJuegoController = new ModoJuegoJpaController(emFactory);
  PlataformaJpaController platController = new PlataformaJpaController(emFactory);
  VideojuegoJpaController videojuegoController = new VideojuegoJpaController(emFactory);
  
 //------------------------------------------------------------------------------------------------->
  public static void main(String[] args) {
    
  }
  
 //------------------------------------------------------------------------------------------------->
   // metodo complementario | generarGeneros ->
  public static void generarGeneros () {
    List<Genero> listaCrearGeneros = new ArrayList<>();
    int contInserts = 0;
  }
  
  
  public static void generarModosJuego () {
    List<ModoJuego> listaCrearModosJuego = new ArrayList<>();
    int contInserts = 0;
  }
  
  
  public static void generarPlataformas () {
    List<Plataforma> listaCrearPlataformas = new ArrayList<>();
    int contInserts = 0;
  }
  
  
  public static void generarVideojuegos () {
    List<Videojuego> listaCrearVideojuegos = new ArrayList<>();
    int contInserts = 0;
  }
  
  
  public static void generarDlc () {
    List<Dlc> listaCrearDLCs = new ArrayList<>();
    int contInserts = 0;
  }
  
 //------------------------------------------------------------------------------------------------->
  
  
 //------------------------------------------------------------------------------------------------->
}
