◎ Camera

相機(Camera)，使用行動裝置的相機裝置取得影像並提供後續演算或管理操作運用。

◎ 第三方軟體
Demo : Call_third_party camera_software

使用第三方軟體流程：

1. Use intent object to start target application.
	- if target application not exist, run dialog and download application.
2. Receive application result and execute result.

使用第三方軟體流程是以Intent物件為基本，呼叫有登記的功能行為的軟體，並取得其回應結果。

※ MediaStore物件下有數個ACTION可使用，IMAGE_CAPTURE和VIDEO_CAPTURE是視為不同的對象軟體，應注意使用上所需對映的軟體為何種。

◎ 函示庫
Demo : Call_library

1. Declare permission and feature in AndroidManifest.xml
	- uses permission : "android.permission.CAMERA"
	- uses feature : "android.hardware.camera" 
	- uses feature : "android.hardware.camera.autofocus"

2. Declare Activity orientation in AndroidManifest.xml, it will affect camera orientation.
	- android:screenOrientation="landscape"

※ Camera class was deprecated in API level 21.
We recommend using the new android.hardware.camera2 API for new applications.



---------------------

Reference page :

Android camera應用(一) - 使用Intent調用其他服務幫忙拍照
http://jim690701.blogspot.tw/2012/07/android-camera-intent.html

Android camera應用(二) - 使用Android內部照相機功能
http://jim690701.blogspot.tw/2012/07/android-camera-android.html

Controlling the Camera
http://developer.android.com/intl/zh-tw/training/camera/cameradirect.html

Android Camera2Basic Sample
https://github.com/googlesamples/android-Camera2Basic