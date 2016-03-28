◎ Application
http://developer.android.com/intl/zh-tw/reference/android/app/Application.html

Base class for those who need to maintain global application state.

Application類別是用於規劃應用程式啟動時的全域狀態，包括與系統相關如啟動、記憶體減少、作業系統事件等；亦可用來管理屬於應用程式的共用變數。

1. 宣告類別 

class DemoApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
	}
}

覆蓋onCreate來處理應用程式啟動時的設定事件。

2. 指定類別

AndroidManifest.xml 
<application android:name=".DemoApplication">
        <activity android:name=".MainActivity" ></activity>
        <activity android:name=".SubActivity" ></activity>
</application>

設定Application對應的類別，亦可使單一應用專案可基於不同需要設計多個應用程式來規劃啟動流程。

---------------------

Reference page :

Android學習_建立程式內(application)的全域變數(Global Variable)
http://wangshifuola.blogspot.tw/2011/12/androidapplicationglobal-variable.html
