package com.math.prime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 与えられた整数を保持し、素数判定および約数収集を行う。
 * メソッドチェーンで計算→出力も可能。
 */
public class PrimeNumber {
    private int number;
    private boolean prime;
    private final List<Integer> divisors;

    // インスタンス初期化ブロックでリストを初期化
    {
        divisors = new ArrayList<>();
    }

    // コンストラクタはプライベート化し、ファクトリメソッド経由で生成
    private PrimeNumber(int number) {
        this.number = number;
    }

    /** ファクトリメソッド。生成と同時に計算も実行される。 */
    public static PrimeNumber of(int number) {
        return new PrimeNumber(number).calculate();
    }

    /** 素数判定と約数収集を行い、自インスタンスを返す。 */
    public PrimeNumber calculate() {
        divisors.clear();
        if (number <= 1) {
            prime = false;
        } else if (number == 2) {
            prime = true;
        } else {
            int limit = (int) Math.sqrt(number);
            for (int d = 2; d <= limit; d++) {
                if (number % d == 0) {
                    divisors.add(d);
                    int other = number / d;
                    if (other != d && other != number) {
                        divisors.add(other);
                    }
                }
            }
            Collections.sort(divisors);
            prime = divisors.isEmpty();
        }
        return this;
    }

    /** Printerと連携して自分自身を出力できる。 */
    public PrimeNumber printWith(PrimePrinter printer) {
        printer.print(this);
        return this;
    }

    @Override
    public String toString() {
        if (prime) {
            return number + " は素数です。";
        } else if (number <= 1) {
            return number + " は素数ではありません。";
        } else {
            return String.format("%d は素数ではありません。（約数: %s）",
                                 number, divisors);
        }
    }
}
