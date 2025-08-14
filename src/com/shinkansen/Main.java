package com.shinkansen;

//====== デモ ======
public class Main {
 private static void printStops(ShinkansenService s) {
     System.out.println("[" + s.name() + "] 停車駅: " + s.allStops());
 }

 public static void main(String[] args) {
     // 良い実装
     ShinkansenService nozomi = new Nozomi();
     ShinkansenService hikari = new Hikari();
     ShinkansenService kodama = new Kodama();

     System.out.println("=== LSP遵守の例 ===");
     printStops(nozomi);
     printStops(hikari);
     printStops(kodama);

     // 「のぞみ ⊆ ひかり ⊆ こだま」を検証
     Lsp.assertSubstitutable("のぞみ", nozomi, "ひかり", hikari);
     Lsp.assertSubstitutable("ひかり", hikari, "こだま", kodama);
     Lsp.assertSubstitutable("のぞみ", nozomi, "こだま", kodama);
     System.out.println("OK: のぞみ→ひかり→こだま の包含関係が成り立ち、置換可能です。\n");

     // 悪い実装（契約違反を発生させる）
     System.out.println("=== LSP違反の例（例外を投げます） ===");
     ShinkansenService badHikari = new BadHikari();
     printStops(badHikari);
     try {
         Lsp.assertSubstitutable("のぞみ", nozomi, "悪いひかり", badHikari);
         System.out.println("（本来ここには来ないはず）");
     } catch (IllegalStateException ex) {
         System.out.println("検出: " + ex.getMessage());
     }
 }
}