/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package midterm_project_gui;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
/**
 *
 * @author Jimuel
 */
public class SelectionSort1 extends javax.swing.JFrame {

    /**
     * Creates new form SelectionSort1
     */
    public SelectionSort1() {
        initComponents();
    }
    
    public SelectionSort1(ArrayList<Object[]> results) {
        initComponents();
        
        // Show result table
        this.updateResultTable(results);
    }
    
    // Method to update the result table with the selected items
    public final void updateResultTable(List<Object[]> selectedItems) {
        Object[][] data = new Object[selectedItems.size()][3];
        for (int i = 0; i < selectedItems.size(); i++) {
            Object[] item = selectedItems.get(i);
            data[i][0] = item[0]; // Product Name
            data[i][1] = item[1]; // Weight/Box
            data[i][2] = item[2]; // Amount
        }

        DefaultTableModel model = new DefaultTableModel(data,
                new String[]{"Product Name", "Weight/Box", "Amount"});
        Result_Table.setModel(model);
    }
    
    // Method to retrieve table data
    private ArrayList<Object[]> getTableData(JTable table) {
        ArrayList<Object[]> data = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            int colCount = model.getColumnCount();
            Object[] row = new Object[colCount];
            for (int j = 0; j < colCount; j++) {
                row[j] = model.getValueAt(i, j);
            }
            data.add(row);
        }
        return data;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Question_Label = new javax.swing.JLabel();
        Sort_Input = new javax.swing.JTextField();
        Sort_Label = new javax.swing.JLabel();
        Product_Name_Label = new javax.swing.JLabel();
        Weight_Label = new javax.swing.JLabel();
        Amount_Label = new javax.swing.JLabel();
        Result_Scroll_Pane = new javax.swing.JScrollPane();
        Result_Table = new javax.swing.JTable();
        Proceed_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Midterm  Project");

        Question_Label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Question_Label.setText("How do you wanna sort the previous results? (Type letter only):");

        Sort_Input.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Sort_Input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sort_InputActionPerformed(evt);
            }
        });

        Sort_Label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Sort_Label.setText("SORT BY:");

        Product_Name_Label.setText("a. Product Name");

        Weight_Label.setText("b. Weight (Highest to lowest)");

        Amount_Label.setText("c. Amount (Highest to lowest)");

        Result_Scroll_Pane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Result_Scroll_Pane.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        Result_Table.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        Result_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product Name", "Weight/Box", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Result_Scroll_Pane.setViewportView(Result_Table);

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
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Proceed_Button)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Result_Scroll_Pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Amount_Label)
                        .addComponent(Product_Name_Label)
                        .addComponent(Weight_Label)
                        .addComponent(Sort_Label)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Question_Label)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Sort_Input, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Question_Label, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(Sort_Input, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Sort_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Product_Name_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Weight_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Amount_Label)
                .addGap(18, 18, 18)
                .addComponent(Result_Scroll_Pane, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(Proceed_Button)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Sort_InputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sort_InputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Sort_InputActionPerformed

    private void Proceed_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Proceed_ButtonActionPerformed
        String input = Sort_Input.getText();
        ArrayList<Object[]> results = getTableData(Result_Table);


        if("a".equals(input) || "A".equals(input) || 
           "b".equals(input) || "B".equals(input) ||
           "c".equals(input) || "C".equals(input)){ // If input character is a, b or c, go to next window
            SelectionSort2 sortResults = new SelectionSort2(Sort_Input.getText(), results);
            sortResults.setVisible(true);
            this.dispose();
        }

        else{// Else display error message
            JOptionPane.showMessageDialog(this,
                "Invalid input! Input only from a to c",
                "Error", // Title of the dialog
                JOptionPane.ERROR_MESSAGE); // Message type
        }
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
            java.util.logging.Logger.getLogger(SelectionSort1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectionSort1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectionSort1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectionSort1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectionSort1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Amount_Label;
    private javax.swing.JButton Proceed_Button;
    private javax.swing.JLabel Product_Name_Label;
    private javax.swing.JLabel Question_Label;
    private javax.swing.JScrollPane Result_Scroll_Pane;
    private javax.swing.JTable Result_Table;
    private javax.swing.JTextField Sort_Input;
    private javax.swing.JLabel Sort_Label;
    private javax.swing.JLabel Weight_Label;
    // End of variables declaration//GEN-END:variables
}