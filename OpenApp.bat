@echo off
title Open My App

echo ==========================================
echo        Open My App from this Repo
echo ==========================================
echo.
echo Select IDE to open the project:
echo   1. Android Studio
echo   2. VS Code
echo.

set /p choice=Enter choice (1 or 2): 

if "%choice%"=="1" (
    echo Opening in Android Studio...
    start "" "C:\Program Files\Android\Android Studio\bin\studio64.exe" "%cd%"
    goto end
)

if "%choice%"=="2" (
    echo Opening in VS Code...
    code .
    goto end
)

echo Invalid choice. Please run again.
:end
pause
