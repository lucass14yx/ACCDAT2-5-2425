/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package accdat.papergames.Vista;

import accdat.papergames.Modelo.Persistencia.Dlc;
import accdat.papergames.Modelo.Persistencia.ModoJuego;
import accdat.papergames.Modelo.Persistencia.Plataforma;
import accdat.papergames.Modelo.Persistencia.Videojuego;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author rezzt
 */
public class VisorVideojuegos extends javax.swing.JPanel {
  private Videojuego baseVideojuego;
  private String titulo;
  private String descripcion;
  private int anioSalida;
  private String genero;
  private List<String> listaPlataformas;
  private int pegi;
  private List<String> listaModosJuego;
  private List<String> listaDLC;
  
  /**
   * Creates new form VisorVideojuegos
   */
  public VisorVideojuegos() {
    initComponents();
    vModoJuego.setEditable(false);
    vAnioSalida.setEditable(false);
    vDLC.setEditable(false);
    vDescripcion.setEditable(false);
    vGenero.setEditable(false);
    vPEGI.setEditable(false);
    vPlataformaText.setEditable(false);
    vTitulo.setEditable(false);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    vListaPlataforma = new javax.swing.JList<>();
    jScrollPane2 = new javax.swing.JScrollPane();
    vListaPlataforma1 = new javax.swing.JList<>();
    vDescripcion = new javax.swing.JTextField();
    vPlataformaText = new javax.swing.JTextField();
    vGenero = new javax.swing.JTextField();
    jScrollPane3 = new javax.swing.JScrollPane();
    vListaModoJuego = new javax.swing.JList<>();
    vAnioSalida = new javax.swing.JTextField();
    vPEGI = new javax.swing.JTextField();
    vModoJuego = new javax.swing.JTextField();
    vTitulo = new javax.swing.JTextField();
    vListaPlataformas = new javax.swing.JScrollPane();
    jListaPlataforma = new javax.swing.JList<>();
    vDLC = new javax.swing.JTextField();
    vListaDLC = new javax.swing.JScrollPane();
    vListaDLCs = new javax.swing.JList<>();

    vListaPlataforma.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    jScrollPane1.setViewportView(vListaPlataforma);

    vListaPlataforma1.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    jScrollPane2.setViewportView(vListaPlataforma1);

    setBackground(new java.awt.Color(200, 212, 227));
    setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

    vDescripcion.setEditable(false);
    vDescripcion.setFocusable(false);
    vDescripcion.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        vDescripcionActionPerformed(evt);
      }
    });

    vPlataformaText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    vPlataformaText.setText("Plataforma");

    vGenero.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    vListaModoJuego.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    vListaModoJuego.setFocusable(false);
    jScrollPane3.setViewportView(vListaModoJuego);
    vListaModoJuego.getAccessibleContext().setAccessibleParent(this);

    vModoJuego.setText("Modo de Juego");

    jListaPlataforma.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    jListaPlataforma.setFocusable(false);
    vListaPlataformas.setViewportView(jListaPlataforma);
    jListaPlataforma.getAccessibleContext().setAccessibleParent(this);

    vDLC.setText("DLC");

    vListaDLCs.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    vListaDLCs.setFocusable(false);
    vListaDLC.setViewportView(vListaDLCs);
    vListaDLCs.getAccessibleContext().setAccessibleParent(this);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(vDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(vPlataformaText, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
              .addComponent(vListaPlataformas))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(vModoJuego)
              .addComponent(jScrollPane3))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(vDLC)
              .addComponent(vListaDLC)))
          .addGroup(layout.createSequentialGroup()
            .addComponent(vTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(vGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(vAnioSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(vPEGI, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(vAnioSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(vPEGI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(vGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(vTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(vDescripcion)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(vPlataformaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(vModoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(vDLC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jScrollPane3)
              .addComponent(vListaPlataformas, javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(vListaDLC, javax.swing.GroupLayout.Alignment.TRAILING))))
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void vDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vDescripcionActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_vDescripcionActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JList<String> jListaPlataforma;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JTextField vAnioSalida;
  private javax.swing.JTextField vDLC;
  private javax.swing.JTextField vDescripcion;
  private javax.swing.JTextField vGenero;
  private javax.swing.JScrollPane vListaDLC;
  private javax.swing.JList<String> vListaDLCs;
  private javax.swing.JList<String> vListaModoJuego;
  private javax.swing.JList<String> vListaPlataforma;
  private javax.swing.JList<String> vListaPlataforma1;
  private javax.swing.JScrollPane vListaPlataformas;
  private javax.swing.JTextField vModoJuego;
  private javax.swing.JTextField vPEGI;
  private javax.swing.JTextField vPlataformaText;
  private javax.swing.JTextField vTitulo;
  // End of variables declaration//GEN-END:variables

  
  private void asignacionAtributos () {
    this.titulo = baseVideojuego.getTitulo();
    this.descripcion = baseVideojuego.getDescripcion();
    this.anioSalida = baseVideojuego.getAño();
    this.pegi = baseVideojuego.getPegi();
    this.genero = baseVideojuego.getNombreGenero().getNombreGenero();
    this.listaDLC = extraerNombreListaDLC(baseVideojuego.getDlcCollection());
    this.listaModosJuego = extraerNombreModosJuego(baseVideojuego.getModoJuegoCollection());
    this.listaPlataformas = extraerNombrePlataformas(baseVideojuego.getPlataformaCollection());
  }
  
  public void asignacionContenidoElementGraficos () {
    asignacionAtributos();
    
    vTitulo.setText(this.titulo);
    vGenero.setText(this.genero);
    vDescripcion.setText(this.descripcion);
    vAnioSalida.setText(Integer.toString(this.anioSalida));
    vPEGI.setText("PEGI " + Integer.toString(this.pegi));
    vListaDLCs.setListData(this.listaDLC.toArray(new String[listaDLC.size()]));
    vListaModoJuego.setListData(this.listaModosJuego.toArray(new String[listaModosJuego.size()]));
    jListaPlataforma.setListData(this.listaPlataformas.toArray(new String[listaPlataformas.size()]));
    
  }
  
  private List<String> extraerNombrePlataformas (Collection<Plataforma> inputListaPlataformas) {
    List<String> listaNombrePlataformas = new ArrayList<>();
    for (Plataforma aux : inputListaPlataformas) {
      listaNombrePlataformas.add(aux.getNombrePlataforma());
    }
    return listaNombrePlataformas;
  }
  private List<String> extraerNombreModosJuego (Collection<ModoJuego> inputListaModosJuego) {
    List<String> listaNombreModosJuego = new ArrayList<>();
    for (ModoJuego aux : inputListaModosJuego) {
      listaNombreModosJuego.add(aux.getNombreModoJuego());
    }
    return listaNombreModosJuego;
  }
  private List<String> extraerNombreListaDLC (Collection<Dlc> inputListaDlc) {
    List<String> listaNombreDLC = new ArrayList<>();
    for (Dlc aux : inputListaDlc) {
      listaNombreDLC.add(aux.getTitulo());
    }
    return listaNombreDLC;
  }
  
 //------------------------------------------------------------------------------->
   // getters & setters ->
  public Videojuego getBaseVideojuego() {
    return baseVideojuego;
  }

  public void setBaseVideojuego(Videojuego baseVideojuego) {
    this.baseVideojuego = baseVideojuego;
  }
  
}
