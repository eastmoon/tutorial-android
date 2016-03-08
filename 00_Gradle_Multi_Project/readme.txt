◎ Multi project

For Android Studio 1.4：

Multi APK :

1. New project
	- 建立專案，此專案為最上層管理專案。
	- 修改預設模組(Module)名稱app為專案對應模組名稱。

2. New module -> Phone & Tablet Module -> Setting module information
	- 建立模組，此為專案內額外模組。
	
3. Build
	- 各模組將獨立建置出可執行的APK檔案，並模擬於ADV中。

主要檔案結構與運作詳閱參考內容。

設計上，互為應用程式的結構無法將內容載入一方應用程式中運用，必須將其中一方改為函示庫(Library)後才可取得實體運用；且設計要注意，資源名域是唯一物件，若出現相同將導致載入錯誤。

※ 相關文章參考：
---------------------------
---------------------------

---------------------

Reference page :

Chapter 24. Multi-project Builds
https://docs.gradle.org/current/userguide/multi_project_builds.html

android-multi-build-sample
https://github.com/flitto/android-multi-build-sample

AndroidComplexBuild
https://github.com/ethankhall/AndroidComplexBuild

How to import android project as library and NOT compile it as apk (Android studio 1.0)
http://stackoverflow.com/questions/27536491

Getting Started With Gradle: Creating a Multi-Project Build
http://www.petrikainulainen.net/programming/gradle/getting-started-with-gradle-creating-a-multi-project-build/

