@echo off

set programdir=%CD%\..\..
set packagedir=%programdir%\Packages
set repodir=%programdir%\Git
set forgedir=%programdir%\Forge
set fmldir=%forgedir%\fml
set mcpdir=%forgedir%\mcp
set slimelib=%repodir%\SlimevoidLibrary
set matlib=%repodir%\MaterialsLibrary
set slopes="%repodir%\SlopesAndCorners"
cd %mcpdir%

if not exist %slopes% GOTO :SLFAIL
GOTO :SL

:SL
if not exist %slimelib% GOTO :SLFAIL
if not exist %matlib% GOTO :SLFAIL
if exist %mcpdir%\src GOTO :COPYSRC
GOTO :SLFAIL

:COPYSRC
if not exist "%mcpdir%\src-work" GOTO :CREATESRC
GOTO :SLFAIL

:CREATESRC
mkdir "%mcpdir%\src-work"
xcopy "%mcpdir%\src\*.*" "%mcpdir%\src-work\" /S
if exist "%mcpdir%\src-work" GOTO :SLCOPY
GOTO :SLFAIL

:SLCOPY
xcopy "%slimelib%\SV-common\*.*" "%mcpdir%\src\minecraft\" /S
xcopy "%matlib%\ML-source\*.*" "%mcpdir%\src\minecraft\" /S
xcopy "%slopes%\SL-source\*.*" "%mcpdir%\src\minecraft\" /S
pause
call %mcpdir%\recompile.bat
call %mcpdir%\reobfuscate.bat
echo Recompile and Reobf Completed Successfully
pause

:REPACKAGE
if not exist "%mcpdir%\reobf" GOTO :SLFAIL
if exist "%packagedir%\Slopes" (
del "%packagedir%\Slopes\*.*" /S /Q
rmdir "%packagedir%\Slopes" /S /Q
)
mkdir "%packagedir%\Slopes"
xcopy "%mcpdir%\reobf\minecraft\slimevoid\slopesncorners\*.*" "%packagedir%\Slopes\slimevoid\slopesncorners\" /S
xcopy "%slopes%\SL-resources\*.*" "%packagedir%\Slopes\" /S
echo Slopes Packaged Successfully
pause
ren "%mcpdir%\src" src-old
echo Recompiled Source folder renamed
pause
ren "%mcpdir%\src-work" src
echo Original Source folder restored
pause
del "%mcpdir%\src-old" /S /Q
del "%mcpdir%\reobf" /S /Q
if exist "%mcpdir%\src-old" rmdir "%mcpdir%\src-old" /S /Q
if exist "%mcpdir%\reobf" rmdir "%mcpdir%\reobf" /S /Q
echo Folder structure reset
GOTO :SLCOMPLETE

:SLFAIL
echo Could not compile Slopes
pause
GOTO :EOF

:SLCOMPLETE
echo Slopes completed compile successfully
pause
GOTO :EOF

:EOF