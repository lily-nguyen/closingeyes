call ant clean debug

if %errorlevel% neq 0 goto end

call adb uninstall com.jack.distanceimages

call adb install .\bin\distanceimages-debug.apk

call adb logcat -c
call adb logcat

:end