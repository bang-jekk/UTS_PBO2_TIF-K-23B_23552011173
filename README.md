# UTS Pemrograman Berorientasi Obyek 2
<ul>
  <li>Mata Kuliah: Pemrograman Berorientasi Obyek 2</li>
  <li>Dosen Pengampu: <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
</ul>

## Profil
<ul>
  <li>Nama: Zainuddin Muhammad Zakiy</li>
  <li>NIM: 23552011173</li>
  <li>Studi Kasus: Kasus 3</li>
</ul>

## Judul Studi Kasus
<p>Kasir Akademik.</p>

## Penjelasan Studi Kasus
<p>Program Kasir Akademik adalah sistem berbasis Java CLI (Command Line Interface) yang digunakan untuk membantu staf administrasi kampus dalam mengelola pembayaran kuliah mahasiswa. Sistem ini mencakup fitur :

•	Input dan menampilkan data mahasiswa

•	Pencatatan tagihan kuliah per semester

•	Transaksi pembayaran tagihan

•	Menampilkan sisa tagihan yang belum lunas

•	Melihat laporan transaksi pembayaran

Semuanya dijalankan lewat console/terminal (CLI) pakai Java, dan datanya disimpan di MySQL.
</p>

## Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. Inheritance
<p>// Abstract class
public abstract class Sivitas {
    protected String nama;
    protected String nim;
    public abstract void tampilkanInfo();
}

// Turunan dari Sivitas
public class Mahasiswa extends Sivitas {
    private int id;
    
    public Mahasiswa(int id, String nama, String nim) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Mahasiswa: " + nama + " (" + nim + ")");
    }
}
.</p>
<p>Jadi penjelasannya kita bikin class umum namanya Sivitas, isinya data kayak nama dan nim. Terus ada class Mahasiswa yang nerusin (inherit) dari Sivitas.

Jadi, Mahasiswa itu anaknya Sivitas. Dia nurun semua atribut dari ortunya.</p>
### 2. Encapsulation
<p>Lorem ipsum sir dolor amet.</p>

### 3. Polymorphism
<p>Lorem ipsum sir dolor amet.</p>

### 4. Abstract
<p>Lorem ipsum sir dolor amet.</p>

## Demo Proyek
<ul>
  <li>Github: <a href="https://github.com/bang-jekk/UTS_PBO2_TIF-K-23B_23552011173">Github</a></li>
  <li>Youtube: <a href="">Youtube</a></li>
</ul>
