/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Matakuliah;
import model.Ujian;

/**
 *
 * @author fauza
 */
public class UjianController {

    public static void createUjian(String kodeUjian, String keterangan, String link, String kodeMatakuliah){
        Ujian ujian = new model.Ujian(kodeUjian, keterangan, link, kodeMatakuliah);
        ujian.createUjian();
    }

    public static void deleteUjian(String kodeUjian, String keterangan, String link, String kodeMatakuliah){
        Ujian ujian = new model.Ujian(kodeUjian, keterangan, link, kodeMatakuliah);
        ujian.deleteUjian();
    }

    public static void updateUjian(String kodeUjian, String keterangan, String link, String kodeMatakuliah){
        Ujian ujian = new model.Ujian(kodeUjian, keterangan, link, kodeMatakuliah);
        ujian.updateUjian();
    }
    
    public static String getIdMatakuliah(String name) {
        Matakuliah matakuliah = new Matakuliah(name);
        return matakuliah.getIdMatakuliah();
    }
}
