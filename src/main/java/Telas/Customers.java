package Telas;

import Conexao.DB;
import DAO.BrandDao;
import DAO.CategoryDao;
import com.formdev.flatlaf.FlatDarkLaf;
import DAO.ColorDao;
import DAO.CustomerDao;
import DAO.ProductDao;
import DAO.SaleDao;
import Entidades.Brand;
import Entidades.Category;
import Entidades.Color;
import Entidades.Customer;
import Entidades.Product;
import Entidades.Sale;
import Services.SaleService;
import Listeners.DataChangeListener;
import Util.Utils;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatMonokaiProIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatNordIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDarkerIJTheme;
import com.google.gson.annotations.Until;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Utilities;
import jdk.jshell.execution.Util;

public class Customers extends javax.swing.JFrame implements DataChangeListener {

    private int mouseX;
    private int mouseY;

    private Map<String, Object> productSelectedFilters = new HashMap<>();

    public Customers() {

        FlatDarkPurpleIJTheme.setup(); // Configura o tema

        initComponents();  // Inicializa os componentes da interface gráfica

        applyDarkTheme();  // Aplica o tema escuro às tabelas
        
        Utils.updateTable(CustomerDao.findAll(), tableCustomers);
        
    }

    private void applyDarkTheme() {
        configureTable(tableCustomers);
        // Outras tabelas que você queira configurar
    }

    private void configureTable(JTable table) {
        table.setBackground(new java.awt.Color(43, 43, 43)); // fundo escuro
        table.setForeground(new java.awt.Color(255, 255, 255)); // texto branco
        table.setGridColor(new java.awt.Color(64, 64, 64)); // cor da grade
        table.setShowGrid(true); // exibir a grade
        table.setSelectionBackground(new java.awt.Color(75, 110, 175)); // fundo da seleção
        table.setSelectionForeground(new java.awt.Color(255, 255, 255)); // texto da seleção

        table.setRowHeight(25); // Aumentar a altura das linhas para 25 pixels (ou outro valor desejado)

        // Centralizar texto nas células
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);
    }

    private void setMenuButtonsColor(JPanel pn1) {

        pn1.setBackground(new java.awt.Color(108, 81, 233));
    }

    public void setDefaultColor(JPanel pnl) {
        pnl.setBackground(new java.awt.Color(98, 85, 158));
    }

    public void resetDefaultColor(JPanel pnl) {
        pnl.setBackground(new java.awt.Color(108, 81, 233));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupProductsTable = new javax.swing.JPopupMenu();
        btnAddProduct = new javax.swing.JMenuItem();
        popupSaleTable = new javax.swing.JPopupMenu();
        menuSaleInfo = new javax.swing.JMenuItem();
        Head = new javax.swing.JPanel();
        MaxMinClose = new javax.swing.JPanel();
        pnl_Max = new javax.swing.JPanel();
        pnl_Close = new javax.swing.JPanel();
        btn_Close = new javax.swing.JLabel();
        pnl_Min = new javax.swing.JPanel();
        pnl_HeaderMenu = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        Mid_Header = new javax.swing.JPanel();
        CollectionCard = new javax.swing.JPanel();
        Card_Customers = new javax.swing.JPanel();
        btnRemoveCustomer = new javax.swing.JLabel();
        btnSearchCustomer = new javax.swing.JLabel();
        btnNewCustomer = new javax.swing.JLabel();
        cSearchCustomer = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCustomers = new javax.swing.JTable();
        btnEditCustomer = new javax.swing.JLabel();

        btnAddProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_mais_claro.png"))); // NOI18N
        btnAddProduct.setText("Adicionar");
        btnAddProduct.setToolTipText("");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });
        popupProductsTable.add(btnAddProduct);

        menuSaleInfo.setText("Ver informações");
        menuSaleInfo.setToolTipText("");
        menuSaleInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSaleInfoActionPerformed(evt);
            }
        });
        popupSaleTable.add(menuSaleInfo);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        Head.setBackground(new java.awt.Color(108, 81, 233));
        Head.setMaximumSize(new java.awt.Dimension(1000, 50));
        Head.setMinimumSize(new java.awt.Dimension(1000, 50));
        Head.setPreferredSize(new java.awt.Dimension(1000, 50));
        Head.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                HeadMouseDragged(evt);
            }
        });
        Head.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HeadMousePressed(evt);
            }
        });
        Head.setLayout(new java.awt.BorderLayout());

        MaxMinClose.setMaximumSize(new java.awt.Dimension(150, 50));
        MaxMinClose.setMinimumSize(new java.awt.Dimension(150, 50));
        MaxMinClose.setPreferredSize(new java.awt.Dimension(150, 50));
        MaxMinClose.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_Max.setBackground(new java.awt.Color(108, 81, 233));
        pnl_Max.setMaximumSize(new java.awt.Dimension(50, 50));
        pnl_Max.setMinimumSize(new java.awt.Dimension(50, 50));
        pnl_Max.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout pnl_MaxLayout = new javax.swing.GroupLayout(pnl_Max);
        pnl_Max.setLayout(pnl_MaxLayout);
        pnl_MaxLayout.setHorizontalGroup(
            pnl_MaxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        pnl_MaxLayout.setVerticalGroup(
            pnl_MaxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        MaxMinClose.add(pnl_Max, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, -1));

        pnl_Close.setBackground(new java.awt.Color(108, 81, 233));
        pnl_Close.setMaximumSize(new java.awt.Dimension(50, 50));
        pnl_Close.setMinimumSize(new java.awt.Dimension(50, 50));
        pnl_Close.setPreferredSize(new java.awt.Dimension(50, 50));

        btn_Close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_fechar.png"))); // NOI18N
        btn_Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_CloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_CloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_CloseMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnl_CloseLayout = new javax.swing.GroupLayout(pnl_Close);
        pnl_Close.setLayout(pnl_CloseLayout);
        pnl_CloseLayout.setHorizontalGroup(
            pnl_CloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_CloseLayout.createSequentialGroup()
                .addComponent(btn_Close, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_CloseLayout.setVerticalGroup(
            pnl_CloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_CloseLayout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(btn_Close, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        MaxMinClose.add(pnl_Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        pnl_Min.setBackground(new java.awt.Color(108, 81, 233));
        pnl_Min.setMaximumSize(new java.awt.Dimension(50, 50));
        pnl_Min.setMinimumSize(new java.awt.Dimension(50, 50));
        pnl_Min.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout pnl_MinLayout = new javax.swing.GroupLayout(pnl_Min);
        pnl_Min.setLayout(pnl_MinLayout);
        pnl_MinLayout.setHorizontalGroup(
            pnl_MinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        pnl_MinLayout.setVerticalGroup(
            pnl_MinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        MaxMinClose.add(pnl_Min, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Head.add(MaxMinClose, java.awt.BorderLayout.LINE_END);

        pnl_HeaderMenu.setBackground(new java.awt.Color(108, 81, 233));

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("VEST | SMART");

        javax.swing.GroupLayout pnl_HeaderMenuLayout = new javax.swing.GroupLayout(pnl_HeaderMenu);
        pnl_HeaderMenu.setLayout(pnl_HeaderMenuLayout);
        pnl_HeaderMenuLayout.setHorizontalGroup(
            pnl_HeaderMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        pnl_HeaderMenuLayout.setVerticalGroup(
            pnl_HeaderMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        Head.add(pnl_HeaderMenu, java.awt.BorderLayout.LINE_START);

        Mid_Header.setBackground(new java.awt.Color(108, 81, 233));
        Mid_Header.setLayout(new java.awt.BorderLayout());
        Head.add(Mid_Header, java.awt.BorderLayout.CENTER);

        getContentPane().add(Head, java.awt.BorderLayout.PAGE_START);

        CollectionCard.setMinimumSize(new java.awt.Dimension(1110, 641));
        CollectionCard.setPreferredSize(new java.awt.Dimension(1110, 641));
        CollectionCard.setLayout(new java.awt.CardLayout());

        Card_Customers.setBackground(new java.awt.Color(0, 0, 0));
        Card_Customers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRemoveCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_excluirClaro.png"))); // NOI18N
        btnRemoveCustomer.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnRemoveCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveCustomerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRemoveCustomerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRemoveCustomerMouseExited(evt);
            }
        });
        Card_Customers.add(btnRemoveCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 104, -1, 30));

        btnSearchCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_pesquisarClaro.png"))); // NOI18N
        btnSearchCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchCustomerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchCustomerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchCustomerMouseExited(evt);
            }
        });
        Card_Customers.add(btnSearchCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 104, -1, -1));

        btnNewCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_adicionarClaro.png"))); // NOI18N
        btnNewCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNewCustomerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNewCustomerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNewCustomerMouseExited(evt);
            }
        });
        Card_Customers.add(btnNewCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 104, -1, -1));

        cSearchCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cSearchCustomerKeyPressed(evt);
            }
        });
        Card_Customers.add(cSearchCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 104, 770, 30));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText(" Clientes");
        jLabel33.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 0, 0, new java.awt.Color(108, 81, 233)));
        Card_Customers.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 19, 100, -1));
        Card_Customers.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 59, 1250, 10));

        tableCustomers.setForeground(new java.awt.Color(255, 255, 255));
        tableCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", ""},
                {"", "", "", ""},
                {"", "", "", ""},
                {"", "", "", ""},
                {"", "", "", ""},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Celular", "E-maill"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCustomers.setGridColor(new java.awt.Color(204, 204, 204));
        tableCustomers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(tableCustomers);

        Card_Customers.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 154, 1250, 440));

        btnEditCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_Editar.png"))); // NOI18N
        btnEditCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditCustomerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditCustomerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditCustomerMouseExited(evt);
            }
        });
        Card_Customers.add(btnEditCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 104, -1, -1));

        CollectionCard.add(Card_Customers, "cardCustomers");

        getContentPane().add(CollectionCard, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1315, 679));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CloseMouseEntered
        // color red
        pnl_Close.setBackground(new java.awt.Color(232, 17, 35));
    }//GEN-LAST:event_btn_CloseMouseEntered

    private void btn_CloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CloseMouseExited
        // color original
        resetDefaultColor(pnl_Close);
    }//GEN-LAST:event_btn_CloseMouseExited

    private void btn_CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CloseMouseClicked
        // Close
        this.dispose();
    }//GEN-LAST:event_btn_CloseMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void btnRemoveCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveCustomerMouseClicked

        int linha = tableCustomers.getSelectedRow();

        if (linha > -1) {

            DefaultTableModel dtm = (DefaultTableModel) tableCustomers.getModel();
            String id = (String) dtm.getValueAt(linha, 1);
            Customer v = CustomerDao.findByCpf(id);

            int ex;
            ex = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este cliente?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (ex == 0) {
                CustomerDao.remove(v);
                Utils.updateTable(CustomerDao.findAll(), tableCustomers);
            }
        } else {

        }
    }//GEN-LAST:event_btnRemoveCustomerMouseClicked

    private void btnNewCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewCustomerMouseClicked

        new Register_And_Edit_Customer(this, true).setVisible(true);
        Utils.updateTable(CustomerDao.findAll(), tableCustomers);
    }//GEN-LAST:event_btnNewCustomerMouseClicked

    private void btnNewCustomerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewCustomerMouseEntered
        btnNewCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_adicionarEscuro.png")));
    }//GEN-LAST:event_btnNewCustomerMouseEntered

    private void btnNewCustomerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewCustomerMouseExited
        btnNewCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_adicionarClaro.png")));
    }//GEN-LAST:event_btnNewCustomerMouseExited

    private void btnRemoveCustomerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveCustomerMouseEntered
        btnRemoveCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_excluir.png")));
    }//GEN-LAST:event_btnRemoveCustomerMouseEntered

    private void btnRemoveCustomerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveCustomerMouseExited
        btnRemoveCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_excluirClaro.png")));
    }//GEN-LAST:event_btnRemoveCustomerMouseExited

    private void btnSearchCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchCustomerMouseClicked
        String str = cSearchCustomer.getText();

        Utils.updateTable(CustomerDao.search(str), tableCustomers);
    }//GEN-LAST:event_btnSearchCustomerMouseClicked

    private void btnSearchCustomerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchCustomerMouseEntered
        btnSearchCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_pesquisar.png")));
    }//GEN-LAST:event_btnSearchCustomerMouseEntered

    private void btnSearchCustomerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchCustomerMouseExited
        btnSearchCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_pesquisarClaro.png")));
    }//GEN-LAST:event_btnSearchCustomerMouseExited

    private void setSelectedProductFilterOrNull(String key, javax.swing.JComboBox comboBox) {
        Object obj = productSelectedFilters.get(key);
        if (obj == null) {
            comboBox.setSelectedIndex(0);
        } else {
            comboBox.setSelectedItem(obj);
        }
    }

    private void btnEditCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditCustomerMouseClicked

        int selectedRow = tableCustomers.getSelectedRow();

        if (selectedRow > -1) {

            DefaultTableModel dtm = (DefaultTableModel) tableCustomers.getModel();

            String cpf = (String) dtm.getValueAt(selectedRow, 1);
            Customer customer = CustomerDao.findByCpf(cpf);

            Register_And_Edit_Customer dialog = new Register_And_Edit_Customer(null, true, customer);
            dialog.setVisible(true);
            Utils.updateTable(CustomerDao.findAll(), tableCustomers);
        } else {
            JOptionPane.showMessageDialog(null, "Você deve selecionar um cliente para poder editar.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditCustomerMouseClicked

    private void btnEditCustomerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditCustomerMouseEntered
        btnEditCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_EditarEscuro.png")));
    }//GEN-LAST:event_btnEditCustomerMouseEntered

    private void btnEditCustomerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditCustomerMouseExited
        btnEditCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_Editar.png")));
    }//GEN-LAST:event_btnEditCustomerMouseExited

    private void cSearchCustomerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cSearchCustomerKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            String str = cSearchCustomer.getText();

            Utils.updateTable(CustomerDao.search(str), tableCustomers);

        }
    }//GEN-LAST:event_cSearchCustomerKeyPressed

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed

    }//GEN-LAST:event_btnAddProductActionPerformed

    private void HeadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeadMousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_HeadMousePressed

    private void HeadMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeadMouseDragged
        this.setLocation(this.getX() + evt.getX() - mouseX, this.getY() + evt.getY() - mouseY);
    }//GEN-LAST:event_HeadMouseDragged

    private void menuSaleInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSaleInfoActionPerformed

    }//GEN-LAST:event_menuSaleInfoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Card_Customers;
    private javax.swing.JPanel CollectionCard;
    private javax.swing.JPanel Head;
    private javax.swing.JPanel MaxMinClose;
    private javax.swing.JPanel Mid_Header;
    private javax.swing.JMenuItem btnAddProduct;
    private javax.swing.JLabel btnEditCustomer;
    private javax.swing.JLabel btnNewCustomer;
    private javax.swing.JLabel btnRemoveCustomer;
    private javax.swing.JLabel btnSearchCustomer;
    private javax.swing.JLabel btn_Close;
    private javax.swing.JTextField cSearchCustomer;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JMenuItem menuSaleInfo;
    private javax.swing.JPanel pnl_Close;
    private javax.swing.JPanel pnl_HeaderMenu;
    private javax.swing.JPanel pnl_Max;
    private javax.swing.JPanel pnl_Min;
    private javax.swing.JPopupMenu popupProductsTable;
    private javax.swing.JPopupMenu popupSaleTable;
    private javax.swing.JTable tableCustomers;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onDataChanged() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
