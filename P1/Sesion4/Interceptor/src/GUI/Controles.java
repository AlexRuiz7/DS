package GUI;

import controlVelocidad.Cliente;
import controlVelocidad.EstadoMotor;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablorobles
 */
public class Controles extends javax.swing.JPanel implements Runnable {

    protected EstadoMotor estado;
    private Cliente controlador;
    public Thread hebra;
    
    
    /**
     * Creates new form VentanaControl
     */
    public Controles() {
        initComponents();
        estado = EstadoMotor.APAGADO;
        hebra = new Thread(this, "Controles");
    }
    
    
    @Override
    public void run() {
        while(true) {
            try {
                enviarPeticion();
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Controles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    public EstadoMotor getEstado() {
        return estado;
    }

    
    public void setEstado(EstadoMotor estado) {
        this.estado = estado;
    }
    
    
    public void setControlador(Cliente c) {
        controlador = c;
        hebra.start();
    }
    
    private void enviarPeticion() {
        controlador.enviarPeticion(estado);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_estado = new javax.swing.JPanel();
        etiqueta_estado = new javax.swing.JLabel();
        panel_botones = new javax.swing.JPanel();
        boton_encendido = new javax.swing.JToggleButton();
        boton_acelerador = new javax.swing.JButton();
        boton_freno = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("mandos"));

        panel_estado.setLayout(new java.awt.BorderLayout());

        etiqueta_estado.setForeground(java.awt.Color.red);
        etiqueta_estado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiqueta_estado.setText("APAGADO");
        etiqueta_estado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        etiqueta_estado.setOpaque(true);
        panel_estado.add(etiqueta_estado, java.awt.BorderLayout.CENTER);

        panel_botones.setLayout(new java.awt.GridLayout(1, 3));

        boton_encendido.setForeground(java.awt.Color.green);
        boton_encendido.setText("ENCENDER");
        boton_encendido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_encendidoActionPerformed(evt);
            }
        });
        panel_botones.add(boton_encendido);

        boton_acelerador.setText("ACELERAR");
        boton_acelerador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_aceleradorMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                boton_aceleradorMouseReleased(evt);
            }
        });
        panel_botones.add(boton_acelerador);

        boton_freno.setText("FRENAR");
        boton_freno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boton_frenoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                boton_frenoMouseReleased(evt);
            }
        });
        panel_botones.add(boton_freno);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 672, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panel_botones, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 82, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 12, Short.MAX_VALUE)
                    .addComponent(panel_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(panel_botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 12, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boton_encendidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_encendidoActionPerformed
        if(this.etiqueta_estado.getText().equals("APAGADO")) {
            this.etiqueta_estado.setText("ENCENDIDO");
            this.setEstado(EstadoMotor.ENCENDIDO);
            this.boton_encendido.setText("APAGAR");
            this.boton_encendido.setForeground(Color.red);
        } 
        else {
            this.etiqueta_estado.setText("APAGADO");
            this.setEstado(EstadoMotor.APAGADO);
            this.boton_encendido.setText("ENCENDER");
            this.boton_encendido.setForeground(Color.green);
        }
    }//GEN-LAST:event_boton_encendidoActionPerformed

    private void boton_aceleradorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_aceleradorMousePressed
        if(this.etiqueta_estado.getText().equals("ENCENDIDO")) {
            this.etiqueta_estado.setText("ACELERANDO");
            this.setEstado(EstadoMotor.ACELERANDO);
            this.etiqueta_estado.setForeground(Color.red);
            this.boton_acelerador.setText("Soltar acelerador");
            this.boton_acelerador.setForeground(Color.red);
        }
    }//GEN-LAST:event_boton_aceleradorMousePressed

    private void boton_aceleradorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_aceleradorMouseReleased
        if(this.etiqueta_estado.getText().equals("ACELERANDO")) {
            this.etiqueta_estado.setText("ENCENDIDO");
            this.setEstado(EstadoMotor.ENCENDIDO);
            this.etiqueta_estado.setForeground(Color.black);
            this.boton_acelerador.setText("ACELERAR");
            this.boton_acelerador.setForeground(Color.black);
        }
    }//GEN-LAST:event_boton_aceleradorMouseReleased

    private void boton_frenoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_frenoMousePressed
        if(this.etiqueta_estado.getText().equals("ENCENDIDO")) {
            this.etiqueta_estado.setText("FRENANDO");
            this.setEstado(EstadoMotor.FRENANDO);
            this.etiqueta_estado.setForeground(Color.red);
            this.boton_freno.setText("Soltar freno");
            this.boton_freno.setForeground(Color.red);
        }
    }//GEN-LAST:event_boton_frenoMousePressed

    private void boton_frenoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_frenoMouseReleased
        if(this.etiqueta_estado.getText().equals("FRENANDO")) {
            this.etiqueta_estado.setText("ENCENDIDO");
            this.setEstado(EstadoMotor.ENCENDIDO);
            this.etiqueta_estado.setForeground(Color.black);
            this.boton_freno.setText("FRENAR");
            this.boton_freno.setForeground(Color.black);
        }
    }//GEN-LAST:event_boton_frenoMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_acelerador;
    private javax.swing.JToggleButton boton_encendido;
    private javax.swing.JButton boton_freno;
    private javax.swing.JLabel etiqueta_estado;
    private javax.swing.JPanel panel_botones;
    private javax.swing.JPanel panel_estado;
    // End of variables declaration//GEN-END:variables
}
