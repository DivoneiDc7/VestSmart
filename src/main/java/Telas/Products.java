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

public class Products extends javax.swing.JFrame implements DataChangeListener {

    private int mouseX;
    private int mouseY;

    private Map<String, Object> productSelectedFilters = new HashMap<>();

    public Products() {
        
        

        FlatDarkPurpleIJTheme.setup(); // Configura o tema

        initComponents();  // Inicializa os componentes da interface gráfica

        applyDarkTheme();  // Aplica o tema escuro às tabelas

        Utils.updateTable(ProductDao.findAll(), table_Products);
    }

    private void applyDarkTheme() {
        configureTable(table_Products);
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
        CollectionCard = new javax.swing.JPanel();
        Card_Products = new javax.swing.JPanel();
        btn_editProduct = new javax.swing.JLabel();
        btn_removeProduct = new javax.swing.JLabel();
        btn_addProduct = new javax.swing.JLabel();
        txtProductsSearchField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Products = new javax.swing.JTable();
        btn_SearchProducts = new javax.swing.JLabel();

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

        getContentPane().add(Head, java.awt.BorderLayout.PAGE_START);

        CollectionCard.setMinimumSize(new java.awt.Dimension(1110, 641));
        CollectionCard.setPreferredSize(new java.awt.Dimension(1110, 641));
        CollectionCard.setLayout(new java.awt.CardLayout());

        Card_Products.setBackground(new java.awt.Color(0, 0, 0));
        Card_Products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card_ProductsMouseClicked(evt);
            }
        });
        Card_Products.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_editProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_editProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_Editar.png"))); // NOI18N
        btn_editProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editProductMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_editProductMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_editProductMouseExited(evt);
            }
        });
        Card_Products.add(btn_editProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 104, -1, -1));

        btn_removeProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_removeProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_excluirClaro.png"))); // NOI18N
        btn_removeProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_removeProductMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_removeProductMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_removeProductMouseExited(evt);
            }
        });
        Card_Products.add(btn_removeProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 104, -1, -1));

        btn_addProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_addProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_adicionarClaro.png"))); // NOI18N
        btn_addProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addProductMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addProductMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addProductMouseExited(evt);
            }
        });
        Card_Products.add(btn_addProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 104, -1, -1));

        txtProductsSearchField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtProductsSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProductsSearchFieldKeyPressed(evt);
            }
        });
        Card_Products.add(txtProductsSearchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 104, 760, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Produtos");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 0, 0, new java.awt.Color(108, 81, 233)));
        Card_Products.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 19, 100, -1));
        Card_Products.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 59, 1230, 10));

        table_Products.setForeground(new java.awt.Color(255, 255, 255));
        table_Products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cód.", "Descrição", "Cor", "Tamanho", "Categoria", "Marca", "P. Custo", "P. Venda", "Qtd.", "Data entrada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Products.setGridColor(new java.awt.Color(204, 204, 204));
        table_Products.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_Products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_ProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_Products);
        if (table_Products.getColumnModel().getColumnCount() > 0) {
            table_Products.getColumnModel().getColumn(0).setMinWidth(25);
            table_Products.getColumnModel().getColumn(0).setPreferredWidth(50);
            table_Products.getColumnModel().getColumn(0).setMaxWidth(75);
            table_Products.getColumnModel().getColumn(1).setMinWidth(150);
            table_Products.getColumnModel().getColumn(1).setPreferredWidth(220);
            table_Products.getColumnModel().getColumn(1).setMaxWidth(300);
            table_Products.getColumnModel().getColumn(2).setMinWidth(60);
            table_Products.getColumnModel().getColumn(2).setPreferredWidth(80);
            table_Products.getColumnModel().getColumn(2).setMaxWidth(100);
            table_Products.getColumnModel().getColumn(3).setMinWidth(60);
            table_Products.getColumnModel().getColumn(3).setPreferredWidth(80);
            table_Products.getColumnModel().getColumn(3).setMaxWidth(100);
            table_Products.getColumnModel().getColumn(4).setMinWidth(50);
            table_Products.getColumnModel().getColumn(4).setPreferredWidth(110);
            table_Products.getColumnModel().getColumn(4).setMaxWidth(150);
            table_Products.getColumnModel().getColumn(5).setMinWidth(50);
            table_Products.getColumnModel().getColumn(5).setPreferredWidth(110);
            table_Products.getColumnModel().getColumn(5).setMaxWidth(150);
            table_Products.getColumnModel().getColumn(6).setMinWidth(60);
            table_Products.getColumnModel().getColumn(6).setPreferredWidth(80);
            table_Products.getColumnModel().getColumn(6).setMaxWidth(100);
            table_Products.getColumnModel().getColumn(7).setMinWidth(60);
            table_Products.getColumnModel().getColumn(7).setPreferredWidth(80);
            table_Products.getColumnModel().getColumn(7).setMaxWidth(100);
            table_Products.getColumnModel().getColumn(8).setMinWidth(25);
            table_Products.getColumnModel().getColumn(8).setPreferredWidth(40);
            table_Products.getColumnModel().getColumn(8).setMaxWidth(60);
            table_Products.getColumnModel().getColumn(9).setMinWidth(80);
            table_Products.getColumnModel().getColumn(9).setPreferredWidth(80);
            table_Products.getColumnModel().getColumn(9).setMaxWidth(100);
        }

        Card_Products.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 152, 1220, 430));

        btn_SearchProducts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_SearchProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_pesquisarClaro.png"))); // NOI18N
        btn_SearchProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SearchProductsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_SearchProductsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_SearchProductsMouseExited(evt);
            }
        });
        Card_Products.add(btn_SearchProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 104, 110, 30));

        CollectionCard.add(Card_Products, "cardProducts");

        getContentPane().add(CollectionCard, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1311, 679));
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
        this.dispose(); // Fecha a tela atual
    }//GEN-LAST:event_btn_CloseMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void setSelectedProductFilterOrNull(String key, javax.swing.JComboBox comboBox) {
        Object obj = productSelectedFilters.get(key);
        if (obj == null) {
            comboBox.setSelectedIndex(0);
        } else {
            comboBox.setSelectedItem(obj);
        }
    }

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

    private void Card_ProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card_ProductsMouseClicked

    }//GEN-LAST:event_Card_ProductsMouseClicked

    private void btn_SearchProductsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SearchProductsMouseExited
        btn_SearchProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_pesquisarClaro.png")));
    }//GEN-LAST:event_btn_SearchProductsMouseExited

    private void btn_SearchProductsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SearchProductsMouseEntered
        btn_SearchProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_pesquisar.png")));
    }//GEN-LAST:event_btn_SearchProductsMouseEntered

    private void btn_SearchProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SearchProductsMouseClicked
        String str = txtProductsSearchField.getText();

        if (productSelectedFilters.size() > 0) {
            Category cat = (Category) productSelectedFilters.get("category");
            Brand brand = (Brand) productSelectedFilters.get("brand");
            Color color = (Color) productSelectedFilters.get("color");
            String size = (String) productSelectedFilters.get("size");

            Utils.updateTable(Utils.productFilters(ProductDao.search(str), cat, brand, color, size), table_Products);
        } else {
            Utils.updateTable(ProductDao.search(str), table_Products);
        }
    }//GEN-LAST:event_btn_SearchProductsMouseClicked

    private void table_ProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ProductsMouseClicked

    }//GEN-LAST:event_table_ProductsMouseClicked

    private void txtProductsSearchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductsSearchFieldKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            btn_SearchProductsMouseClicked(null);
        }
    }//GEN-LAST:event_txtProductsSearchFieldKeyPressed

    private void btn_addProductMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addProductMouseExited
        // Voltar para o ícone original
        btn_addProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_adicionarClaro.png")));
    }//GEN-LAST:event_btn_addProductMouseExited

    private void btn_addProductMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addProductMouseEntered
        // Trocar para o ícone escuro
        btn_addProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_adicionarEscuro.png")));
    }//GEN-LAST:event_btn_addProductMouseEntered

    private void btn_addProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addProductMouseClicked

        productSelectedFilters.clear();

        Register_And_Edit_Products dialog = new Register_And_Edit_Products(this, true);
        dialog.subscribeDataChangeListener(this);
        dialog.setVisible(true);
        Utils.updateTable(ProductDao.findAll(), table_Products);
    }//GEN-LAST:event_btn_addProductMouseClicked

    private void btn_removeProductMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_removeProductMouseExited
        // Voltar para o ícone original
        btn_removeProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_excluirClaro.png")));
    }//GEN-LAST:event_btn_removeProductMouseExited

    private void btn_removeProductMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_removeProductMouseEntered
        // Trocar para o ícone escuro
        btn_removeProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_excluir.png")));
    }//GEN-LAST:event_btn_removeProductMouseEntered

    private void btn_removeProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_removeProductMouseClicked

        int row = table_Products.getSelectedRow();

        if (row > -1) {
            DefaultTableModel dtm = (DefaultTableModel) table_Products.getModel();
            Long id = (Long) dtm.getValueAt(row, 0);

            int op;
            op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esse produto?",
                    "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (op == 0) {
                ProductDao.removeById(id);
                Utils.updateTable(ProductDao.findAll(), table_Products);
            }
        }
    }//GEN-LAST:event_btn_removeProductMouseClicked

    private void btn_editProductMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editProductMouseExited
        // Voltar para o ícone original
        btn_editProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_Editar.png")));
    }//GEN-LAST:event_btn_editProductMouseExited

    private void btn_editProductMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editProductMouseEntered
        // Trocar para o ícone escuro
        btn_editProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_EditarEscuro.png")));
    }//GEN-LAST:event_btn_editProductMouseEntered

    private void btn_editProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editProductMouseClicked

        int selectedRow = table_Products.getSelectedRow();
        productSelectedFilters.clear();
        if (selectedRow > -1) {

            DefaultTableModel dtm = (DefaultTableModel) table_Products.getModel();

            Long id = (Long) dtm.getValueAt(selectedRow, 0);
            Product p = ProductDao.findById(id);

            Register_And_Edit_Products dialog = new Register_And_Edit_Products(null, true, p);
            dialog.subscribeDataChangeListener(this);
            dialog.setVisible(true);
            Utils.updateTable(ProductDao.findAll(), table_Products);
        } else {
            JOptionPane.showMessageDialog(null, "Você deve selecionar um produto para poder editar.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_editProductMouseClicked

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Card_Products;
    private javax.swing.JPanel CollectionCard;
    private javax.swing.JPanel Head;
    private javax.swing.JPanel MaxMinClose;
    private javax.swing.JMenuItem btnAddProduct;
    private javax.swing.JLabel btn_Close;
    private javax.swing.JLabel btn_SearchProducts;
    private javax.swing.JLabel btn_addProduct;
    private javax.swing.JLabel btn_editProduct;
    private javax.swing.JLabel btn_removeProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem menuSaleInfo;
    private javax.swing.JPanel pnl_Close;
    private javax.swing.JPanel pnl_HeaderMenu;
    private javax.swing.JPanel pnl_Max;
    private javax.swing.JPanel pnl_Min;
    private javax.swing.JPopupMenu popupProductsTable;
    private javax.swing.JPopupMenu popupSaleTable;
    private javax.swing.JTable table_Products;
    private javax.swing.JTextField txtProductsSearchField;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onDataChanged() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
