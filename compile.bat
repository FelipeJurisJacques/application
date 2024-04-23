@echo off
setlocal enabledelayedexpansion

set "file=version.txt"
set /p version=<"%file%"
set /a new=version + 1
echo %new% > "%file%"

set "service_worker=source\application\service_worker.js"
set "temporary=source\application\service_worker_temp.js"
set "version=version: %new%"
set "count=0"
for /f "delims=" %%a in ('type "%service_worker%"') do (
    if !count! equ 0 (
        echo !version! > "%temporary%"
    ) else (
        echo %%a >> "%temporary%"
    )
    set /a count+=1
)
move /y "%temporary%" "%service_worker%"

echo Compilando projeto
mvn clean package
echo Projeto compilado v: %new%
pause