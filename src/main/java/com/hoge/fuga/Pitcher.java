package com.hoge.fuga;

import java.util.Random;

// 投手クラス - Playerを継承
public class Pitcher extends Player {
    private double outRate;  // アウト率
    
    public Pitcher(String name, double outRate) {
        super(name, "投手");
        this.outRate = outRate;
    }
    
    public double getOutRate() {
        return outRate;
    }
    
    @Override
    public void displayInfo() {
        System.out.println(name + " (" + position + ") - アウト率: " + String.format("%.3f", outRate));
    }
    
    // 投手としてのプレイ - 投球が主体
    @Override
    public PlayResult play() {
        System.out.println(name + "が投球を行います。");
        Random random = new Random();
        
        // アウト率に基づく結果判定
        if (random.nextDouble() < outRate) {
            return PlayResult.OUT;
        } else {
            return PlayResult.NO_OUT;
        }
    }
}