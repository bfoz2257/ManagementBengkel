class Mobil extends Kendaraan {
    private int jumlahPintu;

    // Constructor dengan parameter
    public Mobil(String noPlat, String merk, String model, int tahun, int jumlahPintu) {
        super(noPlat, merk, model, tahun);
        this.jumlahPintu = jumlahPintu;
    }

    // Constructor kosong
    public Mobil() {
        super();  // Memanggil constructor kosong dari Kendaraan
        this.jumlahPintu = 0;
    }

    @Override
    public String getJenisKendaraan() {
        return "Mobil";
    }

    public int getJumlahPintu() {
        return jumlahPintu;
    }

    public void setJumlahPintu(int jumlahPintu) {
        this.jumlahPintu = jumlahPintu;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + String.format(", Jumlah Pintu: %d", jumlahPintu);
    }
}