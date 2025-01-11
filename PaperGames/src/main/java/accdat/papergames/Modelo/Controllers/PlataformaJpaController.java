/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accdat.papergames.Modelo.Controllers;

import accdat.papergames.Modelo.Controllers.exceptions.NonexistentEntityException;
import accdat.papergames.Modelo.Controllers.exceptions.PreexistingEntityException;
import accdat.papergames.Modelo.Persistencia.Plataforma;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import accdat.papergames.Modelo.Persistencia.Videojuego;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author rezzt
 */
public class PlataformaJpaController implements Serializable {

  public PlataformaJpaController(EntityManagerFactory emf) {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  public void create(Plataforma plataforma) throws PreexistingEntityException, Exception {
    if (plataforma.getVideojuegoCollection() == null) {
      plataforma.setVideojuegoCollection(new ArrayList<Videojuego>());
    }
    if (plataforma.getVideojuegoCollection1() == null) {
      plataforma.setVideojuegoCollection1(new ArrayList<Videojuego>());
    }
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      Collection<Videojuego> attachedVideojuegoCollection = new ArrayList<Videojuego>();
      for (Videojuego videojuegoCollectionVideojuegoToAttach : plataforma.getVideojuegoCollection()) {
        videojuegoCollectionVideojuegoToAttach = em.getReference(videojuegoCollectionVideojuegoToAttach.getClass(), videojuegoCollectionVideojuegoToAttach.getIdVideojuego());
        attachedVideojuegoCollection.add(videojuegoCollectionVideojuegoToAttach);
      }
      plataforma.setVideojuegoCollection(attachedVideojuegoCollection);
      Collection<Videojuego> attachedVideojuegoCollection1 = new ArrayList<Videojuego>();
      for (Videojuego videojuegoCollection1VideojuegoToAttach : plataforma.getVideojuegoCollection1()) {
        videojuegoCollection1VideojuegoToAttach = em.getReference(videojuegoCollection1VideojuegoToAttach.getClass(), videojuegoCollection1VideojuegoToAttach.getIdVideojuego());
        attachedVideojuegoCollection1.add(videojuegoCollection1VideojuegoToAttach);
      }
      plataforma.setVideojuegoCollection1(attachedVideojuegoCollection1);
      em.persist(plataforma);
      for (Videojuego videojuegoCollectionVideojuego : plataforma.getVideojuegoCollection()) {
        videojuegoCollectionVideojuego.getPlataformaCollection().add(plataforma);
        videojuegoCollectionVideojuego = em.merge(videojuegoCollectionVideojuego);
      }
      for (Videojuego videojuegoCollection1Videojuego : plataforma.getVideojuegoCollection1()) {
        Plataforma oldNombrePlataformaOfVideojuegoCollection1Videojuego = videojuegoCollection1Videojuego.getNombrePlataforma();
        videojuegoCollection1Videojuego.setNombrePlataforma(plataforma);
        videojuegoCollection1Videojuego = em.merge(videojuegoCollection1Videojuego);
        if (oldNombrePlataformaOfVideojuegoCollection1Videojuego != null) {
          oldNombrePlataformaOfVideojuegoCollection1Videojuego.getVideojuegoCollection1().remove(videojuegoCollection1Videojuego);
          oldNombrePlataformaOfVideojuegoCollection1Videojuego = em.merge(oldNombrePlataformaOfVideojuegoCollection1Videojuego);
        }
      }
      em.getTransaction().commit();
    } catch (Exception ex) {
      if (findPlataforma(plataforma.getNombrePlataforma()) != null) {
        throw new PreexistingEntityException("Plataforma " + plataforma + " already exists.", ex);
      }
      throw ex;
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void edit(Plataforma plataforma) throws NonexistentEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      Plataforma persistentPlataforma = em.find(Plataforma.class, plataforma.getNombrePlataforma());
      Collection<Videojuego> videojuegoCollectionOld = persistentPlataforma.getVideojuegoCollection();
      Collection<Videojuego> videojuegoCollectionNew = plataforma.getVideojuegoCollection();
      Collection<Videojuego> videojuegoCollection1Old = persistentPlataforma.getVideojuegoCollection1();
      Collection<Videojuego> videojuegoCollection1New = plataforma.getVideojuegoCollection1();
      Collection<Videojuego> attachedVideojuegoCollectionNew = new ArrayList<Videojuego>();
      for (Videojuego videojuegoCollectionNewVideojuegoToAttach : videojuegoCollectionNew) {
        videojuegoCollectionNewVideojuegoToAttach = em.getReference(videojuegoCollectionNewVideojuegoToAttach.getClass(), videojuegoCollectionNewVideojuegoToAttach.getIdVideojuego());
        attachedVideojuegoCollectionNew.add(videojuegoCollectionNewVideojuegoToAttach);
      }
      videojuegoCollectionNew = attachedVideojuegoCollectionNew;
      plataforma.setVideojuegoCollection(videojuegoCollectionNew);
      Collection<Videojuego> attachedVideojuegoCollection1New = new ArrayList<Videojuego>();
      for (Videojuego videojuegoCollection1NewVideojuegoToAttach : videojuegoCollection1New) {
        videojuegoCollection1NewVideojuegoToAttach = em.getReference(videojuegoCollection1NewVideojuegoToAttach.getClass(), videojuegoCollection1NewVideojuegoToAttach.getIdVideojuego());
        attachedVideojuegoCollection1New.add(videojuegoCollection1NewVideojuegoToAttach);
      }
      videojuegoCollection1New = attachedVideojuegoCollection1New;
      plataforma.setVideojuegoCollection1(videojuegoCollection1New);
      plataforma = em.merge(plataforma);
      for (Videojuego videojuegoCollectionOldVideojuego : videojuegoCollectionOld) {
        if (!videojuegoCollectionNew.contains(videojuegoCollectionOldVideojuego)) {
          videojuegoCollectionOldVideojuego.getPlataformaCollection().remove(plataforma);
          videojuegoCollectionOldVideojuego = em.merge(videojuegoCollectionOldVideojuego);
        }
      }
      for (Videojuego videojuegoCollectionNewVideojuego : videojuegoCollectionNew) {
        if (!videojuegoCollectionOld.contains(videojuegoCollectionNewVideojuego)) {
          videojuegoCollectionNewVideojuego.getPlataformaCollection().add(plataforma);
          videojuegoCollectionNewVideojuego = em.merge(videojuegoCollectionNewVideojuego);
        }
      }
      for (Videojuego videojuegoCollection1OldVideojuego : videojuegoCollection1Old) {
        if (!videojuegoCollection1New.contains(videojuegoCollection1OldVideojuego)) {
          videojuegoCollection1OldVideojuego.setNombrePlataforma(null);
          videojuegoCollection1OldVideojuego = em.merge(videojuegoCollection1OldVideojuego);
        }
      }
      for (Videojuego videojuegoCollection1NewVideojuego : videojuegoCollection1New) {
        if (!videojuegoCollection1Old.contains(videojuegoCollection1NewVideojuego)) {
          Plataforma oldNombrePlataformaOfVideojuegoCollection1NewVideojuego = videojuegoCollection1NewVideojuego.getNombrePlataforma();
          videojuegoCollection1NewVideojuego.setNombrePlataforma(plataforma);
          videojuegoCollection1NewVideojuego = em.merge(videojuegoCollection1NewVideojuego);
          if (oldNombrePlataformaOfVideojuegoCollection1NewVideojuego != null && !oldNombrePlataformaOfVideojuegoCollection1NewVideojuego.equals(plataforma)) {
            oldNombrePlataformaOfVideojuegoCollection1NewVideojuego.getVideojuegoCollection1().remove(videojuegoCollection1NewVideojuego);
            oldNombrePlataformaOfVideojuegoCollection1NewVideojuego = em.merge(oldNombrePlataformaOfVideojuegoCollection1NewVideojuego);
          }
        }
      }
      em.getTransaction().commit();
    } catch (Exception ex) {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0) {
        String id = plataforma.getNombrePlataforma();
        if (findPlataforma(id) == null) {
          throw new NonexistentEntityException("The plataforma with id " + id + " no longer exists.");
        }
      }
      throw ex;
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void destroy(String id) throws NonexistentEntityException {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      Plataforma plataforma;
      try {
        plataforma = em.getReference(Plataforma.class, id);
        plataforma.getNombrePlataforma();
      } catch (EntityNotFoundException enfe) {
        throw new NonexistentEntityException("The plataforma with id " + id + " no longer exists.", enfe);
      }
      Collection<Videojuego> videojuegoCollection = plataforma.getVideojuegoCollection();
      for (Videojuego videojuegoCollectionVideojuego : videojuegoCollection) {
        videojuegoCollectionVideojuego.getPlataformaCollection().remove(plataforma);
        videojuegoCollectionVideojuego = em.merge(videojuegoCollectionVideojuego);
      }
      Collection<Videojuego> videojuegoCollection1 = plataforma.getVideojuegoCollection1();
      for (Videojuego videojuegoCollection1Videojuego : videojuegoCollection1) {
        videojuegoCollection1Videojuego.setNombrePlataforma(null);
        videojuegoCollection1Videojuego = em.merge(videojuegoCollection1Videojuego);
      }
      em.remove(plataforma);
      em.getTransaction().commit();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public List<Plataforma> findPlataformaEntities() {
    return findPlataformaEntities(true, -1, -1);
  }

  public List<Plataforma> findPlataformaEntities(int maxResults, int firstResult) {
    return findPlataformaEntities(false, maxResults, firstResult);
  }

  private List<Plataforma> findPlataformaEntities(boolean all, int maxResults, int firstResult) {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(Plataforma.class));
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

  public Plataforma findPlataforma(String id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(Plataforma.class, id);
    } finally {
      em.close();
    }
  }

  public int getPlataformaCount() {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<Plataforma> rt = cq.from(Plataforma.class);
      cq.select(em.getCriteriaBuilder().count(rt));
      Query q = em.createQuery(cq);
      return ((Long) q.getSingleResult()).intValue();
    } finally {
      em.close();
    }
  }
  
}
