◎ Activity.startActivity & Intents

Demo : Intents_and_SetContentView

Intent是用於向另一個應用程式元件要求動作的傳訊物件，指定對象可為明確(Explicit)與隱含(Implicit)兩種，若存在指向對象，則將畫面切置該應用程式的動作物件。
對應目標可為相同應用程式、明確的外部應用程式、明確功能不明確的應用程式。

1. New Intent object

Intent intent = new Intent();
intent.setClass( [source class], [target class] );

or

Intent intent = new Intent( [source class], [target class] );

2. Start action

startActivity(intent);

※ 相關文章參考：
---------------------------
意圖和意圖篩選器
https://developer.android.com/intl/zh-tw/guide/components/intents-filters.html

Common Intents
https://developer.android.com/intl/zh-tw/guide/components/intents-common.html

[Android] 切換畫面 - 基礎篇
http://aiur3908.blogspot.tw/2015/02/android.html
---------------------------

◎ Activity.setContentView

Demo : Intents_and_SetContentView


※ 相關文章參考：
---------------------------
Android程式設計-畫面的切換(1)
http://fgchen.blogspot.tw/2012/11/android-1.html
---------------------------

◎ Difference

※ 相關文章參考：
---------------------------
Difference between and intent and and setcontentview
http://stackoverflow.com/questions/13898355/difference-between-and-intent-and-and-setcontentview
---------------------------

---------------------

Reference page :
