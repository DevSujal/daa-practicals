#include <stdio.h>
#include <string.h>

int main() {
    int available[3] = {0, 0, 0};
    int allocation[5][3] = {
        {0, 1, 0},
        {2, 0, 0},
        {3, 0, 2},
        {2, 1, 1},
        {0, 0, 2}
    };
    int request[5][3] = {
        {0, 0, 0},
        {2, 0, 2},
        {0, 0, 1},
        {1, 0, 0},
        {0, 0, 2}
    };
    int numProcesses = 5;
    int work[3];
    memcpy(work, available, sizeof(available));
    int finish[numProcesses];
    for (int i = 0; i < numProcesses; i++)
    {
       finish[i] = 0;
    }
    while (1)
    {
        int flag = 1;
        for(int i = 0; i < numProcesses; i++){
            if(!finish[i] && request[i][0] <= work[0] && request[i][1] <= work[1] && request[i][2] <= work[2]){
                work[0] += allocation[i][0];
                work[1] += allocation[i][1];
                work[2] += allocation[i][2];
                finish[i] = 1;
                flag = 0;
                printf("process %d Executed\n", i);
            }
        }
        if(flag){
            printf("Deadlock detected!\n");

            int j = 0;

            for(int i = 0; i < numProcesses; i++){
                if(finish[i] != 99){
                    if((allocation[i][0] + allocation[i][1] + allocation[i][2]) > (allocation[j][0] + allocation[j][1] + allocation[j][2])){
                        j = i;
                    }
                    finish[i] = 0;
                }
            }
            finish[j] = 99;
            printf("Process %d Terminated!\n", j);
            printf("Again Running Detection Algorithm!\n");
            memcpy(work, available, sizeof(available));
            work[0] += allocation[j][0];
            work[1] += allocation[j][1];
            work[2] += allocation[j][2];
        }
        int i = 0;
        for (i = 0; i < numProcesses; i++)
        {
            if(!finish[i])break;
        }

        if(i >= numProcesses){
            printf( "All processes are finished.\n" );
            break;
        }
    }
    return 0;
}
