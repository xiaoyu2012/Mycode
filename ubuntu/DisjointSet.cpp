#include<stdio.h>

#define N 6
void Union(int a,int b);
int Boolean(int a,int b);
void DisjointSet(int a);
int p[N];

int main()
{
    int i,j,k;
    DisjointSet(N);
    Union(4,3);
    Union(3,1);
    Union(4,2);

    printf("%d",Boolean(1,2));

}

void DisjointSet(int a)
{

    for(int i = 0;i<a;i++)
       p[i] = i;
}

void Union(int a, int b)
{
    int m;
    m = a;
    while(p[m]!=m)
        m=p[m];
    p[a]=m;

    m=b;
    while(p[m]!=m)
        m=p[m];
    p[b]=m;

    p[p[b]]=p[a];
}
  
int Boolean(int a, int b)
{
    int m;
    m = a;
    while(p[m]!=m)
        m=p[m];
    p[a]=m;

    m=b;
    while(p[m]!=m)
        m=p[m];
    p[b]=m;

    return p[a]==p[b];

}
