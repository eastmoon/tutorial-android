◎ Layout

Android的UI設計結構如下

Activity 
└ Fragment
   └ Layout
      └ View

● Activity：
主視窗元件，Android Application主要控制與操作對象。

○ Fragment：
單元區塊元件，主要用途上，Activity會基於視窗解析度動態依Fragment層級設定調整相對的操作動作；有利於RWD設計。

● Layout：
Activity與Fragment的顯示主元件；在結構上Activity與Fragment類似於Presentation view，本身將呈現何種樣式取決於其後設定的Layout元件，相對的偵聽事件亦同；此部分詳細可參考『01_Framework_SwitchingActivities』。

○ View：
基本單元，如文字框、按鈕、圖片、影片撥放等。

Android的UI設計概念繼承Java Swing概念，在結構上並沒有所謂絕對位置、尺寸，一切皆為相對位置與比例尺吋；當前Android共提供兩種配置(Layout)：

● 線性版面配置 (Linear Layout)：
這種版面配置可將其下層物件整合至單一水平或垂直列。如果視窗長度超過螢幕長度，線性版面配置就會建立捲軸方便使用者捲動畫面。

○ 相對版面配置 (Relative Layout)：
這種版面配置可讓您指定下層物件之間的相對位置 (指定下層物件 A 位於下層物件 B 的左側)，或指定下層物件與上層物件的相對位置 (指定下層物件緊貼上層物件的頂端)。

若配置僅為檢視，怎可使用下列兩種清單：

● 清單檢視 (List View)：
這種版面配置可顯示能夠捲動的單欄清單。

○ 格狀檢視 (Grid View)：
這種版面配置可顯示能夠捲動的資料欄和資料列網格。

輸入控制項：

● Button
可供使用者按下或點擊來執行某項動作的按鈕。
○ EditText
可編輯的文字欄位。
	- AutoCompleteTextView 小工具建立可提供自動完成建議的文字輸入小工具。
● CheckBox
可供使用者切換的開啟/關閉開關。
如果想為使用者提供一組互不相斥的可選取選項時，請使用核取方塊。
○ RadioGroup、RadioButton
功用與核取方塊類似，但會限制使用者只能從一組選項中選取一個選項。
● ToggleButton
附有亮光指標的開啟/關閉按鈕。
○ Spinner
可供使用者從一組選項中選取單一值的下拉式清單。
● DatePicker、TimePicker
可供使用者透過向上/向下按鈕或滑動手勢選取單一值的對話方塊。
	- DatePicker：輸入日期值 (年、月、日) 
	- TimePicker：時間值 (小時、分鐘、AM/PM) 



※ 相關文章參考：
---------------------------
Linear Layout
http://developer.android.com/intl/zh-tw/guide/topics/ui/layout/linear.html

List View
http://developer.android.com/intl/zh-tw/guide/topics/ui/layout/listview.html

Grid View
http://developer.android.com/intl/zh-tw/guide/topics/ui/layout/gridview.html

Relative Layout
http://developer.android.com/intl/zh-tw/guide/topics/ui/layout/relative.html

Input Controls
http://developer.android.com/intl/zh-tw/guide/topics/ui/controls.html

Menu
http://developer.android.com/intl/zh-tw/guide/topics/ui/menus.html
---------------------------

◎ Dynamic Layout

※ 相關文章參考：
---------------------------
Android, Part III: Dynamic Layouts
http://www.dreamincode.net/forums/topic/130521-android-part-iii-dynamic-layouts/

Dynamic vs XML layout in Android?
http://stackoverflow.com/questions/11960501/dynamic-vs-xml-layout-in-android
---------------------------


◎ Custom Views


※ 相關文章參考：
---------------------------
Creating Custom Views
http://developer.android.com/intl/zh-tw/training/custom-views/index.html
---------------------------

◎ Drag and Drop
http://developer.android.com/intl/zh-tw/guide/topics/ui/drag-drop.html

◎ Dialogs
http://developer.android.com/intl/zh-tw/guide/topics/ui/dialogs.html

◎ Menu
http://developer.android.com/intl/zh-tw/guide/topics/ui/menus.html

◎ Toast
http://developer.android.com/intl/zh-tw/guide/topics/ui/notifiers/toasts.html

---------------------

Reference page :

Android Activity类中的finish()、onDestory()和System.exit(0) 三者的区别
http://blog.csdn.net/yelangjueqi/article/details/9466347

處理程序和執行緒
http://developer.android.com/intl/zh-tw/guide/components/processes-and-threads.html

[Android] 多執行緒-Handler和Thread的關係 （2）
http://j796160836.pixnet.net/blog/post/29895257