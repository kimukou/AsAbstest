## AS新規プロジェクト形式MultiProject検証コード

- see
 - http://d.hatena.ne.jp/kimukou_26/20130520/p1
 - http://d.hatena.ne.jp/kimukou_26/20130524/p1
 

- OK) AsAbstest/abstest_ec から
  - ./gradlew clean build

- OK) OKの構成でAndroid Studioから実行

-----------------------------
## 現状わかっている android grade pluginの制限

- 浅い階層(1階層 or 相対パス)で見るために
 - includeFlat を使うと

``
  subprojects{
     version = '1.0'
  }
``

の定義が必要(0.4.1からはなくても動くようになりました)

- (公式サイトのようにプロジェクト下方に2階層潜る場合は上記の記述が要らない）
 - <= android grade plugin 辺の制限？


-----------------------------
## Google Repository/Android Repository を使う場合の制限

- craf さんの指摘により
-- 1) MainP/local.properties のsdk.dir 記述(ANDROID_HOME) を検索
-- 2) MainP/local.properties のandroid.dir 記述(ANDROID_HOME) を検索
-- 3) 環境変数の ANDROID_HOME を検索// System.getenv("ANDROID_HOME") 
-- 4) System.getProperty("android.home") を検索 //＜＝ここは gradle.propertiesで設定可能

でANDROID_HOMEの位置を決定し

``
File androidRepo = new File(mSdkLocation + "/extras/android/m2repository");
File googleRepo = new File(mSdkLocation + "/extras/google/m2repository");
repositories.add(new File(mPlatformRootFolder + "/prebuilts/sdk/m2repository"));
``

という形で自動登録する形で動くようなので、正常に動かないときは上記の設定を注意すること

(環境パス優先なら local.properties を要リネム)

-----------------------------
## ANDROID_HOME等に環境パスをしていない場合
 
- gradle.properties 等が別途必要

``
systemProp.android.home='/Applications/android-sdks'
``

面倒なら $HOME/.gradle/gradle.properties 辺りに上記をおく