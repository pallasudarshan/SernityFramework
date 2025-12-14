import smtplib
import sys
from os.path import basename
from email.mime.application import MIMEApplication
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.utils import COMMASPACE, formatdate
import urllib.request
import re
from collections import namedtuple

def get_component_version(server_ip):
    ComponentDetail = namedtuple('ComponentDetail', 'url version')
    url = f"http://{server_ip}:8181"
    version = "Not found"
    try:
        with urllib.request.urlopen(url) as fp:
            mystr = fp.read().decode("utf8")
            match = re.search(r"<!-- \[@kyma/visual\] installed version is (.*) -->", mystr)
            if match:
                version = match.groups()[0]
    except Exception:
        print('Could not detect kyma version, hence will be Not found in report')
    return ComponentDetail(url, version)

def send_mail(subject, text, test_machine, test_server_ip, kyma_mock_rest, kyma_mock_stream, mobile_app_version, file_paths=None,
              server="relay.ge-healthcare.net"):
    print(f"Preparing email with subject: {subject}")
    msg = MIMEMultipart()
    from_addr = 'Service.kyma_functional@gehealthcare.com'
    to_addr = ['PCSVisualizationPlatformKymaExt@gehealthcare.com']
    msg['From'] = from_addr
    msg['To'] = ', '.join(to_addr)
    msg['Date'] = formatdate(localtime=True)
    msg['Subject'] = subject

    # component_detail = get_component_version(test_server_ip)
    refAppurl = "http://" + test_server_ip + ":8181"

    html1 = f"""\
<html>
  <head></head>
 <body>
 <table style="width: 100%;border: 1px solid black;border-collapse: collapse;background-color: #aae05f;color: white;padding:10px;white-space: nowrap;font-weight:bold;">
<tr>
<td>Linux TestServer IP:</td>
<td><a href=\"""" + str(refAppurl) + """\" target="_blank">""" + str(test_server_ip) + """</a></td>
 </tr>
<tr> 
<td>Windows TestExecution Machine:</td>
<td>""" +str(test_machine)+ """</td>
 </tr> 
<tr> 
<td>Mock-Rest:</td>
 <td>""" +str(kyma_mock_rest)+ """</td> 
</tr> 
<tr> 
<td>Mock-Stream:</td>
 <td>""" +str(kyma_mock_stream)+ """</td>
 </tr>
 <tr>
  <td>Application version:</td>
   <td>""" +str(mobile_app_version)+ """</td>
 </tr>
 <tr> 
<td>Test platform:</td>
 <td>
  <a id="bs-header-logo" class="logo" title="BrowserStack" href="https://app-automate.browserstack.com/" style="text-decoration: underline;">BrowserStack</a>
</td>
 </tr>
</table>
</body>
</html>
"""

    try:
        print(f"Reading report file: {file_paths}")
        with open(file_paths, encoding="utf8") as report_file:
            html2 = report_file.read()
    except Exception as e:
        print(f"Error reading report file: {e}")
        html2 = ""

    part1 = MIMEText(html1 + html2, 'html')
    msg.attach(part1)

    file_list = list(file_paths.split(",")) if file_paths else []
    for file_path in file_list:
        try:
            print(f"Attaching file: {file_path}")
            with open(file_path, "rb") as fil:
                part = MIMEApplication(fil.read(), Name=basename(file_path))
            part['Content-Disposition'] = f'attachment; filename="{basename(file_path)}"'
            msg.attach(part)
        except Exception as e:
            print(f"Error attaching file {file_path}: {e}")

    try:
        print(f"Sending email to: {to_addr} via server: {server}")
        with smtplib.SMTP(server) as smtp:
            smtp.sendmail(from_addr, to_addr, msg.as_string())
        print('Email sent successfully')
    except Exception as e:
        print(f"Error sending email: {e}")


if __name__ == "__main__":
    print(f"Received arguments: {sys.argv}")
    if len(sys.argv) < 8:
        print(
            "Usage: SendEmail.py <subject> <file_path> <mock_rest_image> <mock_stream_image> <test_execution_machine> <test_server_ip> <mobile_app>")
        sys.exit(1)

    subject = sys.argv[1]
    file_path = sys.argv[2]
    mock_rest_image = sys.argv[3]
    mock_stream_image = sys.argv[4]
    test_execution_machine = sys.argv[5]
    test_server_ip = sys.argv[6]
    mobile_app = sys.argv[7] if len(sys.argv) > 7 else "Not provided"
    body = "Add desired text to the body of your email"

    print('Sending an email')
    send_mail(
        subject=subject,
        file_paths=file_path,
        test_server_ip=test_server_ip,
        kyma_mock_rest=mock_rest_image,
        kyma_mock_stream=mock_stream_image,
        mobile_app_version = mobile_app,
        test_machine=test_execution_machine,
        text=body
    )
# -*- coding: utf-8 -*-