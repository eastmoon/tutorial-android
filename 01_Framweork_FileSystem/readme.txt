◎ File system
http://developer.android.com/intl/zh-tw/training/basics/data-storage/index.html

1. 共享檔案 ( SharedPreferences )
共享檔案是以XML檔案儲存於應用程式檔案夾下的檔案類型，其儲存是以Mapping形式完成。
使用者是以KEY(關鍵字)為主，對存於檔案內的全域變數(String, Int)存取內容。
但論讀取動作，其概念與Resource.values相似，但共享是讀取皆可，Resource.values僅提供讀取。

雖然共享檔案可分為私有、公開兩種：
私有，亦即只有應用程式本身可存取。
公開，亦即只要知道變數名稱的應用程式皆可存取，這運作具有風險，但用於多應用程式間溝通是有其必要性。

生命週期，共享檔案自存在後直到應用程式刪除、更新才會被移除。
由於對應檔案存在於應用程式檔案夾內，若應用程式因為刪除、更新而導致整個檔案夾內容移除，將直接移除對應用的檔案。

2. 儲存檔案
以Java.io為API的標準檔案操作。
檔案操作分為內部、外部儲存空間，其差異如下：

內部儲存空間，用於存取應用程式內的檔案，預設操作是以此為主，若系統移除應用程式，其內存的檔案亦刪除。
外部儲存空間，用於存取系統儲存空間，使用此方式需申請權限，且需注意檔案受IO存取占用資源等作業系統規範。
        - 若使用者解除應用程式，只有將檔案儲存在 getExternalFilesDir() 的目錄中時，系統才會從外部儲存空間移除應用程式的檔案。
        - 對無須存取限制、與其他應用程式共享檔案、允許使用者經電腦存取內容，應使用此方式儲存。

● 外部存取空間權限

<manifest ...>
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    ...
</manifest>

READ_EXTERNAL_STORAGE，若應用程式需要讀取外部儲存空間，但不寫入該空間。
WRITE_EXTERNAL_STORAGE，宣告應用程式需寫入外部儲存空間，此宣告亦隱含具備外部儲存空間讀取權限。

3. SQLite
以SQLite存取本地資料庫。
如同在裝置的內部儲存空間儲存檔案一樣，Android 會將資料庫儲存在與應用程式關聯的私用磁碟空間內；依預設，其他應用程式無法存取此區域。

文件提醒，由於資料庫操作的時間可能很長，因此請確保您在背景執行緒 (例如 AsyncTask 或 IntentService) 中呼叫 getWritableDatabase() 或 getReadableDatabase()。

※ 相關文章參考：
---------------------------
Best practices for SharedPreferences
http://blog.yakivmospan.com/best-practices-for-sharedpreferences/


---------------------------

---------------------------------

Reference :