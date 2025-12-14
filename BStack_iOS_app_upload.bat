@echo off
echo. > ios_output.txt
curl -u "vamsianupoju_LDUuir:5ZGFbUGauZGVQh2nZqph" -X POST "https://api-cloud.browserstack.com/app-automate/upload" -F "file=@C:\GitLab-Runner\builds\MOBILE_RUN\Apps\debug\app-debug.ipa" --ssl-no-revoke > ios_output.txt
for /f "tokens=2 delims=:" %%i in ('findstr /i "app_url" ios_output.txt') do set value=%%i
echo value for app_url:%value%