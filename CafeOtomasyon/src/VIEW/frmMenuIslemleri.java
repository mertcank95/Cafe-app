/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import BLL.MenuBLL;
import MODEL.KategoriModel;
import MODEL.UrunModel;
import UTILS.DB;
import UTILS.MyComboBoxModel;
import UTILS.MyTableModel;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class frmMenuIslemleri extends javax.swing.JFrame {

    /**
     * Creates new form frmMenuIslemleri
     */
    static int UrunId = 0;
    static int KategoriId = 0;

    MenuBLL mbl = new MenuBLL();

    public frmMenuIslemleri() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    void UpdateUrunTable() {
        String sql = "select tu.UrunId, tu.KategoriID, isnull((Select KategoriAd from tblKategori tk where tk.KategoriId = tu.KategoriID),'') as KategoriAdi, "
                + " tu.UrunAdi, tu.UrunBirimFiyati, tu.MiktarTipi from tblUrun tu";
        try {
            DB db = new DB();
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            settblUrunModel(rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    void UpdateKategoriTable() {
        String sql = "select * from tblKategori";
        try {
            DB db = new DB();
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            settblKategoriModel(rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    void settblKategoriModel(ResultSet rs) {
        String[] sutunlar = {"Kategori ID", "Kategori Adı"};
        tblKategori.setModel(MyTableModel.resultSetToTableModel(rs, sutunlar));
        tblKategori.getColumnModel().getColumn(0).setMinWidth(0);
        tblKategori.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblKategori.getColumnModel().getColumn(0).setMaxWidth(0);
    }

    void settblUrunModel(ResultSet rs) {
        String[] sutunlar = {"Ürün ID", "Kategori ID", "Kategori Adı", "Ürün Adı", "Birim Fiyatı", "Miktar"};
        tblUrun.setModel(MyTableModel.resultSetToTableModel(rs, sutunlar));
        tblUrun.getColumnModel().getColumn(0).setMinWidth(0);
        tblUrun.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblUrun.getColumnModel().getColumn(0).setMaxWidth(0);

        tblUrun.getColumnModel().getColumn(1).setMinWidth(0);
        tblUrun.getColumnModel().getColumn(1).setPreferredWidth(0);
        tblUrun.getColumnModel().getColumn(1).setMaxWidth(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jMenu1 = new javax.swing.JMenu();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlUrun = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        PnlUrunBilgileri = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtUrunAd = new javax.swing.JTextField();
        cmbKategori = new javax.swing.JComboBox<>();
        txtBirimFiyat = new javax.swing.JTextField();
        txtBirimTip = new javax.swing.JTextField();
        btnYeniUrun = new javax.swing.JButton();
        btnUrunEkle = new javax.swing.JButton();
        btnUrunSil = new javax.swing.JButton();
        pnlTable = new javax.swing.JPanel();
        PnlAra = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txtArananUrun = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUrun = new javax.swing.JTable();
        PnlKategori = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        pnlKategoriAra = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        txtArananKategori = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKategori = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtKategoriAd = new javax.swing.JTextField();
        btnKategoriEkle = new javax.swing.JButton();
        btnYeniKategori = new javax.swing.JButton();
        btnKategoriSil = new javax.swing.JButton();

        jPasswordField1.setText("jPasswordField1");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menü İşlemleri");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlUrun.setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(346);

        PnlUrunBilgileri.setBackground(new java.awt.Color(204, 255, 255));

        jLabel4.setText("Birim Tipi:");

        jLabel3.setText("Birim Fiyatı:");

        jLabel2.setText("Ürün Kategorisi:");

        jLabel1.setText("Ürün Adı:");

        cmbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKategoriActionPerformed(evt);
            }
        });
        cmbKategori.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbKategoriPropertyChange(evt);
            }
        });
        cmbKategori.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                cmbKategoriVetoableChange(evt);
            }
        });

        txtBirimFiyat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBirimFiyatKeyTyped(evt);
            }
        });

        txtBirimTip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBirimTipKeyTyped(evt);
            }
        });

        btnYeniUrun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/new.png"))); // NOI18N
        btnYeniUrun.setText("Yeni");
        btnYeniUrun.setPreferredSize(new java.awt.Dimension(77, 100));
        btnYeniUrun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYeniUrunActionPerformed(evt);
            }
        });

        btnUrunEkle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Button-Add-icon.png"))); // NOI18N
        btnUrunEkle.setText("Ürün Ekle");
        btnUrunEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUrunEkleActionPerformed(evt);
            }
        });

        btnUrunSil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/delete.png"))); // NOI18N
        btnUrunSil.setText("Sil");
        btnUrunSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUrunSilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnlUrunBilgileriLayout = new javax.swing.GroupLayout(PnlUrunBilgileri);
        PnlUrunBilgileri.setLayout(PnlUrunBilgileriLayout);
        PnlUrunBilgileriLayout.setHorizontalGroup(
            PnlUrunBilgileriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlUrunBilgileriLayout.createSequentialGroup()
                .addGroup(PnlUrunBilgileriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlUrunBilgileriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(PnlUrunBilgileriLayout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(PnlUrunBilgileriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(18, 18, 18)
                            .addGroup(PnlUrunBilgileriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtUrunAd, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtBirimTip, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtBirimFiyat, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlUrunBilgileriLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnYeniUrun, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUrunEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PnlUrunBilgileriLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(btnUrunSil, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        PnlUrunBilgileriLayout.setVerticalGroup(
            PnlUrunBilgileriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlUrunBilgileriLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(PnlUrunBilgileriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUrunAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(PnlUrunBilgileriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(PnlUrunBilgileriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBirimFiyat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(15, 15, 15)
                .addGroup(PnlUrunBilgileriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBirimTip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(PnlUrunBilgileriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnYeniUrun, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUrunEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btnUrunSil, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(PnlUrunBilgileri);

        pnlTable.setLayout(new java.awt.BorderLayout());

        PnlAra.setLayout(new javax.swing.BoxLayout(PnlAra, javax.swing.BoxLayout.LINE_AXIS));

        jButton1.setText("Ara");
        PnlAra.add(jButton1);

        txtArananUrun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtArananUrunKeyPressed(evt);
            }
        });
        PnlAra.add(txtArananUrun);

        pnlTable.add(PnlAra, java.awt.BorderLayout.PAGE_START);

        tblUrun.setModel(new javax.swing.table.DefaultTableModel(
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
        tblUrun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUrunMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUrun);
        if (tblUrun.getColumnModel().getColumnCount() > 0) {
            tblUrun.getColumnModel().getColumn(0).setMinWidth(0);
            tblUrun.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblUrun.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        pnlTable.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jSplitPane1.setLeftComponent(pnlTable);

        pnlUrun.add(jSplitPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Ürün İşlemleri", pnlUrun);

        PnlKategori.setLayout(new java.awt.BorderLayout());

        jSplitPane2.setDividerLocation(351);

        jPanel1.setLayout(new java.awt.BorderLayout());

        pnlKategoriAra.setLayout(new javax.swing.BoxLayout(pnlKategoriAra, javax.swing.BoxLayout.LINE_AXIS));

        jButton2.setText("Ara");
        pnlKategoriAra.add(jButton2);

        txtArananKategori.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtArananKategoriKeyPressed(evt);
            }
        });
        pnlKategoriAra.add(txtArananKategori);

        jPanel1.add(pnlKategoriAra, java.awt.BorderLayout.PAGE_START);

        tblKategori.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKategoriMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKategori);

        jPanel1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jSplitPane2.setLeftComponent(jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabel5.setText("Kategori Adı:");

        btnKategoriEkle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Button-Add-icon.png"))); // NOI18N
        btnKategoriEkle.setText("Kategori Ekle");
        btnKategoriEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKategoriEkleActionPerformed(evt);
            }
        });

        btnYeniKategori.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/new.png"))); // NOI18N
        btnYeniKategori.setText("Yeni");
        btnYeniKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYeniKategoriActionPerformed(evt);
            }
        });

        btnKategoriSil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/delete.png"))); // NOI18N
        btnKategoriSil.setText("Kategori Sil");
        btnKategoriSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKategoriSilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtKategoriAd))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnYeniKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnKategoriEkle))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnKategoriSil)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtKategoriAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKategoriEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnYeniKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKategoriSil, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        jSplitPane2.setRightComponent(jPanel2);

        PnlKategori.add(jSplitPane2, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Kategori İşlemleri", PnlKategori);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBirimFiyatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBirimFiyatKeyTyped
        char key = evt.getKeyChar();
        if (!((Character.isDigit(key))
                || (key == KeyEvent.VK_DELETE)
                || (key == KeyEvent.VK_RIGHT)
                || (key == KeyEvent.VK_LEFT)
                || (key == KeyEvent.VK_TAB)
                || (key == KeyEvent.VK_ENTER))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBirimFiyatKeyTyped

    private void txtBirimTipKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBirimTipKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBirimTipKeyTyped

    private void btnYeniUrunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYeniUrunActionPerformed
        UrunId = 0;
        txtUrunAd.setText("");
        txtBirimFiyat.setText("");
        txtBirimTip.setText("");
        cmbKategori.setSelectedIndex(-1);
        btnUrunEkle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Button-Add-icon.png"))); // NOI18N
        btnUrunEkle.setText("Ürün Ekle");
    }//GEN-LAST:event_btnYeniUrunActionPerformed

    private void btnUrunEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUrunEkleActionPerformed

        if (txtUrunAd.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Lütfen Ürün Adını Giriniz!", "Boş Geçilemez", JOptionPane.WARNING_MESSAGE);
            txtUrunAd.requestFocus();
        } else if (txtBirimFiyat.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Lütfen Ürün Birim Fiyatını Giriniz!", "Boş Geçilemez", JOptionPane.WARNING_MESSAGE);
            txtBirimFiyat.requestFocus();
        } else if (cmbKategori.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Lütfen Ürün Kategorisini  Seçiniz!!", "Boş Geçilemez", JOptionPane.WARNING_MESSAGE);
            cmbKategori.requestFocus();

        } else {

            try {
                UrunModel um = new UrunModel();
                KategoriModel km = (KategoriModel) cmbKategori.getSelectedItem();
                um.kategoriId = km.kategoriId;
                um.urunAdi = txtUrunAd.getText().trim();
                um.urunBirimFiyati = Float.parseFloat(txtBirimFiyat.getText().trim());
                um.miktarTipi = txtBirimTip.getText().trim();
                if (UrunId == 0) {

                    if (mbl.UrunEkle(um)) {
                        JOptionPane.showMessageDialog(null, "Ürün Başarıyla Eklendi.", "Ürün Eklendi", JOptionPane.INFORMATION_MESSAGE);
                        frmMain.TreeSetModel();

                    } else {
                        JOptionPane.showMessageDialog(null, "Ürün Eklenirken Hata Oluştu.", "Ürün Ekleme Hatası", JOptionPane.ERROR_MESSAGE);

                    }
                } else {
                    um.urunId = UrunId;
                    if (mbl.UrunGuncelle(um)) {
                        JOptionPane.showMessageDialog(null, "Ürün Başarıyla Güncellendi.", "Ürün Güncellendi", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null, "Ürün Güncellenirken Hata Oluştu.", "Ürün Güncelleme Hatası", JOptionPane.ERROR_MESSAGE);

                    }
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());

            }
            UpdateUrunTable();
        }
    }//GEN-LAST:event_btnUrunEkleActionPerformed

    private void btnUrunSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUrunSilActionPerformed
        if (UrunId == 0) {
            JOptionPane.showMessageDialog(null, "Lütfen silmek istediğiniz ürünü tablodan seçiniz.", "Silme Hatası", JOptionPane.ERROR_MESSAGE);
        } else {
            try {

                if (mbl.UrunSil(UrunId)) {
                    JOptionPane.showMessageDialog(null, "Ürün Başarıyla Silindi", "Ürün Sİlindi", JOptionPane.INFORMATION_MESSAGE);
                    UpdateUrunTable();
                    frmMain.TreeSetModel();

                } else {
                    JOptionPane.showMessageDialog(null, "Ürün Silme Hatası!", "Ürün Silinmedi", JOptionPane.ERROR_MESSAGE);

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }
    }//GEN-LAST:event_btnUrunSilActionPerformed

    static ArrayList<KategoriModel> xkategoriListe;
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        loadComboboxModel();
        UpdateUrunTable();
        UpdateKategoriTable();

    }//GEN-LAST:event_formWindowOpened
    void loadComboboxModel() {
        try {
            cmbKategori.removeAllItems();
            //xkategoriListe = (ArrayList) mbl.loadKategori();

            cmbKategori.setModel(MyComboBoxModel.getComboModel(mbl.loadKategori().toArray()));

            cmbKategori.setSelectedIndex(-1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    private void tblUrunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUrunMouseClicked
        int selectedIndex = tblUrun.getSelectedRow();
        UrunModel um = new UrunModel();
        UrunId = (int) tblUrun.getValueAt(selectedIndex, 0);
        um.kategoriId = (int) tblUrun.getValueAt(selectedIndex, 1);
        um.urunAdi = tblUrun.getValueAt(selectedIndex, 3).toString();
        um.urunBirimFiyati = Float.parseFloat(tblUrun.getValueAt(selectedIndex, 4).toString());
        um.miktarTipi = tblUrun.getValueAt(selectedIndex, 5).toString();
        txtUrunAd.setText(um.urunAdi);
        txtBirimFiyat.setText(String.valueOf(um.urunBirimFiyati));
        txtBirimTip.setText(um.miktarTipi);
        //cmbKategori.setSelectedItem(um.kategoriId);
        MenuBLL mb = new MenuBLL();
        KategoriModel km = mb.getKategori(um.kategoriId);
        cmbKategori.getModel().setSelectedItem(km);


    }//GEN-LAST:event_tblUrunMouseClicked

    private void cmbKategoriPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbKategoriPropertyChange
        System.out.println("VIEW.NewJFrame1.cmbKategoriPropertyChange()");
    }//GEN-LAST:event_cmbKategoriPropertyChange

    private void cmbKategoriVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_cmbKategoriVetoableChange
        System.out.println("VIEW.NewJFrame1.cmbKategoriVetoableChange()");
    }//GEN-LAST:event_cmbKategoriVetoableChange

    private void cmbKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKategoriActionPerformed
        System.out.println("VIEW.NewJFrame1.cmbKategoriActionPerformed()");
        try {
            if (cmbKategori.getSelectedIndex() < 0) {
                return;
            }
            KategoriModel km = (KategoriModel) cmbKategori.getSelectedItem();
            System.out.println(km.kategoriAd + " " + km.kategoriId);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_cmbKategoriActionPerformed

    private void tblKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKategoriMouseClicked
        KategoriModel km = new KategoriModel();
        int selectedIndex = tblKategori.getSelectedRow();
        KategoriId = (int) tblKategori.getValueAt(selectedIndex, 0);
        km.kategoriId = KategoriId;
        km.kategoriAd = tblKategori.getValueAt(selectedIndex, 1).toString();
        txtKategoriAd.setText(km.kategoriAd);


    }//GEN-LAST:event_tblKategoriMouseClicked

    private void btnKategoriEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKategoriEkleActionPerformed
        if (txtKategoriAd.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Lütfen Kategori Adını Giriniz!", "Boş Geçilemez", JOptionPane.WARNING_MESSAGE);

        } else {
            try {
                if (KategoriId == 0) {
                    if (mbl.KategoriEkle(txtKategoriAd.getText().trim())) {
                        JOptionPane.showMessageDialog(null, "Kategori Başarıyla Eklendi", "Kategori Eklendi", JOptionPane.INFORMATION_MESSAGE);
                        UpdateKategoriTable();
                        loadComboboxModel();
                        frmMain.TreeSetModel();

                    } else {
                        JOptionPane.showMessageDialog(null, "Kategori Ekleme Hatası!", "Kategori Eklenemedi", JOptionPane.ERROR_MESSAGE);

                    }
                } else {
                    KategoriModel km = new KategoriModel();
                    km.kategoriId = KategoriId;
                    km.kategoriAd = txtKategoriAd.getText().trim();
                    if (mbl.KategoriGuncelle(km)) {
                        JOptionPane.showMessageDialog(null, "Kategori Başarıyla Güncellendi", "Kategori Güncellendi", JOptionPane.INFORMATION_MESSAGE);
                        UpdateKategoriTable();
                        frmMain.TreeSetModel();

                    } else {
                        JOptionPane.showMessageDialog(null, "Kategori Güncelleme Hatası!", "Kategori Güncellenemedi.", JOptionPane.ERROR_MESSAGE);

                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(frmMenuIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnKategoriEkleActionPerformed

    private void btnYeniKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYeniKategoriActionPerformed
        txtKategoriAd.setText("");
        KategoriId = 0;
    }//GEN-LAST:event_btnYeniKategoriActionPerformed

    private void btnKategoriSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKategoriSilActionPerformed
        if (KategoriId == 0) {
            JOptionPane.showMessageDialog(null, "Lütfen silmek istediğiniz kategoriyi tablodan seçiniz.", "Silme Hatası", JOptionPane.ERROR_MESSAGE);
        } else {
            try {

                if (mbl.KategoriSil(KategoriId)) {
                    JOptionPane.showMessageDialog(null, "Kategori Başarıyla Silindi", "Kategori Sİlindi", JOptionPane.INFORMATION_MESSAGE);
                    UpdateKategoriTable();
                    loadComboboxModel();
                    frmMain.TreeSetModel();

                } else {
                    JOptionPane.showMessageDialog(null, "Kategori Silme Hatası!", "Kategori Silinmedi", JOptionPane.ERROR_MESSAGE);

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }
    }//GEN-LAST:event_btnKategoriSilActionPerformed
    void UrunAra(String aranan) throws SQLException {
        DB db = new DB();
        Connection con = db.CreateConnection();
        String sql = "select tu.UrunId, tu.KategoriID, isnull((Select KategoriAd from tblKategori tk where tk.KategoriId = tu.KategoriID),'') as KategoriAdi, "
                + " tu.UrunAdi, tu.UrunBirimFiyati, tu.MiktarTipi from tblUrun tu where tu.UrunAdi like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, aranan + '%');
        ResultSet rs = ps.executeQuery();
        settblUrunModel(rs);
        rs.close();
        ps.close();

    }

    void KategoriAra(String aranan) throws SQLException {
        DB db = new DB();
        Connection con = db.CreateConnection();
        String sql = "select * from tblKategori where KategoriAd like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, aranan + '%');
        ResultSet rs = ps.executeQuery();

        settblKategoriModel(rs);
        rs.close();
        ps.close();

    }
    private void txtArananUrunKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArananUrunKeyPressed
        try {
            UrunAra(txtArananUrun.getText());
        } catch (SQLException ex) {
            Logger.getLogger(frmMenuIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtArananUrunKeyPressed

    private void txtArananKategoriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArananKategoriKeyPressed
        try {
            KategoriAra(txtArananKategori.getText());
        } catch (SQLException ex) {
            Logger.getLogger(frmMenuIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtArananKategoriKeyPressed

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
            java.util.logging.Logger.getLogger(frmMenuIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenuIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenuIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenuIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenuIslemleri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlAra;
    private javax.swing.JPanel PnlKategori;
    private javax.swing.JPanel PnlUrunBilgileri;
    private javax.swing.JButton btnKategoriEkle;
    private javax.swing.JButton btnKategoriSil;
    private javax.swing.JButton btnUrunEkle;
    private javax.swing.JButton btnUrunSil;
    private javax.swing.JButton btnYeniKategori;
    private javax.swing.JButton btnYeniUrun;
    private javax.swing.JComboBox<String> cmbKategori;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pnlKategoriAra;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JPanel pnlUrun;
    private javax.swing.JTable tblKategori;
    private javax.swing.JTable tblUrun;
    private javax.swing.JTextField txtArananKategori;
    private javax.swing.JTextField txtArananUrun;
    private javax.swing.JTextField txtBirimFiyat;
    private javax.swing.JTextField txtBirimTip;
    private javax.swing.JTextField txtKategoriAd;
    private javax.swing.JTextField txtUrunAd;
    // End of variables declaration//GEN-END:variables
}
