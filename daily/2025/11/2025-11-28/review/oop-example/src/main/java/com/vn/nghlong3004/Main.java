package com.vn.nghlong3004;

import com.vn.nghlong3004.inhertance.MomoWallet;

/**
 * Project: oop-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class Main {
  
  public static void main(String[] args){
    var momoWallet = new MomoWallet(200);
    momoWallet.pay(50);
  }
}
