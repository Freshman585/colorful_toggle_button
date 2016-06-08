    ColorfulToggleButton的功能。
    1.是可以动态改变颜色和边框颜色的ToggleButton
    2.可动态改变形状(圆形或方形)
    3.设置边框的显示或隐藏
    4.type=1是圆形toggleButton，type=2是方形toggleButton
    具体的使用方法：
    <?xml version="1.0" encoding="utf-8"?>
    <com.tutao.lib.view.ColorfulToggleButton xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:custom="http://schemas.android.com/apk/res/[自己的项目包名]"
        android:layout_width="40dp"
        android:layout_height="40dp"
        android:layout_margin="2dp"
        custom:borderColor="@android:color/white"
        custom:borderLine="3dp"
        custom:innerDiffOutter="3dp"
        custom:solidColor="@android:color/black"
        custom:type="2">

    </com.tutao.lib.view.ColorfulToggleButton>
