◎ Barcode

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

---------------------

Reference page :

Android 如何快速掃描條碼以及產生QR Code？
https://magiclen.org/android-barcode/

Android SDK: Create a Barcode Reader
http://code.tutsplus.com/tutorials/android-sdk-create-a-barcode-reader--mobile-17162

Android Barcode and Qr Scanner Example
http://examples.javacodegeeks.com/android/android-barcode-and-qr-scanner-example/

ZXing ("zebra crossing") is an open-source, multi-format 1D/2D barcode image processing library implemented in Java, with ports to other languages.
https://github.com/zxing/zxing

ISBN Search
http://www.isbnsearch.org/isbn/