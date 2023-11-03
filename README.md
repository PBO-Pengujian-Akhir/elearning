# **Dokumentasi Sistem Penugasan Mahasiswa**

## Kelompok 12
- **Imelda Putri** - 2209116016
- **Muhammad Fauzan** Gifari Dzul Fahmi - 2209116042

## Daftar Isi
  - [Deskripsi Program](#deskripsi)
  - [Flowchart](#flowchart)
  - [Entity Relationship Diagram (ERD)](#entity-relationship-diagram-erd)
    - [Logical Model](#logical-model)
    - [Relational Model](#relational-model)
  - [Hirarki Kelas](#hirarki-kelas)
  - [Screenshoot Codingan](#screenshoot-codingan-program)
  - [Screenshoot Output](#screenshoot-output-program)

## Deskripsi Program
Sistem Penugasan Mahasiswa adalah sebuah sistem yang digunakan untuk memudahkan mahasiswa dalam mengumpulkan tugas-tugas yang diberikan oleh dosen. Sistem ini juga dapat digunakan oleh dosen untuk memberikan tugas kepada mahasiswa. Sistem ini dibuat dengan menggunakan bahasa pemrograman Java Swing dan database MySQL.

## Flowchart
![Flowchart](https://github.com/PBO-Pengujian-Akhir/elearning/assets/77602702/3fc42f98-247c-461f-bd6e-4ff6e202274b)

## Entity Relationship Diagram (ERD)
### Logical Model
Logical Model adalah model yang menggambarkan struktur data yang akan digunakan dalam database. Berikut adalah Logical Model dari Sistem Penugasan Mahasiswa.

![image](https://github.com/PBO-Pengujian-Akhir/elearning/assets/77602702/8dccb0fa-e681-4fe3-a700-0efc5e378362)

### Relational Model
Relational Model adalah model yang menggambarkan hubungan antar tabel dalam database. Berikut adalah Relational Model dari Sistem Penugasan Mahasiswa.

![image](https://github.com/PBO-Pengujian-Akhir/elearning/assets/77602702/ea04ee30-6e41-4063-a716-a4a312dc314e)

## Hirarki Kelas
Hirarki Kelas adalah struktur kelas yang digunakan dalam program. Berikut adalah Hirarki Kelas dari Sistem Penugasan Mahasiswa.

![Hirarki](https://github.com/PBO-Pengujian-Akhir/elearning/assets/77602702/e2b2245c-b82a-4d93-ad7b-ef56fb15b4e0)

## Screenshoot Codingan Program
Pada program yang dibuat, terdapat 3 package yaitu `model`, `view`, dan `controller`. Pada struktur folder diatas kami menggunakan struktur folder MVC (Model-View-Controller). Dimana `model` berisi kelas yang digunakan untuk mengatur data, `view` berisi kelas yang digunakan untuk mengatur tampilan, dan `controller` berisi kelas yang digunakan untuk mengatur logika program. Berikut adalah screenshoot codingan program.

### Package Model
Pada package model, terdapat 3 kelas yaitu `Dosen`, `Mahasiswa`, dan `Tugas`. Kelas `Dosen` dan `Mahasiswa` digunakan untuk mengatur data dosen dan mahasiswa. Kelas `Tugas` digunakan untuk mengatur data tugas. Berikut adalah screenshoot codingan kelas `Dosen`, `Mahasiswa`, dan `Tugas`.

#### Kelas Dosen
```java
package model;

import javax.swing.*;
/**
 *
 * @author fauza
 */
public class Dosen extends User{
    
    private final String role = "Dosen";

    public Dosen(String idUser, String name, String password){
        super(idUser, name, password);
    }

    @Override
    public final String getRole(){
        return this.role;
    }

    public static final boolean loginDosen(String id, String password) {
        try {
            String query = "SELECT * FROM dosen WHERE nip = ? AND password = ?";
            Database.preparedStatement = Database.connection.prepareStatement(query);
            Database.preparedStatement.setString(1, id);
            Database.preparedStatement.setString(2, password);
            Database.resultSet = Database.preparedStatement.executeQuery();

            if (Database.resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Login gagal! " + e.getMessage());
        }
        return false;
    }

    public static final String getName(String id) {
        try {
            String query = "SELECT nama_dosen FROM dosen WHERE nip = ?";
            Database.preparedStatement = Database.connection.prepareStatement(query);
            Database.preparedStatement.setString(1, id);
            Database.resultSet = Database.preparedStatement.executeQuery();

            if (Database.resultSet.next()) {
                return Database.resultSet.getString("nama_dosen");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Login gagal! " + e.getMessage());
        }
        return null;
    }
}

```
Pada kelas `Dosen`, terdapat 2 atribut yaitu `role` dan `name`. Atribut `role` digunakan untuk menyimpan role dari user. Atribut `name` digunakan untuk menyimpan nama dari user. Terdapat 2 method yaitu `getRole()` dan `getName()`. Method `getRole()` digunakan untuk mengembalikan nilai atribut `role`. Method `getName()` digunakan untuk mengembalikan nilai atribut `name`. Terdapat 2 method static yaitu `loginDosen()` dan `getName()`. Method `loginDosen()` digunakan untuk melakukan login dosen. Method `getName()` digunakan untuk mengembalikan nama dosen berdasarkan id dosen.

#### Kelas Mahasiswa
```java
package model;

import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.*;
/**
 *
 * @author fauza
 */
public class Mahasiswa extends User{

    private final String role = "Mahasiswa";
        public Mahasiswa(String idUser, String name, String password){
            super(idUser, name, password);
        }
        @Override
        public final String getRole(){
            return this.role;
        }

        public final static boolean loginMahasiswa(String id, String password) {
            try {
                String query = "SELECT * FROM mahasiswa WHERE nim = ? AND password = ?";
                Database.preparedStatement = Database.connection.prepareStatement(query);
                Database.preparedStatement.setString(1, id);
                Database.preparedStatement.setString(2, password);
                Database.resultSet = Database.preparedStatement.executeQuery();

                if (Database.resultSet.next()) {
                    return true;
                } else {
                    return false;
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Login gagal! ");
                return false;
            }
        }
        
        public static final String getName(String id) {
            try {
                String query = "SELECT nama_mahasiswa FROM mahasiswa WHERE nim = ?";
                Database.preparedStatement = Database.connection.prepareStatement(query);
                Database.preparedStatement.setString(1, id);
                Database.resultSet = Database.preparedStatement.executeQuery();

                if (Database.resultSet.next()) {
                    return Database.resultSet.getString("nama_mahasiswa");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Terjadi Kesalahan!");
            }
            return null;
        }
}
```
Pada kelas `Mahasiswa`, terdapat 2 atribut yaitu `role` dan `name`. Atribut `role` digunakan untuk menyimpan role dari user. Atribut `name` digunakan untuk menyimpan nama dari user. Terdapat 2 method yaitu `getRole()` dan `getName()`. Method `getRole()` digunakan untuk mengembalikan nilai atribut `role`. Method `getName()` digunakan untuk mengembalikan nilai atribut `name`. Terdapat 2 method static yaitu `loginMahasiswa()` dan `getName()`. Method `loginMahasiswa()` digunakan untuk melakukan login mahasiswa. Method `getName()` digunakan untuk mengembalikan nama mahasiswa berdasarkan id mahasiswa.

#### Kelas Database
```java
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;

/**
 *
 * @author fauza
 */
public class Database {
    public static Connection connection = null;

    protected static Statement statement;
    protected static PreparedStatement preparedStatement;
    protected static ResultSet resultSet;

    private final static String DB_HOST = "localhost";
    private final static String DB_NAME = "elearning";
    private final static String DB_USERNAME = "root";
    private final static String DB_PASSWORD = "";

    public Database(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load driver!");
        }
    }

    public final static Connection connect(){
        try {
            String url = "jdbc:mysql://" + DB_HOST + "/" + DB_NAME;
            connection = DriverManager.getConnection(url, DB_USERNAME, DB_PASSWORD);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            System.out.println("Failed to connect database!");
        }
        return connection;
    }

    public final static void disconnect() {
        try {
            connection.close();
            System.out.println("Database disconnected!");
        } catch (SQLException e) {
            System.out.println("Failed to disconnect database!");
        }
    }
}

```
Pada kelas `Database`, terdapat 2 atribut yaitu `connection` dan `statement`. Atribut `connection` digunakan untuk menyimpan koneksi ke database. Atribut `statement` digunakan untuk menyimpan statement yang akan dijalankan. Terdapat 3 method yaitu `connect()`, `disconnect()`, dan `main()`. Method `connect()` digunakan untuk melakukan koneksi ke database. Method `disconnect()` digunakan untuk memutuskan koneksi ke database. Method `main()` digunakan untuk menjalankan program.

#### Kelas Matakuliah
```java
package model;

import javax.swing.*;
import java.sql.SQLException;
/**
 *
 * @author fauza
 */
public class Matakuliah {
    private String id;
    private String name;
    private String idDosen;

    public Matakuliah(String id, String name, String idDosen){
        this.id = id;
        this.name = name;
        this.idDosen = idDosen;
    }

    public Matakuliah(String name) {
        this.name = name;
    }

    public final String getId(){
        return this.id;
    }

    public final String getName(){
        return this.name;
    }

    public final String getIdDosen(){
        return this.idDosen;
    }

    public final String getIdMatakuliah() {
        String idMatakuliah = null;

        try {
            String query = "SELECT * FROM matakuliah WHERE nama_matakuliah = ?";
            Database.preparedStatement = Database.connection.prepareStatement(query);
            Database.preparedStatement.setString(1, this.getName());
            Database.resultSet = Database.preparedStatement.executeQuery();

            if (Database.resultSet.next()) {
                idMatakuliah = Database.resultSet.getString("kode_matakuliah");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Matakuliah tidak ditemukan! " + e.getMessage());
        }
        return idMatakuliah;
    }


}
```
Pada kelas `Matakuliah`, terdapat 3 atribut yaitu `id`, `name`, dan `idDosen`. Atribut `id` digunakan untuk menyimpan id matakuliah. Atribut `name` digunakan untuk menyimpan nama matakuliah. Atribut `idDosen` digunakan untuk menyimpan id dosen. Terdapat 4 method yaitu `getId()`, `getName()`, `getIdDosen()`, dan `getIdMatakuliah()`. Method `getId()` digunakan untuk mengembalikan nilai atribut `id`. Method `getName()` digunakan untuk mengembalikan nilai atribut `name`. Method `getIdDosen()` digunakan untuk mengembalikan nilai atribut `idDosen`. Method `getIdMatakuliah()` digunakan untuk mengembalikan id matakuliah berdasarkan nama matakuliah.

#### Kelas PengumpulanTugas
```java
package model;

import javax.swing.*;
import java.sql.SQLException;
/**
 *
 * @author fauza
 */
public class PengumpulanTugas {
    private final String idPengumpulan;
    private final String idMahasiswa;
    private final String lampiran;
    private final String tanggalPengumpulan;
    private final String status;
    private final String idTugas;

    public PengumpulanTugas(String idPengumpulan, String lampiran, String tanggalPengumpulan, String status, String idMahasiswa, String idTugas){
        this.idPengumpulan = idPengumpulan;
        this.lampiran = lampiran;
        this.tanggalPengumpulan = tanggalPengumpulan;
        this.status = status;
        this.idMahasiswa = idMahasiswa;
        this.idTugas = idTugas;
    }

    public final String getIdPengumpulan(){
        return this.idPengumpulan;
    }

    public final String getLampiran(){
        return this.lampiran;
    }

    public final String getTanggalPengumpulan(){
        return this.tanggalPengumpulan;
    }

    public final String getStatus(){
        return this.status;
    }

    public final String getIdTugas(){
        return this.idTugas;
    }

    public final String getIdMahasiswa(){
        return this.idMahasiswa;
    }

    public final void createPengumpulanTugas(){
        try {
            String query = "INSERT INTO pengumpulan_tugas (id_pengumpulan, lampiran, tanggal_pengumpulan, status, mahasiswa_nim, penugasan_id_tugas) VALUES (?, ?, ?, ?, ?, ?)";
            Database.preparedStatement = Database.connection.prepareStatement(query);
            Database.preparedStatement.setString(1, this.getIdPengumpulan());
            Database.preparedStatement.setString(2, this.getLampiran());
            Database.preparedStatement.setString(3, this.getTanggalPengumpulan());
            Database.preparedStatement.setString(4, this.getStatus());
            Database.preparedStatement.setString(5, this.getIdMahasiswa());
            Database.preparedStatement.setString(6, this.getIdTugas());

            int rowsAffected = Database.preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Pengumpulan tugas berhasil dibuat!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Pengumpulan tugas gagal dibuat! " + e.getMessage());
        }
    }

}

```
Pada kelas `PengumpulanTugas`, terdapat 6 atribut yaitu `idPengumpulan`, `idMahasiswa`, `lampiran`, `tanggalPengumpulan`, `status`, dan `idTugas`. Atribut `idPengumpulan` digunakan untuk menyimpan id pengumpulan tugas. Atribut `idMahasiswa` digunakan untuk menyimpan id mahasiswa. Atribut `lampiran` digunakan untuk menyimpan lampiran pengumpulan tugas. Atribut `tanggalPengumpulan` digunakan untuk menyimpan tanggal pengumpulan tugas. Atribut `status` digunakan untuk menyimpan status pengumpulan tugas. Atribut `idTugas` digunakan untuk menyimpan id tugas. Terdapat 7 method yaitu `getIdPengumpulan()`, `getIdMahasiswa()`, `getLampiran()`, `getTanggalPengumpulan()`, `getStatus()`, `getIdTugas()`, dan `createPengumpulanTugas()`. Method `getIdPengumpulan()` digunakan untuk mengembalikan nilai atribut `idPengumpulan`. Method `getIdMahasiswa()` digunakan untuk mengembalikan nilai atribut `idMahasiswa`. Method `getLampiran()` digunakan untuk mengembalikan nilai atribut `lampiran`. Method `getTanggalPengumpulan()` digunakan untuk mengembalikan nilai atribut `tanggalPengumpulan`. Method `getStatus()` digunakan untuk mengembalikan nilai atribut `status`. Method `getIdTugas()` digunakan untuk mengembalikan nilai atribut `idTugas`. Method `createPengumpulanTugas()` digunakan untuk membuat pengumpulan tugas.

#### Kelas Penugasan
```java
package model;


import javax.swing.*;
import java.sql.SQLException;
/**
 *
 * @author fauza
 */
public class Penugasan {
    private final String idPenugasan;
    private String deadline;
    private String title;
    private String deskripsi;
    private final String kodeMatakuliah;

    public Penugasan(String idPenugasan, String deadline, String title, String deskripsi, String kodeMatakuliah){
        this.idPenugasan = idPenugasan;
        this.deadline = deadline;
        this.title = title;
        this.deskripsi = deskripsi;
        this.kodeMatakuliah = kodeMatakuliah;
    }

    public final String getDeadline(){
        return this.deadline;
    }

    public final String getDeskripsi(){
        return this.deskripsi;
    }

    public final String getTitle(){
        return this.title;
    }

    public final String getIdPenugasan(){
        return this.idPenugasan;
    }
    
    public final String getKodeMataKuliah(){
        return this.kodeMatakuliah;
    }

    public final void createPenugasan() {
        try {
            String query = "INSERT INTO penugasan (id_tugas, deadline, title, deskripsi, matakuliah_kode_matakuliah) VALUES (?, ?, ?, ?, ?)";
            Database.preparedStatement = Database.connection.prepareStatement(query);
            Database.preparedStatement.setString(1, this.getIdPenugasan());
            Database.preparedStatement.setString(2, this.getDeadline());
            Database.preparedStatement.setString(3, this.getTitle());
            Database.preparedStatement.setString(4, this.getDeskripsi());
            Database.preparedStatement.setString(5, this.getKodeMataKuliah());


            int rowsAffected = Database.preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Penugasan berhasil dibuat!");
            }
        } catch (SQLException e) {
            Database.disconnect();
            JOptionPane.showMessageDialog(null, "Penugasan gagal dibuat! " + e.getMessage());
        }
    }

    public final void deletePenugasan() {
        try {
            String query = "DELETE FROM penugasan WHERE id_tugas = ?";
            Database.preparedStatement = Database.connection.prepareStatement(query);
            Database.preparedStatement.setString(1, this.getIdPenugasan());

            int rowsAffected = Database.preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Penugasan berhasil dihapus!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Penugasan gagal dihapus! " + e.getMessage());
        }
    }

    public final void updatePenugasan(){
        try {
            String query = "UPDATE penugasan SET deadline = ?, title = ?, deskripsi = ? WHERE id_tugas = ?";
            Database.preparedStatement = Database.connection.prepareStatement(query);
            Database.preparedStatement.setString(1, this.getDeadline());
            Database.preparedStatement.setString(2, this.getTitle());
            Database.preparedStatement.setString(3, this.getDeskripsi());
            Database.preparedStatement.setString(4, this.getIdPenugasan());

            int rowsAffected = Database.preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                
                JOptionPane.showMessageDialog(null, "Penugasan berhasil diupdate!");
            }
        } catch (SQLException e) {;
            JOptionPane.showMessageDialog(null, "Penugasan gagal diupdate! " + e.getMessage());
        }
    }
}

```
Pada kelas `Penugasan`, terdapat 5 atribut yaitu `idPenugasan`, `deadline`, `title`, `deskripsi`, dan `kodeMatakuliah`. Atribut `idPenugasan` digunakan untuk menyimpan id penugasan. Atribut `deadline` digunakan untuk menyimpan deadline penugasan. Atribut `title` digunakan untuk menyimpan title penugasan. Atribut `deskripsi` digunakan untuk menyimpan deskripsi penugasan. Atribut `kodeMatakuliah` digunakan untuk menyimpan kode matakuliah. Terdapat 6 method yaitu `getDeadline()`, `getDeskripsi()`, `getTitle()`, `getIdPenugasan()`, `getKodeMataKuliah()`, `createPenugasan()`, `deletePenugasan()`, dan `updatePenugasan()`. Method `getDeadline()` digunakan untuk mengembalikan nilai atribut `deadline`. Method `getDeskripsi()` digunakan untuk mengembalikan nilai atribut `deskripsi`. Method `getTitle()` digunakan untuk mengembalikan nilai atribut `title`. Method `getIdPenugasan()` digunakan untuk mengembalikan nilai atribut `idPenugasan`. Method `getKodeMataKuliah()` digunakan untuk mengembalikan nilai atribut `kodeMatakuliah`. Method `createPenugasan()` digunakan untuk membuat penugasan. Method `deletePenugasan()` digunakan untuk menghapus penugasan. Method `updatePenugasan()` digunakan untuk mengupdate penugasan.

#### Kelas User
```java
package model;
/**
 *
 * @author fauza
 */
public abstract class User {
    private final String idUser;
    private final String name;
    private final String password;

    public User(String idUser, String name, String password){
        this.idUser = idUser;
        this.name = name;
        this.password = password;
    }


    public abstract String getRole();
}

```
Pada kelas `User`, terdapat 3 atribut yaitu `idUser`, `name`, dan `password`. Atribut `idUser` digunakan untuk menyimpan id user. Atribut `name` digunakan untuk menyimpan nama user. Atribut `password` digunakan untuk menyimpan password user. Terdapat 1 method yaitu `getRole()`. Method `getRole()` digunakan untuk mengembalikan role user. Method `getRole()` merupakan method abstract.

### Package Controller
Pada package controller, terdapat 4 kelas yaitu, `LoginController`, `MatakuliahController`, `PenugasanController`, dan `UserSession`.

#### Kelas LoginController
```java
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Database;
import model.Dosen;
import model.Mahasiswa;
import model.User;
import view.*;

import javax.swing.*;

/**
 *
 * @author fauza
 */
public class LoginController {
    public static LoginController getInstance() {
        return new LoginController();
    }

    public static boolean loginButton(String id, String password){
        try {
            Database.connect();

            if (id.equals("Type your NIM / NIP") || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields!");
            } else {
                switch (id.charAt(0)) {
                    case '2' -> {
                        if (Mahasiswa.loginMahasiswa(id, password)) {
                            UserSession.getInstance().setUserId(id);
                            UserSession.getInstance().setUserName(Mahasiswa.getName(id));
                            MenuMahasiswa dashboardMahasiswa = new MenuMahasiswa();
                            dashboardMahasiswa.setVisible(true);
                            dashboardMahasiswa.pack();
                            dashboardMahasiswa.setLocationRelativeTo(null);
                            dashboardMahasiswa.setDefaultCloseOperation(MenuMahasiswa.EXIT_ON_CLOSE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Login gagal!");
                        }
                    }
                    case '1' -> {
                        if (Dosen.loginDosen(id, password)) {
                            UserSession.getInstance().setUserId(id);
                            UserSession.getInstance().setUserName(Dosen.getName(id));
                            MenuDosen dashboardDosen = new MenuDosen();
                            dashboardDosen.setVisible(true);
                            dashboardDosen.pack();
                            dashboardDosen.setLocationRelativeTo(null);
                            dashboardDosen.setDefaultCloseOperation(MenuDosen.EXIT_ON_CLOSE);;
                        } else {
                            JOptionPane.showMessageDialog(null, "Login gagal!");
                        }
                    }
                    default -> JOptionPane.showMessageDialog(null, "Invalid ID!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
        }
        return false;
    }
    
}

```
Pada kelas `LoginController`, terdapat 1 method yaitu `loginButton()`. Method `loginButton()` digunakan untuk mengatur logika program pada halaman login.

#### Kelas MatakuliahController
```java
package controller;

import model.*;
/**
 *
 * @author fauza
 */
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

```
Pada kelas `MatakuliahController`, terdapat 2 method yaitu `getKodeMatakuliah()` dan `createPengumpulanTugas()`. Method `getKodeMatakuliah()` digunakan untuk mengembalikan kode matakuliah berdasarkan nama matakuliah. Method `createPengumpulanTugas()` digunakan untuk membuat pengumpulan tugas.

#### Kelas PenugasanController
```java
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

```
Pada kelas `PenugasanController`, terdapat 4 method yaitu `createTugasButton()`, `getIdMatakuliah()`, `deleteTugasButton()`, dan `updateTugasButton()`. Method `createTugasButton()` digunakan untuk membuat tugas. Method `getIdMatakuliah()` digunakan untuk mengembalikan id matakuliah berdasarkan nama matakuliah. Method `deleteTugasButton()` digunakan untuk menghapus tugas. Method `updateTugasButton()` digunakan untuk mengupdate tugas.

#### Kelas UserSession
```java
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Dosen;

/**
 *
 * @author fauza
 */
public class UserSession {
    private String userId;
    private String userName;

    private static UserSession instance;

    private UserSession() {
    }

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public void clearSession() {
        userId = null;
    }

    public boolean isUserLoggedIn() {
        return userId != null && userName != null;
    }


}

```

Pada kelas `UserSession`, terdapat 7 atribut yaitu `userId`, `userName`, dan `instance`. Atribut `userId` digunakan untuk menyimpan id user. Atribut `userName` digunakan untuk menyimpan nama user. Atribut `instance` digunakan untuk menyimpan instance dari kelas `UserSession`. Terdapat 7 method yaitu `getInstance()`, `setUserId()`, `setUserName()`, `getUserName()`, `getUserId()`, `clearSession()`, dan `isUserLoggedIn()`. Method `getInstance()` digunakan untuk mengembalikan instance dari kelas `UserSession`. Method `setUserId()` digunakan untuk mengatur nilai atribut `userId`. Method `setUserName()` digunakan untuk mengatur nilai atribut `userName`. Method `getUserName()` digunakan untuk mengembalikan nilai atribut `userName`. Method `getUserId()` digunakan untuk mengembalikan nilai atribut `userId`. Method `clearSession()` digunakan untuk menghapus session. Method `isUserLoggedIn()` digunakan untuk mengecek apakah user sudah login atau belum.

### Package View
Pada package view, terdapat 3 kelas yaitu `MenuDosen`, `MenuMahasiswa`, dan `Login`.

#### Kelas Login
```java
    private void buttonCloseMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_buttonCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_buttonCloseMouseClicked

    private void idBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idBoxFocusGained
        if (idBox.getText().equals("Type your NIM / NIP")) {
            idBox.setText("");
        }
    }//GEN-LAST:event_idBoxFocusGained

    private void idBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idBoxFocusLost
        if (idBox.getText().isEmpty()){
            idBox.setText("Type your NIM / NIP");
        }
    }//GEN-LAST:event_idBoxFocusLost

    private void loginButtonMouseClicked(java.awt.event.MouseEvent evt) {
        String id = idBox.getText();
        String password = passwordField.getText();
        LoginController.loginButton(id, password);
       
```

Pada kode diatas, terdapat 4 method yaitu `buttonCloseMouseClicked()`, `idBoxFocusGained()`, `idBoxFocusLost()`, dan `loginButtonMouseClicked()`. Method `buttonCloseMouseClicked()` digunakan untuk menutup program. Method `idBoxFocusGained()` digunakan untuk mengatur tampilan pada text field idBox saat focus. Method `idBoxFocusLost()` digunakan untuk mengatur tampilan pada text field idBox saat tidak focus. Method `loginButtonMouseClicked()` digunakan untuk mengatur logika program pada tombol login.

#### Kelas MenuDosen
```java
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.io.File;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import controller.PenugasanController;
import controller.LoginController;
import controller.UserSession;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import model.*;

/**
 *
 * @author fauza
 */
public final class MenuDosen extends javax.swing.JFrame {
    int xx, xy;
    /**
         * Creates new form CreateAssignment
         */
    public MenuDosen() {
        initComponents();
        table();
        Database.connect();
        clear();
        labelUser();
    }

    public void labelUser(){
        String name = UserSession.getInstance().getUserName();
        JOptionPane.showMessageDialog(null, "Welcome back " + name);
    }
    
    void clear(){
        assignment.setText("");
        deskripsiField.setText("");
    }

    public void table(){
        DefaultTableModel table = new DefaultTableModel();
        table.addColumn("ID Penugasan");
        table.addColumn("Deadline");
        table.addColumn("Title");
        table.addColumn("Deskripsi");
        table.addColumn("Kode Mata Kuliah");
        
        try {
            Statement statement = (Statement) Database.connect().createStatement();
            ResultSet resulset = statement.executeQuery("SELECT * FROM penugasan");
            
            while(resulset.next()){
                table.addRow(new Object[] {
                    resulset.getString("id_tugas"),
                    resulset.getString("deadline"),
                    resulset.getString("title"),
                    resulset.getString("deskripsi"),
                    resulset.getString("matakuliah_kode_matakuliah")
                });
                dataTable.setModel(table);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Koneksi gagal! " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deskripsiName = new javax.swing.JLabel();
        matakuliahName = new javax.swing.JLabel();
        namaTugasName = new javax.swing.JLabel();
        deadlineName = new javax.swing.JLabel();
        assignment = new javax.swing.JTextField();
        matakuliah = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        createTugasButton = new javax.swing.JButton();
        deleteTugasButton = new javax.swing.JButton();
        updateTugasButton = new javax.swing.JButton();
        showTugasButton = new javax.swing.JButton();
        closeButton = new javax.swing.JLabel();
        titleDashboard = new javax.swing.JLabel();
        backMenuButton = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        deskripsiField = new javax.swing.JTextArea();
        dateChooser = new com.toedter.calendar.JDateChooser();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deskripsiName.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        deskripsiName.setText("Deskripsi Tugas");
        getContentPane().add(deskripsiName, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, -1, 30));

        matakuliahName.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        matakuliahName.setText("Mata Kuliah");
        getContentPane().add(matakuliahName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, -1, 30));

        namaTugasName.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        namaTugasName.setText("Nama Tugas");
        getContentPane().add(namaTugasName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 120, 30));

        deadlineName.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        deadlineName.setText("Deadline");
        getContentPane().add(deadlineName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, 30));
        getContentPane().add(assignment, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 280, 30));

        matakuliah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Mata Kuliah", "Basis Data Lanjut", "Dasar Dasar Pengembangan Perangkat Lunak", "Desain dan Manajemen Jaringan Komputer", "Desain Basis Data", "Interaksi Manusia dan Komputer", "Manajemen Layanan IT", "Manajemen Proses Bisnis Pemrograman Berorientasi Objek", "Riset Operasi" }));
        getContentPane().add(matakuliah, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 280, 30));

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dataTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(dataTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 880, 190));

        createTugasButton.setText("Buat Tugas");
        createTugasButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createTugasButtonMouseClicked(evt);
            }
        });
        createTugasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTugasButtonActionPerformed(evt);
            }
        });
        getContentPane().add(createTugasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 110, -1));

        deleteTugasButton.setText("Hapus Tugas");
        deleteTugasButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteTugasButtonMouseClicked(evt);
            }
        });
        getContentPane().add(deleteTugasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 110, -1));

        updateTugasButton.setText("Edit Tugas");
        updateTugasButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateTugasButtonMouseClicked(evt);
            }
        });
        getContentPane().add(updateTugasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 110, -1));

        showTugasButton.setText("Tampilin Tugas");
        showTugasButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showTugasButtonMouseClicked(evt);
            }
        });
        getContentPane().add(showTugasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, -1, -1));

        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/closeButton.png"))); // NOI18N
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButtonMouseClicked(evt);
            }
        });
        getContentPane().add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, -1, -1));

        titleDashboard.setFont(new java.awt.Font("Montserrat Medium", 0, 36)); // NOI18N
        titleDashboard.setForeground(new java.awt.Color(0, 155, 76));
        titleDashboard.setText("Dashboard Dosen");
        getContentPane().add(titleDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, 40));

        backMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backtButton.png"))); // NOI18N
        backMenuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMenuButtonMouseClicked(evt);
            }
        });
        getContentPane().add(backMenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        deskripsiField.setColumns(20);
        deskripsiField.setRows(5);
        jScrollPane2.setViewportView(deskripsiField);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, 320, -1));

        dateChooser.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 300, 30));
        JTextField dateEditor = (JTextField) dateChooser.getDateEditor().getUiComponent();
        dateEditor.setEditable(false);
        dateEditor.setFocusable(false);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dashboardForm.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createTugasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTugasButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createTugasButtonActionPerformed

    private void createTugasButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createTugasButtonMouseClicked
        try {
            String kodeMatakuliah = PenugasanController.getIdMatakuliah(matakuliah.getSelectedItem().toString());
            String idPenugasan = "TGS-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String deadline = dateFormat.format(dateChooser.getDate());

            if (dateChooser.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Tolong isi semuanya!");
            } else {
                Date date = new Date();
                String dateNow = dateFormat.format(date);
                Date date1 = dateFormat.parse(dateNow);
                Date date2 = dateFormat.parse(deadline);
                if (date2.compareTo(date1) < 0) {
                    JOptionPane.showMessageDialog(null, "Deadline tidak boleh kurang dari hari ini!");
                } else {
                    String titleTugas = assignment.getText();
                    String deskripsi = deskripsiField.getText();

                    if (kodeMatakuliah.isEmpty() || deadline.isEmpty() || titleTugas.isEmpty() || deskripsi.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Tolong isi semuanya!");
                    } else {
                        PenugasanController.createTugasButton(idPenugasan, deadline, titleTugas, deskripsi, kodeMatakuliah);
                        table();
                        clear();
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
        }

    }//GEN-LAST:event_createTugasButtonMouseClicked

    private void deleteTugasButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteTugasButtonMouseClicked
        try {
            int row = dataTable.getSelectedRow();
            if (row >= 0) {
                DefaultTableModel model = (DefaultTableModel) dataTable.getModel();
                String idPenugasan = model.getValueAt(row, 0).toString();
                String kodeMatakuliah = model.getValueAt(row, 4).toString();

                PenugasanController.deleteTugasButton(idPenugasan, null, null, null, kodeMatakuliah);
                table();
                model.removeRow(row);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Pilih tugas yang ingin dihapus!.");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
        }
    }//GEN-LAST:event_deleteTugasButtonMouseClicked

    private void closeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeButtonMouseClicked

    private void showTugasButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showTugasButtonMouseClicked
        table();
    }//GEN-LAST:event_showTugasButtonMouseClicked

    private void updateTugasButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateTugasButtonMouseClicked
        try {
            int row = dataTable.getSelectedRow();
            if (row >= 0) {
                DefaultTableModel model = (DefaultTableModel) dataTable.getModel();
                String idPenugasan = model.getValueAt(row, 0).toString();
                String kodeMatakuliah = model.getValueAt(row, 4).toString();
                String deadline = dateChooser.getDateFormatString();
                String titleTugas = assignment.getText();
                String description = deskripsiField.getText();

                if (deadline.isEmpty() || titleTugas.isEmpty() || description.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields!");
                } else {
                    PenugasanController.updateTugasButton(idPenugasan, deadline, titleTugas, description, kodeMatakuliah);

                    model.setValueAt(deadline, row, 1);
                    model.setValueAt(titleTugas, row, 2);
                    model.setValueAt(description, row, 3);
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Please select a task to update.");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
        }
    }//GEN-LAST:event_updateTugasButtonMouseClicked

    private void backMenuButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMenuButtonMouseClicked
        Login login = new Login();
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(Login.EXIT_ON_CLOSE);
        UserSession.getInstance().clearSession();
        this.dispose();
    }//GEN-LAST:event_backMenuButtonMouseClicked

    /*
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuDosen penugasanForm = new MenuDosen();
                penugasanForm.setVisible(true);
                penugasanForm.pack();
                penugasanForm.setLocationRelativeTo(null);
                penugasanForm.setDefaultCloseOperation(MenuDosen.EXIT_ON_CLOSE);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField assignment;
    private javax.swing.JLabel backMenuButton;
    private javax.swing.JLabel background;
    private javax.swing.JLabel closeButton;
    private javax.swing.JButton createTugasButton;
    private javax.swing.JTable dataTable;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel deadlineName;
    private javax.swing.JButton deleteTugasButton;
    private javax.swing.JTextArea deskripsiField;
    private javax.swing.JLabel deskripsiName;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> matakuliah;
    private javax.swing.JLabel matakuliahName;
    private javax.swing.JLabel namaTugasName;
    private javax.swing.JButton showTugasButton;
    private javax.swing.JLabel titleDashboard;
    private javax.swing.JButton updateTugasButton;
    // End of variables declaration//GEN-END:variables
}

```

Pada kelas `MenuDosen`, terdapat 4 atribut yaitu `xx`, `xy`, `idPenugasan`, dan `kodeMatakuliah`. Atribut `xx` digunakan untuk menyimpan posisi x dari mouse. Atribut `xy` digunakan untuk menyimpan posisi y dari mouse. Atribut `idPenugasan` digunakan untuk menyimpan id penugasan. Atribut `kodeMatakuliah` digunakan untuk menyimpan kode matakuliah. Terdapat 2 method yaitu `labelUser()` dan `table()`. Method `labelUser()` digunakan untuk menampilkan pesan selamat datang. Method `table()` digunakan untuk menampilkan data penugasan pada tabel.

#### Kelas MenuMahasiswa
```java
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.LoginController;
import controller.MatakuliahController;
import controller.UserSession;
import model.Database;

import java.io.File;
import java.sql.*;
import java.util.UUID;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.crypto.Data;

/**
 *
 * @author fauza
 */
public class MenuMahasiswa extends javax.swing.JFrame {

    public MenuMahasiswa() {
        initComponents();
        Database.connect();
        labelUser();

    }
    
    public void labelUser(){
        LoginController loginController = LoginController.getInstance();
        String name = UserSession.getInstance().getUserName();
        JOptionPane.showMessageDialog(null, "Welcome back " + name);
    }

    public void table() {
        DefaultTableModel table = new DefaultTableModel();
        table.addColumn("ID Penugasan");
        table.addColumn("Deadline");
        table.addColumn("Title");
        table.addColumn("Deskripsi");
        table.addColumn("Kode Mata Kuliah");

        try {
            String selectedMatakuliah = matakuliahChoose.getSelectedItem().toString();
            String kodeMatakuliah = MatakuliahController.getKodeMatakuliah(selectedMatakuliah);

            if (!kodeMatakuliah.isEmpty()) {
                PreparedStatement preparedStatement = Database.connect().prepareStatement("SELECT * FROM penugasan WHERE matakuliah_kode_matakuliah = ?");
                preparedStatement.setString(1, kodeMatakuliah);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    table.addRow(new Object[]{
                            resultSet.getString("id_tugas"),
                            resultSet.getString("deadline"),
                            resultSet.getString("title"),
                            resultSet.getString("deskripsi"),
                            resultSet.getString("matakuliah_kode_matakuliah"),
                    });
                }

                tabel.setModel(table);
            } else {
                JOptionPane.showMessageDialog(null, "Kode matakuliah tidak ditemukan.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal! " + e.getMessage());
        }
    }

    public MenuMahasiswa returnValueById(String id) {
        MenuMahasiswa menuMahasiswa = null;
        try {
            Database.connect();
            String sql = "SELECT * FROM penugasan WHERE id_tugas = ?";
            PreparedStatement preparedStatement = Database.connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                menuMahasiswa = new MenuMahasiswa();
                menuMahasiswa.idTugasField.setText(resultSet.getString("id_tugas"));
                menuMahasiswa.keteranganField.setText(resultSet.getString("deskripsi"));
                MenuMahasiswa menu = new MenuMahasiswa();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return menuMahasiswa;
    }
    

    public void selectTugas(){
        int i = tabel.getSelectedRow();
        TableModel model = tabel.getModel();
        idTugasField.setText(model.getValueAt(i, 0).toString());
        keteranganField.setText(model.getValueAt(i, 3).toString());
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileUpload = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        fileTugasField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        keteranganField = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        idTugasField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        kumpulButton = new javax.swing.JButton();
        statusText = new javax.swing.JLabel();
        backMenuButton = new javax.swing.JLabel();
        matakuliahChoose = new javax.swing.JComboBox<>();
        refreshButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fileUpload.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        fileUpload.setText("Uploud Tugas");
        fileUpload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fileUploadMouseClicked(evt);
            }
        });
        fileUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileUploadActionPerformed(evt);
            }
        });
        getContentPane().add(fileUpload, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, 30));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel.getTableHeader().setReorderingAllowed(false);
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 880, 190));
        getContentPane().add(fileTugasField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 180, 30));
        fileTugasField.setEditable(false);
        fileTugasField.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel1.setText("ID Tugas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        keteranganField.setColumns(20);
        keteranganField.setRows(5);
        jScrollPane2.setViewportView(keteranganField);
        keteranganField.setEditable(false);
        keteranganField.setFocusable(false);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, 350, 110));

        jLabel3.setFont(new java.awt.Font("Montserrat Medium", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 155, 76));
        jLabel3.setText("Keterangan Tugas");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, 40));
        getContentPane().add(idTugasField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 180, 30));
        idTugasField.setEditable(false);
        idTugasField.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel4.setText("Keterangan Tugas");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 140, -1));

        kumpulButton.setText("Kumpul");
        kumpulButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kumpulButtonMouseClicked(evt);
            }
        });
        getContentPane().add(kumpulButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 100, 30));

        statusText.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        statusText.setText("Mata Kuliah");
        getContentPane().add(statusText, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, -1, 30));

        backMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backtButton.png"))); // NOI18N
        backMenuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMenuButtonMouseClicked(evt);
            }
        });
        getContentPane().add(backMenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        matakuliahChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Mata Kuliah", "Basis Data Lanjut", "Dasar Dasar Pengembangan Perangkat Lunak", "Desain dan Manajemen Jaringan Komputer", "Desain Basis Data", "Interaksi Manusia dan Komputer", "Manajemen Layanan IT", "Manajemen Proses Bisnis", "Pemrograman Berorientasi Objek", "Riset Operasi" }));
        getContentPane().add(matakuliahChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 180, 30));

        refreshButton.setText("Refresh");
        refreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshButtonMouseClicked(evt);
            }
        });
        getContentPane().add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 400, 90, 30));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dashboardForm.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileUploadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileUploadMouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();

        if (f != null) {
            String fileName = f.getName();
            String fileExtension = "";

            int dotIndex = fileName.lastIndexOf('.');
            if (dotIndex > 0) {
                fileExtension = fileName.substring(dotIndex + 1);
                fileName = fileName.substring(0, dotIndex);
            }

            fileTugasField.setText(fileName + "." + fileExtension);
        } else {
            fileTugasField.setText("Tidak ada file yang dipilih");
        }
    }//GEN-LAST:event_fileUploadMouseClicked

    private void fileUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileUploadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileUploadActionPerformed

    private void kumpulButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kumpulButtonMouseClicked
        String idPengumpulan = UUID.randomUUID().toString().substring(0, 5);
        String lampiran = fileTugasField.getText();
        String idMahasiswa = UserSession.getInstance().getUserId();
        LocalDateTime hariIni = LocalDateTime.now();
        
        LocalDate deadline = hariIni.toLocalDate();

        String status = "";

        if (hariIni.isAfter(deadline.atStartOfDay())) {
            status = "Terlambat mengumpul";
        } else if (hariIni.isEqual(deadline.atStartOfDay())) {
            status = "Terkumpul";
        } else {
            status = "Belum diperiksa";
        }

        String idTugas = idTugasField.getText();

        MatakuliahController.createPengumpulanTugas(idPengumpulan, lampiran, deadline.toString(), status, idTugas, idMahasiswa);
    }//GEN-LAST:event_kumpulButtonMouseClicked

    private void backMenuButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMenuButtonMouseClicked
        Login login = new Login();
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(MenuMahasiswa.EXIT_ON_CLOSE);
        UserSession.getInstance().clearSession();
        this.dispose();
    }//GEN-LAST:event_backMenuButtonMouseClicked

    private void refreshButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseClicked
        table();
    }//GEN-LAST:event_refreshButtonMouseClicked

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int selectedRow = tabel.getSelectedRow();

        if (selectedRow >= 0) {
            String idTugas = tabel.getValueAt(selectedRow, 0).toString();
            String keterangan = tabel.getValueAt(selectedRow, 3).toString();

            idTugasField.setText(idTugas);
            keteranganField.setText(keterangan);
        }
    }//GEN-LAST:event_tabelMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuMahasiswa tugasForm = new MenuMahasiswa();
                tugasForm.setVisible(true);
                tugasForm.pack();
                tugasForm.setLocationRelativeTo(null);
                tugasForm.setDefaultCloseOperation(MenuMahasiswa.EXIT_ON_CLOSE);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backMenuButton;
    private javax.swing.JLabel background;
    private javax.swing.JTextField fileTugasField;
    private javax.swing.JButton fileUpload;
    private javax.swing.JTextField idTugasField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea keteranganField;
    private javax.swing.JButton kumpulButton;
    private javax.swing.JComboBox<String> matakuliahChoose;
    private javax.swing.JButton refreshButton;
    private javax.swing.JLabel statusText;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}

```

Pada kelas `MenuMahasiswa`, terdapat 2 atribut yaitu `idTugas` dan `kodeMatakuliah`. Atribut `idTugas` digunakan untuk menyimpan id tugas. Atribut `kodeMatakuliah` digunakan untuk menyimpan kode matakuliah. Terdapat 3 method yaitu `labelUser()`, `table()`, dan `returnValueById()`. Method `labelUser()` digunakan untuk menampilkan pesan selamat datang. Method `table()` digunakan untuk menampilkan data penugasan pada tabel. Method `returnValueById()` digunakan untuk mengembalikan nilai berdasarkan id.


## Screenshoot Output Program
### Halaman Login
![image](https://github.com/PBO-Pengujian-Akhir/elearning/assets/77602702/bbf3e8d4-145a-44e9-8095-8c4fa83c960f)

Terdapat 1 login dimana user dapat memilih login sebagai mahasiswa atau dosen. Jika login sebagai mahasiswa, maka akan diarahkan ke halaman mahasiswa. Jika login sebagai dosen, maka akan diarahkan ke halaman dosen. Program akan menampilkan pesan error jika username atau password yang dimasukkan salah.

### Halaman Dosen
![image](https://github.com/PBO-Pengujian-Akhir/elearning/assets/77602702/edf34adf-0c9d-46c7-8715-5b62d2632754)

Di Dashboard Dosen, dosen langsung diarahkan ke halaman untuk membuat tugas. Dosen dapat membuat tugas dengan mengisi form yang tersedia. Dosen dapat menghapus tugas yang telah dibuat dengan menekan tombol hapus. Dosen dapat mengedit tugas yang telah dibuat dengan menekan tombol edit. Dosen dapat melihat daftar tugas yang telah dibuat dengan menekan tombol Tampilkan Tugas atau pilih langsung di tabel.

#### Membuat Penugasan
![image](https://github.com/PBO-Pengujian-Akhir/elearning/assets/77602702/f2305555-89f5-496a-8b3e-6467cad9ed44)

Dosen dapat membuat tugas dengan mengisi form yang tersedia. Jika dosen memilih deadline waktu kurang dari waktu saat ini, maka akan muncul pesan error. Jika dosen memilih deadline waktu lebih dari waktu saat ini, maka tugas akan tersimpan di database dan dosen akan diarahkan ke halaman daftar tugas.

![image](https://github.com/PBO-Pengujian-Akhir/elearning/assets/77602702/24824676-77dc-4423-bef3-602475db92df)

Ketika sudah menginputkan data, dosen dapat menekan tombol Buat Tugas untuk menyimpan tugas ke database.

#### Menghapus Penugasan
![image](https://github.com/PBO-Pengujian-Akhir/elearning/assets/77602702/3e53e02a-2760-401e-992e-f9662a3af71b)

![image](https://github.com/PBO-Pengujian-Akhir/elearning/assets/77602702/dd586d3c-3b12-4bee-9bb5-6b9bb00fc1f5)

Jika ingin mau menghapus tugas, dosen dapat memilih tugas yang ingin dihapus di tabel, lalu menekan tombol Hapus Tugas. Tugas akan terhapus dari database dan tabel.

#### Mengedit Penugasan
![image](https://github.com/PBO-Pengujian-Akhir/elearning/assets/77602702/12419262-3d0d-4c68-94b4-5f70bc58d782)

![image](https://github.com/PBO-Pengujian-Akhir/elearning/assets/77602702/2705afe2-9f96-4907-9e35-02267c76dc37)

![image](https://github.com/PBO-Pengujian-Akhir/elearning/assets/77602702/797d498b-d760-4658-a0ac-39a4a207de5c)

Jika ingin mengedit tugas, dosen dapat memilih tugas yang ingin dihapus di tabel, lalu menekan tombol Edit Tugas. Tugas akan teredit di database dan tabel.

### Halaman Mahasiswa
![image](https://github.com/PBO-Pengujian-Akhir/elearning/assets/77602702/6aaf5bb8-8376-46a2-bc76-7c9b22d755de)

Di Dashboard Mahasiswa, mahasiswa dapat memilih mata kuliah yang ingin dilihat tugasnya. Mahasiswa dapat melihat tugas yang telah dibuat dengan menekan tombol Tampilkan Tugas atau pilih langsung di tabel. Mahasiswa dapat mengumpulkan tugas dengan mengisi form yang tersedia. Mahasiswa dapat menghapus tugas yang telah dibuat dengan menekan tombol hapus. Mahasiswa dapat mengedit tugas yang telah dibuat dengan menekan tombol edit.

#### Melihat Daftar Penugasan
![image](https://github.com/PBO-Pengujian-Akhir/elearning/assets/77602702/26633e71-ab5e-4950-a919-502adaab1c22)

Mahasiswa dapat melihat daftar tugas yang telah dibuat dengan menekan tombol Tampilkan Tugas atau pilih langsung di tabel.

#### Mengumpulkan Penugasan
![image](https://github.com/PBO-Pengujian-Akhir/elearning/assets/77602702/99b3a402-d714-4b81-94c0-6a5c50eeefe5)

Mahasiswa dapat mengumpulkan tugas dengan mengisi form yang tersedia. Jika mahasiswa memilih deadline waktu kurang dari waktu saat ini, maka akan muncul pesan error. Jika mahasiswa memilih deadline waktu lebih dari waktu saat ini, maka tugas akan tersimpan di database dan mahasiswa akan diarahkan ke halaman daftar tugas.


# Terima Kasih
