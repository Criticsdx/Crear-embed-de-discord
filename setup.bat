@echo off
echo ========================================
echo   Discord Bot - Setup y Compilacion
echo ========================================
echo.

REM Crear directorio para librerias
if not exist "lib" mkdir lib

echo [1/3] Descargando JDA (Java Discord API)...
curl -L -o lib\JDA-5.0.0-beta.20-withDependencies.jar "https://github.com/discord-jda/JDA/releases/download/v5.0.0-beta.20/JDA-5.0.0-beta.20-withDependencies.jar"

if %ERRORLEVEL% NEQ 0 (
    echo ERROR: No se pudo descargar JDA
    echo Intenta descargar manualmente desde: https://github.com/discord-jda/JDA/releases
    pause
    exit /b 1
)

echo.
echo [2/3] Compilando DiscordBot.java...
javac -cp "lib\*" DiscordBot.java

if %ERRORLEVEL% NEQ 0 (
    echo ERROR: No se pudo compilar el bot
    pause
    exit /b 1
)

echo.
echo [3/3] Compilacion completada exitosamente!
echo.
echo ========================================
echo   Para ejecutar el bot, usa:
echo   run.bat
echo ========================================
pause
