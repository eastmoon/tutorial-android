◎ Android

Andorid wiki
https://zh.wikipedia.org/wiki/Android

◎ Integrated Development Environment, IDE 

Android Studio
http://developer.android.com/intl/zh-tw/sdk/index.html

---------------------------
How to install Android Studio ?
http://www.flag.com.tw/android/AndroidStudio/index.html
---------------------------
How to startup ADV with Intel CPU ?
https://software.intel.com/en-us/android/articles/speeding-up-the-android-emulator-on-intel-architecture

※Check the box and click the ‘Install packages…’ button, once you have installed the package, the status will appear as ‘Installed’, which is misleading as this is not the case. The SDK only copies the Intel HAXM executable on your machine, and it is up to you to install the executable.

※Start ADV in Android studio
Tools -> Android -> AVD Manager -> Choose one drive and launch.
---------------------------

◎ 概觀

※ 相關文章參考：
---------------------------
Android - Hello World Example
http://www.tutorialspoint.com/android/android_hello_world_example.htm

Creating an Example Android App in Android Studio
http://www.techotopia.com/index.php/Creating_an_Example_Android_App_in_Android_Studio

Android 6 Tutorial 第一堂（1）西遊記裡的那隻潑猴
http://www.codedata.com.tw/mobile/android-6-tutorial-1-1/
---------------------------

◎ 應用程式架構

Android應用程式架構是一套以『Activity』元件構築的Java應用程式。
當應用程式啟動，便執行設定的起始Activity元件，而使用者的操作亦重於往返各Activity元件之間。

設計上，Activity最小單元應以表單形式考量，而非最小單一元件 ( 例如按鈕 )；若要考量單一元件，則以Fragment來設計。
其次，因Activity的設計考量，可於開發前期以Layout方式呈現各Activity的關係，並以此來完成程式的測試程式與討論文件。

※ 相關文章參考：
---------------------------
Android 6 Tutorial 第一堂（3）開始設計Android應用程式
http://www.codedata.com.tw/mobile/android-6-tutorial-1-3/

應用程式基礎知識
http://developer.android.com/intl/zh-tw/guide/components/fundamentals.html

Manifest.ermission reference
http://developer.android.com/intl/zh-tw/reference/android/Manifest.permission.html
---------------------------

◎ 主程式架構

透過Android Studio建立的應用程式專案，其專案內容與程式碼皆放置於『app』內的『src/main』下，其目錄內容說明如下：
※ 依據不同版本與時期的文獻來看，檔案架構會略有出入，但主要文檔並沒改變。

● AndroidManifest.xml：

應用程式的主要設定檔。

○ java：

應用程式的模組目錄，其內可看到一個基本套件，這是在建立專案時決定的主要套件名稱。

● res：

應用程式的資源目錄，例如圖形（png）與音效（mp3）檔案，還有各種XML格式的資源檔案都放在這個目錄。
此外在『res/layout』目錄下，則放置對應於『java』內Activity模組的預設畫面配置XML檔案。

另外，位於『app』內，其目錄內容說明如下：

● build.gradle：

Gradle是Android Studio採用的全新應用程式建置系統。
在Android Studio開發Android應用程式，一個應用程式可以有多個模組；例如一個音樂播放應用程式，可以包含行動電話、平板電腦、穿戴式三個模組，每一個模組都可以被建置成一個獨立的App。
此檔案即是撰寫該專案的建置設定內容。

○ build：

建置內容放置目錄。


※ 相關文章參考：
---------------------------
Android 6 Tutorial 第一堂（4）開發Android應用程式的準備工作
http://www.codedata.com.tw/mobile/android-6-tutorial-1-4/

應用程式宣示說明
http://developer.android.com/intl/zh-tw/guide/topics/manifest/manifest-intro.html

Android Studio系列教程四--Gradle基础
http://stormzhang.com/devtools/2014/12/18/android-studio-tutorial4/

Groovy Tutorial（1）認識 Groovy 的第一課
http://www.codedata.com.tw/java/groovy-tutorial-1-understanding-groovy/
---------------------------

◎ 應用程式類型

※ 此為粗略分類，依實作細節將有不同變化。

● 標準應用程式

應用程式主用於顯示內容、提供介面供使用者操作並據此回饋、互動，此即為標準應用程式。
此類應用程式，其每個畫面都是一個繼承自『android.app.Activity』類別的Activity元件，若介面操作複雜，則會包含數個Activity元件。

○ 背景服務應用程式

應用程式啟動後，無須呈現任何畫面，並存在於行動裝置的背景程序中持續的運作，此即為背景服務應用程式。
例如Android作業系統內建一個檢查應用程式是否需要更新的程式，如果發現需要更新應用程式，它就會通知使用者更新應用程式的訊息。

◎ Android IDE Problem 

---------------------------
Android studio 1.4 import .jar file
http://www.hyjiacan.com/android-studio-import-jar/
http://stackoverflow.com/questions/33380785/how-to-import-library-android-studio-1-4

---------------------------
Error Issus : No cached version of [Remote Library] available for offline mode
http://stackoverflow.com/questions/22607661/no-cached-version-of-com-android-tools-buildgradle0-9-1-available-for-offline

1. Uncheck "Offline work" in File > Settings > Build, Execution, Deployment > Build Tools > Gradle > Global Gradle Settings
2. Resync the project, for example by restarting the Android Studio
3. Once synced, you can check the option again to work offline.

※ Work in Android Studio 1.4

---------------------------

◎ Android Manifest Setting

---------------------------
設定固定畫面不翻轉
http://ocean2002n.pixnet.net/blog/post/89552289

android:screenOrientation
http://developer.android.com/intl/zh-tw/guide/topics/manifest/activity-element.html#screen

---------------------------

---------------------

Reference page :

i18n.HOMEPAGE
https://www.genymotion.com/#!/
	
Code Tutorials
http://code.tutsplus.com/?p=22764

Android Tutorial for Beginners: Part 1
http://www.raywenderlich.com/78574/android-tutorial-for-beginners-part-1

[閒聊] 那些我從 android app 學到的事情
https://www.ptt.cc/bbs/AndroidDev/M.1370641609.A.1BF.html

Component issue :

EditText:修改虛擬鍵盤的Enter鍵
http://androidbounce.blogspot.tw/2012/09/edittextenter.html

Library import :

using facebook sdk in android studio
http://stackoverflow.com/questions/19961828/using-facebook-sdk-in-android-studio

Android Studio 0.8.1 - how to use Facebook SDK?
http://stackoverflow.com/questions/24466921/android-studio-0-8-1-how-to-use-facebook-sdk

Android Studio - Quick Start to Brightcove Player SDK for Android
http://docs.brightcove.com/en/perform/mobile-sdks/brightcove-player-sdk-for-android/guides/studio-android-sdk-quick-start.html