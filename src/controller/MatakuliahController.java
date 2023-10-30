package controller;

import model.*;

public class MatakuliahController {

    public static PenugasanController getInstance() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static String getKodeMatakuliah(String selectedMatakuliah) {
        Matakuliah matakuliah = new Matakuliah(selectedMatakuliah);
        return matakuliah.getIdMatakuliah();
    }

    public static void createPengumpulanTugas(String idPengumpulan, String lampiran, String tanggalPengumpulan, String status, String idTugas, String idMahasiswa){
        PengumpulanTugas pengumpulanTugas = new PengumpulanTugas(idPengumpulan, lampiran, tanggalPengumpulan, status, idMahasiswa, idTugas);
        pengumpulanTugas.createPengumpulanTugas();
    }
}
