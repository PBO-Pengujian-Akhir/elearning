/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.*;

/**
 *
 * @author fauza
 */
public class PenugasanController {
    
    public static void createTugasButton(String idPenugasan, String deadline, String title, String deskripsi, String kodeMatakuliah){
        Penugasan penugasan = new Penugasan(idPenugasan, deadline, title, deskripsi, kodeMatakuliah);
        penugasan.createPenugasan();
    }

    public static String getIdMatakuliah(String name) {
        Matakuliah matakuliah = new Matakuliah(name);
        return matakuliah.getIdMatakuliah();
    }

    public static void deleteTugasButton(String idPenugasan, String deadline, String title, String deskripsi, String kodeMatakuliah){
        Penugasan penugasan = new Penugasan(idPenugasan, deadline, title, deskripsi, kodeMatakuliah);
        penugasan.deletePenugasan();
    }

    public static void updateTugasButton(String idPenugasan, String deadline, String title, String deskripsi, String kodeMatakuliah){
        Penugasan penugasan = new Penugasan(idPenugasan, deadline, title, deskripsi, kodeMatakuliah);
        penugasan.updatePenugasan();
    }
}
