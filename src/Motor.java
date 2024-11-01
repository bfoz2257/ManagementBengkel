class Motor extends Kendaraan {
    private String jenisTransmisi;

    // Constructor dengan parameter
    public Motor(String noPlat, String merk, String model, int tahun, String jenisTransmisi) {
        super(noPlat, merk, model, tahun);
        this.jenisTransmisi = jenisTransmisi;
    }

    // Constructor kosong
    public Motor() {
        super();  // Memanggil constructor kosong dari Kendaraan
        this.jenisTransmisi = "";
    }

    @Override
    public String getJenisKendaraan() {
        return "Motor";
    }

    // Getter dan Setter untuk jenisTransmisi
    public String getJenisTransmisi() {
        return jenisTransmisi;
    }

    public void setJenisTransmisi(String jenisTransmisi) {
        this.jenisTransmisi = jenisTransmisi;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + String.format(", Transmisi: %s", jenisTransmisi);
    }
}