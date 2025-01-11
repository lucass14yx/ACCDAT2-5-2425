/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accdat.papergames.Modelo.Persistencia;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author rezzt
 */
@Entity
@Table(name = "DLC")
@NamedQueries({
  @NamedQuery(name = "Dlc.findAll", query = "SELECT d FROM Dlc d"),
  @NamedQuery(name = "Dlc.findByIdDlc", query = "SELECT d FROM Dlc d WHERE d.idDlc = :idDlc"),
  @NamedQuery(name = "Dlc.findByTitulo", query = "SELECT d FROM Dlc d WHERE d.titulo = :titulo"),
  @NamedQuery(name = "Dlc.findByPrecio", query = "SELECT d FROM Dlc d WHERE d.precio = :precio")})
public class Dlc implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID_DLC")
  private Long idDlc;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 200)
  @Column(name = "TITULO")
  private String titulo;
  @Lob
  @Column(name = "DESCRIPCION")
  private String descripcion;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "PRECIO")
  private BigDecimal precio;
  @JoinColumn(name = "ID_VIDEOJUEGO", referencedColumnName = "ID_VIDEOJUEGO")
  @ManyToOne(optional = false)
  private Videojuego idVideojuego;

  public Dlc() {
  }

  public Dlc(Long idDlc) {
    this.idDlc = idDlc;
  }

  public Dlc(Long idDlc, String titulo, BigDecimal precio) {
    this.idDlc = idDlc;
    this.titulo = titulo;
    this.precio = precio;
  }

  public Long getIdDlc() {
    return idDlc;
  }

  public void setIdDlc(Long idDlc) {
    this.idDlc = idDlc;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public BigDecimal getPrecio() {
    return precio;
  }

  public void setPrecio(BigDecimal precio) {
    this.precio = precio;
  }

  public Videojuego getIdVideojuego() {
    return idVideojuego;
  }

  public void setIdVideojuego(Videojuego idVideojuego) {
    this.idVideojuego = idVideojuego;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idDlc != null ? idDlc.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Dlc)) {
      return false;
    }
    Dlc other = (Dlc) object;
    if ((this.idDlc == null && other.idDlc != null) || (this.idDlc != null && !this.idDlc.equals(other.idDlc))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "accdat.papergames.Modelo.Persistencia.Dlc[ idDlc=" + idDlc + " ]";
  }
  
}
