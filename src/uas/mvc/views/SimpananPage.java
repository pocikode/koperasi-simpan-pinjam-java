package uas.mvc.views;

import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import uas.mvc.controllers.AnggotaController;
import uas.mvc.controllers.SimpananController;
import uas.mvc.models.Anggota;
import uas.mvc.models.CRUD;
import uas.mvc.models.Simpanan;
import uas.mvc.utils.Helpers;

/**
 *
 * @author agus
 */
public class SimpananPage extends javax.swing.JPanel {

    private DefaultTableModel tblModel;
    private Simpanan.SimpananType tipe_transaksi = null;
    private final AnggotaController anggotaController = new AnggotaController();
    private final SimpananController simpananController = new SimpananController();

    public SimpananPage() {
        initComponents();

        btnGroupType.add(rbCredit);
        btnGroupType.add(rbDebit);
        setDataAnggota(anggotaController.fetchAnggota());
        setDataSimpanan(simpananController.fetchSimpanan());
    }

    private void setDataAnggota(List<Anggota> dataAnggota) {
        if (dataAnggota == null) {
            JOptionPane.showMessageDialog(this, "Data anggota tidak bisa di load", "Gagal Koneksi",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            inputNIK.setModel(new DefaultComboBoxModel(dataAnggota.toArray()));
        }
    }

    private void setDataSimpanan(List<Simpanan> daSimpanan) {
        if (daSimpanan == null) {
            JOptionPane.showMessageDialog(this, "Data Simpanan tidak bisa di load", "Gagal Koneksi",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            tblModel = new DefaultTableModel();
            tblModel.setColumnIdentifiers(new String[]{"ID", "NIK", "Nama Anggota", "Jumlah", "Tipe Transaksi", "Saldo Awal", "Saldo Akhir", "Keterangan", "Tanggal Transaksi"});

            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            for (Simpanan simpanan : daSimpanan) {
                Object[] o = new Object[9];
                o[0] = simpanan.getID();
                o[1] = simpanan.getAnggota().getNik();
                o[2] = simpanan.getAnggota().getNama();
                o[3] = Helpers.formatRupiah(simpanan.getJumlah());
                o[4] = simpanan.getType();
                o[5] = Helpers.formatRupiah(simpanan.getSaldoAwal());
                o[6] = Helpers.formatRupiah(simpanan.getSaldoAkhir());
                o[7] = simpanan.getKeterangan();
                o[8] = df.format(simpanan.getTanggalTransaksi());
                tblModel.addRow(o);
            }

            tblSimpanan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
            tblSimpanan.setModel(tblModel);
        }
    }

    private void resetForm() {
        inputNIK.setEnabled(true);
        inputJumlah.setText(null);
        inputKeterangan.setText(null);
        btnGroupType.clearSelection();
        btnSimpan.setEnabled(true);
        inputNIK.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupType = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inputNIK = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        inputJumlah = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rbCredit = new javax.swing.JRadioButton();
        rbDebit = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputKeterangan = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        inputKodeTransaksi = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSimpanan = new javax.swing.JTable();

        jLabel3.setFont(new java.awt.Font("Fira Sans", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Data Simpanan");

        jLabel1.setText("Anggota:");

        inputNIK.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setText("Jumlah:");

        inputJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputJumlahKeyTyped(evt);
            }
        });

        jLabel4.setText("Tipe Transaksi:");

        rbCredit.setText("Credit");

        rbDebit.setText("Debit");

        jLabel5.setText("Keterangan:");

        inputKeterangan.setColumns(20);
        inputKeterangan.setRows(5);
        jScrollPane1.setViewportView(inputKeterangan);

        jLabel6.setText("Kode Transaksi:");

        inputKodeTransaksi.setEnabled(false);

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Fira Sans", 2, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("*Kode Transaksi akan di generate otomatis");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(rbCredit)
                            .addGap(18, 18, 18)
                            .addComponent(rbDebit))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                        .addComponent(inputNIK, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inputJumlah)
                        .addComponent(inputKodeTransaksi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(inputKodeTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputNIK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inputJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rbCredit)
                    .addComponent(rbDebit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        tblSimpanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NIK", "Nama Anggota", "Jumlah", "Tipe Transaksi", "Saldo Awal", "Saldo Akhir", "Keterangan", "Tanggal Transaksi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSimpanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSimpananMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSimpanan);
        if (tblSimpanan.getColumnModel().getColumnCount() > 0) {
            tblSimpanan.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblSimpanan.getColumnModel().getColumn(8).setResizable(false);
            tblSimpanan.getColumnModel().getColumn(8).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(20, 20, 20)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel3)
                    .addContainerGap(635, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetForm();
    }//GEN-LAST:event_btnResetActionPerformed

    private void inputJumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputJumlahKeyTyped
        Helpers.inputNumeric(evt);
    }//GEN-LAST:event_inputJumlahKeyTyped

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (validateInput()) {
            Simpanan simpanan = new Simpanan()
                    .setType(tipe_transaksi)
                    .setJumlah(Long.parseLong(inputJumlah.getText()))
                    .setKeterangan(inputKeterangan.getText())
                    .setAnggota((Anggota) inputNIK.getSelectedItem());

            simpananController.setDML(simpanan, CRUD.CREATE);
            JOptionPane.showMessageDialog(this, "Berhasil menambah transaksi simpanan.");
            resetForm();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tblSimpananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSimpananMouseClicked
        inputKodeTransaksi.setText(tblModel.getValueAt(tblSimpanan.getSelectedRow(), 0) + "");
        inputKeterangan.setText(tblModel.getValueAt(tblSimpanan.getSelectedRow(), 7) + "");
        rbCredit.setSelected(tblModel.getValueAt(tblSimpanan.getSelectedRow(), 4).equals(Simpanan.SimpananType.CREDIT));
        rbDebit.setSelected(tblModel.getValueAt(tblSimpanan.getSelectedRow(), 4).equals(Simpanan.SimpananType.DEBIT));
        inputJumlah.setText(tblModel.getValueAt(tblSimpanan.getSelectedRow(), 3) + "");
        inputNIK.getModel().setSelectedItem(tblModel.getValueAt(tblSimpanan.getSelectedRow(), 1) + " - " + tblModel.getValueAt(tblSimpanan.getSelectedRow(), 2));
    }//GEN-LAST:event_tblSimpananMouseClicked

    private boolean validateInput() {
        if (inputJumlah.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Jumlah Tidak Boleh Kosong");
        } else {
            if (rbCredit.isSelected()) {
                tipe_transaksi = Simpanan.SimpananType.CREDIT;
            } else if (rbDebit.isSelected()) {
                tipe_transaksi = Simpanan.SimpananType.DEBIT;
            } else {
                tipe_transaksi = null;
            }

            if (tipe_transaksi == null) {
                JOptionPane.showMessageDialog(this, "Tipe Transaksi Belum Dipilih!");
            } else {
                return true;
            }
        }

        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupType;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JTextField inputJumlah;
    private javax.swing.JTextArea inputKeterangan;
    private javax.swing.JTextField inputKodeTransaksi;
    private javax.swing.JComboBox<String> inputNIK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbCredit;
    private javax.swing.JRadioButton rbDebit;
    private javax.swing.JTable tblSimpanan;
    // End of variables declaration//GEN-END:variables
}