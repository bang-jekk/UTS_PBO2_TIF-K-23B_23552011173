/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir.akademik;

public class Tagihan {
    private int id;
    private int mahasiswaId;
    private int semester;
    private double total;

    public Tagihan(int id, int mahasiswaId, int semester, double total) {
        this.id = id;
        this.mahasiswaId = mahasiswaId;
        this.semester = semester;
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

}
