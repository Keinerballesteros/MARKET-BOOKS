

package com.mycompany.marketbooks;

import main.LoanBooks;
import java.util.Scanner;
public class MARKETBOOKS {
  public static String ENTREGA = "Entrega";
 public static String PRESTAMO = "Prestamo";
    public static void main(String[] args) {
        LoanBooks booksOne = new LoanBooks("La Divina Comedia","Dante Alighieri", "Dramático", "1314", true, 2, 7," ","6/03/2024","10/03/2024");
            LoanBooks booksTwo = new LoanBooks("Lágrimas de Angeles", "Edna Iturralde","Ficción","2021",true,2,7," ","6/03/2024","10/10/2024");
            LoanBooks booksThree =  new LoanBooks ("La Odisea", "Homero","Épica","VII",true,1,7,"","7/03/2024","17/03/2024");
            Scanner read = new Scanner (System.in);
            String action;
        do {
            System.out.println("Ingrese la acción que va a realizar: ");
            action = read.nextLine();
            if (ENTREGA.equalsIgnoreCase(action)) {
                booksOne.returnBooks();
                
            } else if (PRESTAMO.equalsIgnoreCase(action)) {
                booksOne.lendBooks();
            } else {
                System.out.println("La acción no se puede realizar");
            }
        } while (!action.equalsIgnoreCase("salir"));
    }
    }

