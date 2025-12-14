@echo off
echo. > android_output.txt
curl -u "vamsianupoju_LDUuir:5ZGFbUGauZGVQh2nZqph" -X POST "https://api-cloud.browserstack.com/app-automate/upload" -F "file=@C:\GitLab-Runner\builds\MOBILE_RUN\Apps\debug\app-debug.apk" --ssl-no-revoke > android_output.txt
for /f "tokens=2 delims=:" %%i in ('findstr /i "app_url" android_output.txt') do set value=%%i
echo value for app_url:%value%