
package GUI.MonitorMecanico;

import controlVelocidad.Objetivo;

/**
 *
 * @author alex
 */
public class MonitorMecanicoSteelSeries extends javax.swing.JPanel {

    /**
     * Creates new form MonitorMecanico
     */
    public MonitorMecanicoSteelSeries() {
        initComponents();
    }
    
    public void setObjetivo(Objetivo motor) {
        panelAceite.setObservable(motor);
        panelFrenos.setObservable(motor);
        panelRevision.setObservable(motor);
        this.combustibleSteelSeries.setObservable(motor);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMecanica = new javax.swing.JPanel();
        panelAceite = new GUI.MonitorMecanico.ControlAceite();
        panelFrenos = new GUI.MonitorMecanico.ControlFrenos();
        panelRevision = new GUI.MonitorMecanico.ControlRevision();
        combustibleSteelSeries = new GUI.MonitorMecanico.CombustibleSteelSeries();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Monitorización"));
        setLayout(new java.awt.GridLayout(2, 1));

        panelMecanica.setBorder(javax.swing.BorderFactory.createTitledBorder("Mecánica"));
        panelMecanica.setLayout(new java.awt.GridLayout(3, 0));
        panelMecanica.add(panelAceite);
        panelMecanica.add(panelFrenos);
        panelMecanica.add(panelRevision);

        add(panelMecanica);
        add(combustibleSteelSeries);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.MonitorMecanico.CombustibleSteelSeries combustibleSteelSeries;
    private GUI.MonitorMecanico.ControlAceite panelAceite;
    private GUI.MonitorMecanico.ControlFrenos panelFrenos;
    private javax.swing.JPanel panelMecanica;
    private GUI.MonitorMecanico.ControlRevision panelRevision;
    // End of variables declaration//GEN-END:variables
}
