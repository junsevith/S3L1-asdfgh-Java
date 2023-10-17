package org.lista1;

import org.junit.*;

public class AsdfghTest {
   @Test
   public void testowanie(){
      NotacjaPolska notacjaPolska = new NotacjaPolska();
      notacjaPolska.write(5);
      notacjaPolska.write(10);
      notacjaPolska.write("DIVIDE");
      System.out.println(notacjaPolska.calculate());
   }

   @Test
   public void testowanie2(){
      NotacjaPolska notacjaPolska = NotacjaParser.parse("12 2 3 4 × 10 5 / + × +");
      System.out.println(notacjaPolska.calculate());

   }

}
