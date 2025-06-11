@echo off
REM === Cambia estos valores si es necesario ===
set APP_NAME=InsentiveApp
set MAIN_JAR=InsentiveDelayTask.jar
set MAIN_CLASS=PanelesPrincipales.InsentiveDelayTask

REM === Asume que estás en la raíz del proyecto ===
REM === y que ya has ejecutado mvn package ===

echo Generando ejecutable con jpackage...

jpackage ^
  --type exe ^
  --input target ^
  --dest dist ^
  --name %APP_NAME% ^
  --main-jar %MAIN_JAR% ^
  --main-class %MAIN_CLASS% ^
  --win-shortcut ^
  --win-menu ^
  --java-options "-Xmx512m"

echo.
echo El ejecutable se ha generado (revisa la carpeta "dist")
pause