package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Model;

public class StatusShalatModel {

    String nama, status;

    public StatusShalatModel() {

    }

    public StatusShalatModel(String nama, String status) {

        this.nama = nama;
        this.status = status;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
