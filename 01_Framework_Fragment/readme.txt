◎ Fragment

Fragment是一種模組化的Activity物件，其據有同等於Activity的生命週期事件，但僅可隸屬於Activity下；其層級結構如下

Activity
├ View component
└ Fragment
	└ View component

由於僅能隸屬於Activity下，所以其生命週期除受操作影響導致變動外，最大生命週期受所屬的Activity影響。

◎ 靜態設置
Demo : Resource_layout_insert

在結構上，Fragment一旦宣告完成，等同於可配置的元件。
{
    <fragment
        android:name="example.fragment.BlankFragment"
	... />
}

而當Activity配置Layout時，其過程便會呼叫Fragment內的onCreateView，並取回該Fragment對應的Layout。
{
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        	// Inflate the layout for this fragment
        	return inflater.inflate([Resource layout ID], container, false);
    	}
}

最後在onActivityCreated時，將所屬的Activity完成。
{
	public void onActivityCreated (Bundle savedInstanceState) {
        	super.onActivityCreated(savedInstanceState);
		// Find target view object in activity who have fragment.
		View rv = this.getActivity().findViewById([Resource ID]);
		// Find target view object in current fragment view.
		View cv = this.getView().findViewById([Resource ID]);
    	}
}

◎ 動態變更
Demo : Dynamic_insert

動態設計是指於程式運作期間，動態指定Fragment給特定Layout中的ViewGroup元件(LinearLayout etc.)。
這樣設計下，可在Activity內新增(add)、刪除(remove)、替換(replace)指定的Fragment物件。

其過程是以Activity內的FragmentManager管理目標。

新增：
{
            getFragmentManager().beginTransaction().add([Resource ID], [Fragment Object]).commit();
}

刪除：
{
            getFragmentManager().beginTransaction().remove([Resource ID], [Fragment Object]).commit();
}

替換：
{
            getFragmentManager().beginTransaction().replace([Resource ID], [Fragment Object]).commit();
}

依文件內容所述，在commit執行前，行為並不會被執行。

---------------------

Reference page :

Fragment
http://developer.android.com/intl/zh-tw/guide/components/fragments.html

Android Fragment详解
http://blog.csdn.net/t12x3456/article/category/1649005