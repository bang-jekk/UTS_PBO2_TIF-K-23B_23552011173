/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir.akademik;

public abstract class Sivitas {
    protected String nama;
    protected String id;

    public Sivitas(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public abstract void tampilkanInfo();
}

