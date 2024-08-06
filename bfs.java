import java.util.*;
class Queue
{
    int front,rear;
    Node queue[]=new Node[100];

    Queue()
    {
        front=rear=-1;
    }
    void push(Node p)
    {
        queue[++rear]=p;
        if(front==-1)
        {
            front=0;
        }
    }
    Node pop()
    {
        if(front ==-1)
        {
            return new Node(-99999);
        }
        //pop the last element:
        if(front==rear)
        {
            Node temp=queue[front];
            front=rear=-1;
            return temp;
            
        }
        // pop the first element:
        Node temp=queue[front++];
        return temp;
    }
}
class Node
{
    Node left,right;
    int val;
    Node(int data)
    {
        val=data;
        left=right=null;
    }
}

class Stack
{
    int top;
    Node stack[]=new Node[100];
    Stack()
    {
        top=-1;
    }
    void push(Node n)
    {
        stack[++top]=n;
    }
    Node pop()
    {
        if(top==-1)
        {
            return new Node(-99999);
        }
        Node temp=stack[top--];
        return temp;
    }
}
class bfs
{
    public static boolean BFS(Node root,int elem)
    {
        Queue q=new Queue();
        q.push(root);
        while(q.front>-1)
        {
            Node temp=q.pop();
            if(temp.val==elem)
                return true;
            if(temp.left!=null)
            {
                q.push(temp.left);
            }
            if(temp.right!=null)
            {
                q.push(temp.right);
            }
        }
        return false;
        

    }
    public static boolean DFS(Node root,int elem)
    {
        Stack s=new Stack();
        s.push(root);
        while(s.top>-1)
        {
            Node temp=s.pop();
            if(temp.val==elem)
            {
                return true;
            }
            if(temp.left!=null)
            {
                s.push(temp.left);
            }
            if(temp.right!=null)
            {
                s.push(temp.right);
            }
        }
        return false;
    }
    public static void main(String[] args) 
    {
        System.out.print("Enter the value of the root:\t");
        Scanner sc=new Scanner(System.in);
        int data=sc.nextInt();
        // making the tree:
        Node root=new Node(data);
        root.left=new Node(22);
        root.right=new Node(11);
        root.left.left=new Node(44);
        root.left.right=new Node(2);
        root.right.left=new Node(29);
        root.right.right=new Node(90);
        // Calling the BFS function:
        System.out.println("Enter the element to search:\t");
        int elem =sc.nextInt();
        // boolean res=BFS(root,elem);
        boolean res=DFS(root,elem);
        if(res)
        {
            System.out.println("Found");
        }
        else
        {
            System.out.println("Not Found!");
        }
               
                
    }
}