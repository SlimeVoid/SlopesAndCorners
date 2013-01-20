@echo off

set programdir="C:\Programming"
set packagedir="%programdir%\Packages"
set repodir="%programdir%\Repositories"
set forgedir="%repodir%\MinecraftForge"
set fmldir="%repodir%\MinecraftForge\fml"
set mcpdir="%programdir%\mcp"
set euryscore="%repodir%\EurysCore-FML"
set slopes="%repodir%\SlopesAndCorners"
cd %mcpdir%

if not exist %slopes% GOTO :ECFAIL
GOTO :EC

:EC
if not exist %euryscore% GOTO :ECFAIL
if exist %mcpdir%\src GOTO :COPYSRC
GOTO :ECFAIL

:COPYSRC
if not exist "%mcpdir%\src-work" GOTO :CREATESRC
GOTO :ECFAIL

:CREATESRC
mkdir "%mcpdir%\src-work"
xcopy "%mcpdir%\src\*.*" "%mcpdir%\src-work\" /S
if exist "%mcpdir%\src-work" GOTO :COPYEC
GOTO :ECFAIL

:COPYEC
xcopy "%euryscore%\SV-common\*.*" "%mcpdir%\src\minecraft\" /S
xcopy "%euryscore%\LB-api\*.*" "%mcpdir%\src\minecraft\" /S
xcopy "%slopes%\SL-source\*.*" "%mcpdir%\src\minecraft\" /S
pause
call %mcpdir%\recompile.bat
call %mcpdir%\reobfuscate.bat
echo Recompile and Reobf Completed Successfully
pause

:REPACKAGE
if not exist "%mcpdir%\reobf" GOTO :ECFAIL
if exist "%packagedir%\Slopes" (
del "%packagedir%\Slopes\*.*" /S /Q
rmdir "%packagedir%\Slopes" /S /Q
)
mkdir "%packagedir%\Slopes"
xcopy "%mcpdir%\reobf\minecraft\*.*" "%packagedir%\Slopes\" /S
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
GOTO :ECCOMPLETE

:ECFAIL
echo Could not compile Slopes
pause
GOTO :EOF

:ECCOMPLETE
echo Slopes completed compile successfully
pause
GOTO :EOF

:EOF