call G:
call cd G:\Android\workingspace\ClosingEyes

call ant clean debug

if %errorlevel% neq 0 goto end

call adb uninstall com.jack.closingeyes

call adb install .\bin\ClosingEyes-debug.apk

call adb logcat -c
call adb logcat

:end
call pause