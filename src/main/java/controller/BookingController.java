/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Customer;
import model.Member;
import model.NonMember;
import model.Lapangan;
import model.Booking;

/**
 *
 * @author Acer
 */
public class BookingController {
    private ArrayList<Customer> listCustomer = new ArrayList<>();
    private ArrayList<Booking> listBooking = new ArrayList<>();
    private ArrayList<Lapangan> listLapangan = new ArrayList<>();
    
    public BookingController(){
//        Data Lapangan
        listLapangan.add(new Lapangan(1, "Vinyl", 60000));
        listLapangan.add(new Lapangan(2, "Vinyl", 60000));
        listLapangan.add(new Lapangan(3, "Wooden", 50000));
        listLapangan.add(new Lapangan(4, "Wooden", 50000));

//        Data Member
        listCustomer.add(new Member("A1","Adam","081122334455",0.10));
        listCustomer.add(new NonMember("B1","Budi","082233445566",5000));

//        Data Booking
        listBooking.add(new Booking("A101","A1",1,2,17,"24/09/2026"));
        
    }
    
//        Getter
    public ArrayList<Customer> getListCustomer(){
        return listCustomer;
    }
    public ArrayList<Booking> getListBooking(){
        return listBooking;
    }
    public ArrayList<Lapangan> getListLapangan(){
        return listLapangan;
    }
    
//    Method cari idCostomer
    public Customer cariCustomer(String idCustomer){
        for(Customer customer : listCustomer){
            if(customer.getIdCustomer().equalsIgnoreCase(idCustomer)){
                return customer;
            }
        }
        return null;
    }
    
//    Method read/cari nomorlapangan
    public Lapangan cariLapangan(int nomorLapangan){
        for(Lapangan lapangan : listLapangan){
            if(lapangan.getNomorLapangan() == nomorLapangan){
                return lapangan;
            }
        }
        return null;
    }
    
//    Method read/cari kodeBooking
    public Booking cariBooking(String kodeBooking) {
        for (Booking booking : listBooking) {
            if (booking.getKodeBooking().equalsIgnoreCase(kodeBooking)) {
                return booking;
            }
        }
        return null;
    }
    
//    Method nambah customer biar idnya ga duplikat
    public boolean tambahCustomer(Customer customer) {
        if (cariCustomer(customer.getIdCustomer()) != null) {
            return false;
        }
        listCustomer.add(customer);
        return true;
    }
    
//    Method nambah booking 
    public boolean tambahBooking(Booking booking) {

//        Cek kodeBooking
        if (cariBooking(booking.getKodeBooking()) != null) {
            return false;
        }

//        Cek Cust
        if (cariCustomer(booking.getIdCustomer()) == null) {
            return false;
        }

//        Cek lapangan
        if (cariLapangan(booking.getNomorLapangan()) == null) {
            return false;
        }

//        Cek Durasi
        if (booking.getDurasiJam() <= 0) {
            return false;
        }

//        Cek jam start main
        if (booking.getJamMulai() < 0 || booking.getJamMulai() > 21) {
            return false;
        }

//        cek tanggal
        if (booking.getTanggal() == null || booking.getTanggal().isBlank()) {
            return false;
        }
        
//         Hitung total harga booking
        double total = hitungHargaTotal(booking);
        booking.setHargaTotal(total);
        
        listBooking.add(booking);
        return true;
    }

//    Method edit Booking
    public boolean updateBooking(String kodeBooking, String idCustomer, int nomorLapangan, int durasiJam, int jamMulai, String tanggal){
        Booking booking = cariBooking(kodeBooking);

        if (booking == null) {
            return false;
        }

//        Validasi Cust
        if (cariCustomer(idCustomer) == null) {
            return false;
        }

//        Validasi lapangan
        if (cariLapangan(nomorLapangan) == null) {
            return false;
        }

//        validasi durasi
        if (durasiJam <= 0) {
            return false;
        }

//        validasi jam mulai
        if (jamMulai < 0 || jamMulai > 23) {
            return false;
        }

//        validasi tanggal
        if (tanggal == null || tanggal.isBlank()) {
            return false;
        }

        booking.setIdCustomer(idCustomer);
        booking.setNomorLapangan(nomorLapangan);
        booking.setDurasiJam(durasiJam);
        booking.setJamMulai(jamMulai);
        booking.setTanggal(tanggal);
        double total = hitungHargaTotal(booking);
        booking.setHargaTotal(total);
        return true;
    }
    
//    Method Hapus Booking
    public boolean hapusBooking(String kodeBooking){
        Booking booking = cariBooking(kodeBooking);

        if (booking == null) {
            return false;
        }
        listBooking.remove(booking);
        return true;
    }
    
//    Method hitung harga lapangan
    public double hitungHargaTotal(Booking booking) {
        Lapangan lapangan = cariLapangan(booking.getNomorLapangan());
        Customer customer = cariCustomer(booking.getIdCustomer());

        if (lapangan == null || customer == null) {
            return 0;
        }

        double total = booking.getDurasiJam() * lapangan.getHargaPerJam();

        // Diskon member
        total = total - (total * customer.hitungDiskon());

        // Biaya tambahan non member
        if (customer instanceof NonMember) {
            NonMember nonMember = (NonMember) customer;
            total += nonMember.getBiayaTambahan();
        }
        return total;
    }
    
}
