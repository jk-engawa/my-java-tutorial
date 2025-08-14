package com.shinkansen;

//====== 「のぞみ ⊆ ひかり ⊆ こだま」という契約でLSPを検証 ======
final class Lsp {
 /**
  * 親の契約: parent が停車する駅は、child も必ず停車する（包含関係）
  */
 static void assertSubstitutable(String parentLabel, ShinkansenService parent,
                                 String childLabel, ShinkansenService child) {
     for (Station s : Station.values()) {
         if (parent.stopsAt(s) && !child.stopsAt(s)) {
             throw new IllegalStateException(
                 "LSP違反: 「" + parentLabel + "が停まる駅」なのに「" + childLabel + "が通過」: " + s);
         }
     }
 }
}