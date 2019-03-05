#include <windows.h>
#include <process.h>
#include <stdio.h>

unsigned WINAPI func(void *arg);

int main(int argc, char *argv[])
{
    HANDLE thread_handle; //句柄和线程的ID
    DWORD wr;
    unsigned thread_ID;
    int param = 5;
    thread_handle = (HANDLE)_beginthreadex(NULL, 0, func, (void *)&param, 0, &thread_ID);
    if (thread_handle == 0)
    {
        printf("creat thread error");
        exit(1);
    }
    //printf("%s",WaitForSingleObject(thread_handle,500));
    if((wr=WaitForSingleObject(thread_handle,INFINITE))==WAIT_FAILED)//成功时返回事件信息，失败返回WAIT_FAILED
    {
        printf("return error\n");
        exit(1);
    }
    printf("wait result:%s",(wr==WAIT_OBJECT_0)?"signaled\n":"time-out\n");
    Sleep(5000);
    printf("end of main");
    printf("thread_ID=%d",thread_ID);
    return 0;
}

unsigned WINAPI func(void *arg)
{
    int cnt = *((int *)arg);
    for (int i = 0; i < cnt; i++)
    {
        printf("running thread\n");
        Sleep(500);
    }
    return 0;
}