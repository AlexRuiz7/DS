package controlVelocidad;

/**
 *
 * @author pablorobles
 */
public class VentanaControl extends javax.swing.JFrame {
    
    /**
     * Creates new form VentanaSalpicadero
     */
    public VentanaControl() {
        initComponents();
    }
    
    private void initComponents() {

        panel_estado = new javax.swing.JPanel();
        etiqueta_estado = new javax.swing.JLabel();
        panel_botones = new javax.swing.JPanel();
        boton_encendido = new javax.swing.JToggleButton();
        boton_acelerar = new javax.swing.JButton();
        boton_frenar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_estado.setLayout(new java.awt.BorderLayout());

        etiqueta_estado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiqueta_estado.setText("APAGADO");
        panel_estado.add(etiqueta_estado, java.awt.BorderLayout.CENTER);

        getContentPane().add(panel_estado, java.awt.BorderLayout.PAGE_START);

        panel_botones.setLayout(new java.awt.GridLayout(1, 3));

        boton_encendido.setText("ENCENDER");
        panel_botones.add(boton_encendido);

        boton_acelerar.setText("ACELERAR");
        panel_botones.add(boton_acelerar);

        boton_frenar.setText("FRENAR");
        panel_botones.add(boton_frenar);

        getContentPane().add(panel_botones, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>                        

    synchronized private void boton_encendidoActionPerformed(java.awt.event.ActionEvent evt) {      
        System.out.println("CLICK");
        if(this.etiqueta_estado.getText().equals("APAGADO")){
            this.etiqueta_estado.setText("ENCENDIDO");
            this.boton_encendido.setText("APAGAR");
        }else{
            this.etiqueta_estado.setText("APAGADO");
            this.etiqueta_estado.setText("ENCENDER");
        }
    }
    
    synchronized private void boton_acelerarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(this.etiqueta_estado.getText().equals("FRENAR")){
            this.etiqueta_estado.setText("FRENANDO");
            this.boton_acelerar.setText("SOLTAR FRENO");
        }else{
            this.etiqueta_estado.setText("ENCENDIDO");
            this.boton_encendido.setText("FRENAR");
        }
    }
    
    synchronized private void boton_frenarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(this.etiqueta_estado.getText().equals("FRENAR")){
            this.etiqueta_estado.setText("FRENANDO");
            this.boton_acelerar.setText("SOLTAR FRENO");
        }else{
            this.etiqueta_estado.setText("ENCENDIDO");
            this.boton_encendido.setText("FRENAR");
        }
    }
    
        
    
   
   
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
            java.util.logging.Logger.getLogger(VentanaControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaControl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton boton_acelerar;
    private javax.swing.JToggleButton boton_encendido;
    private javax.swing.JButton boton_frenar;
    private javax.swing.JLabel etiqueta_estado;
    private javax.swing.JPanel panel_botones;
    private javax.swing.JPanel panel_estado;
    // End of variables declaration                    
}
