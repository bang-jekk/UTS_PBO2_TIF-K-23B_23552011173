/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir.akademik;

public class Pembayaran {
    public double hitungTagihan(Tagihan tagihan) {
        return tagihan.getTotal();
    }

    public double hitungTagihan(Tagihan tagihan, double diskon) {
        return tagihan.getTotal() - diskon;
    }
}

