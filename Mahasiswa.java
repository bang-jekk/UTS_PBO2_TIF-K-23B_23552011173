/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir.akademik;

public class Mahasiswa extends Sivitas {
    private String nim;

    public Mahasiswa(String id, String nama, String nim) {
        super(id, nama);
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Mahasiswa: " + nama + ", NIM: " + nim);
    }
}