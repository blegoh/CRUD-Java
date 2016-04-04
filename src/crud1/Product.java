/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author blegoh
 */
public class Product extends javax.swing.JFrame {

    private Koneksi kon;
    private String categoryId[];
    private String supplierId[];
    private DefaultTableModel tabelModel;

    public Product() throws SQLException {
        kon = new Koneksi("root", "hornline", "northwind");
        initComponents();
        Object[] header = {"ID", "Product Name", "Category", "Supplier", "Unit Price"};
        tabelModel = new DefaultTableModel(null, header);
        tabel.setModel(tabelModel);
        showData();
        isiCategory();
        isiSupplier();
    }

    private void isiCategory() throws SQLException {
        String sql = "select * from Categories";
        ResultSet rs = kon.getResult(sql);
        int index = 0;
        rs.last();
        categoryId = new String[rs.getRow()];
        rs.beforeFirst();
        while (rs.next()) {
            categoryId[index++] = rs.getString(1);
            category.addItem(rs.getString(2));
        }
    }

    private void isiSupplier() throws SQLException {
        String sql = "select * from Suppliers";
        ResultSet rs = kon.getResult(sql);
        int index = 0;
        rs.last();
        supplierId = new String[rs.getRow()];
        rs.beforeFirst();
        while (rs.next()) {
            supplierId[index++] = rs.getString(1);
            supplier.addItem(rs.getString(2));
        }
    }

    private void showData() throws SQLException {
        clearTable();
        String sql = "SELECT ProductID,ProductName,Categories.CategoryName,Suppliers.CompanyName,UnitPrice "
                + "FROM `Products` "
                + "JOIN Categories on Products.CategoryID = Categories.CategoryID "
                + "JOIN Suppliers on Products.SupplierID = Suppliers.SupplierID "
                + "Order By ProductID";
        ResultSet rs = kon.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[5];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tabelModel.addRow(kolom);
        }
    }

    private void clearTable() {
        for (int i = tabelModel.getRowCount() - 1; i >= 0; i--) {
            tabelModel.removeRow(i);
        }
    }

    private void add() throws SQLException {
        String productName = this.productName.getText();
        String categoryId = this.categoryId[category.getSelectedIndex()];
        String supplierId = this.supplierId[supplier.getSelectedIndex()];
        String quantityPerUnit = this.quantityPerUnit.getText();
        String unitPrice = this.unitPrice.getText();
        String unitsInStock = this.unitsInStock.getText();
        String unitsOnOrder = this.unitsOnOrder.getText();
        String reorderLevel = this.reorderLevel.getText();
        String discontinued = this.discontinued.getText();
        String sql = "insert into Products values(Null,'" + productName + "',"
                + supplierId + "," + categoryId + ",'" + quantityPerUnit + "',"
                + unitPrice + "," + unitsInStock + "," + unitsOnOrder + "," + reorderLevel + ","
                + discontinued + ")";
        kon.execute(sql);
    }

    private void edit() throws SQLException {
        String productName = this.productName.getText();
        String categoryId = this.categoryId[category.getSelectedIndex()];
        String supplierId = this.supplierId[supplier.getSelectedIndex()];
        String quantityPerUnit = this.quantityPerUnit.getText();
        String unitPrice = this.unitPrice.getText();
        String unitsInStock = this.unitsInStock.getText();
        String unitsOnOrder = this.unitsOnOrder.getText();
        String reorderLevel = this.reorderLevel.getText();
        String discontinued = this.discontinued.getText();
        String id = valueId.getText();
        String sql = "update Products set ProductName = '" + productName + "',"
                + "CategoryID = " + categoryId + ","
                + "SupplierID = " + supplierId + ","
                + "QuantityPerUnit = '" + quantityPerUnit + "',"
                + "UnitPrice = " + unitPrice + ","
                + "UnitsInStock = " + unitsInStock + ","
                + "UnitsOnOrder = " + unitsOnOrder + ","
                + "ReorderLevel = " + reorderLevel + ","
                + "Discontinued = " + discontinued
                + " where ProductID = " + id;
        kon.execute(sql);
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
        jTable1 = new javax.swing.JTable();
        lblId = new javax.swing.JLabel();
        valueId = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        productName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        supplier = new javax.swing.JComboBox();
        category = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        quantityPerUnit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        unitPrice = new javax.swing.JTextField();
        unitsInStock = new javax.swing.JTextField();
        unitsOnOrder = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        reorderLevel = new javax.swing.JTextField();
        discontinued = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Product Name");

        jLabel4.setText("Supplier");

        jLabel5.setText("Category");

        jLabel6.setText("QuantityPerUnit");

        jLabel7.setText("UnitPrice");

        jLabel8.setText("UnitsInStock");

        jLabel9.setText("UnitsOnOrder");

        unitsInStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitsInStockActionPerformed(evt);
            }
        });

        jLabel10.setText("ReorderLevel");

        jLabel11.setText("Discontinued");

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.setEnabled(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(lblId)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel11)
                        .addComponent(jLabel10)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                        .addGap(81, 81, 81))
                    .addComponent(valueId)
                    .addComponent(productName)
                    .addComponent(quantityPerUnit)
                    .addComponent(unitPrice)
                    .addComponent(unitsInStock)
                    .addComponent(unitsOnOrder)
                    .addComponent(reorderLevel)
                    .addComponent(discontinued)
                    .addComponent(category, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(supplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(valueId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(supplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(quantityPerUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(unitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(unitsInStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(unitsOnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(reorderLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(discontinued, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void unitsInStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitsInStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitsInStockActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (valueId.getText().equals("")) {
                add();
            } else {
                edit();
            }
            clearData();
            showData();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void clearData(){
        lblId.setText("");
        valueId.setText("");
        productName.setText("");
        supplier.setSelectedIndex(0);
        category.setSelectedIndex(0);
        quantityPerUnit.setText("");
        unitPrice.setText("");
        unitsInStock.setText("");
        unitsOnOrder.setText("");
        reorderLevel.setText("");
        discontinued.setText("");
    }
    
    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        btnEdit.setEnabled(true);
        btnDelete.setEnabled(true);
    }//GEN-LAST:event_tabelMouseClicked
    
    private int getSupplierIndex(String suplierId){
        for (int i = 0; i < this.supplierId.length; i++) {
            if (suplierId.equals(this.supplierId[i])) {
                return i;
            }
        }
        return -1;
    }
    
    private int getCategoryIndex(String CategoryId){
        for (int i = 0; i < this.categoryId.length; i++) {
            if (CategoryId.equals(this.categoryId[i])) {
                return i;
            }
        }
        return -1;
    }
    
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            int baris = tabel.getSelectedRow();
            String sql = "select * from Products where ProductID = "+tabel.getValueAt(baris, 0);
            ResultSet rs = kon.getResult(sql);
            rs.next();
            lblId.setText("Product ID");
            valueId.setText(rs.getString(1));
            productName.setText(rs.getString(2));
            supplier.setSelectedIndex(getSupplierIndex(rs.getString(3)));
            category.setSelectedIndex(getCategoryIndex(rs.getString(4)));
            quantityPerUnit.setText(rs.getString(5));
            unitPrice.setText(rs.getString(6));
            unitsInStock.setText(rs.getString(7));
            unitsOnOrder.setText(rs.getString(8));
            reorderLevel.setText(rs.getString(9));
            discontinued.setText(rs.getString(10));
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin?");
        if (confirm == JOptionPane.YES_OPTION) {
            String sql = "delete from Products where ProductID = "+tabel.getValueAt(tabel.getSelectedRow(), 0);
            try {
                kon.execute(sql);
                showData();
            } catch (SQLException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox category;
    private javax.swing.JTextField discontinued;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField productName;
    private javax.swing.JTextField quantityPerUnit;
    private javax.swing.JTextField reorderLevel;
    private javax.swing.JComboBox supplier;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField unitPrice;
    private javax.swing.JTextField unitsInStock;
    private javax.swing.JTextField unitsOnOrder;
    private javax.swing.JLabel valueId;
    // End of variables declaration//GEN-END:variables
}
