## eclipse形式MultiProject検証コード

see 
http://d.hatena.ne.jp/kimukou_26/20130520/p1  
http://d.hatena.ne.jp/kimukou_26/20130524/p1


- OK) AsAbstest/abstest_ec から
  - ./gradlew clean build

- OK) OKの構成でAndroid Studioから実行

-----------------------------
## 現状わかっている android grade pluginの制限

- 浅い階層(1階層 or 相対パス)で見るために
 - includeFlat を使うと

``
  allprojects{
     version = '1.0'
  }
``
の定義が必要(0.4.1からはなくても動くようになりました)

- (公式サイトのようにプロジェクト下方に2階層潜る場合は上記の記述が要らない）
 - <= android grade plugin 辺の制限？


-----------------------------
## ANDROID_HOME等に環境パスをしていない場合
 
- gradle.properties 等が別途必要

``
systemProp.ANDROID_HOME='/Applications/android-sdks'
``
