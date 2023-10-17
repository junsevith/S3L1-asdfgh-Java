package org.lista1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class PolishNotation {
   /**
    * Linked list that stores the notation.
    */
   private final Deque<NotationElement> napis = new LinkedList<>();


   /**
    * Adds an element (number) to notation.
    *
    * @param number Element to be added
    */
   public void write(final Number number) {
      napis.offer(new NotationElement(number));
   }

   /**
    * Adds an element (operator) to notation.
    *
    * @param operation Element to be added
    */
   public void write(final String operation) {
      napis.offer(new NotationElement(operation));
   }

   /**
    * Calculates value of the current notation.
    *
    * @return Calculated value
    */
   public Double calculate() {
      final Stack<NotationElement> stack = new Stack<>();
      napis.forEach((notationElement) -> {
         if (notationElement.isNumber()) {
            stack.push(notationElement);
         } else {
            stack.push(notationElement.operate(stack.pop(), stack.pop()));
         }
      });
      if (stack.size() > 1) {
         throw new ArithmeticException("Niepoprawna ilość operatorów");
      }
      return stack.pop().getValue();
   }
}
