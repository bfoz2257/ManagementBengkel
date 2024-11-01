class Servis {
    private String id;
    private Kendaraan kendaraan;
    private String jenisServis;
    private Double biaya;
    private String tanggal;

    // Constructor dengan parameter
    public Servis(String id, Kendaraan kendaraan, String jenisServis, Double biaya, String tanggal) {
        this.id = id;
        this.kendaraan = kendaraan;
        this.jenisServis = jenisServis;
        this.biaya = biaya;
        this.tanggal = tanggal;
    }

    // Constructor kosong
    public Servis() {
        this.id = "";
        this.kendaraan = null;
        this.jenisServis = "";
        this.biaya = 0.0;
        this.tanggal = "";
    }

    // Getter dan Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    public String getJenisServis() {
        return jenisServis;
    }

    public void setJenisServis(String jenisServis) {
        this.jenisServis = jenisServis;
    }

    public Double getBiaya() {
        return biaya;
    }

    public void setBiaya(Double biaya) {
        this.biaya = biaya;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    // Method untuk menampilkan informasi servis
    public void tampilkanInfo() {
        System.out.println("=== Info Servis ===");
        System.out.println("ID: " + id);
        System.out.println("Kendaraan: " + (kendaraan != null ? kendaraan.getInfo() : "Tidak ada"));
        System.out.println("Jenis Servis: " + jenisServis);
        System.out.println("Biaya: Rp" + String.format("%,.2f", biaya));
        System.out.println("Tanggal: " + tanggal);
    }
}