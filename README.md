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
### > Logical Model
Logical Model adalah model yang menggambarkan struktur data yang akan digunakan dalam database. Berikut adalah Logical Model dari Sistem Penugasan Mahasiswa.

![image](https://github.com/PBO-Pengujian-Akhir/elearning/assets/77602702/8dccb0fa-e681-4fe3-a700-0efc5e378362)

### > Relational Model
Relational Model adalah model yang menggambarkan hubungan antar tabel dalam database. Berikut adalah Relational Model dari Sistem Penugasan Mahasiswa.

![image](https://github.com/PBO-Pengujian-Akhir/elearning/assets/77602702/ea04ee30-6e41-4063-a716-a4a312dc314e)

## Hirarki Kelas
Hirarki Kelas adalah struktur kelas yang digunakan dalam program. Berikut adalah Hirarki Kelas dari Sistem Penugasan Mahasiswa.

![Hirarki](https://github.com/PBO-Pengujian-Akhir/elearning/assets/77602702/e2b2245c-b82a-4d93-ad7b-ef56fb15b4e0)

## Screenshoot Codingan Program

## Screenshoot Output Program
### Halaman Login
![image](https://github.com/PBO-Pengujian-Akhir/elearning/assets/77602702/bbf3e8d4-145a-44e9-8095-8c4fa83c960f)

Terdapat 1 login dimana user dapat memilih login sebagai mahasiswa atau dosen. Jika login sebagai mahasiswa, maka akan diarahkan ke halaman mahasiswa. Jika login sebagai dosen, maka akan diarahkan ke halaman dosen. Program akan menampilkan pesan error jika username atau password yang dimasukkan salah.

### Halaman Dosen
![image](https://github.com/PBO-Pengujian-Akhir/elearning/assets/77602702/edf34adf-0c9d-46c7-8715-5b62d2632754)

Di Dashboard Dosen, dosen langsung diarahkan ke halaman untuk membuat tugas. Dosen dapat membuat tugas dengan mengisi form yang tersedia. Dosen dapat menghapus tugas yang telah dibuat dengan menekan tombol hapus. Dosen dapat mengedit tugas yang telah dibuat dengan menekan tombol edit. Dosen dapat melihat daftar tugas yang telah dibuat dengan menekan tombol Tampilkan Tugas atau pilih langsung di tabel.

#### Membuat Penugasan
![image](https://github.com/PBO-Pengujian-Akhir/elearning/assets/77602702/78f9995c-b95f-4586-9fd0-60bf38dc1145)

Dosen dapat membuat tugas dengan mengisi form yang tersedia. Jika dosen memilih deadline waktu kurang dari waktu saat ini, maka akan muncul pesan error. Jika dosen memilih deadline waktu lebih dari waktu saat ini, maka tugas akan tersimpan di database dan dosen akan diarahkan ke halaman daftar tugas.

#### Menghapus Penugasan

#### Mengedit Penugasan


### Halaman Mahasiswa

#### Melihat Daftar Penugasan

#### Mengumpulkan Penugasan
