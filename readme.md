## AS new project format MultiProject verification code

- [Japanise-readme.md](readme_ja.md)

- see
 - http://d.hatena.ne.jp/kimukou_26/20130520/p1
 - http://d.hatena.ne.jp/kimukou_26/20130524/p1
 

- OK) from AsAbstest/abstest 
  - ./gradlew clean build

- OK) OK structure Android Studio v0.1.2 is run

- NG) OK structure Android Studio v0.1.3 not run
 - prepare IDEA Plugin settings.gradle check lower folder
 

-----------------------------
## Limit of android grade plugin known status

- To see (1 hierarchy or relative path) shallow hierarchy
 - using includeFlat 
 
```
  subprojects{
     version = '1.0'
  }
```

need define (from 0.4.1 run, prepare not need write)

- (The above description does not need If you dive in two-tier project downward as the official site)
 - <= android grade plugin limit?


-----------------------------
## Google Repository/Android Repository using limit

- mr craf appoint problem
 - 1)MainP/local.properties has sdk.dir (ANDROID_HOME) search  
 - 2) MainP/local.properties has android.dir (ANDROID_HOME) search  
 - 3) enviroments ANDROID_HOME search// System.getenv("ANDROID_HOME")   
 - 4) System.getProperty("android.home") search //＜＝gradle.properties has can setting
 
ANDROID_HOME location deside 

```
File androidRepo = new File(mSdkLocation + "/extras/android/m2repository");
File googleRepo = new File(mSdkLocation + "/extras/google/m2repository");
repositories.add(new File(mPlatformRootFolder + "/prebuilts/sdk/m2repository"));
```


Because such work in a way that is automatically registered in the form of,   
you can note the above settings when you do not work properly

(If environment path first local.properties need mv _local.properties )

-----------------------------
## If you do not have the environment path to ANDROID_HOME etc.
 
- gradle.properties Required separately

```
systemProp.android.home='/Applications/android-sdks'
```

Or $HOME/.gradle/gradle.properties put.