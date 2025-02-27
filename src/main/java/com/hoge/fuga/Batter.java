package com.hoge.fuga;

import java.util.Random;

// 打者クラス - Playerを継承
public class Batter extends Player {
    private double scoreRate;  // 得点率
    
    public Batter(String name, String position, double scoreRate) {
        super(name, position);
        this.scoreRate = scoreRate;
    }
    
    public double getScoreRate() {
        return scoreRate;
    }
    
    @Override
    public void displayInfo() {
        System.out.println(name + " (" + position + ") - 得点率: " + String.format("%.3f", scoreRate));
    }
    
    // 打者としてのプレイ - 打撃が主体
    @Override
    public PlayResult play() {
        System.out.println(name + "が打席に立ちます。");
        Random random = new Random();
        
        // 得点率に基づく結果判定
        if (random.nextDouble() < scoreRate) {
            return PlayResult.SCORE;
        } else {
            return PlayResult.NO_SCORE;
        }
    }
}