#!/bin/bash
# Clear the output file
> android_output.txt
# Upload the APK to BrowserStack
curl -u "vamsianupoju_LDUuir:5ZGFbUGauZGVQh2nZqph" -X POST "https://api-cloud.browserstack.com/app-automate/upload" -F "file=@/Users/a223054054/Documents/Kyma/QA/platformbdd-mobile/Apps/debug/app-debug.apk" --ssl-no-revoke > android_output.txt
# Extract the app_url from the output
value=$(grep -o '"app_url":"[^"]*' android_output.txt | awk -F'":"' '{print $2}')
echo "value for app_url: $value"

