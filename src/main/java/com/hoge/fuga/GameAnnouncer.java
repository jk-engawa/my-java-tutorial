package com.hoge.fuga;

//実況者クラス
public class GameAnnouncer implements GameObserver {
 private String name;
 
 public GameAnnouncer(String name) {
     this.name = name;
 }
 
 @Override
 public void update(String event) {
     System.out.println("【実況】" + event);
 }
}