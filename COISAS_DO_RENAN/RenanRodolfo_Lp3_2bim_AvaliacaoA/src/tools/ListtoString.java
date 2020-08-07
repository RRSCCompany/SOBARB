/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.List;
import java.util.stream.Collectors;
import static jdk.nashorn.internal.objects.NativeRegExp.test;

/**
 *
 * @author Renan
 */
public class ListtoString {
    
    public void ListtoString(List<String> x) {
        
    String joined2 = String.join(",", x );
        
  
    System.out.println(joined2);
}
    
}
