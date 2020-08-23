//验证WaitForMultipleObjects函数
#include<stdio.h>
#include<windows.h>
#include<process.h>

#define MAX_THREAD 50
long long num=0;
unsigned WINAPI thread_dec(void *arg);
unsigned WINAPI thread_inc(void *arg);
CRITICAL_SECTION cs;

int main(int argc,char*argv[])
{
    HANDLE handle[MAX_THREAD];
    int thread_id[MAX_THREAD];
    int i;
    DWORD wr;
    InitializeCriticalSection(&cs);
    for(i=0;i<MAX_THREAD;i++)
    {
        if(i%2)
          handle[i]=(HANDLE)_beginthreadex(NULL,0,thread_inc,NULL,0,&thread_id[i]);
        else
          handle[i]=(HANDLE)_beginthreadex(NULL,0,thread_dec,NULL,0,&thread_id[i]);
        
        
    }
  
    wr=WaitForMultipleObjects(MAX_THREAD,handle,TRUE,INFINITE);
    if(wr==WAIT_FAILED)
    {
        printf("return error");
        exit(0);
    }
    printf("statue:%s",(wr==WAIT_OBJECT_0)?"signaled\n":"errorn\n");
    printf("num=%lld",num);
    DeleteCriticalSection(&cs);
    return 0;
}


unsigned WINAPI thread_inc(void *arg)
{
    //获取和释放cs对象
    EnterCriticalSection(&cs);
    for(int i=0;i<5000000;i++)
        num+=1;
    LeaveCriticalSection(&cs);
    return 0;
}
unsigned WINAPI thread_dec(void *arg)
{
    EnterCriticalSection(&cs);
    for(int i=0;i<5000000;i++)
        num-=1;
    LeaveCriticalSection(&cs);
    return 0;
}
