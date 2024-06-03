#include <stdio.h>
#include <stdlib.h>
int comp(const void *elem1, const void *elem2)
{
    int f = *((int *)elem1);
    int s = *((int *)elem2);
    if (f > s)
        return 1;
    if (f < s)
        return -1;
    return 0;
}
void main()
{
    int p[] = {98, 183, 37, 122, 14, 124, 65, 67};
    int n = 8;
    int isfinished[8] = {0};
    int head = 53;
    qsort(p, sizeof(p) / sizeof(int), sizeof(int), comp);
    int total = 0;
    while (n > 0)
    {
        for (int i = 0; i < 9; i++)
        {
            if (head <= p[i] && n != 0)
            {
                printf("Head moved from %d to %d!\n", head, p[i]);
                total += abs(p[i] - head);
                head = p[i];
                n--;
            }
        }
        if (n != 0)
        {
                printf("Head moved from %d to %d!\n", head, 199);
                printf("Head moved from %d to %d!\n", 199, 0);
            total += 199 + (199 - head);    
            head = 0;
        }
    }
    printf("The Total Number of Head Movements Are : %d", total);
}