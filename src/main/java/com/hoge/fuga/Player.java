package com.hoge.fuga;

public abstract class Player {
 protected String name;
 protected String position;
 
 public Player(String name, String position) {
     this.name = name;
     this.position = position;
 }
 
 public String getName() {
     return name;
 }
 
 public String getPosition() {
     return position;
 }
 
 // 選手情報の表示（各サブクラスでオーバーライド）
 public abstract void displayInfo();
 
 // 核となるプレイメソッド - ポリモーフィズムの中心
 public abstract PlayResult play();
}