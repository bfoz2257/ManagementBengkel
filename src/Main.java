import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bengkel bengkel;

    public static void main(String[] args) {
        System.out.println("=== SISTEM MANAJEMEN BENGKEL ===");
        System.out.print("Masukkan nama bengkel: ");
        String namaBengkel = scanner.nextLine();
        bengkel = new Bengkel(namaBengkel);

        int pilihan;
        do {
            tampilkanMenu();
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    tambahPelanggan();
                    break;
                case 2:
                    tambahKendaraan();
                    break;
                case 3:
                    tambahServis();
                    break;
                case 4:
                    lihatDataPelanggan();
                    break;
                case 5:
                    lihatRiwayatServis();
                    break;
                case 6:
                    cariDataPelanggan();
                    break;
                case 7:
                    System.out.println("Terima kasih telah menggunakan sistem ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 7);
    }

    private static void tampilkanMenu() {
        System.out.println("\n=== MENU UTAMA ===");
        System.out.println("1. Tambah Pelanggan Baru");
        System.out.println("2. Tambah Kendaraan ke Pelanggan");
        System.out.println("3. Catat Servis Baru");
        System.out.println("4. Lihat Data Pelanggan");
        System.out.println("5. Lihat Riwayat Servis");
        System.out.println("6. Cari Data Pelanggan");
        System.out.println("7. Keluar");
        System.out.print("Pilih menu (1-7): ");
    }

    private static void tambahPelanggan() {
        System.out.println("\n=== TAMBAH PELANGGAN BARU ===");
        System.out.print("ID Pelanggan: ");
        String id = scanner.nextLine();
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("No. Telepon: ");
        String noTelp = scanner.nextLine();
        System.out.print("Alamat: ");
        String alamat = scanner.nextLine();

        Pelanggan pelanggan = new Pelanggan(id, nama, noTelp, alamat);
        bengkel.tambahPelanggan(pelanggan);
        System.out.println("Pelanggan berhasil ditambahkan!");
    }

    private static void tambahKendaraan() {
        System.out.println("\n=== TAMBAH KENDARAAN ===");
        System.out.print("ID Pelanggan: ");
        String idPelanggan = scanner.nextLine();

        Pelanggan pelanggan = bengkel.cariPelanggan(idPelanggan);
        if (pelanggan != null) {
            System.out.println("Jenis Kendaraan:");
            System.out.println("1. Mobil");
            System.out.println("2. Motor");
            System.out.print("Pilih (1/2): ");
            int jenisKendaraan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            System.out.print("No. Plat: ");
            String noPlat = scanner.nextLine();
            System.out.print("Merk: ");
            String merk = scanner.nextLine();
            System.out.print("Model: ");
            String model = scanner.nextLine();
            System.out.print("Tahun: ");
            int tahun = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            if (jenisKendaraan == 1) {
                System.out.print("Jumlah Pintu: ");
                int jumlahPintu = scanner.nextInt();
                Mobil mobil = new Mobil(noPlat, merk, model, tahun, jumlahPintu);
                pelanggan.tambahKendaraan(mobil);
            } else {
                System.out.print("Jenis Transmisi: ");
                String transmisi = scanner.nextLine();
                Motor motor = new Motor(noPlat, merk, model, tahun, transmisi);
                pelanggan.tambahKendaraan(motor);
            }
            System.out.println("Kendaraan berhasil ditambahkan!");
        } else {
            System.out.println("Pelanggan tidak ditemukan!");
        }
    }

    private static void tambahServis() {
        System.out.println("\n=== TAMBAH SERVIS ===");
        System.out.print("ID Servis: ");
        String idServis = scanner.nextLine();
        System.out.print("ID Pelanggan: ");
        String idPelanggan = scanner.nextLine();

        Pelanggan pelanggan = bengkel.cariPelanggan(idPelanggan);
        if (pelanggan != null && !pelanggan.getKendaraanList().isEmpty()) {
            System.out.println("\nDaftar Kendaraan Pelanggan:");
            ArrayList<Kendaraan> kendaraanList = pelanggan.getKendaraanList();
            for (int i = 0; i < kendaraanList.size(); i++) {
                System.out.println((i+1) + ". " + kendaraanList.get(i).getInfo());
            }

            System.out.print("Pilih kendaraan (1-" + kendaraanList.size() + "): ");
            int pilihKendaraan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            if (pilihKendaraan > 0 && pilihKendaraan <= kendaraanList.size()) {
                Kendaraan kendaraan = kendaraanList.get(pilihKendaraan-1);

                System.out.print("Jenis Servis: ");
                String jenisServis = scanner.nextLine();
                System.out.print("Biaya: ");
                double biaya = scanner.nextDouble();
                scanner.nextLine(); // Membersihkan buffer
                System.out.print("Tanggal (YYYY-MM-DD): ");
                String tanggal = scanner.nextLine();

                Servis servis = new Servis(idServis, kendaraan, jenisServis, biaya, tanggal);
                bengkel.tambahServis(servis);
                System.out.println("Servis berhasil dicatat!");
            } else {
                System.out.println("Pilihan kendaraan tidak valid!");
            }
        } else {
            System.out.println("Pelanggan tidak ditemukan atau belum memiliki kendaraan!");
        }
    }

    private static void lihatDataPelanggan() {
        System.out.println("\n=== DATA PELANGGAN ===");
        bengkel.tampilkanSemuaPelanggan();
    }

    private static void lihatRiwayatServis() {
        System.out.println("\n=== RIWAYAT SERVIS ===");
        bengkel.tampilkanSemuaServis();
    }

    private static void cariDataPelanggan() {
        System.out.println("\n=== CARI DATA PELANGGAN ===");
        System.out.print("Masukkan ID Pelanggan: ");
        String idPelanggan = scanner.nextLine();

        Pelanggan pelanggan = bengkel.cariPelanggan(idPelanggan);
        if (pelanggan != null) {
            pelanggan.tampilkanInfo();

            // Menampilkan riwayat servis pelanggan
            System.out.println("\nRiwayat Servis:");
            bengkel.tampilkanServisPelanggan(pelanggan);
        } else {
            System.out.println("Pelanggan tidak ditemukan!");
        }
    }
}