/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accdat.papergames.Modelo.Filtros;

import accdat.papergames.Modelo.Persistencia.Dlc;
import accdat.papergames.Modelo.Persistencia.Plataforma;
import accdat.papergames.Modelo.Persistencia.Videojuego;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.LockModeType;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import java.util.List;

/**
 *
 * @author rezzt
 */
public class FiltrosBBDD_JPQL {
   // constantes & atributos ->
  static EntityManagerFactory emFactory;
  static EntityManager entityManager;
  private static FiltrosBBDD_JPQL instace;
  
 //------------------------------------------------------------------------------->
   // constructores ->
  public FiltrosBBDD_JPQL () {}
  public static FiltrosBBDD_JPQL getInstance () {
    if (instace == null) {
      instace = new FiltrosBBDD_JPQL();
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
    List<Videojuego> listaVideojuegos = entityManager.createQuery(consulta).setLockMode(LockModeType.PESSIMISTIC_WRITE).getResultList();
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
    List<Videojuego> listaVideojuegos = entityManager.createQuery(consulta).setLockMode(LockModeType.PESSIMISTIC_WRITE).getResultList();
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
                    .setParameter("plataformas", inputPlataformas).setLockMode(LockModeType.PESSIMISTIC_WRITE).getResultList()
            ));
    
    consulta.select(rootVideoJuego).where(rootVideoJuego.get("idVideojuego").in(subquery));
    List<Videojuego> listaVideojuegos = entityManager.createQuery(consulta).setLockMode(LockModeType.PESSIMISTIC_WRITE).getResultList();
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
            .setParameter("modosjuego", inputModosJuego).setLockMode(LockModeType.PESSIMISTIC_WRITE).getResultList()
    ));
    
    consulta.select(rootVideoJuego).where(rootVideoJuego.get("idVideojuego").in(subquery));
    List<Videojuego> listaVideojuegos = entityManager.createQuery(consulta).setLockMode(LockModeType.PESSIMISTIC_WRITE).getResultList();
    return listaVideojuegos;
  }
  
    // metodo publico | consultaVideojuegoPorPEGI =>
  public List<Videojuego> consultaVideojuegoPorPEGI (List<Integer> inputPEGI) {
    CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Videojuego> consulta = cBuilder.createQuery(Videojuego.class);
    Root<Videojuego> rootQuery = consulta.from(Videojuego.class);
    
    consulta.select(rootQuery).where(rootQuery.get("pegi").in(inputPEGI));
    List<Videojuego> listaVideojuegos = entityManager.createQuery(consulta).setLockMode(LockModeType.PESSIMISTIC_WRITE).getResultList();
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
    List<Dlc> listaDLC = entityManager.createQuery(consulta).setLockMode(LockModeType.PESSIMISTIC_WRITE).getResultList();
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
    List<Dlc> listaDLC = entityManager.createQuery(consulta).setLockMode(LockModeType.PESSIMISTIC_WRITE).getResultList();
    return listaDLC;
  }
  
 //----------------------------------------------------------------------------------------->
   // metodos complementarios ->
    // metodo complementario | actualizarAñoVideojuegoPorAño =>
  public int actualizarAnioVideojuegoPorAnio (int inputAnioActual, int inputAnioNuevo) {
    abrirFactory();
    entityManager.getTransaction().begin();
    
    int actualizados = entityManager.createQuery(
            "UPDATE Videojuego v SET v.año = :nuevoAÑO WHERE v.año = :actualAÑO"
    ).setParameter("nuevoAÑO", inputAnioNuevo).setParameter("actualAÑO", inputAnioActual).executeUpdate();
    
    entityManager.getTransaction().commit();
    cerrarFactory();
    return actualizados;
  }
  
    // metodo complementario | reasignarVideojuegosDePlataformas =>
  public int reasignarVideojuegosDePlataformas (String inputNombrePlataformaEliminar) {
    abrirFactory();
    entityManager.getTransaction().begin();
    
    int numRegistrosActualizados = 0;
    
    try {
      String plataformaNoAsignada = "No Asignada";
      Long idPlataformaNoAsignada = null;
      
      List<Long> plataformasNoAsignadas = entityManager.createQuery(
              "SELECT p.id FROM Plataforma p WHERE p.nombre = :nombre", Long.class
      ).setParameter("nombre", inputNombrePlataformaEliminar).setLockMode(LockModeType.PESSIMISTIC_WRITE).getResultList();
      
      if (plataformasNoAsignadas.isEmpty()) {
        Plataforma nuevaPlataforma = new Plataforma();
        nuevaPlataforma.setNombrePlataforma(plataformaNoAsignada);
        entityManager.persist(nuevaPlataforma);
        entityManager.flush();
        idPlataformaNoAsignada = plataformasNoAsignadas.get(0);
      } else {
        idPlataformaNoAsignada = plataformasNoAsignadas.get(0);
      }
      
      List<Videojuego> videojuegos = entityManager.createQuery(
              "SELECT v FROM Videojuego v WHERE v.plataforma.nombre = :plataformaEliminar", Videojuego.class
      ).setParameter("plataformaEliminar", inputNombrePlataformaEliminar).setLockMode(LockModeType.PESSIMISTIC_WRITE).getResultList();
    
      int actualizados = entityManager.createQuery(
              "UPDATE Videojuego v SET v.plataforma.id = :nuevaPlataformaId WHERE v.plataforma.nombre = :plataformaEliminar"
      )
      .setParameter("nuevaPlataformaId", idPlataformaNoAsignada)
        .setParameter("plataformaEliminar", inputNombrePlataformaEliminar)
        .executeUpdate();
      
      entityManager.createQuery(
              "DELETE FROM Plataforma p WHERE p.nombre = :plataformaEliminar"
      ).setParameter("plataformaEliminar", inputNombrePlataformaEliminar).executeUpdate();
      
      entityManager.getTransaction().commit();
      numRegistrosActualizados = actualizados;
    } catch (Exception ex) {
      entityManager.getTransaction().rollback();
      ex.printStackTrace();
    } finally {
      cerrarFactory();
    }
    
    return numRegistrosActualizados;
  }
  
  public List<Videojuego> consultaVideojuegoPorGenero(List<String> nombreGeneros) {
    abrirFactory(); 
    entityManager.getTransaction().begin();
    
    List<Videojuego> listaVideojuegos = entityManager.createQuery(
        "SELECT v FROM Videojuego v JOIN v.genero g WHERE g.nombreGenero IN :generos", Videojuego.class)
        .setParameter("generos", nombreGeneros)
        .setLockMode(LockModeType.PESSIMISTIC_WRITE)
        .getResultList();
    
    entityManager.getTransaction().commit();
    cerrarFactory(); 
    
    return listaVideojuegos;
  }
}
