# 算法和数据结构学习👾

由于大二和大三时运气不好，没有选到算法导论这门课，然后自己在这方面也有所怠惰，因此一直没怎么注意算法还有数据结构这一块，最近阅读了相关书籍还有一些CSDN上的博文，算是学习到了不少内容。正所谓“三天不练手生”，学习算法也是要实战才能加深记忆，因此在每学一道题目后都将整合到这个仓库中，与君分享

## 结构

大致分为两块，algorithm和dataStructure，algorithm中主要是包含跟数组、字符串有关的算法，dataStructure中主要是包含各种数据结构的包装，以及跟数据结构有关的题目

## 内容

### 数组与字符串

#### 位运算实现加减乘除

BitOperation

#### 斐波那契

Fibonacci

#### 元素两两出现的数组中找出唯一的数

FindTheSingle

元素两两出现的数组中找出两个唯一的数

FindTheTwoSingle

#### 全组合

FullCombination

#### 全排列

FullPermutation

找出数组中前k个最小的元素

KLeastElement

最大和连续子数组

MaxSumSubArray

反转单词

ReverseWords

排序算法

Sort

和为k的两个元素

TwoElementWithSum

杨氏矩阵查找

YoungMatrixSearch

------

### 数据结构

数据结构这部分涉及到各种链表、树之类的节点定义和构造方式。

节点定义在util包中的Node.java，Node类只有一个成员，类型是int，设置了toString()方法为返回value，直接子类有LinkedNode和BinaryNode。LinkedNode是链表节点，BinaryNode是二叉树节点。

至于链表和二叉树的构造方式，因为手动创建对象再连接的方式又麻烦又难看，所以在LinkedNode和BinaryNode中添加了静态的Builder类，使用Builder类来构建链表和二叉树：

LinkedNode.Builder中只有一个静态函数convert，接受int类型的可变参数列表，将该数组转换成链表，并返回头节点，使用示例：

```java
LinkedNode head = LinkedNode.Builder.convert(1, 2, 3, 4, 5, 6, 7, 8);
```

BinaryNode.Builder的构造函数接受一个int参数，表示根节点的value；addChild方法接受两个int参数，分别表示左节点的value和右节点的value，如果没有左节点或右节点，使用标志NULL_CHILD；build方法返回根节点。构造树的顺序是从上到下，从左到右，使用示例：

```java
BinaryNode root = new BinaryNode.Builder(10)
				.addChild(4, 16)
				.addChild(2, 7)
				.addChild(15, 20)
				.build();
```

------

#### 链表

##### 倒数第k个节点

LastKNode

##### 两链表最近公共节点

NearestPublicNode

##### 两栈实现队列

QueueWithTwoStack

------

#### 树

##### 和为k的路径

FindPathWithSum

##### 检验后序遍历

IsCorrectPostOrder

##### 相隔最远的两叶子结点的距离

LongestDistance

镜像二叉树

MirrorBinaryTree

打印二叉树

PrintBinaryTree

##### 根据前序遍历和中序遍历重建二叉树

RebuildBinaryTree

##### 遍历二叉树

Traverse

二叉树转换成链表

TreeToLinkedList

------

#### 栈

##### 带有min函数的栈

StackWithMin

##### 两队列实现栈

StackWithTwoQueue