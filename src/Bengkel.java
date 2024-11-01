import java.util.ArrayList;

class Bengkel {
    private String nama;
    private ArrayList<Pelanggan> pelangganList;
    private ArrayList<Servis> servisList;

    public Bengkel(String nama) {
        this.nama = nama;
        this.pelangganList = new ArrayList<>();
        this.servisList = new ArrayList<>();
    }

    public Bengkel() {
        this.nama = "";
        this.pelangganList = new ArrayList<>();
        this.servisList = new ArrayList<>();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public ArrayList<Pelanggan> getPelangganList() {
        return pelangganList;
    }

    public ArrayList<Servis> getServisList() {
        return servisList;
    }

    public void tambahPelanggan(Pelanggan pelanggan) {
        pelangganList.add(pelanggan);
    }

    public void tambahServis(Servis servis) {
        servisList.add(servis);
    }

    public Pelanggan cariPelanggan(String id) {
        for (Pelanggan p : pelangganList) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void tampilkanSemuaPelanggan() {
        if (pelangganList.isEmpty()) {
            System.out.println("Belum ada data pelanggan!");
            return;
        }
        System.out.println("=== Daftar Pelanggan " + nama + " ===");
        for (Pelanggan p : pelangganList) {
            p.tampilkanInfo();
            System.out.println();
        }
    }

    public void tampilkanSemuaServis() {
        if (servisList.isEmpty()) {
            System.out.println("Belum ada data servis!");
            return;
        }
        System.out.println("=== Daftar Servis " + nama + " ===");
        for (Servis s : servisList) {
            s.tampilkanInfo();
            System.out.println();
        }
    }

    public void tampilkanServisPelanggan(Pelanggan pelanggan) {
        if (pelanggan == null || pelanggan.getKendaraanList().isEmpty()) {
            System.out.println("Pelanggan tidak ditemukan atau tidak memiliki kendaraan!");
            return;
        }

        System.out.println("=== Riwayat Servis Pelanggan: " + pelanggan.getNama() + " ===");
        boolean adaServis = false;

        for (Servis s : servisList) {
            
            for (Kendaraan k : pelanggan.getKendaraanList()) {
                if (s.getKendaraan().getNoPlat().equals(k.getNoPlat())) {
                    s.tampilkanInfo();
                    System.out.println();
                    adaServis = true;
                    break;
                }
            }
        }

        if (!adaServis) {
            System.out.println("Belum ada riwayat servis untuk pelanggan ini.");
        }
    }
}
