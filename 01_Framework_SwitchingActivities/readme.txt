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

Intent做為切換Activity是基於其轉換功能的用途在於指定應用程式內當前主運作的模組切換，當這運作完成，不再運作的Activity會依據其生命週期觸發對應的系統事件。

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

Activity.setContentView，依據傳入的明確顯示(Explicit view)元件或草稿資源(Layout resource)更換當前Activity的顯示內容。
若傳入為明確顯示元件，則定義顯示的草稿參數(Layout parameters)將會被忽略，若要輸入自訂的顯示參數則需額外帶入(LayoutParams)物件。

※ 實務上，若對於Activity第一次指定為明確顯示元件，其後若更換也需使用相同方式，反之若使用草稿資源亦同。
---------------
setContentView(int layoutResID);
setContentView(View view);
在Activity內使用僅可選一方式，混用則可能導致運作失當；由於Activity執行建立函數時必須設定一次setContentView，因此該時後所指定的方式會決定後續動作。
---------------

● 使用View

1. Take back view

View v = getLayoutInflater().inflate(R.layout.xxx, null);

2. Setting view

setContentView(v);

第一階段使用函數getLayoutInflater().inflate()取回草稿資源對應的顯示元件；第二階段將儲存起來的View指定給Activity。

○ 使用LayoutResID

1. Setting view

setContentView(R.layout.xxx);

對當前的Activity指定對應的草稿資源。

※ 相關文章參考：
---------------------------
Android程式設計-畫面的切換(1)
http://fgchen.blogspot.tw/2012/11/android-1.html

LayoutInflater
http://developer.android.com/intl/zh-tw/reference/android/view/LayoutInflater.html
---------------------------

◎ Difference

上述兩種切換畫面的方式，其最大差別在於是否更換Activity物件，前者是以替換Activity，後者則是替換Activity對應的Content，這樣的差別會有以下差異：

1. 切換速度

前者因為以替換Activity，這部分牽扯諸多系統事件，致使切換過程有延遲存在；而後者無此負擔，使得切換速度提升。

2. 程式碼閱讀與撰寫技巧

前者一個Activity對應一個Layout，使得Layout的元件操作可以單純化；後者是將多個Layout轉為View，並將其儲存於Activity內，因此各View的操作事件亦須定義於此處，這容易使得程式碼冗長，但主要操控皆可儲存於Activity內並共用。

3. 系統事件

如前述，前者替換Activity會觸發系統事件，亦即這過程是受到系統控管，而諸如系統按鍵的Back操作則會實際運作；後者則因為並無觸發，並不受Back操作影響。

※ 相關文章參考：
---------------------------
Difference between and intent and and setcontentview
http://stackoverflow.com/questions/13898355/difference-between-and-intent-and-and-setcontentview
---------------------------

---------------------

Reference page :
