◎ Activity

Android應用程式架構是一套以『Activity』元件構築的Java應用程式。
當應用程式啟動，便執行設定的起始Activity元件，而使用者的操作亦重於往返各Activity元件之間。

設計上，Activity最小單元應以表單形式考量，而非最小單一元件 ( 例如按鈕 )；若要考量單一元件，則以Fragment來設計。
其次，因Activity的設計考量，可於開發前期以Layout方式呈現各Activity的關係，並以此來完成程式的測試程式與討論文件。


Android應用程式的設計架構，在畫面和資源的部份，有一種比較特別的設計方式。在一般的情況下，應用程式的一個畫面，通常是由一個Activity類別和一個畫面配置檔組合而成的。Activity類別是一個繼承自「android.app.Acitivty」的子類別，這個類別負責執行讀取資料、提供互動功能這類工作。搭配使用的畫面配置檔是一個XML格式的文件，負責提供Activity元件使用的畫面。這種把程式和畫面設計分開來的作法，雖然好像比較麻煩一些，不過可以提供應用程式更大的靈活性。

Android應用程式還有一個很重要的設計方式，就是	把應用程式使用的資源獨立出來，畫面配置檔就是最明顯的應用。應用程式通常會使用一些需要的資源，例如在畫面上顯示的文字與圖示，還有播放的音效或影片，都會依照應用程式的需求一起放在專案的資源目錄。

※ 相關文章參考：
---------------------------
Activity
http://developer.android.com/intl/zh-tw/guide/components/activities.html

Fragment
http://developer.android.com/intl/zh-tw/guide/components/fragments.html
---------------------------

◎ 生命週期
Demo : Activity_LifeCycle

Activity 的整個生命週期是介於 onCreate() 呼叫和 onDestroy() 呼叫之間。您的 Activity 應在 onCreate() 中設定「全域」狀態 (例如定義版面配置)，並且在 onDestroy() 中釋放所有剩餘的資源。 例如，如果您的 Activity 有一個執行緒在背景執行，並從網路下載資料，那麼最好可以在 onCreate() 中建立該執行緒，然後在 onDestroy() 中將它停止。

Activity 的可見生命週期是介於 onStart() 呼叫和 onStop() 呼叫之間。在此期間，使用者可以在螢幕上看到該 Activity，並與之互動。 例如，啟動新的 Activity，而這個 Activity 不再看得到時，會呼叫 onStop()。 在這兩個方法之間，您可以維護需要讓使用者看到的資源。 例如，您可以在onStart() 中註冊 BroadcastReceiver，以監視影響到 UI 的變更，然後當使用者不再看到您顯示的內容時，在 onStop() 中將它取消註冊。 系統可以在 Activity 的整個生命週期時，多次呼叫 onStart() 和 onStop()，因為 Activity 對使用者而言會一直在顯示和隱藏之間切換。

Activity 的前景生命週期是介於 onResume() 呼叫和 onPause() 呼叫之間。在此期間，Activity 會在螢幕上所有其他 Activity 的前面，而且具有使用者輸入焦點。 Activity 可以經常在前景和背景之間轉換 — 例如，裝置進入睡眠或顯示對話方塊時，會呼叫 onPause()。 由於此狀態可能會經常轉換，因此這兩個方法中的程式碼應十分精簡，這樣可以避免使用者在轉換時等待。

◎ 協調

生命週期回呼的順序定義的很好，尤其是當兩個 Activity 位於相同的處理程序，而其中一個 Activity 啟動另一個 Activity 時。 Activity A 啟動 Activity B 時所發生的操作順利如下：

Activity A 的 onPause() 方法會執行。
Activity B 按順序執行 onCreate()、onStart() 以及 onResume() 方法。 (Activity B 現在擁有使用者焦點)。
然後，如果螢幕上已經看不到 Activity A，就會執行 Activity A 的 onStop() 方法。



