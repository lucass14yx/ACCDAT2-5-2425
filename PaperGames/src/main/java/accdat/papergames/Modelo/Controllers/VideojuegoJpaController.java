/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accdat.papergames.Modelo.Controllers;

import accdat.papergames.Modelo.Controllers.exceptions.IllegalOrphanException;
import accdat.papergames.Modelo.Controllers.exceptions.NonexistentEntityException;
import accdat.papergames.Modelo.Controllers.exceptions.PreexistingEntityException;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import accdat.papergames.Modelo.Persistencia.Genero;
import accdat.papergames.Modelo.Persistencia.Plataforma;
import java.util.ArrayList;
import java.util.Collection;
import accdat.papergames.Modelo.Persistencia.ModoJuego;
import accdat.papergames.Modelo.Persistencia.Dlc;
import accdat.papergames.Modelo.Persistencia.Videojuego;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

/**
 *
 * @author rezzt
 */
public class VideojuegoJpaController implements Serializable {

  public VideojuegoJpaController(EntityManagerFactory emf) {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  public void create(Videojuego videojuego) throws PreexistingEntityException, Exception {
    if (videojuego.getPlataformaCollection() == null) {
      videojuego.setPlataformaCollection(new ArrayList<Plataforma>());
    }
    if (videojuego.getModoJuegoCollection() == null) {
      videojuego.setModoJuegoCollection(new ArrayList<ModoJuego>());
    }
    if (videojuego.getDlcCollection() == null) {
      videojuego.setDlcCollection(new ArrayList<Dlc>());
    }
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      Genero nombreGenero = videojuego.getNombreGenero();
      if (nombreGenero != null) {
        nombreGenero = em.getReference(nombreGenero.getClass(), nombreGenero.getNombreGenero());
        videojuego.setNombreGenero(nombreGenero);
      }
      Plataforma nombrePlataforma = videojuego.getNombrePlataforma();
      if (nombrePlataforma != null) {
        nombrePlataforma = em.getReference(nombrePlataforma.getClass(), nombrePlataforma.getNombrePlataforma());
        videojuego.setNombrePlataforma(nombrePlataforma);
      }
      Collection<Plataforma> attachedPlataformaCollection = new ArrayList<Plataforma>();
      for (Plataforma plataformaCollectionPlataformaToAttach : videojuego.getPlataformaCollection()) {
        plataformaCollectionPlataformaToAttach = em.getReference(plataformaCollectionPlataformaToAttach.getClass(), plataformaCollectionPlataformaToAttach.getNombrePlataforma());
        attachedPlataformaCollection.add(plataformaCollectionPlataformaToAttach);
      }
      videojuego.setPlataformaCollection(attachedPlataformaCollection);
      Collection<ModoJuego> attachedModoJuegoCollection = new ArrayList<ModoJuego>();
      for (ModoJuego modoJuegoCollectionModoJuegoToAttach : videojuego.getModoJuegoCollection()) {
        modoJuegoCollectionModoJuegoToAttach = em.getReference(modoJuegoCollectionModoJuegoToAttach.getClass(), modoJuegoCollectionModoJuegoToAttach.getNombreModoJuego());
        attachedModoJuegoCollection.add(modoJuegoCollectionModoJuegoToAttach);
      }
      videojuego.setModoJuegoCollection(attachedModoJuegoCollection);
      Collection<Dlc> attachedDlcCollection = new ArrayList<Dlc>();
      for (Dlc dlcCollectionDlcToAttach : videojuego.getDlcCollection()) {
        dlcCollectionDlcToAttach = em.getReference(dlcCollectionDlcToAttach.getClass(), dlcCollectionDlcToAttach.getIdDlc());
        attachedDlcCollection.add(dlcCollectionDlcToAttach);
      }
      videojuego.setDlcCollection(attachedDlcCollection);
      em.persist(videojuego);
      if (nombreGenero != null) {
        nombreGenero.getVideojuegoCollection().add(videojuego);
        nombreGenero = em.merge(nombreGenero);
      }
      if (nombrePlataforma != null) {
        nombrePlataforma.getVideojuegoCollection().add(videojuego);
        nombrePlataforma = em.merge(nombrePlataforma);
      }
      for (Plataforma plataformaCollectionPlataforma : videojuego.getPlataformaCollection()) {
        plataformaCollectionPlataforma.getVideojuegoCollection().add(videojuego);
        plataformaCollectionPlataforma = em.merge(plataformaCollectionPlataforma);
      }
      for (ModoJuego modoJuegoCollectionModoJuego : videojuego.getModoJuegoCollection()) {
        modoJuegoCollectionModoJuego.getVideojuegoCollection().add(videojuego);
        modoJuegoCollectionModoJuego = em.merge(modoJuegoCollectionModoJuego);
      }
      for (Dlc dlcCollectionDlc : videojuego.getDlcCollection()) {
        Videojuego oldIdVideojuegoOfDlcCollectionDlc = dlcCollectionDlc.getIdVideojuego();
        dlcCollectionDlc.setIdVideojuego(videojuego);
        dlcCollectionDlc = em.merge(dlcCollectionDlc);
        if (oldIdVideojuegoOfDlcCollectionDlc != null) {
          oldIdVideojuegoOfDlcCollectionDlc.getDlcCollection().remove(dlcCollectionDlc);
          oldIdVideojuegoOfDlcCollectionDlc = em.merge(oldIdVideojuegoOfDlcCollectionDlc);
        }
      }
      em.getTransaction().commit();
    } catch (Exception ex) {
      if (findVideojuego(videojuego.getIdVideojuego()) != null) {
        throw new PreexistingEntityException("Videojuego " + videojuego + " already exists.", ex);
      }
      throw ex;
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void edit(Videojuego videojuego) throws IllegalOrphanException, NonexistentEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      Videojuego persistentVideojuego = em.find(Videojuego.class, videojuego.getIdVideojuego());
      Genero nombreGeneroOld = persistentVideojuego.getNombreGenero();
      Genero nombreGeneroNew = videojuego.getNombreGenero();
      Plataforma nombrePlataformaOld = persistentVideojuego.getNombrePlataforma();
      Plataforma nombrePlataformaNew = videojuego.getNombrePlataforma();
      Collection<Plataforma> plataformaCollectionOld = persistentVideojuego.getPlataformaCollection();
      Collection<Plataforma> plataformaCollectionNew = videojuego.getPlataformaCollection();
      Collection<ModoJuego> modoJuegoCollectionOld = persistentVideojuego.getModoJuegoCollection();
      Collection<ModoJuego> modoJuegoCollectionNew = videojuego.getModoJuegoCollection();
      Collection<Dlc> dlcCollectionOld = persistentVideojuego.getDlcCollection();
      Collection<Dlc> dlcCollectionNew = videojuego.getDlcCollection();
      List<String> illegalOrphanMessages = null;
      for (Dlc dlcCollectionOldDlc : dlcCollectionOld) {
        if (!dlcCollectionNew.contains(dlcCollectionOldDlc)) {
          if (illegalOrphanMessages == null) {
            illegalOrphanMessages = new ArrayList<String>();
          }
          illegalOrphanMessages.add("You must retain Dlc " + dlcCollectionOldDlc + " since its idVideojuego field is not nullable.");
        }
      }
      if (illegalOrphanMessages != null) {
        throw new IllegalOrphanException(illegalOrphanMessages);
      }
      if (nombreGeneroNew != null) {
        nombreGeneroNew = em.getReference(nombreGeneroNew.getClass(), nombreGeneroNew.getNombreGenero());
        videojuego.setNombreGenero(nombreGeneroNew);
      }
      if (nombrePlataformaNew != null) {
        nombrePlataformaNew = em.getReference(nombrePlataformaNew.getClass(), nombrePlataformaNew.getNombrePlataforma());
        videojuego.setNombrePlataforma(nombrePlataformaNew);
      }
      Collection<Plataforma> attachedPlataformaCollectionNew = new ArrayList<Plataforma>();
      for (Plataforma plataformaCollectionNewPlataformaToAttach : plataformaCollectionNew) {
        plataformaCollectionNewPlataformaToAttach = em.getReference(plataformaCollectionNewPlataformaToAttach.getClass(), plataformaCollectionNewPlataformaToAttach.getNombrePlataforma());
        attachedPlataformaCollectionNew.add(plataformaCollectionNewPlataformaToAttach);
      }
      plataformaCollectionNew = attachedPlataformaCollectionNew;
      videojuego.setPlataformaCollection(plataformaCollectionNew);
      Collection<ModoJuego> attachedModoJuegoCollectionNew = new ArrayList<ModoJuego>();
      for (ModoJuego modoJuegoCollectionNewModoJuegoToAttach : modoJuegoCollectionNew) {
        modoJuegoCollectionNewModoJuegoToAttach = em.getReference(modoJuegoCollectionNewModoJuegoToAttach.getClass(), modoJuegoCollectionNewModoJuegoToAttach.getNombreModoJuego());
        attachedModoJuegoCollectionNew.add(modoJuegoCollectionNewModoJuegoToAttach);
      }
      modoJuegoCollectionNew = attachedModoJuegoCollectionNew;
      videojuego.setModoJuegoCollection(modoJuegoCollectionNew);
      Collection<Dlc> attachedDlcCollectionNew = new ArrayList<Dlc>();
      for (Dlc dlcCollectionNewDlcToAttach : dlcCollectionNew) {
        dlcCollectionNewDlcToAttach = em.getReference(dlcCollectionNewDlcToAttach.getClass(), dlcCollectionNewDlcToAttach.getIdDlc());
        attachedDlcCollectionNew.add(dlcCollectionNewDlcToAttach);
      }
      dlcCollectionNew = attachedDlcCollectionNew;
      videojuego.setDlcCollection(dlcCollectionNew);
      videojuego = em.merge(videojuego);
      if (nombreGeneroOld != null && !nombreGeneroOld.equals(nombreGeneroNew)) {
        nombreGeneroOld.getVideojuegoCollection().remove(videojuego);
        nombreGeneroOld = em.merge(nombreGeneroOld);
      }
      if (nombreGeneroNew != null && !nombreGeneroNew.equals(nombreGeneroOld)) {
        nombreGeneroNew.getVideojuegoCollection().add(videojuego);
        nombreGeneroNew = em.merge(nombreGeneroNew);
      }
      if (nombrePlataformaOld != null && !nombrePlataformaOld.equals(nombrePlataformaNew)) {
        nombrePlataformaOld.getVideojuegoCollection().remove(videojuego);
        nombrePlataformaOld = em.merge(nombrePlataformaOld);
      }
      if (nombrePlataformaNew != null && !nombrePlataformaNew.equals(nombrePlataformaOld)) {
        nombrePlataformaNew.getVideojuegoCollection().add(videojuego);
        nombrePlataformaNew = em.merge(nombrePlataformaNew);
      }
      for (Plataforma plataformaCollectionOldPlataforma : plataformaCollectionOld) {
        if (!plataformaCollectionNew.contains(plataformaCollectionOldPlataforma)) {
          plataformaCollectionOldPlataforma.getVideojuegoCollection().remove(videojuego);
          plataformaCollectionOldPlataforma = em.merge(plataformaCollectionOldPlataforma);
        }
      }
      for (Plataforma plataformaCollectionNewPlataforma : plataformaCollectionNew) {
        if (!plataformaCollectionOld.contains(plataformaCollectionNewPlataforma)) {
          plataformaCollectionNewPlataforma.getVideojuegoCollection().add(videojuego);
          plataformaCollectionNewPlataforma = em.merge(plataformaCollectionNewPlataforma);
        }
      }
      for (ModoJuego modoJuegoCollectionOldModoJuego : modoJuegoCollectionOld) {
        if (!modoJuegoCollectionNew.contains(modoJuegoCollectionOldModoJuego)) {
          modoJuegoCollectionOldModoJuego.getVideojuegoCollection().remove(videojuego);
          modoJuegoCollectionOldModoJuego = em.merge(modoJuegoCollectionOldModoJuego);
        }
      }
      for (ModoJuego modoJuegoCollectionNewModoJuego : modoJuegoCollectionNew) {
        if (!modoJuegoCollectionOld.contains(modoJuegoCollectionNewModoJuego)) {
          modoJuegoCollectionNewModoJuego.getVideojuegoCollection().add(videojuego);
          modoJuegoCollectionNewModoJuego = em.merge(modoJuegoCollectionNewModoJuego);
        }
      }
      for (Dlc dlcCollectionNewDlc : dlcCollectionNew) {
        if (!dlcCollectionOld.contains(dlcCollectionNewDlc)) {
          Videojuego oldIdVideojuegoOfDlcCollectionNewDlc = dlcCollectionNewDlc.getIdVideojuego();
          dlcCollectionNewDlc.setIdVideojuego(videojuego);
          dlcCollectionNewDlc = em.merge(dlcCollectionNewDlc);
          if (oldIdVideojuegoOfDlcCollectionNewDlc != null && !oldIdVideojuegoOfDlcCollectionNewDlc.equals(videojuego)) {
            oldIdVideojuegoOfDlcCollectionNewDlc.getDlcCollection().remove(dlcCollectionNewDlc);
            oldIdVideojuegoOfDlcCollectionNewDlc = em.merge(oldIdVideojuegoOfDlcCollectionNewDlc);
          }
        }
      }
      em.getTransaction().commit();
    } catch (Exception ex) {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0) {
        Long id = videojuego.getIdVideojuego();
        if (findVideojuego(id) == null) {
          throw new NonexistentEntityException("The videojuego with id " + id + " no longer exists.");
        }
      }
      throw ex;
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      Videojuego videojuego;
      try {
        videojuego = em.getReference(Videojuego.class, id);
        videojuego.getIdVideojuego();
      } catch (EntityNotFoundException enfe) {
        throw new NonexistentEntityException("The videojuego with id " + id + " no longer exists.", enfe);
      }
      List<String> illegalOrphanMessages = null;
      Collection<Dlc> dlcCollectionOrphanCheck = videojuego.getDlcCollection();
      for (Dlc dlcCollectionOrphanCheckDlc : dlcCollectionOrphanCheck) {
        if (illegalOrphanMessages == null) {
          illegalOrphanMessages = new ArrayList<String>();
        }
        illegalOrphanMessages.add("This Videojuego (" + videojuego + ") cannot be destroyed since the Dlc " + dlcCollectionOrphanCheckDlc + " in its dlcCollection field has a non-nullable idVideojuego field.");
      }
      if (illegalOrphanMessages != null) {
        throw new IllegalOrphanException(illegalOrphanMessages);
      }
      Genero nombreGenero = videojuego.getNombreGenero();
      if (nombreGenero != null) {
        nombreGenero.getVideojuegoCollection().remove(videojuego);
        nombreGenero = em.merge(nombreGenero);
      }
      Plataforma nombrePlataforma = videojuego.getNombrePlataforma();
      if (nombrePlataforma != null) {
        nombrePlataforma.getVideojuegoCollection().remove(videojuego);
        nombrePlataforma = em.merge(nombrePlataforma);
      }
      Collection<Plataforma> plataformaCollection = videojuego.getPlataformaCollection();
      for (Plataforma plataformaCollectionPlataforma : plataformaCollection) {
        plataformaCollectionPlataforma.getVideojuegoCollection().remove(videojuego);
        plataformaCollectionPlataforma = em.merge(plataformaCollectionPlataforma);
      }
      Collection<ModoJuego> modoJuegoCollection = videojuego.getModoJuegoCollection();
      for (ModoJuego modoJuegoCollectionModoJuego : modoJuegoCollection) {
        modoJuegoCollectionModoJuego.getVideojuegoCollection().remove(videojuego);
        modoJuegoCollectionModoJuego = em.merge(modoJuegoCollectionModoJuego);
      }
      em.remove(videojuego);
      em.getTransaction().commit();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public List<Videojuego> findVideojuegoEntities() {
    return findVideojuegoEntities(true, -1, -1);
  }

  public List<Videojuego> findVideojuegoEntities(int maxResults, int firstResult) {
    return findVideojuegoEntities(false, maxResults, firstResult);
  }

  private List<Videojuego> findVideojuegoEntities(boolean all, int maxResults, int firstResult) {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(Videojuego.class));
      Query q = em.createQuery(cq);
      if (!all) {
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
      }
      return q.getResultList();
    } finally {
      em.close();
    }
  }

  public Videojuego findVideojuego(Long id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(Videojuego.class, id);
    } finally {
      em.close();
    }
  }

  public int getVideojuegoCount() {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<Videojuego> rt = cq.from(Videojuego.class);
      cq.select(em.getCriteriaBuilder().count(rt));
      Query q = em.createQuery(cq);
      return ((Long) q.getSingleResult()).intValue();
    } finally {
      em.close();
    }
  }
  
}
