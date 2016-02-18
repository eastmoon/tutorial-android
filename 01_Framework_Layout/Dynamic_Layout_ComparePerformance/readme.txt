◎ Compare performance
Demo : Dynamic_Layout_ComparePerformance

Dynamic Layout使用XML layout resource與Compound view component，在同樣生成數量下所需之時間差比較。

1. Dynamice by layout resource

- Reterive resource id by string
Resources res = this.getResources();
int id = res.getIdentifier([ID Name], [ID Group], [Context].getPackageName());

上為動態取得被定義好的ID編號，使用已知的字串；利用此方式可以建立單一元件的系列按鈕，並已迴圈取回。

2. Dynamice by compound view component

- Compound view AttributeSet and initial param
Constuctor(context, self-param = null)
Constuctor(context, attribute-set, self-param = null)
Constuctor(context, attribute-set, default-style, self-param = null)

表準的建構元定義上，需使用attribute-set來建立需求屬性，但已知過程卻必須以取得Attribute Resource XML檔案。
對此，改善新的建構元，上為以合併原有系統方式建構，self-param可為物件，也可為矩陣，端看設計需求改變。

● 緣由

UX軟體設計時，依據主導對象、需求的不同會有不同的適當設計方式。
1. 平面設計主導
設計特點：講求可視化、畫面動態性固定、程式設計為輔助。

2. 功能設計主導
設計特點：單一群組內的元件數量無法估計、畫面動態不固定、元件位置可依相對數據運算、平面設計以最小單元為主。

上述兩種狀況，在人力配置、工作程序並不相同，對此程式設計的過程與配合亦不同。
然而，在這兩者結構上仍可能最後走向無法估計數量、參數化的動態設計。
但兩種方式卻存在者不同產出效能的問題，預期上使用資源檔案，其編譯過程即可能最初事先完成編碼的效能設計。

考慮至此，設計本範例用以評估效能差異。

○ 結論

比較同樣數量的按鈕與對等事件產出後，兩者時間差異極小，但並無何者絕對快於一方的狀況。
差異來源可推估為產出瞬間的設備效能問題，另外相關問題來自產出時設備對Android支援度。
※ 本次測試，在不同設備上onEnterAnimationComplete的觸動狀況不同，而亦即無法正取得轉場並顯示完畢後的時間點。

因此效能問題可歸類為設備本身的問題，而非軟體設計方式導致的缺陷。

※ 相關文章參考：
---------------------------
Java Performance Testing [duplicate]
http://stackoverflow.com/questions/447739/java-performance-testing

How to find View from string instead of R.id
http://stackoverflow.com/questions/8438943/how-to-find-view-from-string-instead-of-r-id

Resource.getIdentifier
http://developer.android.com/intl/zh-tw/reference/android/content/res/Resources.html#getIdentifier(java.lang.String, java.lang.String, java.lang.String)
---------------------------
