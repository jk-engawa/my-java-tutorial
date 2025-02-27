package com.hoge.fuga;

import java.util.ArrayList;
import java.util.List;

//チームクラス - 複数のプレイヤーを持つ
public class Team {
 private String name;
 private List<Player> players;
 
 public Team(String name) {
     this.name = name;
     this.players = new ArrayList<>();
 }
 
 public void addPlayer(Player player) {
     players.add(player);
 }
 
 public String getName() {
     return name;
 }
 
 public List<Player> getPlayers() {
     return players;
 }
 
 // 特定の型のプレイヤーを取得するジェネリックメソッド
 public <T extends Player> List<T> getPlayersByType(Class<T> type) {
     List<T> result = new ArrayList<>();
     for (Player player : players) {
         if (type.isInstance(player)) {
             result.add(type.cast(player));
         }
     }
     return result;
 }
 
 // 投手を取得
 public Pitcher getPitcher() {
     List<Pitcher> pitchers = getPlayersByType(Pitcher.class);
     return pitchers.isEmpty() ? null : pitchers.get(0);
 }
 
 // 打者を取得
 public List<Batter> getBatters() {
     return getPlayersByType(Batter.class);
 }
 
 // チーム情報を表示
 public void displayTeamInfo() {
     System.out.println("\n===== チーム: " + name + " =====");
     for (Player player : players) {
         player.displayInfo();
     }
 }
}
