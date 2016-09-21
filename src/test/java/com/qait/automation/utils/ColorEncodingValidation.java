/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.automation.utils;

/**
 *
 * @author QAI
 */
public class ColorEncodingValidation {
    
    public String encode(String rgba) {
  String[] numbers = rgba.replace("rgba(", "").replace(")", "").split(",");
  int r = Integer.parseInt(numbers[0].trim());
  int g = Integer.parseInt(numbers[1].trim());
  int b = Integer.parseInt(numbers[2].trim());
  String hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
  return hex;
 }
    
}
