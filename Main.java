package kasir.akademik;

import java.sql.*;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== KASIR AKADEMIK ===");
            System.out.println("1. Load Mahasiswa");
            System.out.println("2. Input Mahasiswa");
            System.out.println("3. Input Tagihan");
            System.out.println("4. Bayar Tagihan");
            System.out.println("5. Cek Sisa Tagihan");
            System.out.println("6. Laporan Transaksi");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    loadMahasiswa();
                    break;
                case 2:
                    inputMahasiswa();
                    break;
                case 3:
                    inputTagihan();
                    break;
                case 4:
                    bayarTagihan();
                    break;
                case 5:
                    cekSisaTagihan();
                    break;
                case 6:
                    laporanTransaksi();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void loadMahasiswa() {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM mahasiswa";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("\nDAFTAR MAHASISWA:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", NAMA: " + rs.getString("nama") + ", NIM: " + rs.getString("nim"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void inputMahasiswa() {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.print("Nama Mahasiswa: ");
            String nama = scanner.nextLine();
            System.out.print("NIM: ");
            String nim = scanner.nextLine();

            String query = "INSERT INTO mahasiswa(nama, nim) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nama);
            pstmt.setString(2, nim);
            pstmt.executeUpdate();

            System.out.println("Mahasiswa berhasil ditambahkan.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void inputTagihan() {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.print("ID Mahasiswa: ");
            int mahasiswaId = scanner.nextInt();
            System.out.print("Semester: ");
            int semester = scanner.nextInt();
            System.out.print("Total Tagihan: ");
            double total = scanner.nextDouble();

            String query = "INSERT INTO tagihan(mahasiswa_id, semester, total) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, mahasiswaId);
            pstmt.setInt(2, semester);
            pstmt.setDouble(3, total);
            pstmt.executeUpdate();

            System.out.println("Tagihan berhasil ditambahkan.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void bayarTagihan() {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.print("ID Tagihan: ");
            int tagihanId = scanner.nextInt();
            System.out.print("Jumlah Bayar: ");
            double jumlah = scanner.nextDouble();
            scanner.nextLine();

            String query = "INSERT INTO transaksi(tagihan_id, jumlah_bayar, tanggal) VALUES (?, ?, NOW())";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, tagihanId);
            pstmt.setDouble(2, jumlah);
            pstmt.executeUpdate();

            System.out.println("Pembayaran berhasil.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void cekSisaTagihan() {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.print("ID Mahasiswa: ");
            int mahasiswaId = scanner.nextInt();

            String query = "SELECT t.id, t.total, IFNULL(SUM(tr.jumlah_bayar), 0) AS sudah_bayar, t.total - IFNULL(SUM(tr.jumlah_bayar), 0) AS sisa " +
                           "FROM tagihan t LEFT JOIN transaksi tr ON t.id = tr.tagihan_id " +
                           "WHERE t.mahasiswa_id = ? GROUP BY t.id";

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, mahasiswaId);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("\nSISA TAGIHAN:");
            while (rs.next()) {
                System.out.println("Tagihan ID: " + rs.getInt("id") + ", Total: " + rs.getDouble("total") + ", Sudah Bayar: " + rs.getDouble("sudah_bayar") + ", Sisa: " + rs.getDouble("sisa"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void laporanTransaksi() {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT tr.id, tr.tanggal, tr.jumlah_bayar, m.nama FROM transaksi tr " +
                           "JOIN tagihan t ON tr.tagihan_id = t.id " +
                           "JOIN mahasiswa m ON t.mahasiswa_id = m.id ORDER BY tr.tanggal DESC";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("\nLAPORAN TRANSAKSI:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Nama: " + rs.getString("nama") + ", Tanggal: " + rs.getTimestamp("tanggal") + ", Jumlah: " + rs.getDouble("jumlah_bayar"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
