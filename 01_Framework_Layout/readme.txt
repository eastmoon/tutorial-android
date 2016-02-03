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
Demo : Dynamic_Layout

1. Create Layout view
- LinearLaoyout
{
	LinearLayout layout = new LinearLayout();
	layout.setOrientation(LinearLayout.VERTICAL);
}

建立LinearLayout後，需直接指定其排列方向為(VERTICAL / HORIZONTAL)。

- RelativeLayout
{
	RelativeLayoutlayout = new RelativeLayout();
}

RelativeLayout的設定主要在於其長度、寬度對應於螢幕的比例，但預設值已足夠，除有詳細設計的必要。

2. Create Component View
- Create and Set View
{
	View v = new View(this);
	v.[set method](...);
	v.[set event listener](...);
	v.setId([Identity number]);
	layout.addView(v);
}

View元件，除系統提供的控制項類別外，亦可自訂設計。
其設置步驟分別為建立、設定屬性、設定偵聽事件、加入layout。
此外，部分View擁有addView行為，如ScrollView；此結構表示該元件主要用於操控擁有的內容(Layout、View)為主，結構如：Main-Layout -> Node-View -> Content-Layout -> Left-View。

View.setId為指定一個數字或資源編號給此元件，在RelativeLayout需使用此來讓元件為參照並設定相對位置，而如LinearLayout對內部元件已具有對應排列時，並不需要設定。

- Setting view layout
{
	RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams([width], [height]);
	lp.addRule([Rule Enum]);
	lp.addRule([Rule Enum], [Target ID]);
	lp.setMargins([left], [top], [right], [bottom]);
	layout.addView(v, lp);
}

View元件設定配置，建立時設定View的長寬比例；對應自身內容(WRAP_CONTENT)或對應上層(MATCH_PARENT)。
LayoutParams.addRule，設定元件配置的對應方式，如對應上層的垂直中心等；若對應某元件的右側，則須在第二參數設定對應元件的ID(v.getId)。
LayoutParams.setMargins，設定間距，對應好目標後，設置與該目標的相對距離。
加入LayoutParams，透過Layout.addView第二參數設置或View.setLayoutParams直接指定。

※ 相關文章參考：
---------------------------
Android, Part III: Dynamic Layouts
http://www.dreamincode.net/forums/topic/130521-android-part-iii-dynamic-layouts/

Dynamic vs XML layout in Android?
http://stackoverflow.com/questions/11960501/dynamic-vs-xml-layout-in-android

How to set RelativeLayout layout params in code not in xml
http://stackoverflow.com/questions/5191099/how-to-set-relativelayout-layout-params-in-code-not-in-xml

Android dynamic RelativeLayout
http://stackoverflow.com/questions/10110953/android-dynamic-relativelayout

RelativeLayout.LayoutParams
http://developer.android.com/intl/zh-tw/reference/android/widget/RelativeLayout.LayoutParams.html

<RelativeLayout> 會把此佈局內的元件利用各元件的id來做相對位置的佈局
http://style77125tech.pixnet.net/blog/post/11600599-%5Bandroid%5D-relativelayout

Android 元件佈局(二) RelativeLayout
http://corn0521.blogspot.tw/2011/04/android-relativelayout.html
---------------------------

◎ Compound View

※ 相關文章參考：
---------------------------
Creating Compound Views on Android
http://code.tutsplus.com/tutorials/creating-compound-views-on-android--cms-22889

Creating custom and compound Views in Android - Tutorial
http://www.vogella.com/tutorials/AndroidCustomViews/article.html

Creating Custom Views in Android Tutorial
http://javatechig.com/android/creating-custom-views-in-android-tutorial
---------------------------

◎ Custom Views

自訂元件是繼承View後修改其內容與對應之屬性。
而View是Android UI Conpoment的最小單元，其顯示是以繪圖為主。
因此，當物件建立後，除設定主要的外部屬性(res/value/attrs_[Custom View Name])、內部屬性、配置檔案(res/layout/[Custom Layout File])、類別檔案與顯示內容。

設計上，Custom View並不用於應用程式設計，而是開發特殊繪顯元件，例如：遊戲引擎、編解碼器、實境等，顯示時需以繪顯為操作方式的元件設計。
主要會是針對移動裝置內的感測儀器，其所提供的資訊將其顯示與演算整合並輸出至繪顯畫面。
※ 因需針對繪圖物件進行研究，此部分不再此探討。

※ 相關文章參考：
---------------------------
Creating Custom Views
http://developer.android.com/intl/zh-tw/training/custom-views/index.html

Android SDK: Creating Custom Views
http://code.tutsplus.com/tutorials/android-sdk-creating-custom-views--mobile-14548

在Layout檔案中使用自訂的View
http://shung007.blogspot.tw/2010/11/android-tips-layoutview.html
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

LayoutInflater作用及使用
http://www.imyukin.com/?p=226

