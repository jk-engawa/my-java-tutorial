package com.hoge.fuga;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    	
    	// チーム作成
        Team giants = new Team("巨人");
        Team tigers = new Team("阪神");

     // 投手 - アウト率で定義
        Pitcher giantsPitcher = new Pitcher("菅野", 0.70);  // 70%の確率でアウト
        Pitcher tigersPitcher = new Pitcher("西", 0.65);    // 65%の確率でアウト
        
        // 打者 - 得点率で定義
        Batter giants1 = new Batter("坂本", "遊撃手", 0.30);  // 30%の確率で得点
        Batter giants2 = new Batter("岡本", "三塁手", 0.35);  // 35%の確率で得点
        Batter giants3 = new Batter("丸", "外野手", 0.25);    // 25%の確率で得点
        
        Batter tigers1 = new Batter("佐藤", "外野手", 0.40);  // 40%の確率で得点
        Batter tigers2 = new Batter("大山", "三塁手", 0.30);  // 30%の確率で得点
        Batter tigers3 = new Batter("近本", "外野手", 0.25);  // 25%の確率で得点
        
        // チームに選手を追加
        giants.addPlayer(giantsPitcher);
        giants.addPlayer(giants1);
        giants.addPlayer(giants2);
        giants.addPlayer(giants3);
        
        tigers.addPlayer(tigersPitcher);
        tigers.addPlayer(tigers1);
        tigers.addPlayer(tigers2);
        tigers.addPlayer(tigers3);
        
        // チーム情報の表示
        giants.displayTeamInfo();
        tigers.displayTeamInfo();
        
        // ゲームインスタンスの取得
        BaseballGame game = BaseballGame.getInstance();
        
        // ポリモーフィズムのデモンストレーション
        game.demonstratePolymorphism(giants, tigers);
        
        // 実況者の作成
        GameAnnouncer announcer = new GameAnnouncer("実況者");
        game.addObserver(announcer);
        
        // 試合の実行
        game.playGame(giants, tigers);
    }
}
