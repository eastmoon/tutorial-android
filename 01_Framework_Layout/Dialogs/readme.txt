◎ Dialogs

● Dialog 建構過程
1. Instantiate an AlertDialog.Builder with its constructor
以AlertDialog.Builder建構對話框元件。

{
	AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
}


2. Chain together various setter methods to set the dialog characteristics
以Builder的行為來設定對話框元件。

{
	builder.setMessage(R.string.dialog_message)
		.setTitle(R.string.dialog_title);
}

3. Get the AlertDialog from create()
以Buildert產生並顯示，對話框元件。

{
	AlertDialog dialog = builder.create();
	dialog.show();
}

○ Dialog主要的三部分

1. 標題
Builder.setTitle

2. 內容

內容可為一段訊息、清單、自訂配置版面(layout resource)

- 訊息 
{
	Builder.setMessage("Message Content");
}

- 清單
└ 單一列表
{
	Builder.setItems([String Array], new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int which) {
		// The 'which' argument contains the index position of the selected item
		});
	}
}
└ 多重選擇
{
	Builder.setMultiChoiceItems([String Array], [Default Selected], new DialogInterface.OnMultiChoiceClickListener() {
		public void onClick(DialogInterface dialog, int which, boolean isChecked) {
		// The 'which' argument contains the index position of the click item
		// The 'isChecked' argument contains the index position is selected or not.
		})
		.[動作按鈕];
	}
}
└ 單一選項
{
	Builder.setSingleChoiceItems([String Array], [Default Selected], new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int which) {
		// The 'which' argument contains the index position of the selected item
		})
		.[動作按鈕];
	}
}

- 自訂配置版面
{
	Builder.setView(getLayoutInflater().inflate([Layout Resource Id], null))
		.[動作按鈕];
	}
}
※ 定義View後的動作按鈕內，需以外部物件保存當前啟動的View，以便正確取得數據資料



3. 動作按鈕
單一對話框至多只能包含三種動作按鈕，每一種只能增加一個。

- 正面 ( Builder.setPositiveButton )
這種按鈕的用途是接受及繼續進行特定動作 (「確定」按鈕)。
- 負面 ( Builder.setNegativeButton )
這種按鈕的用途是取消動作。
- 中立 ( Builder.setNeutralButton )
如果使用者不想繼續進行特定動作，但並非要取消動作，請使用這種按鈕。 這種按鈕會顯示在正面和負面按鈕之間。 範例：[稍後提醒我] 按鈕。

