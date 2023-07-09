adb shell
run-as ru.iteco.fmhandroid sh -c 'cd /data/data/ru.iteco.fmhandroid/files && tar cf - allure-results' | tar xvf - -C /data/local/tmp
exit
adb pull /data/local/tmp/allure-results



 adb exec-out run-as ru.iteco.fmhandroid sh -c '/data/data/ru.iteco.fmhandroid/files/allure-results'  


adb pop '/data/data/ru.iteco.fmhandroid/files/allure-results' /*  