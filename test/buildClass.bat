@echo off
title Tomcat-BeX5运行平台（调试模式） Ctrl+C键结束服务
cd /d %~dp0


set startDir=%cd%
rem echo %startDir%|findstr /ibe "[0-9a-z:\\\~\!\@\#\$\(\)\_\+\`\-\=\;\'\.\,]*">nul&&goto run||goto error
goto run

:error
@echo 错误：不要把版本解压放在包含有中文、空格和特殊字符的目录！
pause
goto end

:run
@echo .
@echo ...检测执行环境中..........................................................
@echo .                                  
@echo . 检测执行环境中...                                  .
@echo . 当前环境JAVA_HOME为 %JAVA_HOME%                                                    .
@echo . 编译class文件中...                                                          .
@echo .                                                                         .
@echo ...........................................................................
call javac  -source 1.6 -target 1.6  Test.java
pause

:end