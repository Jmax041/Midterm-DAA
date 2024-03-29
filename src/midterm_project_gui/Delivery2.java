/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package midterm_project_gui;
import java.util.Random;


/**
 *
 * @author Jimuel
 */
public class Delivery2 extends javax.swing.JFrame {

    /**
     * Creates new form Delivery2
     */
    public Delivery2() {
        initComponents();
    }
    
    public Delivery2(String name, String address) {
        initComponents();
        this.Name_Input.setText(name);
        this.Address_Input.setText(address);
        String complete_address = address;
        
        // Split the complete address using comma as the separator
        String[] parts = complete_address.split(", ");
        
        // Extract the individual parts
        String customer_street = parts[1]; // Street Name
        
        // Generate Random Source of Package
        Random random = new Random();
        String sourceStreet = sources[random.nextInt(sources.length)];
        
        // Display source street to customer before converting to lowercase
        this.Street_Input.setText(sourceStreet);
        
        // Convert customer_street and source_street to lowercase for case-insensitive comparison
        customer_street = customer_street.toLowerCase();
        sourceStreet = sourceStreet.toLowerCase();
        
        // Find the indices of source and destination streets
        int sourceIndex = 0;
        int destinationIndex = 0;
        for (int i = 0; i < sources.length; i++) {
            if (sources[i].toLowerCase().equals(sourceStreet)) { // Convert source street to lowercase
                sourceIndex = i;
            }
            if (sources[i].toLowerCase().equals(customer_street)) { // Convert customer street to lowercase
                destinationIndex = i;
            }
        }
        
        // Retrieve the distance between the source and destination streets
        String distanceResult = distance[sourceIndex][destinationIndex + 1]; // +1 because the first column contains street names
        
        // Display distance to customer
        this.Distance_Input.setText(distanceResult + " meters");
    }
    
    // List of streetname and their distance
    private final String[][] distance = {
            {"St Peter", "0", "300", "150", "200"},
            {"St. John", "150", "0", "200", "300"},
            {"Lanao", "100", "120", "0", "200"},
            {"Maguindanao", "200", "200", "100", "0"}
    };
    
    // List of streetname for source of package
    private final String[] sources = {"St. Peter", "St. John", "Lanao", "Maguindanao"};

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Name_Input_Label = new javax.swing.JLabel();
        Name_Input = new javax.swing.JLabel();
        Address_Input_Label = new javax.swing.JLabel();
        Address_Input = new javax.swing.JLabel();
        Source_Input_Label = new javax.swing.JLabel();
        Street_Input = new javax.swing.JLabel();
        Distance_Input_Label = new javax.swing.JLabel();
        Distance_Input = new javax.swing.JLabel();
        Delivery_Scroll_Pane = new javax.swing.JScrollPane();
        Delivery_Table = new javax.swing.JTable();
        Proceed_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Midterm Project");

        Name_Input_Label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Name_Input_Label.setText("Customer Name:");

        Name_Input.setText(" Name");

        Address_Input_Label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Address_Input_Label.setText("Address:");

        Address_Input.setText("Address");

        Source_Input_Label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Source_Input_Label.setText("Source of Package:");

        Street_Input.setText("Random Street");

        Distance_Input_Label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Distance_Input_Label.setText("Distance:");

        Distance_Input.setText("Distance in meters");

        Delivery_Scroll_Pane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Delivery_Scroll_Pane.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Delivery_Scroll_Pane.setHorizontalScrollBar(null);

        Delivery_Table.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Delivery_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"St. Peter", "0", "300", "150", "200"},
                {"St. John", "150", "0", "200", "300"},
                {"Lanao", "100", "120", "0", "200"},
                {"Maguindanao", "200", "200", "100", "0"}
            },
            new String [] {
                "Source", "St. Peter", "St. John", "Lanao", "Maguindanao"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Delivery_Scroll_Pane.setViewportView(Delivery_Table);

        Proceed_Button.setText("Proceed");
        Proceed_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Proceed_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Address_Input_Label)
                            .addGap(411, 411, 411))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Address_Input, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(Source_Input_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Street_Input, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGap(6, 6, 6)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Name_Input_Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Name_Input, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Proceed_Button)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Distance_Input_Label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Distance_Input, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(Delivery_Scroll_Pane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Name_Input_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Name_Input, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Address_Input_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Address_Input, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Source_Input_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Street_Input, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Distance_Input_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Distance_Input, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Delivery_Scroll_Pane, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(Proceed_Button)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Proceed_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Proceed_ButtonActionPerformed
        
        StringMatching matchingWindow = new StringMatching(this.Address_Input.getText());
        matchingWindow.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Proceed_ButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Delivery2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Delivery2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Delivery2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Delivery2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Delivery2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Address_Input;
    private javax.swing.JLabel Address_Input_Label;
    private javax.swing.JScrollPane Delivery_Scroll_Pane;
    private javax.swing.JTable Delivery_Table;
    private javax.swing.JLabel Distance_Input;
    private javax.swing.JLabel Distance_Input_Label;
    private javax.swing.JLabel Name_Input;
    private javax.swing.JLabel Name_Input_Label;
    private javax.swing.JButton Proceed_Button;
    private javax.swing.JLabel Source_Input_Label;
    private javax.swing.JLabel Street_Input;
    // End of variables declaration//GEN-END:variables
}
