# SkinApp
#一：AndroidStudio
####compileSdkVersion 24 
####buildToolsVersion "24.0.0"
####Android SDK Platform-Tools 24

#二：对资源进行区分
values<br/>
values-night<br/>

drawable<br/>
drawable-night<br/>

修改styles中parent为Theme.AppCompat.DayNight<br/>

自定义attrs<br/>

#三:自定义 SkinAppCompatActivity
自定义 view extends AppCompatButton implements Skinnable<br/>

#四：自定义View
