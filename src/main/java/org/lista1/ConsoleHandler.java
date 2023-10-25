package org.lista1;

import java.util.Scanner;

public class ConsoleHandler {
   public static void main(String[] args) {
      System.out.println("Podaj działanie w notacji polskiej: eoeo");
      Scanner scanner = new Scanner(System.in);
      while (true) {
         String string = scanner.nextLine();
         System.out.println(NotationParser.parse(string).calculate());
      }
   }
}
