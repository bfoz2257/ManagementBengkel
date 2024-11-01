class Motor extends Kendaraan {
    private String jenisTransmisi;

    public Motor(String noPlat, String merk, String model, int tahun, String jenisTransmisi) {
        super(noPlat, merk, model, tahun);
        this.jenisTransmisi = jenisTransmisi;
    }

    
    public Motor() {
        super();  
        this.jenisTransmisi = "";
    }

    @Override
    public String getJenisKendaraan() {
        return "Motor";
    }


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
