:: stuff to do on Windows Host when VM is destroyed
if exist ".vagrant" rmdir /S /Q .vagrant
if exist "ubuntu-bionic-18.04-cloudimg-console.log" del ubuntu-bionic-18.04-cloudimg-console.log
if exist "ubuntu-bionic-18.05-cloudimg-console.log" del ubuntu-bionic-18.05-cloudimg-console.log
