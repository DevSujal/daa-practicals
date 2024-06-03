#include <stdio.h>

int resources[5] = {100, 500, 200, 300, 600};
int process[4] = {212, 417, 112, 426};
int alloc[5] = {0};
int ext_fragment = 0, allocation = 0;

void main() {
    printf("\nDemonstration of FCFS Memory Management - > \n");
    for (int i = 0; i < 4; i++){
        int j = 0;
        for (j = 0; j < 5; j++)
            if (process[i] <= resources[j] && !alloc[j]) {
                allocation += process[i];
                resources[j] -= process[i];
                printf("Block %d Allocated to process %d! \n", j + 1, i + 1);
                alloc[j] = 1;
                break;
            }
            if (!alloc[j])
                printf("process %d is unallocated! memory for execution is %d\n", i+1, process[i]);
    }
    printf("Updated Resoures: ");
    for (int i = 0; i < 5; i++) {
        printf("%d  ", resources[i]);
        ext_fragment += resources[i];
    }
    printf("\nExternal Fragmentation: %d\n", ext_fragment);
    printf("Allocation: %d\n", allocation);
}