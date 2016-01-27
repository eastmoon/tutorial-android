◎ UI Controller

Demo : EventListener

● 標準事件偵聽

Object.setEventListener( new EventListener() { ... } );

缺點：對特定事件指向特定行為，事件不可重複使用且外部參數取得寫法會導致閱讀不易。

○ 建立事件偵聽物件

EventListener myListener = new EventListener() { ... };
Object.setEventListener(myListener);

缺點：外部參數取得寫法會導致閱讀不易。

● Activity實作事件偵聽函數

class Activity ... implements EventListener {
	@Override
	public onXXX ( View v ) { ... }

	@onCreate( ... ) {
		Object.setEventListener(this);
	}
}

缺點：單一物件內僅有單一函數可被事件調用。

○ 宣告客制事件偵聽物件

class Activity ... {
	
	public EventMethod() { ... }

	public class MyEventListener implements EventListener {
		public MyEventListener ( Activity obj ) { this.m_obj = obj }
		@Override
		public onXXX ( View v ) { this.m_obj.EventMethod(); }
	}

	@onCreate( ... ) {
		Object.setEventListener(this);
	}
}

缺點：調用後的演算過程限制於客制物件，若轉移至外則導致客制物件為冗餘設計。

● 宣告公用事件偵聽物件

	- 客制事件偵聽物件為基礎
	- 使用Reflection，調用特定物件內的指定函數
	- 目標，Activity調用事件函數無須設定實作、調用函數可動態指向、減少多餘客制事件偵聽物件、指向函數仍保有需求的傳遞參數

---------------------

Reference page :
Android 中的事件傾聽者 (EventListener)
http://ccckmit.wikidot.com/ga:eventlistener

Android onClick事件的四種實現方式.
http://rory.cba.tw/archives/163

Lesson 9. Event listeners with Button example
http://www.startofandroid.com/en/lessons/complete-list/210-lesson-9-event-listeners-with-button-example.html

How to use Reflection to call Java method at runtime
http://www.mkyong.com/java/how-to-use-reflection-to-call-java-method-at-runtime/

Creating Custom Listeners
https://guides.codepath.com/android/Creating-Custom-Listeners
