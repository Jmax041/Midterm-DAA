/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package midterm_project_gui;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jimuel
 */
public class Knapsack2 extends javax.swing.JFrame {

    /**
     * Creates new form Knapsack2
     */
    public Knapsack2() {
        initComponents();
    }
    
    public Knapsack2(String input){
        initComponents();
        this.User_Weight_Input.setText(input);
        double totalWeight = Double.parseDouble(input);
        Knapsack2 solver = new Knapsack2();

        // Perform knapsack algorithm to find most valuable subset
        List<Object[]> results = solver.knapsack(products, totalWeight);
        
        // Update result table
        String total = this.updateResultTable(results);
        
        // Split the string using space as the separator
        String[] parts = total.split(" ");
        
        // Extract the individual parts
        String part1 = parts[0]; // total weight
        String part2 = parts[1]; // total amount
        
        this.Total_Weight_Value.setText(part1);
        this.Total_Amount_Value.setText(part2);

    }
    // List of products and their information
    private final Object[][] products = {
            {"Soap", 7.0, 500},
            {"Noodles", 2.5, 375},
            {"Canned Goods", 5.0, 450},
            {"Cooking Oil", 3.0, 725}
    };
    
    // Knapsack algorithm implementation
    private List<Object[]> knapsack(Object[][] products, double totalWeight) {
        List<Object[]> selectedItems = new ArrayList<>();
        knapsackHelper(products, totalWeight, 0, selectedItems, new ArrayList<>());
        return selectedItems;
    }

    private void knapsackHelper(Object[][] products, double remainingWeight, int index, List<Object[]> selectedItems, List<Object[]> currentList) {
        if (index == products.length) { // If all items have been considered
            double currentListValue = calculateTotalValue(currentList);
            double selectedListValue = calculateTotalValue(selectedItems);
            if (currentListValue > selectedListValue) {
                selectedItems.clear();
                selectedItems.addAll(new ArrayList<>(currentList));
            }
            return;
        }

        // Skip the current item
        knapsackHelper(products, remainingWeight, index + 1, selectedItems, currentList);

        // Include the current item if it fits
        double weight = (double) products[index][1];
        if (weight <= remainingWeight) {
            currentList.add(products[index]);
            knapsackHelper(products, remainingWeight - weight, index + 1, selectedItems, currentList); 
            currentList.remove(currentList.size() - 1); // backtrack by removing the last item and explore other paths    
        }
    }
    
    // Method to calculate total value
    private double calculateTotalValue(List<Object[]> items) {
        double totalValue = 0;
        for (Object[] item : items) {
            totalValue += (int) item[2];
        }
        return totalValue;
    }
    
    // Method to update the result table with the selected items
    public final String updateResultTable(List<Object[]> selectedItems) {
        Object[][] data = new Object[selectedItems.size() ][3]; // 
        double totalWeight = 0;
        int totalAmount = 0;
        for (int i = 0; i < selectedItems.size(); i++) {
            Object[] item = selectedItems.get(i);
            data[i][0] = item[0]; // Product Name
            data[i][1] = item[1]; // Weight/Box
            data[i][2] = item[2]; // Amount
            totalWeight += (double) item[1]; // Add weight of selected item to totalWeight
            totalAmount += (int) item[2]; // Add amount of selected item to totalAmount
        }

        DefaultTableModel model = new DefaultTableModel(data,
                new String[]{"Product Name", "Weight/Box", "Amount"});
        Result_Table.setModel(model);
        
        // Return the totals as a single string
        String total_weight_text = Double.toString(totalWeight);
        String total_amount_text = Integer.toString(totalAmount);
        String total = total_weight_text +" " + total_amount_text;
        return total;
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

        Best_Weight_Amount_Label = new javax.swing.JLabel();
        Result_Scroll_Pane = new javax.swing.JScrollPane();
        Result_Table = new javax.swing.JTable();
        Weight_Input_Label = new javax.swing.JLabel();
        User_Weight_Input = new javax.swing.JLabel();
        Proceed_Button = new javax.swing.JButton();
        Total_Weight_Value = new javax.swing.JLabel();
        Total_Amount_Value = new javax.swing.JLabel();
        Total_Label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Midterm Project");

        Best_Weight_Amount_Label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Best_Weight_Amount_Label.setText("Table below shows most valuable subset of items that fit the weight of the vehicle:");

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

        Weight_Input_Label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Weight_Input_Label.setText("Given weight:");

        User_Weight_Input.setText("Weight");

        Proceed_Button.setText("Proceed");
        Proceed_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Proceed_ButtonActionPerformed(evt);
            }
        });

        Total_Weight_Value.setText("Total_Weight");

        Total_Amount_Value.setText("Total_Amount");

        Total_Label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Total_Label.setText("TOTAL:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Proceed_Button)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Weight_Input_Label)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(User_Weight_Input, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(Result_Scroll_Pane)
                        .addComponent(Best_Weight_Amount_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(Total_Label)
                .addGap(95, 95, 95)
                .addComponent(Total_Weight_Value)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Total_Amount_Value)
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Weight_Input_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(User_Weight_Input, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Best_Weight_Amount_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Result_Scroll_Pane, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Total_Weight_Value)
                    .addComponent(Total_Amount_Value)
                    .addComponent(Total_Label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(Proceed_Button)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Proceed_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Proceed_ButtonActionPerformed
        
        ArrayList<Object[]> results = getTableData(Result_Table);
        
        SelectionSort1 Sort1 = new SelectionSort1(results);
        Sort1.setVisible(true);
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
            java.util.logging.Logger.getLogger(Knapsack2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Knapsack2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Knapsack2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Knapsack2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Knapsack2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Best_Weight_Amount_Label;
    private javax.swing.JButton Proceed_Button;
    private javax.swing.JScrollPane Result_Scroll_Pane;
    private javax.swing.JTable Result_Table;
    private javax.swing.JLabel Total_Amount_Value;
    private javax.swing.JLabel Total_Label;
    private javax.swing.JLabel Total_Weight_Value;
    private javax.swing.JLabel User_Weight_Input;
    private javax.swing.JLabel Weight_Input_Label;
    // End of variables declaration//GEN-END:variables
}
