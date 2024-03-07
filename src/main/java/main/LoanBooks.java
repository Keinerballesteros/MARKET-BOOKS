
package main;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import 
import java.awt.print.Book;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class LoanBooks {
    String title;
        String author;
        String gener;
        String datePub;
        boolean available;
        int quantity;
        int loadTime;
        String user;
        String loanDate;
        String returnDate;

    public LoanBooks(String title, String author, String gener, String datePub, boolean available, int quantity, int loadTime, String user, String loanDate, String returnDate) {
        this.title = title;
        this.author = author;
        this.gener = gener;
        this.datePub = datePub;
        this.available = available;
        this.quantity = quantity;
        this.loadTime = loadTime;
        this.user = user;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }
       
    public void lendBooks(){
        Scanner read = new Scanner(System.in);
        System.out.println("Ingrese el nombre del libro");
        String name = read.nextLine();
        if (this.title.equalsIgnoreCase(name)) {
            if (this.quantity >= 1) {
                this.quantity--;
                if (this.quantity == 0) {
                    this.available = false;
                }
                System.out.println("Ingrese su nombre:");
                String user = read.nextLine();
                this.user = user;
                System.out.println("Libro prestado con éxito a " + this.user);
                System.out.println("Cantidad restante: " + this.quantity);
                SimpleDateFormat fechaf = new SimpleDateFormat("dd/mm/yyyy");
               
               Date fecha = new Date();
              Calendar c1 = Calendar.getInstance();
             
              String fecha_H = String.valueOf(c1.get(Calendar.DATE))+"/"+String.valueOf(c1.get(Calendar.MONTH)+1)+"/"+String.valueOf(c1.get(Calendar.YEAR));
            try {

                Date fechaHoy = fechaf.parse(fecha_H);
               
                long sumaFecha = fechaHoy.getTime() + (this.loadTime*24*60*60*1000); //convierto loanTime en milisegundos
                 Instant instant = Instant.ofEpochMilli(sumaFecha);
                 Date myDate = Date.from(instant);
                 this.loanDate = fecha_H;
                 this.returnDate = fechaf.format(myDate);
                 System.out.println("La fecha de entrega es: "+this.returnDate);
               
            } catch (ParseException ex) {
                Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
            }

            } else {
                System.out.println("Cantidad insuficiente");
            }
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    public void returnBooks(){
        Scanner read = new Scanner (System.in);
        System.out.println("Ingrese el nombre del libro que va a entregar");
        String name = read.nextLine();
        if(name.equalsIgnoreCase(this.title)){
            this.quantity++;
            this.available = true;
            System.out.println("Libro entregado con éxito");
            System.out.println("Cantidad actual: " + this.quantity);
        } else {
            System.out.println("Libro no encontrado");
        }
    }
    }

