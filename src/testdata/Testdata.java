/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdata;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.RoundingMode;

public class Testdata
{
  public static void main (String[] args)
  {
    Scanner sc = new Scanner(System.in);
    String[] lines = new String[5];
    
    for (int i = 0; i < 5; i++) lines[i] = sc.nextLine();
    
    for (String line : lines)
    {
      String[] elements = line.split(", ");
      String f = elements[0];
      int entireLength = Integer.parseInt(elements[1]);
      int decimalLength = Integer.parseInt(elements[2]);
      String formatted = STR(f,entireLength,decimalLength);
      System.out.println(formatted);
    }
  }
  
  private static String STR(String f, int entireLength, int decimalLength)
  {
    int intLength = entireLength - decimalLength - 1;
    boolean hasPlus = (f.charAt(0) == '+');
 
    String pattern = "";
    for (int i = 0; i < intLength; i++) pattern += "#";
    pattern += ".";
    for (int i = 0; i < decimalLength; i++) pattern += "#";
    if (hasPlus) pattern = pattern.replaceFirst("#","+");
        
    if (intLength < f.indexOf(".")) return pattern;
    
    DecimalFormat formatter = new DecimalFormat(pattern);
    formatter.setRoundingMode(RoundingMode.HALF_UP);
    String formatted = formatter.format(Float.parseFloat(f));
    
     while (formatted.length() != entireLength) 
       formatted = "#" + formatted;
    
    return formatted;
  }
}