/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accdat.papergames.Modelo.Persistencia;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author rezzt
 */
@Entity
@Table(name = "GENERO")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Genero.findAll", query = "SELECT g FROM Genero g"),
  @NamedQuery(name = "Genero.findByNombreGenero", query = "SELECT g FROM Genero g WHERE g.nombreGenero = :nombreGenero")})
public class Genero implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "NOMBRE_GENERO")
  private String nombreGenero;
  @OneToMany(mappedBy = "nombreGenero")
  private Collection<Videojuego> videojuegoCollection;

  public Genero() {
  }

  public Genero(String nombreGenero) {
    this.nombreGenero = nombreGenero;
  }

  public String getNombreGenero() {
    return nombreGenero;
  }

  public void setNombreGenero(String nombreGenero) {
    this.nombreGenero = nombreGenero;
  }

  @XmlTransient
  public Collection<Videojuego> getVideojuegoCollection() {
    return videojuegoCollection;
  }

  public void setVideojuegoCollection(Collection<Videojuego> videojuegoCollection) {
    this.videojuegoCollection = videojuegoCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (nombreGenero != null ? nombreGenero.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Genero)) {
      return false;
    }
    Genero other = (Genero) object;
    if ((this.nombreGenero == null && other.nombreGenero != null) || (this.nombreGenero != null && !this.nombreGenero.equals(other.nombreGenero))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "accdat.papergames.Modelo.Persistencia.Genero[ nombreGenero=" + nombreGenero + " ]";
  }
  
}
