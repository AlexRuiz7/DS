package observador;

import observable.Temperatura;

/**
 *
 * @author alex
 */
public class BotonCambio extends ObservadorTemperatura {
    
    /**
     * Constructor
     * @param t 
     */
    public BotonCambio(Temperatura t) {
        super(t);
        initComponents();
    }
    
    @Override
    public String toString() {
        return "BotonCambio: " + miTemperatura;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textField_temp = new javax.swing.JTextField();
        boton = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(150, 60));
        setPreferredSize(new java.awt.Dimension(140, 60));
        setLayout(new java.awt.BorderLayout());

        textField_temp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textField_temp.setText("0.00");
        textField_temp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_tempActionPerformed(evt);
            }
        });
        add(textField_temp, java.awt.BorderLayout.CENTER);

        boton.setText("Cambiar");
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActionPerformed(evt);
            }
        });
        add(boton, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActionPerformed
        double nueva_temp = Double.parseDouble(textField_temp.getText());
        miObservable.setTemperatura(nueva_temp);
    }//GEN-LAST:event_botonActionPerformed

    private void textField_tempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_tempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_tempActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton;
    private javax.swing.JTextField textField_temp;
    // End of variables declaration//GEN-END:variables
}
