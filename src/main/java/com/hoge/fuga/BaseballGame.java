package com.hoge.fuga;

import java.util.ArrayList;
import java.util.List;

//ゲームクラス
public class BaseballGame {
 // シングルトンインスタンス
 private static BaseballGame instance;
 
 private List<GameObserver> observers;
 
 // プライベートコンストラクタ
 private BaseballGame() {
     observers = new ArrayList<>();
 }
 
 // シングルトンのインスタンス取得メソッド
 public static BaseballGame getInstance() {
     if (instance == null) {
         instance = new BaseballGame();
     }
     return instance;
 }
 
 // オブザーバーの追加
 public void addObserver(GameObserver observer) {
     observers.add(observer);
 }
 
 // イベント通知
 private void notifyObservers(String event) {
     for (GameObserver observer : observers) {
         observer.update(event);
     }
 }
 
 // ポリモーフィズムのデモンストレーション
 public void demonstratePolymorphism(Team team1, Team team2) {
     System.out.println("\n===== ポリモーフィズムのデモンストレーション =====");
     System.out.println("投手と打者が「同じplay()メソッド」を持ちながら、全く異なる振る舞いをする例");
     
     // 両チームからプレイヤーを取得
     List<Player> allPlayers = new ArrayList<>();
     allPlayers.addAll(team1.getPlayers());
     allPlayers.addAll(team2.getPlayers());
     
     // 各プレイヤーに対して同じメソッド呼び出し
     for (Player player : allPlayers) {
         System.out.println("\n" + player.getName() + " (" + player.getPosition() + ") のプレイ:");
         PlayResult result = player.play(); // ポリモーフィズム！同じメソッド呼び出しで異なる振る舞い
         System.out.println("→ 結果: " + result);
     }
 }
 
 // 試合実行
 public void playGame(Team homeTeam, Team awayTeam) {
     int homeScore = 0;
     int awayScore = 0;
     
     notifyObservers("試合開始！ " + awayTeam.getName() + " vs " + homeTeam.getName());
     
     // 3イニングをプレイ
     for (int inning = 1; inning <= 3; inning++) {
         // 表の攻撃
         notifyObservers(inning + "回表、" + awayTeam.getName() + "の攻撃");
         int runsTop = playHalfInning(awayTeam, homeTeam);
         awayScore += runsTop;
         notifyObservers(inning + "回表終了、" + runsTop + "点追加。現在 " + 
                       awayTeam.getName() + " " + awayScore + " - " + 
                       homeScore + " " + homeTeam.getName());
         
         // 裏の攻撃
         notifyObservers(inning + "回裏、" + homeTeam.getName() + "の攻撃");
         int runsBottom = playHalfInning(homeTeam, awayTeam);
         homeScore += runsBottom;
         notifyObservers(inning + "回裏終了、" + runsBottom + "点追加。現在 " + 
                       awayTeam.getName() + " " + awayScore + " - " + 
                       homeScore + " " + homeTeam.getName());
     }
     
     // 試合結果の表示
     notifyObservers("試合終了！ 最終スコア: " + 
                    awayTeam.getName() + " " + awayScore + " - " + 
                    homeScore + " " + homeTeam.getName());
     
     if (homeScore > awayScore) {
         notifyObservers(homeTeam.getName() + "の勝利！");
     } else if (awayScore > homeScore) {
         notifyObservers(awayTeam.getName() + "の勝利！");
     } else {
         notifyObservers("引き分け！");
     }
 }
 
 // 半イニングをプレイ
 private int playHalfInning(Team battingTeam, Team fieldingTeam) {
     int outs = 0;
     int runs = 0;
     int batterIndex = 0;
     
     Pitcher pitcher = fieldingTeam.getPitcher();
     List<Batter> batters = battingTeam.getBatters();
     
     // 3アウトになるまで攻撃を続ける
     while (outs < 3) {
         Batter currentBatter = batters.get(batterIndex % batters.size());
         batterIndex++;
         
         notifyObservers(currentBatter.getName() + "の打席");
         
         // 投手のプレイ - ポリモーフィズムの活用
         PlayResult pitcherResult = pitcher.play();
         
         // 打者のプレイ - ポリモーフィズムの活用
         PlayResult batterResult = currentBatter.play();
         
         // 投手と打者の結果を表示
         notifyObservers(pitcher.getName() + "の投球結果: " + pitcherResult);
         notifyObservers(currentBatter.getName() + "の打撃結果: " + batterResult);
         
         // 両者の結果から最終結果を判定
         if (pitcherResult == PlayResult.OUT) {
             outs++;
             notifyObservers(currentBatter.getName() + "、アウト！ " + outs + "アウト");
         } else if (batterResult == PlayResult.SCORE) {
             runs++;
             notifyObservers(currentBatter.getName() + "、ホームラン！ 1点追加！");
         } else {
             // 投手がアウトを取れず、打者も得点できなかった場合
             outs++;
             notifyObservers(currentBatter.getName() + "、凡退！ " + outs + "アウト");
         }
     }
     
     return runs;
 }
}