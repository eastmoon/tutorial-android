◎ OpenCV

1. OpenCV官方網站下載OpenCV for android

2. 安裝OpenCV Manager in ADV / emulator environment
	- 小米手機需要額外載入並安裝

3. 啟動特定專案並確認軟體最小需求版本符合Library需求

◎ Package

○ core
a compact module defining basic data structures, including the dense multi-dimensional array Mat and basic functions used by all other modules.
基本資料結構，包括維度矩陣、基礎函數。

● imgproc 
an image processing module that includes linear and non-linear image filtering, geometrical image transformations (resize, affine and perspective warping, generic table-based remapping), color space conversion, histograms, and so on.
影像處理模組，如線性、非線性影像過濾，幾何影像轉換，色彩空間轉換，直方圖等。

○ video
a video analysis module that includes motion estimation, background subtraction, and object tracking algorithms.
影片分析模組，如動態分析，背景相減，物件追跡演算法。

● calib3d
basic multiple-view geometry algorithms, single and stereo camera calibration, object pose estimation, stereo correspondence algorithms, and elements of 3D reconstruction.
基礎多視點幾何演算法，攝影機標定，物體姿態分析等。

○ features2d
salient feature detectors, descriptors, and descriptor matchers.
特徵點偵測，描述子，描述子比對。

● objdetect
detection of objects and instances of the predefined classes (for example, faces, eyes, mugs, people, cars, and so on).
偵測特定實體物件，如臉、眼睛、馬克杯、人、車等。

○ highgui
an easy-to-use interface to video capturing, image and video codecs, as well as simple UI capabilities.

◎ Import library
For Android studio

1. File => New => Import module
2. Source directory => \OpenCV-[Version]-android-sdk\OpenCV-android-sdk\java
3. Download build tool by error message.
4. Goto openCVLibrary[version] build.gradle
	- modify compileSdkVersion and minSdkVersion to the library requested. 
5. Setting dependencies.

◎ Library document
函式庫文件詳見OpenCV for Android下載檔案夾內。
\OpenCV-[Version]-android-sdk\OpenCV-android-sdk\java\javadoc\index.html

◎ 教學文件
http://docs.opencv.org/2.4/doc/tutorials/tutorials.html
http://ccw1986.blogspot.tw/2013/09/learningopencv.html

---------------------------

Reference :

http://docs.opencv.org/2.4.12/modules/core/doc/intro.html

Andorid上執行OpenCV範例
http://opencv-android.blogspot.tw/2014/04/andoridopencv_2.html
http://ibuzzlog.blogspot.tw/2012/07/androidopencv.html
https://www.youtube.com/watch?v=ZMkjPHaTniU

Open Source Computer Vision Library
https://sourceforge.net/projects/opencvlibrary/files/

Get started with OpenCV on Android™
http://developer.sonymobile.com/knowledge-base/tutorials/android_tutorial/get-started-with-opencv-on-android/

Developing OpenCV computer vision apps for the Android platform
http://www.embedded.com/design/programming-languages-and-tools/4406164/Developing-OpenCV-computer-vision-apps-for-the-Android-platform

Developing OpenCV Computer Vision Apps for the Android Platform
http://www.embedded-vision.com/platinum-members/bdti/embedded-vision-training/documents/pages/developing-opencv-computer-vision-app

Problem :

Installing OpenCV Manager 3.0.0 on Android (phone + emulator)
http://answers.opencv.org/question/68324/installing-opencv-manager-300-on-android-phone-emulator/