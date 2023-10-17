package org.lista1;

import java.util.LinkedList;
import java.util.Stack;

public class NotacjaPolska {
   private final LinkedList<ElementNotacji> napis = new LinkedList<>();

   public void write(Number number) {
      napis.offer(new ElementNotacji(number));
   }

   public void write(String operation) {
      napis.offer(new ElementNotacji(operation));
   }

   public Double calculate() {
      Stack<ElementNotacji> stack = new Stack<>();
      napis.forEach((elementNotacji)->{
         System.out.println(elementNotacji.toString());
         if (elementNotacji.isNumber()){
            stack.push(elementNotacji);
         } else {
            stack.push(elementNotacji.operate(stack.pop(),stack.pop()));
         }
      });
      if (stack.size() > 1){
         throw new ArithmeticException("Niepoprawna ilość operatorów");
      }
      return stack.pop().getValue();
   }
}
