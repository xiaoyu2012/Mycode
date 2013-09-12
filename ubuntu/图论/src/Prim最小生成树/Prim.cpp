#include<iostream> 
　　#include <iostream>
    　　using namespace std;
　　#define MAX 1000 //用于表示顶点之间没有联系
    　　
    　　//无向图的邻接矩阵定义   
    　　typedef struct {   
        　　    char *vertics;//存放图中结点   
        　　    int **edge;//存放邻接矩阵   
        　　    int num;//存放图中顶点数量   
        　　}Graph;  
　　
    　　typedef struct {
        　　	char vertics;//顶点信息
        　　	int weight;//权值
        　　}MinSpanTree;//记录最小生成树的n个结点的信息
　　
    　　//这里用了简单的lowCost[]数组记录当前可选顶点到生成树上的最小距离,
    　　//更好的办法是利用最小堆，不断取当前与生成树具有最小距离的顶点加入到生成树
    　　//更新堆中的每个顶点对应的距离,从而免去了每次都用O(n)时间,
    　　//从lowcost[]中取最小距离顶点的时间和判断顶点是否已经加入生成树的if语句
    　　
    　　class Prim {
    　　  private:
    　　	  Graph graph; //定义图
    　　	  MinSpanTree *tree; //记录最小生成树的信息
    　　  public:
    　　	//构造函数
        　　	Prim(int num) {
        　　		tree  =new MinSpanTree[num+1];
        　　		graph.vertics = new char[num+1];
        　　		graph.edge = new int* [num+1];
        　　		for(int i = 0; i <= num; i++)	{
            　　			graph.edge[i] = new int[num+1];
            　　		}
        　　		graph.num = num;
        　　	}
    　　   
        　　	//普里姆算法
        　　	void prim()	{
        　　		int min; //用于记录最小lowCost
        　　		int minPoint; //用于记录最小lowCost的顶点编号
        　　    //num个顶点到生成树上的最小花费, MAX表示与生成树无联系
            　　　　//或者已经加入到生成树中
            　　		int *lowCost = new int[graph.num+1];
        　　　　　　　　　　　　　
            　　		//初始化第一个顶点
            　　		lowCost[1] = -1; //花费设置为-1,表示已加入生成树
        　　		tree[1].vertics = graph.vertics[1];
        　　		tree[1].weight = 0;
        　　		//初始化其他顶点到生成树的花费
            　　		for(int i = 2; i <= graph.num; i++) {
            　　			lowCost[i]=graph.edge[1][i];
            　　		}
        　　		//一共加入num-1个顶点（加上第一个顶点则为num个）构成最小生成树
            　　		int count = 2;
        　　		while(count <= graph.num)	{
            　　			min = MAX;	
            　　			//找出距离生成树距离最小的且没有加入生成树的点
                　　			for(int i = 2; i <= graph.num; i++) {
                　　				if(lowCost[i] != -1 && lowCost[i] < min) {
                    　　					min = lowCost[i];
                    　　					minPoint = i;
                    　　				}
                　　			}
            　　			//如果不存在点与生成树有联系
                　　			if(min == MAX) {
                　　				cout << "无法生成最小生成树" << endl;
                　　				return;
                　　			}
            　　			//记录第count个加入生成树的顶点的信息
                　　			tree[count].vertics = graph.vertics[minPoint];
            　　			tree[count].weight = lowCost[minPoint];
            　　			//设置该顶点的lowCost为MAX，表示已加入生成树
                　　			lowCost[minPoint] = -1;
            　　			//更新lowCost[]
                　　			for(i = 2; i <= graph.num; i++) {
                　　				if(lowCost[i] != -1&&graph.edge[minPoint][i] < lowCost[i])	{
                    　　					lowCost[i] = graph.edge[minPoint][i];
                    　　				}
                　　			}
            　　			++count;
            　　		}	
        　　	}
    　　	//输入图的信息
        　　	void input() {
        　　		int temp;
        　　		cout << "下面输入顶点的信息" <<endl;
        　　		for(int i = 1; i <= graph.num; i++) {
            　　			cout << "输入第" << i << "个顶点:";
            　　			cin >> graph.vertics[i];
            　　		}
        　　		for(i = 1; i <= graph.num; i++) {
            　　			for(int j = i+1; j <= graph.num; j++)	{
                cout<<"输入"<<graph.vertics[i]<<"到"<<graph.vertics[j]<<"的距离"<<endl;
                　　				cin >> temp;
                　　				graph.edge[i][j] = temp;
                　　				graph.edge[j][i] = temp;
                　　			}
            　　		}
        　　	}
    　　	//输出最小生成树的信息
        　　	void display()	{
        　　		int tot = 0;
        　　		for(int i = 1; i <= graph.num; i++) {
            cout << "第" << i << "个加入的顶点为:" << tree[i].vertics << ",其花
　费权值:" << tree[i].weight << endl;
            　　            tot += tree[i].weight;
            　　		}
        　　		cout << "最小生成树的权值是：" << tot <<endl;
        　　	}
    　　};
　　
    　　void main() {
    　　	int n;
    　　	cin >> n; //输入顶点数
    　　	Prim test(n);//图有n个顶点
    　　	test.input();//输入图的信息
    　　	test.prim();//普里姆算法求最小生成树
    　　	test.display();//打印生成树的信息
    　　}
