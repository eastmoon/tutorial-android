◎ WebAPI Library OkHttp
Demo : Send_HTTP_Request

HTTP需求傳送擁有諸多的函數庫可應用，在此選擇OkHttp library為主要工具。

1. 下載OkHttp JAR file

2. 將JAR檔加入IDE
※ 注意，不同版本IDE加入方式有所不同，加入後應確認物件是否可以宣告並建立。

3. 宣告使用網路於AndroidManifest.xml
<uses-permission android:name="android.permission.INTERNET" />

4. 依據OkHttp程序撰寫發送函數。
http://square.github.io/okhttp/

5. android.os.NetworkOnMainThreadException

Andorid為了避免設計者因設計失當或系統錯誤導致連線逾時而讓系統崩潰或進入無窮等待，所有網路連線運作皆不可撰寫於主執行緒。

呼叫單次執行續命令運作
{
	new Thread(new Runnable() {...}).start();
}

6. POST & GET

使用此函數，POST與GET最大差異在於呼叫時夾帶的參數用何種形式傳遞。
- GET：參數為於網址之後，例如：http://xxx.xxx.xxx/xxx?[Variable]=[Value]&[Variable]=[Value]&...
	└ GET傳送參數有最大字串限度長度，若需傳送大量資料，此方式並不適合。
- POST：參數存於需求內容，Request request = new Request.Builder().url("http://xxx.xxx").post(body);

7. HTTP Header

部分網站需傳送系統資訊，此資訊應夾帶於Request Header內。
equest request = new Request.Builder()
                .url("http://xxx.xxx")
                .header("User-Agent", "OkHttp Headers.java")
                .header("Cookie", "PHPSESSID=123456789");

以上方式傳送至URL的HTTP Request會夾帶User-Agent與Cookie參數於Header內。

---------------------

Reference page :

Android SDK: Making Remote API Calls
http://code.tutsplus.com/tutorials/android-sdk-making-remote-api-calls--mobile-17568

How to use a web API from your Android app
http://www.androidauthority.com/use-remote-web-api-within-android-app-617869/

How to call ASP.Net Web API from Android Studio?
http://instinctcoder.com/how-to-call-asp-net-web-api-from-android-studio/

What is the most efficient way on Android to call HTTP Web API calls that return a JSON response?
http://stackoverflow.com/questions/19050294/

INTEGRATE A REST API INTO ANDROID APPLICATION IN LESS THAN 15 MINUTES
http://blog.strikeiron.com/bid/73189/

Calling RESTful services from your Android app
http://www.techrepublic.com/blog/software-engineer/calling-restful-services-from-your-android-app/

Call a REST Web Service
https://developer.xamarin.com/recipes/android/web_services/consuming_services/call_a_rest_web_service/

Checking for all possible internet providers, ConnectionDetector.java
https://gist.github.com/tony1223/5732145

Detect 3G or Wifi Network restoration
http://stackoverflow.com/questions/4503561/

Building Android Applications that Use Web API, Google ppt
https://docs.google.com/presentation/d/1ac39UGuRGHNmuEwhC3VNVFQo3LAjrcqcJ_-A0ZIp9Ao/preview?slide=id.p18


Spec :
HttpURLConnection
http://developer.android.com/intl/zh-tw/reference/java/net/HttpURLConnection.html

URL
http://developer.android.com/intl/zh-tw/reference/java/net/URL.html


Library :
OkHttp
http://square.github.io/okhttp/

Recipes
https://github.com/square/okhttp/wiki/Recipes
