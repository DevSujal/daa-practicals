#include<stdio.h>
#include<stdlib.h>
struct prs {
    int a, b, p;
};
int compare(const void *a, const void *b){
    return ((struct prs *)a) -> b - ((struct prs *)b) -> b;
}

void main(){
    int a[] = {3, 5, 0, 5, 4};
    int b[] = {4, 3, 2, 1, 3};
    int p[] = {1, 2, 3, 4, 5};

    struct prs o[5];
    for (int i = 0; i < 5; i++)
    {
        struct prs k;
        k.a = a[i];
        k.b = b[i];
        k.p = p[i];
        o[i] = k;
    }
    
    qsort(o, sizeof(o)/sizeof(o[0]), sizeof(o[0]), compare);

    for (int i = 0; i < 5; i++)
    {
       printf("%d ", o[i].a);
       printf("%d ", o[i].b);
       printf("%d \n", o[i].p);
    }
    int waitTime = 0, turnTime = 0;
    for (int i = 0; i < 5; i++)
    {
        int wait = (turnTime - o[i].a);
        waitTime += wait < 0 ? 0 : wait;
        turnTime += o[i].b + abs(wait < 0 ? wait : 0);
    }
    printf("Average waiting time = %f\n", waitTime / 5.0);
    printf("Average TurnAround time = %f\n", turnTime / 5.0); 
}