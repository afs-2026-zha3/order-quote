@echo off
cd /d "%~dp0"
call mvnw.cmd -q -DskipTests package
if errorlevel 1 exit /b %errorlevel%
java -cp target/classes training.quote.QuoteApp %*
