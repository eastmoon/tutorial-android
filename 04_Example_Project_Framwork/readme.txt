◎ Project Fromework

專案基底架構：

1. Framework class defined
	A. Basics Activity ( code : BasicsActivity )
	主要功能：
		‧控制行動列
		‧禁用或管理 
			- Back navigation event
		‧啟動載入程序
			- Progress implement
	B. Model Singleton-Facede Controller 
	主要功能：
		‧管理Data Model
			- Register、Remove、Retrieve、Has
2. Pattern class defined
	A. Invoke Observer
	主要功能：
		‧Trigger，自目標物件以名稱字串來執行函數。
		‧Subject，管理多量Trigger建立、刪除，當發送事件後統一執行各Trigger對應的函數。
	B. Proxy Model  
	主要功能：
		‧後端溝通
			- 使用Plug-in library，調用WebAPI取回資料後並解譯。
		‧JSON Parser event
	C. Progress Pipes and Filters  
	主要功能：
		‧管理演算操作
			- Pipes，管理佇列
			- Filters，演算物件
