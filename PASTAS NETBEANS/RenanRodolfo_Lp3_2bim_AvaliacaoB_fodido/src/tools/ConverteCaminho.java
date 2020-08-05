/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import static jdk.nashorn.internal.objects.NativeRegExp.test;

/**
 *
 * @author Renan
 */
public class ConverteCaminho {
    
private String bgcerto;
private String t;

public String Converte(String caminho){
    for (int e = 0; e < 1; e++) {
      for (int i = 0; i < caminho.length(); i++) {
           if (caminho.contains("\\")) {
           bgcerto = caminho.replace("\\", "/");
      }
          bgcerto += caminho.substring(i);
        
        }
        }
   return bgcerto;
  }
}
//    t = caminho.substring(0, caminho.lastIndexOf("a"));
//    String t = caminho.substring(caminho.lastIndexOf("a")+1);
//    for (int e = 0; e < 1; e++) {
//        for (int i = 0; i < t.length(); i++) {
//            if (t.contains("\\")) {
//            bgcerto = t.replace("\\", "/");
//        }
//            bgcerto += t.substring(i);


