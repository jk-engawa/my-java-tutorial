package com.math.prime;

/**
 * 素数判定結果を整形して出力するプリンタ。
 * メソッドチェーンで接頭辞/接尾辞の設定も可能。
 */
public class PrimePrinter {
    private String prefix;
    private String suffix;

    // インスタンス初期化でデフォルトを設定
    {
        prefix = "";
        suffix = "";
    }

    /** 出力時の接頭辞を設定。 */
    public PrimePrinter withPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    /** 出力時の接尾辞を設定。 */
    public PrimePrinter withSuffix(String suffix) {
        this.suffix = suffix;
        return this;
    }

    /** PrimeNumber を受け取って出力し、自インスタンスを返す。 */
    public PrimePrinter print(PrimeNumber p) {
        System.out.println(prefix + p.toString() + suffix);
        return this;
    }
}
