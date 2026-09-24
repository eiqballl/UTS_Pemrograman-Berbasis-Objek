/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mycompany.utspemrogramanberbasisobjek;
import controller.BookingController;
import view.BookingView;
/**
 *
 * @author Acer
 */
public class UTSPemrogramanBerbasisObjek {

    public static void main(String[] args) {
        BookingController controller = new BookingController();
        BookingView view = new BookingView(controller);

        view.menu();
    }
}
