◎ org.opencv.core
Java, \sdk\java\javadoc\org\opencv\core\package-frame.html
C++, http://docs.opencv.org/2.4.12/modules/core/doc/core.html

Opencv.core為OpenCV的核心演算架構，包括資料結構(如：Point、Rect、Mat等)和相應的數學運算式。

◎ CV_TYPE
\sdk\java\javadoc\org\opencv\core\CvType.html
http://blog.csdn.net/wunghao8/article/details/39494653

在OpenCV中，所有資料型態都會標記CV_TYPE來告知其資料類型，數據結構。
※ 在C / C++ / Java中，由於資料型態的強度與類別規範不同，詳細的用途在不同語言其用處未必相同

型態格式：CV_<bit_depth>(S|U|F)C<number_of_channels>

bit_depth：可為8，16, 32；意思是深度，分别代表每個數據使用的記憶體空間大小8位元，16位元，32位元。
	- S = Signed integer，整數。
	- U =Unsigned integer，無正負號整數。
	- F =Float，浮點數。

number_of_channels：代表通道数；
	- 1代表一通道，如灰階圖。
	- 3代表三通道，如RGB圖像。
	- 4代表四通道，如RGBA，彩色含透明度圖像。

◎ 資料結構
http://docs.opencv.org/2.4.12/modules/core/doc/basic_structures.html
※ 在Java中，輸入資料皆以Double為主；其語言結構並無使用樣板型態來產出變數型別。

○ Point
二維空間中單點資訊結構 ( x, y )。

● Point3
三維空間中單點資訊結構 ( x, y, z )。

○ Size
標明影像(image)與矩形(rectangle)的尺寸 ( width, height )。

● Rect
標明二維空間中的一個矩形空間與位置 ( x, y, width, height )。

○ RotatedRect
標明平面上具有迴轉角度的矩形空間與位置 ( Mass Point{x, y}, width, height, angle )。

● TermCriteria
標明終止遞迴演算用的計數物件。
Parameters:	
	- type，遞迴終止條件
		- TermCriteria::COUNT、TermCriteria::EPS、TermCriteria::COUNT + TermCriteria::EPS.
	- maxCount，最大遞迴次數，用於COUNT。
	- epsilon，參數變異精度，用於EPS。

○ Mat
http://docs.opencv.org/2.4.12/modules/core/doc/basic_structures.html#mat

N維度矩陣(Matrix)物件。
矩陣操作運算函式庫參考Core。
※ 維度創立，使用CV_TYPE來控制；其餘方式可參考文件。

● Scalar
擁有4元素的Vector ( [v0, v1, v2, v3] )。
※ 在C / C++ 中，另有不定元素數量的Vector，Scalar則為固定4元素。

○ Range
標明整段序列中的子序列物件 ( start, end )。
此物件可用於標明Mat中的行(Row)、列(Column)

● KeyPoint
此物件為Java的資料型態，依據屬性判讀，此為序列影像、音訊的重要關鍵點、位置、相對資訊等。

◎ Core，矩陣運算
http://docs.opencv.org/2.4.12/modules/core/doc/basic_structures.html#matrix-expressions
\sdk\java\javadoc\org\opencv\core\Core.html

Demo：

※ 相關文章參考：
---------------------------
矩陣乘法
https://zh.wikipedia.org/wiki/%E7%9F%A9%E9%99%A3%E4%B9%98%E6%B3%95
---------------------------

靜態函數操作
- Core.add(Mat src1, Mat src2, Mat dst) 

---------------------------

Reference :
