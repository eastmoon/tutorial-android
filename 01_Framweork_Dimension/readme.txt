◎ Dimension
http://developer.android.com/intl/zh-tw/guide/topics/resources/more-resources.html#Dimension

1. px

Pixels - corresponds to actual pixels on the screen.

2. in

Inches - based on the physical size of the screen.
1 Inch = 2.54 centimeters

3. mm

Millimeters - based on the physical size of the screen.

4. pt

Points - 1/72 of an inch based on the physical size of the screen.

5. dp or dip

Density-independent Pixels - an abstract unit that is based on the physical density of the screen. These units are relative to a 160 dpi screen, so one dp is one pixel on a 160 dpi screen. The ratio of dp-to-pixel will change with the screen density, but not necessarily in direct proportion. Note: The compiler accepts both "dip" and "dp", though "dp" is more consistent with "sp".

dp = (width in pixels * 160) /  screen density

6. sp

Scale-independent Pixels - this is like the dp unit, but it is also scaled by the user's font size preference. It is recommend you use this unit when specifying font sizes, so they will be adjusted for both the screen density and user's preference.

※ 相關文章參考：
---------------------------
Difference between px, dp, dip and sp on Android?
http://stackoverflow.com/questions/2025282/difference-between-px-dp-dip-and-sp-on-android

Understanding Density Independence in Android
https://www.captechconsulting.com/blogs/understanding-density-independence-in-android

Layout - Units and measurements
https://www.google.com/design/spec/layout/units-measurements.html#units-measurements-scaleable-pixels-sp-

Supporting Multiple Screens
http://developer.android.com/intl/zh-tw/guide/practices/screens_support.html

Get screen dimensions in pixels
http://stackoverflow.com/questions/1016896/get-screen-dimensions-in-pixels

Get current activity content view size.
getRight, getLeft, getTop returning zero
http://stackoverflow.com/questions/12052570/getright-getleft-gettop-returning-zero

Android屏幕密度（Density）和分辨率的关系
http://blog.csdn.net/angle_rupert/article/details/6407070
---------------------------

◎ Typography
https://www.google.com/design/spec/style/typography.html#

◎ Support multi-screen
Here is a quick checklist about how you can ensure that your application displays properly on different screens:

1. Use wrap_content, fill_parent, or dp units when specifying dimensions in an XML layout file
2. Do not use hard coded pixel values in your application code
3. Do not use AbsoluteLayout (it's deprecated)
4. Supply alternative bitmap drawables for different screen densities

◎ UI Design & RWD

在Android內部，由於元件的實際尺寸(Pixel)產出在onResume之後的內部程序中，在此之前僅能取得視窗的大小。
考量無法確切取得實際尺寸的情況，以DPI換算相對座標的設計，可以避免對位錯誤。
在實際高度上，直接取得Content view並無法正確得到，產生一背景元件，設定MATCH_PARENT並取得其寬高的實際值則會正確；但此法會產生無意義元件，對此設計仍有考量必要。

- 百分比(Percentage)
- 實際尺(Inches)

1. 假設影像上的最小單位。

※ 考量圖示(ICON 32*32 px)的整併問題，最小單位可以此為基本值考慮。
160 mdpi = 32 px = 32 dp
240 hdpi = 48 px = 32 dp
320 xhdpi = 64 px = 32 dp 
480 xxhdpi = 96 px = 32 dp
640 xxxhdpi = 128 px = 32 dp

2. 以最小單位的倍數設計，並以DPI換算為實際尺寸。

假設最小單位為ICON的32 dp，則實際寬度為其10倍，在16:9的螢幕尺寸下。
實際尺寸為320*640 dp，換算為實際尺寸
mdpi = 320*568.9 px
hdpi = 480*853.3 px
xhdpi = 640*1137.8 px
xxhdpi = 960*1706.7 px
xxxhdpi = 1280*2275.6 px

3. 設計假定與實際誤差

依據不同廠商的螢幕設計考量實際尺寸，即可能存在僅有一邊符合或接近實際尺寸的情況；高度原則上會因動作列等設計導致實際高會減少約(80-90dp)。

※ 動作列導致的高度差
240 px(480dpi) = 80dp，ADV ( Nexus 5 )
268 px(480dpi) = 89.3dp，小米
162 px(320dpi) = 81dp，ASUS
122 px(240dpi) = 81.3dp，雜牌

在此狀況下，應注意兩點：
1. 寬度：對齊邊
小於實際，採留白設計填補實際差，並以中央對齊。
大於實際，採用比例縮放。

2. 高度：相對邊
當寬度為對齊後，計算相對高度，並與實際高計算。
小於實際：不改動。
大於實際：增加Scroller。

在預設上，應將高度導致的誤差列入設計考量，並將此段列為容易導致誤差設計區，應該避免將設計放於此。
若將設計放於此，則應考量此頁必須增加滾輪的導覽設計。

※ 相關文章參考：
---------------------------

---------------------------

---------------------------------

Reference :

Draw 9-patch
http://developer.android.com/intl/zh-tw/tools/help/draw9patch.html

A simple guide to 9-patch for Android UI
http://radleymarx.com/blog/simple-guide-to-9-patch/

Android Tutorials Leson 13 9 Patch image creation
https://www.youtube.com/watch?v=wLimJf-EIl8

Simple Nine-patch Generator
http://romannurik.github.io/AndroidAssetStudio/nine-patches.html

ANDROID自定义视图——onMeasure，MeasureSpec源码 流程 思路详解
http://blog.csdn.net/a396901990/article/details/36475213

ANDROID自定义视图——onLayout源码 流程 思路详解
http://blog.csdn.net/a396901990/article/details/38129669

ANDROID自定义视图——仿瀑布布局（附源码）
http://blog.csdn.net/a396901990/article/details/38688409

Android App支援多種不同螢幕規格的方式
https://magiclen.org/android-screen/
