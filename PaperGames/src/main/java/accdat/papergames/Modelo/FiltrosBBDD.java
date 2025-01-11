/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accdat.papergames.Modelo;

import accdat.papergames.Modelo.Persistencia.Dlc;
import accdat.papergames.Modelo.Persistencia.Videojuego;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import java.util.List;

/**
 *
 * @author rezzt
 */
public class FiltrosBBDD {
   // constantes & atributos ->
  static EntityManagerFactory emFactory;
  static EntityManager entityManager;
  private static FiltrosBBDD instace;
  
 //------------------------------------------------------------------------------->
   // constructores ->
  private FiltrosBBDD () {}
  public static FiltrosBBDD getInstance () {
    if (instace == null) {
      instace = new FiltrosBBDD();
    }
    return instace;
  }
  
 //------------------------------------------------------------------------------->
   // metodos privados | abrir & cerrar factory ->
  private void abrirFactory () {
    emFactory = Persistence.createEntityManagerFactory("accdat_PaperGames_jar_1.0-SNAPSHOTPU");
    entityManager = emFactory.createEntityManager();
  }
  
  private void cerrarFactory () {
    entityManager.close();
    emFactory.close();
  }
  
 //------------------------------------------------------------------------------->
   // metodos publicos | consultas de videojuegos ->
    // metodo publico | consultaVideojuegoPorNombre =>
  public List<Videojuego> consultaVideojuegoPorNombre (String inputTitulo) {
    CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Videojuego> consulta = cBuilder.createQuery(Videojuego.class);
    Root<Videojuego> rootQuery = consulta.from(Videojuego.class);
    
    consulta.select(rootQuery).where(cBuilder.like(rootQuery.get("titulo"), "%" + inputTitulo + "%"));
    List<Videojuego> listaVideojuegos = entityManager.createQuery(consulta).getResultList();
    return listaVideojuegos;
  }
  
    // metodo publico | consultaVideojuegoPorAio =>
  public List<Videojuego> consultaVideojuegoPorAio(Integer inputAnioMin, Integer inputAnioMax) {
    CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Videojuego> consulta = cBuilder.createQuery(Videojuego.class);
    Root<Videojuego> rootQuery = consulta.from(Videojuego.class);
    
    Predicate filtro = cBuilder.conjunction();
    if (inputAnioMin != null) {
      filtro = cBuilder.and(filtro, cBuilder.greaterThanOrEqualTo(rootQuery.get("año"), inputAnioMin));
    }
    if (inputAnioMax != null) {
      filtro = cBuilder.and(filtro, cBuilder.lessThanOrEqualTo(rootQuery.get("año"), inputAnioMax));
    }
    
    consulta.select(rootQuery).where(filtro);
    List<Videojuego> listaVideojuegos = entityManager.createQuery(consulta).getResultList();
    return listaVideojuegos;
  }
  
    // metodo publico | consultaVideojuegoPorPlataforma =>
  public List<Videojuego> consultaVideojuegoPorPlataforma (List<String> inputPlataformas) {
    CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Videojuego> consulta = cBuilder.createQuery(Videojuego.class);
    Root<Videojuego> rootVideoJuego = consulta.from(Videojuego.class);
    
     // subconsulta para filtrar videojuegos por plataformas ->
    Subquery<Long> subquery = consulta.subquery(Long.class);
    Root<Videojuego> subRoot = subquery.from(Videojuego.class);
    
    subquery.select(subRoot.get("idVideojuego"))
            .where(subRoot.get("idVideojuego").in(
            entityManager.createQuery("SELECT DISTINCT vp.id_videojuego FROM VIDEOJUEGO_PLATAFORMAS vp WHERE vp.nombre_plataforma IN :plataformas", Long.class)
                    .setParameter("plataformas", inputPlataformas).getResultList()
            ));
    
    consulta.select(rootVideoJuego).where(rootVideoJuego.get("idVideojuego").in(subquery));
    List<Videojuego> listaVideojuegos = entityManager.createQuery(consulta).getResultList();
    return listaVideojuegos;
  }
  
    // metodo publico | consultaVideojuegoPorModoJuego =>
  public List<Videojuego> consultaVideojuegoPorModoJuego (List<String> inputModosJuego) {
    CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Videojuego> consulta = cBuilder.createQuery(Videojuego.class);
    Root<Videojuego> rootVideoJuego = consulta.from(Videojuego.class);
    
    Subquery<Long> subquery = consulta.subquery(Long.class);
    Root<Videojuego> subRoot = subquery.from(Videojuego.class);
    
    subquery.select(subRoot.get("idVideojuego")).where(subRoot.get("idVideojuego").in(
            entityManager.createQuery("SELECT DISTINCT vmj.id_videojuego FROM VIDEOJUEGO_MODO_JUEGO vmj WHERE vmj.nombre_modo_juego IN :modosjuego", Long.class)
            .setParameter("modosjuego", inputModosJuego).getResultList()
    ));
    
    consulta.select(rootVideoJuego).where(rootVideoJuego.get("idVideojuego").in(subquery));
    List<Videojuego> listaVideojuegos = entityManager.createQuery(consulta).getResultList();
    return listaVideojuegos;
  }
  
    // metodo publico | consultaVideojuegoPorPEGI =>
  public List<Videojuego> consultaVideojuegoPorPEGI (List<Integer> inputPEGI) {
    CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Videojuego> consulta = cBuilder.createQuery(Videojuego.class);
    Root<Videojuego> rootQuery = consulta.from(Videojuego.class);
    
    consulta.select(rootQuery).where(rootQuery.get("pegi").in(inputPEGI));
    List<Videojuego> listaVideojuegos = entityManager.createQuery(consulta).getResultList();
    return listaVideojuegos;
  }
  
 //------------------------------------------------------------------------------->
   // metodos publicos | consultas de dlc ->
    // metodo publico | consultaDLCPorNombre =>
  public List<Dlc> consultaDLCPorNombre (String inputNombreDLC) {
    CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Dlc> consulta = cBuilder.createQuery(Dlc.class);
    Root<Dlc> rootQuery = consulta.from(Dlc.class);
    
    consulta.select(rootQuery).where(cBuilder.like(rootQuery.get("titulo"), "%" + inputNombreDLC + "%"));
    List<Dlc> listaDLC = entityManager.createQuery(consulta).getResultList();
    return listaDLC;
  }
  
    // metodo publico | consultaDLCPorPrecio =>
  public List<Dlc> consultaDLCPorPrecio (Integer inputPrecioMin, Integer inputPrecioMax) {
    CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Dlc> consulta = cBuilder.createQuery(Dlc.class);
    Root<Dlc> rootQuery = consulta.from(Dlc.class);
    
    Predicate filtro = cBuilder.conjunction();
    if (inputPrecioMin != null) {
      filtro = cBuilder.and(filtro, cBuilder.greaterThanOrEqualTo(rootQuery.get("precio"), inputPrecioMin));
    }
    
    if (inputPrecioMax != null) {
      filtro = cBuilder.and(filtro, cBuilder.lessThanOrEqualTo(rootQuery.get("precio"), inputPrecioMax));
    }
    
    consulta.select(rootQuery).where(filtro);
    List<Dlc> listaDLC = entityManager.createQuery(consulta).getResultList();
    return listaDLC;
  }
}
