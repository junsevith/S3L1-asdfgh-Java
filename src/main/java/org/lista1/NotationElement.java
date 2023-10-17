package org.lista1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

public class NotationElement {
   /**
    * Specifies type of notation element: number or operator.
    */
   public enum Type {
      /**
       * Mathematical operator such as + ("ADD") or / ("DIVIDE").
       */
      OPERATOR, NUMBER
   }

   /**
    * Map with currently implemented operators.
    */
   private static final Map<String, BiFunction<Double, Double, Double>> OPERATOR_MAP = new ConcurrentHashMap<>();

   static {
      OPERATOR_MAP.put("ADD", Double::sum);
      OPERATOR_MAP.put("SUBTRACT", (x, y) -> y - x);
      OPERATOR_MAP.put("MULTIPLY", (x, y) -> y * x);
      OPERATOR_MAP.put("DIVIDE", (x, y) -> y / x);
   }

   /**
    * Type of this object (operator, number).
    */
   private final Type type;

   /**
    * Operator type of this object.
    */
   private final String operator;

   /**
    * Number value of this object.
    */
   private final  Double value;

   /**
    * Creates operator type notation element.
    *
    * @param operator operator name
    */
   public NotationElement(final String operator) {
      this.operator = operator;
      this.value = null;
      type = Type.OPERATOR;
   }

   /**
    * Creates number type notation element.
    *
    * @param number number
    */
   public NotationElement(final Number number) {
      this.operator = null;
      value = number.doubleValue();
      type = Type.NUMBER;
   }

   /**
    * Executes operation written inside current element.
    *
    * @param x first parameter of operation
    * @param y second parameter of operation
    * @return calculated value of operation
    */
   public NotationElement operate(final NotationElement x, final NotationElement y) {
      return new NotationElement(OPERATOR_MAP.get(operator).apply(x.getValue(), y.getValue()));

   }

   /**
    * Checks the type of notation element.
    *
    * @return true if element is a number
    */
   public boolean isNumber() {
      return type == Type.NUMBER;
   }

   /**
    * Gets value of number in notation element.
    *
    * @return number value of element
    */
   public Double getValue() {
      return value;
   }

   /*
   Creates a string with value of element
    */
   @Override
   public String toString() {
      String retval;
      switch (type) {
         case NUMBER -> {
            retval = value.toString();
         }
         case OPERATOR -> {
            retval = operator;
         }
         default -> {
            retval = null;
         }
      }
      return retval;
   }
}
