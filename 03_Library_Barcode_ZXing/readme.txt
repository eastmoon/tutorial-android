◎ Barcode Library ZXing

ZXing是一套開源軟體，並提供1D/2D barcode掃描系統，在已知資料中，此為Android當前主要選擇。

◎ 基本範例 - 掃描與處理
Demo : Basic_ZXing_Operate
Demo : Scan_and_LinkToWebsite

基礎操作上，對ZXing、導覽資料等操作，以Intent為主。
藉由Intent的特性，指向登記於系統上的Intent code，呼叫起對映應用程式，並取得實際回傳內容。
在藉由回傳內容，呼叫外部軟體顯示內容，範例是顯示對映的網址。

以下為範例運作流程：

1. Click button to trigger functional.
2. Use intent object to start target application.
	- if target application not exist, run dialog and download application.
3. Receive application result and execute result.

實務上，軟體若不是載入第三方函式庫，就會以執行第三方軟體並取回結果最為主要操作過程。
但考量網路環境受限，以此方式逐步要求用戶下載並執行第三方軟體取得資料並非適當設計。

◎ Embedded in Android
Demo : Basic_ZXing_embedded

1. Uncheck "Offline work", follow [Error Issus] in [Android IDE Problem]
2. Setting build.gradle with [ZXing Android Embedded]
3. Rebuild project

設計上，嵌入ZXing第三方函式庫，其優點在於無須另外下載掃描軟體，且可自訂掃描畫面。
而操作流程與基本範例相同，但主要使用IntentIntegrator物件進行操作；讀取訊息時，則以IntentResult操作。

※需注意，網路資訊中對於不同版本的操控使用的參數會有不同，在參考前應先確認使用版本與行為是否存在於API中。

※ 相關文章參考：
---------------------------
ZXing Android Embedded
https://github.com/journeyapps/zxing-android-embedded/

Android Barcode Scanner
http://kaazing.org/blog/android-barcode-scanner/

ZXing API
http://zxing.github.io/zxing/apidocs/index.html

Java Code Examples for zxing.IntentIntegrator
http://www.javased.com/?api=com.google.zxing.integration.android.IntentIntegrator
http://www.programcreek.com/java-api-examples/index.php?api=com.google.zxing.integration.android.IntentIntegrator

---------------------------

◎ Generate QRCode
Demo : Basic_ZXing_generate

1. Embedded ZXing library
2. Create code matrix with encoder object and code format
	- Could defined image width and height
3. Copy code matrix into bitmap
4. Draw bitmap into ImageView

在API文件中，ZXing將不同的Barcode格式分成Reader和Writer，並統一繼承自ZXing核心下的主要物件。
然而掃描過程中需運用到相機等外部元件，因此採用IntentIntegrator代為操作內層，僅以取得結果並反饋。
但產生編碼部分並沒有操作物件，因此針對不同的編碼可以設計彙整型演算函數或各自獨立撰寫。

※ 相關文章參考：
---------------------------
Java Code Examples for com.google.zxing.qrcode.QRCodeWriter
http://www.programcreek.com/java-api-examples/index.php?api=com.google.zxing.qrcode.QRCodeWriter

Android Generate QR code using ZXing library
http://www.mysamplecode.com/2012/09/android-generate-qr-code-using-zxing.html

Java: Simple QR Code Generator Example
http://crunchify.com/java-simple-qr-code-generator-example/

Android ZXing Get Barcode Image
http://stackoverflow.com/questions/11697001/android-zxing-get-barcode-image

---------------------------


---------------------

Reference page :

Android 如何快速掃描條碼以及產生QR Code？
https://magiclen.org/android-barcode/

Android SDK: Create a Barcode Reader
http://code.tutsplus.com/tutorials/android-sdk-create-a-barcode-reader--mobile-17162

Android Barcode and Qr Scanner Example
http://examples.javacodegeeks.com/android/android-barcode-and-qr-scanner-example/

Java: Simple QR Code Generator Example
http://crunchify.com/java-simple-qr-code-generator-example/

ZXing ("zebra crossing") is an open-source, multi-format 1D/2D barcode image processing library implemented in Java, with ports to other languages.
https://github.com/zxing/zxing

ISBN Search
http://www.isbnsearch.org/isbn/

addExtra format list
https://github.com/zxing/zxing/blob/master/android/src/com/google/zxing/client/android/Intents.java

Zxing lib supports Barcode scanning in Android
http://stackoverflow.com/questions/21522620/zxing-lib-supports-barcode-scanning-in-android

--------------------------

Style reference page :

Change QR Scanner orientation with ZXING in Android Studio
http://stackoverflow.com/questions/34983201/change-qr-scanner-orientation-with-zxing-in-android-studio
