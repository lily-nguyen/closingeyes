REM update this file
call G:
call cd G:\Android\android-sdk\tools\

call android create project --target 1 --name distanceimages --path G:\Android\workingspace\distanceimages --activity DistanceImage --package com.jack.distanceimages

call xcopy G:\Android\workingspace\run.cmd G:\Android\workingspace\distanceimages\


REM update existing project:
REM call android update project --target 1 --path G:\Android\workingspace\POSA-15-master\assignments\assignment1


REM create lib:
REM call android create lib-project --target 1 --name AndroidLib --path G:\Android\workingspace\AndroidLib --package com.jack.android.lib


REM list targets:
REM call android list targets
