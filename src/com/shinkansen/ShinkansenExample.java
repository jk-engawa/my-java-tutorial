package com.shinkansen;

import java.util.Arrays;
import java.util.List;

public class ShinkansenExample {
    public static void main(String[] args) {
        // ① リスコフの置換原則 + 動的結合
        List<Train> trains = Arrays.asList(
            new Hayabusa(s -> true, 5),
            new Yamabiko(s -> true, 5),
            new Nasuno(s -> true, 5)
        );

        // 関数型インタフェース＋ラムダ：PremiumService のみ抽出
        TrainFilter premiumOnly = t -> t instanceof PremiumService;
        System.out.println("▼ プレミアムサービス列車のみ出発");
        trains.stream()
              .filter(premiumOnly::filter)
              .forEach(Train::depart);

        // 駅リストフィルタの例：上野を飛ばす
        StationFilter skipUeno = name -> !name.equals("Ueno");
        System.out.println("\n▼ はやぶさ（上野をスキップ）");
        Hayabusa special = new Hayabusa(skipUeno, 5);
        special.depart();
    }
}

