package uas.mvc.views;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import uas.mvc.controllers.AnggotaController;
import uas.mvc.models.Anggota;
import uas.mvc.models.CRUD;
import uas.mvc.models.SaldoAnggota;
import uas.mvc.utils.Helpers;

/**
 *
 * @author agus
 */
public class AnggotaPage extends javax.swing.JPanel {

    private DefaultTableModel tblModel;
    private final AnggotaController anggotaController = new AnggotaController();

    public AnggotaPage() {
        initComponents();
        this.setDataAnggota(anggotaController.fetchAnggota());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        panelBorder1 = new uas.mvc.views.components.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAnggota = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inputNIK = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        inputNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inputTempatLahir = new javax.swing.JTextField();
        inputTanggalLahir = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        inputPekerjaan = new javax.swing.JTextField();
        inputEmail = new javax.swing.JTextField();
        inputHP = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        jLabel3.setFont(new java.awt.Font("Fira Sans", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Data Anggota");

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        tblAnggota.setForeground(new java.awt.Color(0, 0, 0));
        tblAnggota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIK", "Nama", "Tempat Lahir", "Tanggal Lahir", "Pekerjaan", "Email", "No HP", "Saldo", "Total Pinjaman"
            }
        ));
        tblAnggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAnggotaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAnggota);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 857, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBorder1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap()))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBorder1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setLabelFor(inputNIK);
        jLabel1.setText("NIK:");

        inputNIK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputNIKKeyTyped(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setLabelFor(inputNIK);
        jLabel2.setText("Nama:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setLabelFor(inputNIK);
        jLabel4.setText("Tempat, Tanggal Lahir:");

        inputTanggalLahir.setDateFormatString("yyyy-MM-dd");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setLabelFor(inputNIK);
        jLabel5.setText("Pekerjaan:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setLabelFor(inputNIK);
        jLabel6.setText("Email:");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setLabelFor(inputNIK);
        jLabel7.setText("No HP:");

        inputHP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputHPKeyTyped(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(inputHP)
                        .addComponent(inputEmail)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(inputTempatLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(inputTanggalLahir, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                        .addComponent(inputNIK)
                        .addComponent(inputNama)
                        .addComponent(inputPekerjaan)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inputNIK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(inputTempatLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inputTanggalLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(inputPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(inputHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUbah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setDataAnggota(List<Anggota> dataAnggota) {
        if (dataAnggota == null) {
            JOptionPane.showMessageDialog(this, "Data tidak bisa di load", "Gagal Koneksi",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            tblModel = new DefaultTableModel();
            tblModel.setColumnIdentifiers(new String[]{"NIK","Nama","Tempat Lahir", "Tanggal Lahir", "Pekerjaan", "Email", "No HP", "Saldo", "Sisa Pinjaman"});
            
            for (Anggota anggota : dataAnggota) {
                Object[] o = new Object[9];
                o[0] = anggota.getNik();
                o[1] = anggota.getNama();
                o[2] = anggota.getTempatLahir();
                o[3] = anggota.getTanggalLahir();
                o[4] = anggota.getPekerjaan();
                o[5] = anggota.getEmail();
                o[6] = anggota.getNoHP();
                o[7] = Helpers.formatRupiah(anggota.getSaldoAnggota().getSaldoSimpanan());
                o[8] = Helpers.formatRupiah(anggota.getSaldoAnggota().getSisaPinjaman());
                tblModel.addRow(o);
            }

            tblAnggota.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
            tblAnggota.setModel(tblModel);
        }
    }

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (validateInput()) {
            Anggota anggota = new Anggota()
                    .setNik(Long.parseLong(inputNIK.getText()))
                    .setNama(inputNama.getText())
                    .setTempatLahir(inputTempatLahir.getText())
                    .setTanggalLahir(
                            Helpers.utilDateToSqlDate(inputTanggalLahir.getDate())
                    )
                    .setPekerjaan(inputPekerjaan.getText())
                    .setEmail(inputEmail.getText())
                    .setNoHP(inputHP.getText())
                    .setSaldoAnggota(
                            new SaldoAnggota(Long.valueOf(0), Long.valueOf(0))
                    );

            try {
                anggotaController.setDML(anggota, CRUD.CREATE);
                JOptionPane.showMessageDialog(this, "Data Anggota Berhasil Disimpan");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "No KTP Sudah Pernah Digunakan!");
                return;
            }

            resetForm();
            this.setDataAnggota(anggotaController.fetchAnggota());
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        if (validateInput()) {
            Anggota anggota = new Anggota()
                    .setNik(Long.parseLong(inputNIK.getText()))
                    .setNama(inputNama.getText())
                    .setTempatLahir(inputTempatLahir.getText())
                    .setTanggalLahir(
                            Helpers.utilDateToSqlDate(inputTanggalLahir.getDate())
                    )
                    .setPekerjaan(inputPekerjaan.getText())
                    .setEmail(inputEmail.getText())
                    .setNoHP(inputHP.getText());

            try {
                anggotaController.setDML(anggota, CRUD.UPDATE);
                JOptionPane.showMessageDialog(this, "Data Anggota Berhasil DIubah!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Terjadi Kesalahan Sistem!");
                return;
            }

            resetForm();
            this.setDataAnggota(anggotaController.fetchAnggota());
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        Long nik = Long.parseLong(inputNIK.getText());
        Anggota mhs = new Anggota(nik);
        int hapus = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus anggota ini?",
                null, JOptionPane.YES_NO_OPTION);
        if(hapus == JOptionPane.YES_OPTION){
            anggotaController.setDML(mhs, CRUD.DELETE);
            JOptionPane.showMessageDialog(this, "Data Mahasiswa Berhasil di Hapus");
        }
        
        resetForm();
        this.setDataAnggota(anggotaController.fetchAnggota());
    }//GEN-LAST:event_btnHapusActionPerformed

    private void inputHPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputHPKeyTyped
        Helpers.inputNumeric(evt);
    }//GEN-LAST:event_inputHPKeyTyped

    private void inputNIKKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNIKKeyTyped
        Helpers.inputNumeric(evt);
    }//GEN-LAST:event_inputNIKKeyTyped

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetForm();
    }//GEN-LAST:event_btnResetActionPerformed

    private void tblAnggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAnggotaMouseClicked
        inputNIK.setText(tblModel.getValueAt(tblAnggota.getSelectedRow(), 0) + "");
        inputNama.setText(tblModel.getValueAt(tblAnggota.getSelectedRow(), 1) + "");
        inputTempatLahir.setText(tblModel.getValueAt(tblAnggota.getSelectedRow(), 2) + "");
        inputPekerjaan.setText(tblModel.getValueAt(tblAnggota.getSelectedRow(), 4) + "");
        inputEmail.setText(tblModel.getValueAt(tblAnggota.getSelectedRow(), 5) + "");
        inputHP.setText(tblModel.getValueAt(tblAnggota.getSelectedRow(), 6) + "");
        inputTanggalLahir.setDate(Helpers.parseDate(
                tblModel.getValueAt(tblAnggota.getSelectedRow(), 3) + ""
        ));

        inputNIK.setEnabled(false);
        btnSimpan.setEnabled(false);
        btnUbah.setEnabled(true);
        btnHapus.setEnabled(true);
    }//GEN-LAST:event_tblAnggotaMouseClicked

    private boolean validateInput() {
        if (inputNIK.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "NIK Tidak Boleh Kosong");
        } else if (inputNama.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nama Tidak Boleh Kosong");
        } else if (inputTempatLahir.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tempat Lahir Tidak Boleh Kosong");
        } else if (inputTanggalLahir.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Tanggal Lahir Tidak Boleh Kosong");
        } else if (inputPekerjaan.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Pekerjaan Tidak Boleh Kosong");
        } else if (inputEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Email Tidak Boleh Kosong");
        } else if (inputHP.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "No HP Tidak Boleh Kosong");
        } else {
            return true;
        }

        return false;
    }

    private void resetForm() {
        inputNIK.setEnabled(true);
        inputNIK.setText(null);
        inputNama.setText(null);
        inputTempatLahir.setText(null);
        inputTanggalLahir.setDate(null);
        inputPekerjaan.setText(null);
        inputEmail.setText(null);
        inputHP.setText(null);
        btnUbah.setEnabled(false);
        btnHapus.setEnabled(false);
        btnSimpan.setEnabled(true);
        inputNIK.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JTextField inputHP;
    private javax.swing.JTextField inputNIK;
    private javax.swing.JTextField inputNama;
    private javax.swing.JTextField inputPekerjaan;
    private com.toedter.calendar.JDateChooser inputTanggalLahir;
    private javax.swing.JTextField inputTempatLahir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private uas.mvc.views.components.PanelBorder panelBorder1;
    private javax.swing.JTable tblAnggota;
    // End of variables declaration//GEN-END:variables
}