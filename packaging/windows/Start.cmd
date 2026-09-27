@echo off
setlocal
cd /d "%~dp0"
chcp 65001 >nul
"%~dp0SpaceMarineCLI.exe" %*
pause