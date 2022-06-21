package UTILS;

import BLL.AdisyonBLL;
import BLL.MasaBL;
import MODEL.MasaModel;
import VIEW.frmMain;
import static VIEW.frmMain.tblSiparisÖzeti;
import VIEW.frmMasaDuzenle;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class MyMasaPanel extends JPanel {

    JLabel lblid;
    JLabel lbladi;
    JLabel masaicon;
    Date dt = new Date();
    AdisyonBLL abl = new AdisyonBLL();
    public MasaModel mx;

    public MyMasaPanel(MasaModel mm) {
        //this.setLayout(null);
        this.mx = mm;
        this.setPreferredSize(new Dimension(160, 80));

        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        //this.mx.dolu = mm.dolu;
        if (mx.dolu) {
            this.setBackground(Color.red);
        } else {
            this.setBackground(Color.green);
        }

        lblid = new JLabel(String.valueOf(mm.masaAdi));
        lblid.setBounds(20, 10, 80, 20);
        lblid.setFont(new java.awt.Font("Tahoma", 1, 14));
        JPopupMenu popup = new JPopupMenu("Edit");
        JMenuItem adisyon = new JMenuItem("Adisyon Aç/Kapa");
        JMenuItem duzenle = new JMenuItem("Masayı Düzenle");
//        JMenuItem sil = new JMenuItem("Masayı Sil");

        popup.add(adisyon);
        popup.add(duzenle);
        // popup.add(sil);

        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }

            }
        });
        adisyon.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MasaBL mb = new MasaBL();
                if (mx.dolu) {
                    //px.setBackground(Color.green);
                    mx.dolu = false;
                    try {
                        abl.AdisyonKapat((float) frmMain.ToplamHesap(), mx.masaId);
                    } catch (SQLException ex) {
                        Logger.getLogger(MyMasaPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    //px.setBackground(Color.red);
                    int cevap = JOptionPane.showConfirmDialog(null, mx.masaAdi + " Adisyon Açılsın Mı?", "Adisyon Açılsın Mı?", JOptionPane.YES_NO_OPTION);
                    if (cevap == JOptionPane.YES_OPTION) {
                        try {

                            abl.AdisyonAç(mx.masaId);
                            mx.dolu = true;
                            MasaBL.mx.dolu = true;
                            frmMain.SecilenMasaId = mx.masaId;
                            frmMain.lblSecilenMasa.setText(mx.masaAdi);
                            frmMain.TableSetModel();

                        } catch (SQLException ex) {
                            Logger.getLogger(MyMasaPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                mb.updateMasa(mx);
                mb.clearAllMasa(frmMain.pnlMasa);
                mb.loadMasa(frmMain.pnlMasa);
            }
        }
        );
        duzenle.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmMasaDuzenle masa = new frmMasaDuzenle(mx.masaId, mx.masaAdi);
                masa.setVisible(true);

            }
        }
        );
//        sil.addActionListener(
//                new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                MasaBL mb = new MasaBL();
//
//                try {
//                    if (mb.MasaSil(mx.masaId)) {
//                        JOptionPane.showMessageDialog(null, "Masa Başarıyla Silindi", "Silme Başarılı.", JOptionPane.INFORMATION_MESSAGE);
//                        mb.clearAllMasa(frmMain.pnlMasa);
//                        mb.loadMasa(frmMain.pnlMasa);
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Masa Silerken Bir Hata Oluştu. ", "Silme Başarısız!", JOptionPane.INFORMATION_MESSAGE);
//
//                    }
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(null, "Masa Silerken Bir Hata Oluştu. Hata=" + ex.getMessage(), "Silme Başarısız!", JOptionPane.INFORMATION_MESSAGE);
//                }
//            }
//        }
//        );

        this.add(lblid);

    }

}
