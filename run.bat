@echo off
echo ========================================
echo   Iniciando Discord Bot
echo ========================================
echo.

if not exist "DiscordBot.class" (
    echo ERROR: El bot no esta compilado.
    echo Por favor ejecuta setup.bat primero.
    pause
    exit /b 1
)

if not exist "lib\JDA-5.0.0-beta.20-withDependencies.jar" (
    echo ERROR: La libreria JDA no esta descargada.
    echo Por favor ejecuta setup.bat primero.
    pause
    exit /b 1
)

echo Ejecutando el bot...
echo Presiona Ctrl+C para detener el bot
echo.

java -cp ".;lib\*" DiscordBot

pause
