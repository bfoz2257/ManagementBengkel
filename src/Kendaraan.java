// Kelas Kendaraan (parent)
class Kendaraan {
    private String noPlat;
    private String merk;
    private String model;
    private int tahun;

    // Constructor dengan parameter
    public Kendaraan(String noPlat, String merk, String model, int tahun) {
        this.noPlat = noPlat;
        this.merk = merk;
        this.model = model;
        this.tahun = tahun;
    }

    // Constructor kosong
    public Kendaraan() {
        this.noPlat = "";
        this.merk = "";
        this.model = "";
        this.tahun = 0;
    }

    // Method yang akan di-override
    public String getJenisKendaraan() {
        return "Kendaraan";
    }

    public String getInfo() {
        return String.format("%s [%s] %s %s (%d)",
                getJenisKendaraan(), noPlat, merk, model, tahun);
    }

    // Getter dan Setter
    public String getNoPlat() { return noPlat; }
    public void setNoPlat(String noPlat) { this.noPlat = noPlat; }
    public String getMerk() { return merk; }
    public void setMerk(String merk) { this.merk = merk; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getTahun() { return tahun; }
    public void setTahun(int tahun) { this.tahun = tahun; }
}