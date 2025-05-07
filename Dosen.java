/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir.akademik;

public class Dosen extends Sivitas {
    private String nidn;

    public Dosen(String id, String nama, String nidn) {
        super(id, nama);
        this.nidn = nidn;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Dosen: " + nama + ", NIDN: " + nidn);
    }
}