@echo off
title Tomcat-BeX5����ƽ̨������ģʽ�� Ctrl+C����������
cd /d %~dp0


set startDir=%cd%
rem echo %startDir%|findstr /ibe "[0-9a-z:\\\~\!\@\#\$\(\)\_\+\`\-\=\;\'\.\,]*">nul&&goto run||goto error
goto run

:error
@echo ���󣺲�Ҫ�Ѱ汾��ѹ���ڰ��������ġ��ո�������ַ���Ŀ¼��
pause
goto end

:run
@echo .
@echo ...���ִ�л�����..........................................................
@echo .                                  
@echo . ���ִ�л�����...                                  .
@echo . ��ǰ����JAVA_HOMEΪ %JAVA_HOME%                                                    .
@echo . ����class�ļ���...                                                          .
@echo .                                                                         .
@echo ...........................................................................
call javac  -source 1.6 -target 1.6  Test.java
pause

:end