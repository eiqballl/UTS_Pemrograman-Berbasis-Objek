# SISTEM BOOKING LAPANGAN BADMINTON - UTS Mata Kuliah Pemrograman Berbasis Objek

**Nama: Iqbal Nurriz Ramadhan**

**NIM: 2509116067**

**Kelas: Sistem Informasi (B)**


## Latar Belakang & Deskripsi Singkat Program

Program ini merupakan sistem berbasis Java yang dibuat untuk memenuhi tugas Ujian Tengah Semester (UTS) Mata Kuliah Pemrograman Berorientasi Objek (PBO). Sistem ini bertujuan untuk membantu pengelolaan data customer, lapangan, serta pemesanan lapangan badminton secara terstruktur.

Sistem Booking Lapangan Badminton dibuat berbasis CLI (Command Line Interface) dan menyimpan data secara dinamis di dalam memori menggunakan `ArrayList`. Program menerapkan konsep Pemrograman Berorientasi Objek seperti inheritance, polymorphism, condition, looping, dan encapsulation.


## Penjelasan Alur Program

1. **Inisialisasi Awal**
   - Program membuat `ArrayList` untuk menyimpan data Customer, Lapangan, dan Booking.
   - Sistem memiliki dummy data awal Customer, Lapangan, dan Booking agar data dapat langsung ditampilkan atau diuji ketika program dijalankan.
   - Tersedia 4 lapangan dengan jenis karpet Vinyl dan Wooden.
   - Customer terdiri dari dua jenis, yaitu Member dan Non Member.

2. **Menu Utama**
   - Program menggunakan perulangan `while` dan percabangan `switch-case` untuk menampilkan menu interaktif pilihan 1–8 hingga pengguna memilih menu keluar.

     <img width="312" height="207" alt="image" src="https://github.com/user-attachments/assets/0f2af432-8a6b-4a14-9cc2-5fbe82a9357f" />

3. **Operasi Fitur Program & CRUD**
   - **Tambah Customer (Pilihan 1):** Mengambil input ID Customer, nama, nomor HP, dan jenis customer. Berdasarkan jenis yang dipilih, program membuat object `Member` atau `NonMember`, kemudian menyimpannya ke dalam `listCustomer`.

      <img width="240" height="242" alt="image" src="https://github.com/user-attachments/assets/b0f400a8-4c67-49eb-8ad1-17ff3346ec42" />

   - **Tampilkan Customer (Pilihan 2):** Menampilkan seluruh data customer mulai dari ID, nama, nomor HP, hingga status Member atau Non Member.

     <img width="450" height="158" alt="image" src="https://github.com/user-attachments/assets/c8c12e84-e790-4914-833e-b94e2fbed908" />

   - **Tampilkan Lapangan (Pilihan 3):** Menampilkan seluruh lapangan yang tersedia beserta informasi nomor lapangan, jenis karpet, dan harga sewa per jam.

     <img width="390" height="166" alt="image" src="https://github.com/user-attachments/assets/d75bba55-89d2-4bd9-93ac-2f2fbbb94976" />

   - **Tambah Booking Lapangan (Pilihan 4):** Pengguna memilih customer dan lapangan, kemudian memasukkan durasi bermain, jam mulai, serta tanggal booking. Kode booking dibuat secara otomatis berdasarkan ID Customer dan nomor lapangan, lalu object `Booking` disimpan ke dalam `listBooking`.

     <img width="446" height="463" alt="image" src="https://github.com/user-attachments/assets/93ceb8e6-199a-42f3-912c-ca28cb380f87" />

   - **Tampilkan Booking (Pilihan 5):** Menampilkan seluruh data booking seperti kode booking, ID Customer, nomor lapangan, durasi bermain, jam mulai, tanggal, dan total harga.

   - Total harga booking dihitung berdasarkan durasi bermain dan harga sewa lapangan. Customer Member mendapatkan diskon, sedangkan Non Member mendapatkan biaya tambahan.

     <img width="972" height="100" alt="image" src="https://github.com/user-attachments/assets/c23bd8a4-356e-478e-843a-f97c3c77ce43" />

   - **Update Booking (Pilihan 6):** Meminta kode booking yang ingin diubah, kemudian pengguna memasukkan data booking baru berupa ID Customer, nomor lapangan, durasi bermain, jam mulai, dan tanggal.

     <img width="970" height="310" alt="image" src="https://github.com/user-attachments/assets/bfbf19b8-71d0-4bfe-86fb-3e00efcb9116" />

     Hasil setelah data diperbarui:

     <img width="969" height="99" alt="image" src="https://github.com/user-attachments/assets/6d2803d7-f6a4-416a-a6af-3fae2699776c" />

   - **Hapus Booking (Pilihan 7):** Meminta kode booking yang ingin dihapus, kemudian menghapus object dari `listBooking` jika data ditemukan.

     <img width="975" height="131" alt="image" src="https://github.com/user-attachments/assets/e8128ceb-a6c6-42b7-adf6-340332fa7ff2" />

     Daftar booking setelah dihapus:

     <img width="969" height="96" alt="image" src="https://github.com/user-attachments/assets/1cf64724-87f2-485c-95b4-43a61e45e9b8" />

   - **Keluar (Pilihan 8):** Menghentikan perulangan menu utama sehingga program selesai dijalankan.

     <img width="377" height="231" alt="image" src="https://github.com/user-attachments/assets/79f027f3-1912-471b-b47e-c4f67a3d6dac" />


## Penerapan Encapsulation

Encapsulation diterapkan dengan menggunakan access modifier `private` pada atribut di dalam class.

Contohnya:

```java
private String idCustomer;
private String namaCustomer;
private String noHp;
```

Data dapat diakses melalui getter dan beberapa data dapat diubah menggunakan setter.

Contoh:

```java
public String getNamaCustomer() {
    return namaCustomer;
}

public void setNamaCustomer(String namaCustomer) {
    this.namaCustomer = namaCustomer;
}
```

Atribut yang digunakan sebagai identitas utama seperti `idCustomer` dan `kodeBooking` tidak diberikan setter agar tidak dapat diubah secara sembarangan.


## Penerapan Elemen Wajib UTS PBO

### 1. Inheritance

Inheritance diterapkan pada class `Customer` sebagai superclass dengan dua subclass, yaitu `Member` dan `NonMember`.

```text
Customer (Superclass)
|__ Member (Subclass)
|__ NonMember (Subclass)
```

Class `Customer` menyimpan atribut umum seperti ID Customer, nama, dan nomor HP. Class `Member` memiliki atribut tambahan berupa `diskon`, sedangkan `NonMember` memiliki atribut tambahan berupa `biayaTambahan`.

Contoh:

```java
public class Member extends Customer
```

```java
public class NonMember extends Customer
```

Dengan inheritance, atribut dan method umum dari `Customer` dapat digunakan kembali oleh kedua subclass tersebut.


### 2. Polymorphism

Polymorphism diterapkan menggunakan **method overriding** pada method `hitungDiskon()`.

Pada class `Customer`:

```java
public double hitungDiskon() {
    return 0;
}
```

Pada class `Member`:

```java
@Override
public double hitungDiskon() {
    return diskon;
}
```

Pada class `NonMember`:

```java
@Override
public double hitungDiskon() {
    return 0;
}
```

Penerapan polymorphism terlihat ketika object disimpan atau digunakan melalui referensi bertipe `Customer`. Ketika method `hitungDiskon()` dipanggil, Java akan menjalankan method sesuai dengan object sebenarnya, misalnya `Member` atau `NonMember`.

Contoh pada proses perhitungan harga:

```java
Customer customer = cariCustomer(booking.getIdCustomer());

total = total - (total * customer.hitungDiskon());
```


### 3. Condition (If-Else)

Condition digunakan untuk melakukan pengecekan kondisi dan menentukan proses yang harus dijalankan berdasarkan input atau keadaan data.

Salah satu penerapannya terdapat pada proses penambahan customer:

```java
if (jenis == 1) {
    customer = new Member(idCustomer, nama, nomorHp, diskon);

} else if (jenis == 2) {
    customer = new NonMember(idCustomer, nama, nomorHp, biayaTambahan);

} else {
    System.out.println("Jenis customer tidak valid!");
    return;
}
```

Condition juga digunakan dalam proses validasi booking, misalnya untuk memastikan customer dan lapangan tersedia serta input yang diberikan valid.

Contoh:

```java
if (cariCustomer(booking.getIdCustomer()) == null) {
    return false;
}

if (cariLapangan(booking.getNomorLapangan()) == null) {
    return false;
}

if (booking.getDurasiJam() <= 0) {
    return false;
}
```

Dengan condition tersebut, program dapat mencegah data yang tidak valid masuk ke dalam sistem.


### 4. Looping

Looping digunakan agar suatu proses dapat dijalankan secara berulang.

Pada menu utama, program menggunakan perulangan `while`:

```java
while (pilihan != 8) {
    // menampilkan dan menjalankan menu
}
```

Perulangan tersebut membuat menu terus ditampilkan hingga pengguna memilih pilihan `8` untuk keluar.

Program juga menggunakan perulangan `for-each` untuk membaca data yang tersimpan di dalam `ArrayList`.

Contoh untuk menampilkan customer:

```java
for (Customer customer : controller.getListCustomer()) {
    System.out.println(
        "ID: " + customer.getIdCustomer()
        + " | Nama: " + customer.getNamaCustomer()
        + " | No HP: " + customer.getNoHp()
    );
}
```

Perulangan `for-each` juga digunakan untuk mencari Customer, Lapangan, dan Booking serta untuk menampilkan daftar data yang tersedia.


### Penerapan MVC

Pada program ini juga diterapkan pola **MVC (Model-View-Controller)** untuk memisahkan bagian data, tampilan, dan proses program. tujuan saya memakai ini untuk memudahkan proses developing program.

Struktur program:

```text
Source Packages
|
|__ mycompany.sistembookinglapanganbadmintondua
|   |__ SistemBookingLapanganBadmintonDua
|
|__ controller
|   |__ BookingController
|
|__ view
|   |__ BookingView
|
|__ model
    |__ Customer
    |__ Member
    |__ NonMember
    |__ Lapangan
    |__ Booking
```

Penjelasan:

- **Model:** Menyimpan struktur data dan class/object yang digunakan dalam program, seperti `Customer`, `Member`, `NonMember`, `Lapangan`, dan `Booking`.
- **View:** Menampilkan menu, menerima input dari pengguna, serta menampilkan hasil proses program.
- **Controller:** Mengelola data, proses CRUD, validasi, pencarian data, serta perhitungan total harga booking.
- **Main:** Membuat object Controller dan View, kemudian menjalankan menu utama program.

Dengan pembagian tersebut, struktur program menjadi lebih terorganisir karena bagian data, tampilan, dan logika proses dipisahkan ke dalam package yang berbeda.
