/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.log;

import java.util.Calendar;
import vista.VentanaPrincipal;

/**
 *
 * @author JoseAntonio
 */
public class Log extends javax.swing.JPanel {

    /**
     * Creates new form Log
     */
    private long tamFile = 0;

    private VentanaPrincipal padre;

    public Log(VentanaPrincipal padre) {
        initComponents();
        initComponents();
        this.logTA.setEditable(false);
        this.padre = padre;
    }

    public void timeS() {
        Calendar c1 = Calendar.getInstance();
        String[] date = c1.getTime().toString().split("CEST");
        String cad = StartL.getText();
        cad = cad.trim();
        if (cad.compareToIgnoreCase("Start Time:") == 0) {
            StartL.setText(cad + date[0]);
        }
    }

    public void timeF(int i) {

        String cad = FinishL.getText();

        if (cad.compareToIgnoreCase("Orientative time:") == 0) {
            tamFile = i;
            if (i == 100) {
                FinishL.setText(FinishL.getText() + " Undenifnied");
            } else {
                FinishL.setText(FinishL.getText() + " " + (i / 60) + " minute/s");
            }
        }

        if (tamFile < i) {
            tamFile = i;
            writeLog("Last loading file has increased the finish time due to its size", true);
            if (i == 100) {
                FinishL.setText(FinishL.getText() + " Undenifnied");
            } else {
                FinishL.setText(FinishL.getText() + " " + (i / 60) + " minute/s");
            }
        }
    }

    public void clearTime() {
        StartL.setText("Start Time:");
        FinishL.setText("Orientative time:");

    }

    public void writeLog(String text, boolean imp) {

        if (imp) {
            Calendar c1 = Calendar.getInstance();
            String[] date = c1.getTime().toString().split("CEST");
            //String log = "\n"+"["+date[0]+"] - "+text;
            this.logTA.setText(this.logTA.getText() + "\n" + "[" + date[0] + "] - " + text);
        } else {
            this.logTA.setText(this.logTA.getText() + "\n" + "" + text);
        }

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
        logTA = new javax.swing.JTextArea();
        FinishL = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        StartL = new javax.swing.JLabel();

        logTA.setColumns(20);
        logTA.setRows(5);
        jScrollPane1.setViewportView(logTA);

        FinishL.setText("Orientative time:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Log");

        jButton2.setText("Clean");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        StartL.setText("Start Time: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FinishL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(StartL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(StartL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FinishL)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.logTA.setText("");
        StartL.setText("Start Time:");
        FinishL.setText("Orientative time:");
        tamFile = 0;
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FinishL;
    private javax.swing.JLabel StartL;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea logTA;
    // End of variables declaration//GEN-END:variables
}
