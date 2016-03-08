◎ Intent

An application can define the target component directly in the intent (explicit intent) or ask the Android system to evaluate registered components based on the intent data (implicit intents).

Explicit Intents
{
	Intent i = new Intent([Current context], [Target class]);
	i.putExtra([Key], [Value]);
}

Explicit intents explicitly define the component which should be called by the Android system, by using the Java class as identifier.

Explicit intents are typically used within on application as the classes in an application are controlled by the application developer.

Implicit Intents
{
	// e.g : Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
	Intent i = new Intent([Intent Action]);
	i.putExtra([Key], [Value]);
}

If an implicit intent is sent to the Android system, it searches for all components which are registered for the specific action and the fitting data type.

If only one component is found, Android starts this component directly. If several components are identified by the Android system, the user will get a selection dialog and can decide which component should be used for the intent.


Extras

onCreate(Bundle savedInstanceState)?
this.getIntent().getExtras()?

extras.getString([Key]);

startActivityResult
http://developer.android.com/intl/zh-tw/training/basics/intents/result.html
http://stackoverflow.com/questions/9268153/what-is-the-meaning-of-requestcode-in-startactivityforresult

該整數引數是識別您要求的「要求代碼」。在您接收結果 Intent 時，回呼會提供同一要求代碼，以便您的應用程式可以正確識別結果並判斷如何處理結果。

此代碼是 RESULT_OK (若操作成功) 或 RESULT_CANCELED (若因故使用者退出或操作失敗)。


Defining intent filters
If a component does not define an intent filter, it can only be called by explicit intents.
http://developer.android.com/intl/zh-tw/training/basics/intents/filters.html




內部呼叫

外部呼叫

封裝整合 ( Facade pattern )

---------------------

Reference page :

Android Intents - Tutorial
http://www.vogella.com/tutorials/AndroidIntent/article.html

Android - Intents and Filters
http://www.tutorialspoint.com/android/android_intents_filters.htm

Android: Sending & Receiving Broadcast Messages
http://mobisys.in/blog/2012/01/android-sending-receiving-broadcast-messages/

Intent用法整理
https://dotblogs.com.tw/hanry/2012/07/05/73239
http://ccckmit.wikidot.com/ga:intentexample

android intent vs observer
http://stackoverflow.com/questions/15893974/android-intent-vs-observer