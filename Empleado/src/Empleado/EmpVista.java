package Empleado;
import java.util.Observer;
import javax.swing.UIManager;
import java.util.Observable;
public class EmpVista extends javax.swing.JFrame implements Observer { 
    public EmpVista() {
        initComponents();
        //se establece como default el boton deenviar reporte
        this.getRootPane().setDefaultButton(this.BotonReportar);
        //se invoca la clase servior creando un objeto y pasandole un puerto al constructor de servidor
        EmpServidor serv = new EmpServidor(5000);
        //al objeto servidor se le agrega un observador
        serv.addObserver(this);
        //se crea un theard el cual se le pasa como parametro de constructor el objeto servidor
        Thread thre = new Thread(serv);
        //se inicializa el theard
        thre.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        CuadroChat = new javax.swing.JTextArea();
        BotonReportar = new javax.swing.JButton();
        CuadroEnvio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CHAT - Empleado de Planta");
        setBackground(new java.awt.Color(102, 153, 255));

        CuadroChat.setBackground(new java.awt.Color(255, 204, 204));
        CuadroChat.setColumns(20);
        CuadroChat.setRows(5);
        jScrollPane1.setViewportView(CuadroChat);

        BotonReportar.setBackground(new java.awt.Color(255, 204, 204));
        BotonReportar.setFont(new java.awt.Font("Tempus Sans ITC", 2, 18)); // NOI18N
        BotonReportar.setLabel("Reportar");
        BotonReportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonReportarActionPerformed(evt);
            }
        });

        CuadroEnvio.setBackground(new java.awt.Color(153, 255, 255));
        CuadroEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuadroEnvioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonReportar)
                    .addComponent(CuadroEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotonReportar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CuadroEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonReportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonReportarActionPerformed
        // se define el string a obtener del campo de escritura del empleado  por medi de get       
        String nota = "Empleado Dice--> " + this.CuadroEnvio.getText() +  "\n";
        //se escribe  el string en el  campo detexto del chap por medio de append
        this.CuadroChat.append(nota);
        // se hace conexion y se envia el mensaje del empleado por medio dell constructor de la case cliente en su para metro string
        // tambien hay que dar el puerto y direccion ipv4 de la computadora jefe
        EmpCliente clien = new EmpCliente(5000,"192.168.12.50", nota);// se crea un objeto de la clase empleado cliente
        Thread threa = new Thread(clien);// se crea un thread pasandole como parametro en su constructor el Empleadocliente creado
        threa.start();// se inicializa el thread
    }//GEN-LAST:event_BotonReportarActionPerformed

    private void CuadroEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuadroEnvioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuadroEnvioActionPerformed

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
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmpVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonReportar;
    private javax.swing.JTextArea CuadroChat;
    private javax.swing.JTextField CuadroEnvio;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable obs, Object arget) {    
        this.CuadroChat.append((String) arget);
    }
}
