import java.util.ArrayList;

class Pelanggan {
    
    private String id;
    private String nama;
    private String noTelp;
    private String alamat;
    private ArrayList<Kendaraan> kendaraanList;

    public Pelanggan(String id, String nama, String noTelp, String alamat) {
        this.id = id;
        this.nama = nama;
        this.noTelp = noTelp;
        this.alamat = alamat;
        this.kendaraanList = new ArrayList<>();
    }

    public Pelanggan() {
        this.id = "";
        this.nama = "";
        this.noTelp = "";
        this.alamat = "";
        this.kendaraanList = new ArrayList<>();
    }

    public void tambahKendaraan(Kendaraan kendaraan) {
        if (kendaraan != null) {
            kendaraanList.add(kendaraan);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public ArrayList<Kendaraan> getKendaraanList() {
        return kendaraanList;
    }

    public void tampilkanInfo() {
        System.out.println("=== Info Pelanggan ===");
        System.out.println("ID: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("No. Telp: " + noTelp);
        System.out.println("Alamat: " + alamat);
        System.out.println("Kendaraan:");
        if (kendaraanList.isEmpty()) {
            System.out.println("- Belum ada kendaraan terdaftar");
        } else {
            for (Kendaraan k : kendaraanList) {
                if (k != null) {
                    System.out.println("- " + k.getInfo());
                }
            }
        }
    }
}
