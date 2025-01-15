/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package accdat.papergames.Vista;

import accdat.papergames.Controlador.Controlador;
import accdat.papergames.Modelo.Persistencia.ModoJuego;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author rezzt
 */
public class VentanaPrincipal extends javax.swing.JFrame {
  private Controlador controlador;
  private List<Checkbox> listaGenerosSelected = new ArrayList<>();
  private List<Checkbox> listaPlataformasSelected = new ArrayList<>();
  private List<Integer> listaPEGISelected = new ArrayList<>();
  private List<Checkbox> listaModosJuegoSelected = new ArrayList<>();
  
  
  
  /**
   * Creates new form VentanaPrincipal
   */
  public VentanaPrincipal() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    scrollPaneListaVideojuegos = new javax.swing.JScrollPane();
    panelFiltros = new javax.swing.JPanel();
    txtGenero = new javax.swing.JLabel();
    txtPlataforma = new javax.swing.JLabel();
    txtAnioPublicacion = new javax.swing.JLabel();
    txtPrecio = new javax.swing.JLabel();
    txtPegi = new javax.swing.JLabel();
    txtModoJuego = new javax.swing.JLabel();
    panelOpcionesGenero = new javax.swing.JPanel();
    panelOpcionesPlataforma = new javax.swing.JPanel();
    panelOpcionesModoJuego = new javax.swing.JPanel();
    panelOpcionesPEGI = new javax.swing.JPanel();
    btnModificar = new javax.swing.JButton();
    btnSeleccionar = new javax.swing.JButton();
    btnEliminar = new javax.swing.JButton();
    btnBuscar = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setPreferredSize(new java.awt.Dimension(900, 800));

    panelFiltros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    txtGenero.setText("Género");

    txtPlataforma.setText("Plataforma");

    txtAnioPublicacion.setText("Año de publicación");

    txtPrecio.setText("Precio");

    txtPegi.setText("PEGI");

    txtModoJuego.setText("Modo de juego");
    txtModoJuego.setMaximumSize(new java.awt.Dimension(85, 17));
    txtModoJuego.setMinimumSize(new java.awt.Dimension(85, 17));
    txtModoJuego.setPreferredSize(new java.awt.Dimension(85, 17));

    javax.swing.GroupLayout panelOpcionesGeneroLayout = new javax.swing.GroupLayout(panelOpcionesGenero);
    panelOpcionesGenero.setLayout(panelOpcionesGeneroLayout);
    panelOpcionesGeneroLayout.setHorizontalGroup(
      panelOpcionesGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );
    panelOpcionesGeneroLayout.setVerticalGroup(
      panelOpcionesGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 112, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout panelOpcionesPlataformaLayout = new javax.swing.GroupLayout(panelOpcionesPlataforma);
    panelOpcionesPlataforma.setLayout(panelOpcionesPlataformaLayout);
    panelOpcionesPlataformaLayout.setHorizontalGroup(
      panelOpcionesPlataformaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );
    panelOpcionesPlataformaLayout.setVerticalGroup(
      panelOpcionesPlataformaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 124, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout panelOpcionesModoJuegoLayout = new javax.swing.GroupLayout(panelOpcionesModoJuego);
    panelOpcionesModoJuego.setLayout(panelOpcionesModoJuegoLayout);
    panelOpcionesModoJuegoLayout.setHorizontalGroup(
      panelOpcionesModoJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );
    panelOpcionesModoJuegoLayout.setVerticalGroup(
      panelOpcionesModoJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 112, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout panelOpcionesPEGILayout = new javax.swing.GroupLayout(panelOpcionesPEGI);
    panelOpcionesPEGI.setLayout(panelOpcionesPEGILayout);
    panelOpcionesPEGILayout.setHorizontalGroup(
      panelOpcionesPEGILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );
    panelOpcionesPEGILayout.setVerticalGroup(
      panelOpcionesPEGILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 100, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout panelFiltrosLayout = new javax.swing.GroupLayout(panelFiltros);
    panelFiltros.setLayout(panelFiltrosLayout);
    panelFiltrosLayout.setHorizontalGroup(
      panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelFiltrosLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(txtPegi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(txtModoJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(txtGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(txtPlataforma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(panelOpcionesGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(panelOpcionesPlataforma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(panelOpcionesModoJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(panelFiltrosLayout.createSequentialGroup()
            .addGap(13, 13, 13)
            .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(txtAnioPublicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
          .addComponent(panelOpcionesPEGI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    panelFiltrosLayout.setVerticalGroup(
      panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelFiltrosLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(txtGenero)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(panelOpcionesGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txtPlataforma)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(panelOpcionesPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txtModoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(panelOpcionesModoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txtPegi)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(panelOpcionesPEGI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
        .addComponent(txtAnioPublicacion)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txtPrecio))
    );

    btnModificar.setText("Modificar");
    btnModificar.setMaximumSize(new java.awt.Dimension(75, 30));
    btnModificar.setMinimumSize(new java.awt.Dimension(75, 30));
    btnModificar.setPreferredSize(new java.awt.Dimension(75, 30));
    btnModificar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnModificarActionPerformed(evt);
      }
    });

    btnSeleccionar.setText("Seleccionar");
    btnSeleccionar.setMaximumSize(new java.awt.Dimension(75, 30));
    btnSeleccionar.setMinimumSize(new java.awt.Dimension(75, 30));
    btnSeleccionar.setPreferredSize(new java.awt.Dimension(75, 30));

    btnEliminar.setText("Eliminar");
    btnEliminar.setMaximumSize(new java.awt.Dimension(75, 30));
    btnEliminar.setMinimumSize(new java.awt.Dimension(75, 30));
    btnEliminar.setPreferredSize(new java.awt.Dimension(75, 30));

    btnBuscar.setText("Buscar");
    btnBuscar.setMaximumSize(new java.awt.Dimension(75, 30));
    btnBuscar.setMinimumSize(new java.awt.Dimension(75, 30));
    btnBuscar.setPreferredSize(new java.awt.Dimension(75, 30));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(panelFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(btnSeleccionar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(scrollPaneListaVideojuegos, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(panelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(scrollPaneListaVideojuegos))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void iniciarComponentes () {
    panelOpcionesGenero.setLayout(new java.awt.GridLayout(0,1));
    panelOpcionesPlataforma.setLayout(new java.awt.GridLayout(0,1));
    panelOpcionesModoJuego.setLayout(new java.awt.GridLayout(0,1));
    panelOpcionesPEGI.setLayout(new java.awt.GridLayout(0,1));

    
    cargarOpcionesGenero();
    cargarOpcionesModosJuego();
    cargarOpcionesPlataforma();
  }
  
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new VentanaPrincipal().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnBuscar;
  private javax.swing.JButton btnEliminar;
  private javax.swing.JButton btnModificar;
  private javax.swing.JButton btnSeleccionar;
  private javax.swing.JPanel panelFiltros;
  private javax.swing.JPanel panelOpcionesGenero;
  private javax.swing.JPanel panelOpcionesModoJuego;
  private javax.swing.JPanel panelOpcionesPEGI;
  private javax.swing.JPanel panelOpcionesPlataforma;
  private javax.swing.JScrollPane scrollPaneListaVideojuegos;
  private javax.swing.JLabel txtAnioPublicacion;
  private javax.swing.JLabel txtGenero;
  private javax.swing.JLabel txtModoJuego;
  private javax.swing.JLabel txtPegi;
  private javax.swing.JLabel txtPlataforma;
  private javax.swing.JLabel txtPrecio;
  // End of variables declaration//GEN-END:variables
 //-------------------------------------------------------------------------------------------------------------->
  private void comprobarFiltrosSeleccionados () {
    List<String> listaCheckboxGeneros = new ArrayList<>();
    List<String> listaCheckBoxPlataforma = new ArrayList<>();
    List<String> listaCheckboxModoJuego = new ArrayList<>();
    
    for (Checkbox aux : listaGenerosSelected) {
      if (aux.getState() == true) {
        listaCheckboxGeneros.add(aux.getLabel());
      }
    }
    
    for (Checkbox aux : listaPlataformasSelected) {
      if (aux.getState() == true) {
        listaCheckBoxPlataforma.add(aux.getLabel());
      }
    }
    
    for (Checkbox aux : listaModosJuegoSelected) {
      if (aux.getState() == true) {
        listaCheckboxModoJuego.add(aux.getLabel());
      }
    }
  }
  
  
 //-------------------------------------------------------------------------------------------------------------->
  private void cargarOpcionesGenero () {
    panelOpcionesGenero.removeAll();
    List<String> listaGeneros = controlador.cargarNombresGeneros();
    
    for (String aux : listaGeneros) {
      java.awt.Checkbox genCheckBox = new Checkbox(aux, false);
      listaGenerosSelected.add(genCheckBox);
      panelOpcionesGenero.add(genCheckBox);
    }
  }
  
  private void cargarOpcionesPlataforma () {
    panelOpcionesPlataforma.removeAll();
    List<String> listaPlataformas = controlador.cargarNombresPlataformas();
    
    for (String aux : listaPlataformas) {
      java.awt.Checkbox genCheckBox = new Checkbox(aux, false);
      listaPlataformasSelected.add(genCheckBox);
      panelOpcionesPlataforma.add(genCheckBox);
    }
  }
  
  private void cargarOpcionesModosJuego () {
    panelOpcionesModoJuego.removeAll();
    List<String> listaModosJuego = controlador.cargarNombresModoJuego();
    
    for (String aux : listaModosJuego) {
      java.awt.Checkbox genCheckBox = new Checkbox(aux, false);
      listaModosJuegoSelected.add(genCheckBox);
      panelOpcionesModoJuego.add(genCheckBox);
    }
  }
  
  private void cargarOpcionesPEGI () {
    panelOpcionesPEGI.removeAll();
    List<String> listaPEGI = controlador.car
  }
  
 //-------------------------------------------------------------------------------------------------------------->
  
  
 //-------------------------------------------------------------------------------------------------------------->
  
  
 //-------------------------------------------------------------------------------------------------------------->
}
