package com.shinkansen;

import java.util.*;


//====== 悪い実装（LSP違反の例：のぞみが停まる駅を通過してしまう） ======
class BadHikari implements ShinkansenService {
 // ひかりのはずが、新大阪を「気まぐれ通過」にしてしまった例（契約違反）
 private static final Set<Station> STOPS = new LinkedHashSet<>(Arrays.asList(
     Station.TOKYO, Station.SHINAGAWA, Station.SHIN_YOKOHAMA,
     Station.SHIN_FUJI, Station.SHIZUOKA, Station.HAMAMATSU, Station.TOYOHASHI,
     Station.NAGOYA, Station.GIFU_HASHIMA, Station.MAIBARA, Station.KYOTO
     // 本来は SHIN_OSAKA も停まるべきだが、わざと外している
 ));
 @Override public String name() { return "悪いひかり"; }
 @Override public boolean stopsAt(Station s) { return STOPS.contains(s); }
}