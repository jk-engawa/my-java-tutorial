package com.math.prime;

import java.util.Scanner;

/**
 * ユーザ入力を受け取り、PrimeNumber と PrimePrinter をメソッド
 * チェーンでつなげて結果を表示するサンプルアプリ。
 */
public class MainApp {
    public static void main(String[] args) {
        System.out.println("整数を入力してください（0 で終了）:");

        try (Scanner scanner = new Scanner(System.in)) {
            // プリンタは接頭辞を設定した上で生成
            PrimePrinter printer = new PrimePrinter()
                                       .withPrefix("> ");

            int input;
            while ((input = scanner.nextInt()) != 0) {
                // ファクトリ→計算→出力をチェーン
                PrimeNumber.of(input)
                           .printWith(printer);
            }
        }

        System.out.println("終了します。");
    }
}
