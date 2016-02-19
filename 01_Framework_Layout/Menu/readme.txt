◎ Menu
http://developer.android.com/intl/zh-tw/guide/topics/ui/menus.html

Android選單機制共有三種類型：
1. 選項選單(Option Menu)與動作列(Action Bar)
	- 主要設置於Activity內的選單集合，針對不同應用程式應修改其選單結構，提供適切的操作介面。
2. 內容選單(Context Menu)
	- 內容選單是會在使用者長按某元素時顯示的浮動選單，它提供的動作會影響所選取內容或內容畫面。
3. 彈出選單(Popup Menu)
	- 彈出式選單顯示的項目清單會以垂直清單的方式，錨定在呼叫該選單的檢視。 

● 選項選單

選項選單是動作列中主要調整與控制的項目，然詳細的動作列設定不再此討論，可參考下列相關文章。
選項選單的建立共有三個步驟：

1. 建立選單Layout於res/menu內

此部分依據設計情況需求，可以Layout或Coding完成。

2. 宣告與建立選單
{
	public boolean onCreateOptionsMenu (Menu menu) {
		// Create menu with layout file or method.
		return true;
	}
}

3. 接收事件
{
	public boolean onOptionsItemSelected(MenuItem item) {
		// selected processing
		swtich(item.getItemId()) {...}
	}
}

選項選單的主流程與設定已建置於Activity內，因此僅需覆寫對應的事件行為。
然而，動作列的其他細部操作則需直接調用動作列物件，甚至需改寫Activity layout，對此詳細設定參閱參考文獻。

※ 相關文章參考：
---------------------------
Using the Android Toolbar (ActionBar) - Tutorial
http://www.vogella.com/tutorials/AndroidActionBar/article.html

Android Working with Action Bar
http://www.androidhive.info/2013/11/android-working-with-action-bar/

Android SDK: Implement an Options Menu
http://code.tutsplus.com/tutorials/android-sdk-implement-an-options-menu--mobile-9453

Navigation Drawer
http://blog.tonycube.com/2014/02/android-navigation-drawer-1.html

ActionBar version change
http://blog.tonycube.com/2015/06/android-navigation-drawer-toolbar.html

Android Navigation Drawer Example Step by Step
https://www.codeofaninja.com/2014/02/android-navigation-drawer-example.html

Navigation with Back and Up
http://developer.android.com/intl/zh-tw/design/patterns/navigation.html
---------------------------

○ 內容選單

內容選單，是當使用者長按某元素觸發的選單項目，可用於對內容的說明、操作，如複製、貼上等行為。

1. 建立選單Layout於res/menu內

此部分依據設計情況需求，可以Layout或Coding完成。

2. 宣告選單
{
	TextView tv = (TextView) findViewById([Resource ID]);
        registerForContextMenu(tv);
}

取得需要觸發內容的元件，並將其登記。

3. 建立選單
{
	public void onCreateContextMenu (Menu menu) {
		// Create menu with layout file or method.
	}
}

建立事件，若無元件登記，將不會觸發與建立。

4. 接收事件
{
	public boolean onContextItemSelected(MenuItem item) {
		// selected processing
		swtich(item.getItemId()) {...}
	}
}

內容選單的建立是在長按登記的元件後才觸發主流程，若對不同的元件要產出不同選單，應在Create內檢查後處理。
但在事件處理則無法區分，僅能依據觸發事件編號處理對應運作。

※ 相關文章參考：
---------------------------
Context menu in Android with example
http://www.compiletimeerror.com/2013/09/context-menu-in-android-with-example.html#.VsWXlfl95D8
---------------------------

● 彈出選單 

1. 建立選單Layout於res/menu內

此部分依據設計情況需求，可以Layout或Coding完成。

2. 宣告選單
{
	TextView tv = (TextView) findViewById([Resource ID]);
	tv.setOnClickListener(...)
}

取得需要觸發內容的元件，並將其登記。

3. 建立選單與設定事件處理
{
	public void showPopupMenu(View v) {
		// Create menu.
		PopupMenu popup = new PopupMenu(this, v);
		// Setting click event.
		popup.setOnMenuItemClickListener(...);
		// Declare layout
		popup.getMenuInflater().inflate([Layout ID], popup.getMenu());
		// Show menu
		popup.show();
	}
}

彈出選單的操作與建立過程與對話框相同，但不同在於先是位置為點擊元件旁側，這樣能提供使用者明確的內容關聯。
但彈出選單若流於內容說明補充等操作，亦可能造成程式過度繁瑣、設計累贅。
且顯示於元件旁側，則適合於內容補充，非選項操控。
對此設計應多加考量使用者經驗與介面設計。