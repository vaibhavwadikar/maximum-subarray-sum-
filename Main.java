package simple;
public class Main
{
	public void max_sub_array_1(int a[])
	{
		int max=Integer.MIN_VALUE;

		int count=0;
		for(int i=1;i<=a.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				int sum=0;
				for(int k=j;k<(i+j);k++)
				{
					count++;
					if((i+j)>a.length)
					{
						break;
					}
				
					sum=sum+a[k];
				}
				if(sum>max)
				{
					max=sum;
				}
			}
		}
		System.out.println("max value of subarray using brute force ="+max);
		System.out.println("It takes "+count+" iterations");
	}
	public void max_sub_array_2(int a[])
	{
		int max=Integer.MIN_VALUE;
		int count=0;
		for(int k=0;k<a.length;k++)
		{
			for(int i=k;i<a.length;i++)
			{
				int sum=0;
				for(int j=k;j<i+1;j++)
				{
					count++;
					if(i+1>a.length)
					{
						break;
					}
					sum=sum+a[j];
				}
				if(sum>max)
				{
					max=sum;
				}
			}
		}
		System.out.println("max value of subarray using My Method ="+max);
		System.out.println("It takes "+count+" iterations");
	}
	public void max_sub_array_3(int []a)	//Dynamic programming
	{
		int max=Integer.MIN_VALUE;
		int count=0;
		for (int i = 0; i < a.length; i++)
        {
            int sum = 0;
            for (int j = i; j < a.length; j++)
            {
            	count++;
                sum += a[j];
                if (sum > max)
                    max = sum;
            }
        }
		System.out.println("max value of subarray using O(n^2) ="+max);
		System.out.println("It takes "+count+" iterations");
	}
	public void max_sub_array_4(int a[])	//Dynamic programming
	{
		int max_cur,max,count=0;
		max_cur=a[0];
		max=a[0];
		//System.out.println("max_cur="+max_cur);
		//System.out.println("max ="+max);
		
		for(int i=1;i<a.length;i++)
		{
			count++;
			if(max_cur<0)
			{
				max_cur=a[i];
			//	System.out.println("Max_cur="+max_cur);
			}
			else
			{
				max_cur=max_cur+a[i];
			//	System.out.println("Max_cur="+max_cur);
			}
			if(max_cur>=max)
			{
				max=max_cur;
			//	System.out.println("Max="+max);
			}
		}
		System.out.println("max value of subarray using Kadane's algorithm ="+max);
		System.out.println("It takes "+count+" iterations");
	}
	public static void main(String[] args) 
	{
		int a[]={10,-2,4,-14,0,-7,-8,11,-7,-2,5,10,-2,-2,-2,-7,10,-8,2,-3,4};
		Main m=new Main();
		System.out.println("Brute force : Complexity : O(n^3)");
		m.max_sub_array_1(a);
		System.out.println();
		System.out.println("My Method : Complexity : O(n^3)");
		m.max_sub_array_2(a);
		System.out.println();
		System.out.println("Complexity : O(n^2)");
		m.max_sub_array_3(a);
		System.out.println();
		System.out.println("Kadane's algorithm : Complexity O(n)");
		m.max_sub_array_4(a);	
	}
}
