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

◎ Animation

場景切換動畫依據前述法則，共有兩種物件：
A. Intent & Activity.startActivity
B. View & Activity.setContentView

Android動畫運作有兩種方式：
a. Animation & Animator Class
使用物件操作定義動畫方式、事件。

b. Animation Resource XML file
將動畫運作定義於XML檔內，此方式無法於檔案內設定對應事件。

合併上述兩種規範，共有以下組合方式處理動畫原則
    A    B
a  No   Yes
b  Yes  Yes

- A-a
Intent & Activity.startActivity 切景，並使用Animation & Animator Class進行動畫運作處理。
目前查無運作方式。

- A-b
Intent & Activity.startActivity 切景，並使用Animation Resource XML file進行動畫運作處理。
{ 
	startActivity( Intent ) / finish();
	overridePendingTransition([Target-in animation resource], [Source-out animation resource]);
}

overridePendingTransition 是指定對應進出場景Activity物件的動畫，但句型並無法設置動畫事件，亦即此方式無法知道Activity動畫完結與否。

- B-a
View & Activity.setContentView 切景，並使用Animation & Animator Class進行動畫運作處理。
{
        ObjectAnimator anim = ObjectAnimator.ofFloat([Target View], [Property type], [Start value], [End value]);
        anim.setDuration([Millisecond]);
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) { ... }
        });
	anim.start()
}

Animator 物件可指定其需依設定之時間變動指定物件屬性的數值；可對物件設定對應的事件以處理後續或連續的運作。
Animator 物件上層具有集合物件，可將多個Animator集合同步處理。

※ 動畫事件宣告物件
》 AnimatorListenerAdapter 
宣告單一事件函數並掛載入Animator內。
》 Animation.AnimationListener
宣告所有動畫事件函數並掛載入Animator內。

- B-b
View & Activity.setContentView 切景，並使用Animation Resource XML file進行動畫運作處理。
{
        Animation anim = AnimationUtils.loadAnimation([Application Context], [Animation resource]);
	anim.setAnimationListener(new Animation.AnimationListener() {...});
        [Target View].startAnimation(anim);
}

載入已定義好的動畫資源檔案，並直接交付物件執行；此可對物件設定對應的事件以處理後續或連續的運作。
※ 動畫事件宣告物件僅可使用AnimationListener物件。

※ 相關文章參考：
---------------------------
Animation Resources
http://developer.android.com/intl/zh-tw/guide/topics/resources/animation-resource.html

View Animation
http://developer.android.com/intl/zh-tw/guide/topics/graphics/view-animation.html

Property Animation	
http://developer.android.com/intl/zh-tw/guide/topics/graphics/prop-animation.html

Activity.overridePendingTransition
http://developer.android.com/intl/zh-tw/reference/android/app/Activity.html#overridePendingTransition(int, int)

Android Activity切换动画overridePendingTransition
http://blog.csdn.net/bufanni12/article/details/26453725

Custom Animation while switching Activity, using overridePendingTransition()
http://android-er.blogspot.tw/2013/04/custom-animation-while-switching.html

Android animation while switching activities
http://www.mysamplecode.com/2013/02/android-animation-switching-activity.html

Can I change the Android startActivity() transition animation?
http://stackoverflow.com/questions/3515264/can-i-change-the-android-startactivity-transition-animation

is it possible to do transition animations when changing views in the same activity?
http://stackoverflow.com/questions/4446105/is-it-possible-to-do-transition-animations-when-changing-views-in-the-same-activ

Animation Resources and AnimationListener
http://www.javacodegeeks.com/2013/06/animation-resources-and-animationlistener.html
---------------------------

◎ Transition

※ 相關文章參考：
---------------------------
Defining Custom Animations
http://developer.android.com/intl/zh-tw/training/material/animations.html

Animating Views Using Scenes and Transitions
http://developer.android.com/intl/zh-tw/training/transitions/index.html
---------------------------

---------------------

Reference page :
Android grow LinearLayout using animation
http://stackoverflow.com/questions/18582310/android-grow-linearlayout-using-animation

Circular Reveal Animation
https://guides.codepath.com/android/Circular-Reveal-Animation

Java Code Examples for android.view.animation.LayoutAnimationController
http://www.programcreek.com/java-api-examples/index.php?api=android.view.animation.LayoutAnimationController
