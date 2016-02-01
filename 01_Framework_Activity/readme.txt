◎ Activity

Android應用程式架構是一套以『Activity』元件構築的Java應用程式。
當應用程式啟動，便執行設定的起始Activity元件，而使用者的操作亦重於往返各Activity元件之間。
在一般的情況下，應用程式的一個畫面，通常是由一個Activity類別和一個畫面配置Layout檔組合而成的。
	- Activity類別是一個繼承自「android.app.Acitivty」的子類別，這個類別負責執行讀取資料、提供互動功能這類工作。
	- Layout畫面配置檔是一個XML格式的文件，負責提供Activity元件使用的畫面。

這種把程式和畫面設計分開來的作法，雖然好像比較麻煩一些，不過可以提供應用程式更大的靈活性，並依據設計必要，Activity可以選擇使用不同的Layout檔為其畫面結構。

Android應用程式還有一個很重要的設計方式，就是把應用程式使用的資源獨立出來，畫面配置檔就是最明顯的應用。
應用程式通常會使用一些需要的資源，例如在畫面上顯示的文字與圖示，還有播放的音效或影片，都會依照應用程式的需求一起放在專案的資源目錄。

設計上，Activity最小單元應以表單形式考量，而非最小單一元件 ( 例如按鈕 )；Fragment則依表單操作區塊來設計。
其次，因Activity的設計考量，可於開發前期以Layout方式呈現各Activity的關係，並以此來完成程式的測試程式與討論文件。

※ 相關文章參考：
---------------------------
Activity
http://developer.android.com/intl/zh-tw/guide/components/activities.html
---------------------------

◎ 生命週期
Demo : Activity_LifeCycle

● onCreate
	├ onRestart
	├ onStart
	│	├ onResume
	│	├ << Activity running >>
	│	└ onPause
	└ onStop
○ onDestroy

Activity的整個生命週期是介於onCreate和onDestroy之間，在onCreate中設定「全域」狀態 (例如定義版面配置)，並且在onDestroy中釋放所有剩餘的資源。 
例如，如果您的Activity有一個執行緒在背景執行，並從網路下載資料，那麼最好可以在onCreate中建立該執行緒，然後在onDestroy中將它停止。

Activity的可見生命週期是介於onStart和onStop之間，在此期間，使用者可以在螢幕上看到該Activity，並與之互動；例如，啟動新的Activity，而當前Activity不再看得到時，會呼叫onStop。 
在這兩個方法之間，您可以維護需要讓使用者看到的資源；例如，您可以在onStart中註冊BroadcastReceiver，以監視影響到UI的變更，然後當使用者不再看到您顯示的內容時，在onStop中將它取消註冊。 
系統會在Activity的整個生命週期內，多次呼叫onStart和onStop，因為Activity對使用者而言會一直在顯示和隱藏之間切換。

Activity的前景生命週期是介於onResume呼叫和onPause呼叫之間，在此期間，Activity會在螢幕上所有其他Activity的前面，而且具有使用者輸入焦點。 
Activity可以經常在前景和背景之間轉換；例如，裝置進入睡眠或顯示對話方塊時，會呼叫onPause。 
由於此狀態可能會經常轉換，因此這兩個方法中的程式碼應十分精簡，這樣可以避免使用者在轉換時等待。

◎ 協調
Demo : Activity_Switching_LifeCycle

生命週期回呼的順序定義的很好，尤其是當兩個Activity位於相同的處理程序，而其中一個Activity A啟動另一個Activity B時所發生的操作順利如下：

1. Activity A執行onPause方法。
2. Activity B按順序執行onCreate、onStart、onResume方法；Activity B 現在擁有使用者焦點。
3. 若Activity轉場動畫執行完畢，發生如下動作：
	- 如果螢幕上由Activity B完全覆蓋，就會執行Activity B的onEnterAnimationComplete方法。
	- 如果螢幕上已經看不到Activity A，就會執行Activity A的onStop方法。
	- 依據轉場啟動命令，Activity A會執行onDestroy來避免佔用多於記憶體。

兩個Activity的轉場行為可參考『01_Framework_SwitchingActivities』內說明。
※ 需要注意重點，Activity轉場設定並啟動後，onResume方法執行時並不是轉場停止的時點，而是取得焦點的時點；例如，場景由左至右過場，onResume發生在進場動畫啟動的時點，因此若內部動畫於此執行會瞬間造成系統負擔而影響轉場動畫運作。


◎ Fragment

※ 相關文章參考：
---------------------------
Fragment
http://developer.android.com/intl/zh-tw/guide/components/fragments.html

Building a Dynamic UI with Fragments
http://developer.android.com/intl/zh-tw/training/basics/fragments/index.html
---------------------------


---------------------

Reference page :

Android Activity类中的finish()、onDestory()和System.exit(0) 三者的区别
http://blog.csdn.net/yelangjueqi/article/details/9466347

處理程序和執行緒
http://developer.android.com/intl/zh-tw/guide/components/processes-and-threads.html

[Android] 多執行緒-Handler和Thread的關係 （2）
http://j796160836.pixnet.net/blog/post/29895257