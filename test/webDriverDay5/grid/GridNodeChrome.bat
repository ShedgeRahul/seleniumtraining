c:
cd "C:\64-bit Java 8\SeleniumProjects\webdrivertraining\lib"
java ^
-Dwebdriver.chrome.driver="C:\64-bit Java 8\SeleniumProjects\webdrivertraining\test\resources\chromedriver.exe" ^
-jar selenium-server-standalone-3.141.59.jar -role node ^
-hub http://192.168.0.111:4444/grid/register ^
-browser "browserName=chrome,maxInstances=3" ^
-maxSession 3
pause