/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir.akademik;

import java.util.Date;

public class Transaksi {
    private int id;
    private int tagihanId;
    private double jumlahBayar;
    private Date tanggal;

    public Transaksi(int id, int tagihanId, double jumlahBayar, Date tanggal) {
        this.id = id;
        this.tagihanId = tagihanId;
        this.jumlahBayar = jumlahBayar;
        this.tanggal = tanggal;
    }

}

