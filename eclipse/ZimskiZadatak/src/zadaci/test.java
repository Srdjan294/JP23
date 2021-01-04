package zadaci;


	
	import java.io.*;

	import java.lang.*;

	class test

	{

	public static void main(String args[ ])throws IOException

	{

	BufferedReader br=new BufferedReader (new InputStreamReader(System.in));

	int arr[ ]=new int [10];

	int lowest;

	System.out.println("Enter 10 numbers");

	for(int i=0;i<10;i++)

	{

	arr[i]=Integer.parseInt(br.readLine());

	}

	lowest=arr[0]; //assume the element at first position to be the lowest

	for(int i=0;i<10;i++)

	{

	if(arr[i]<lowest) //check for all the subsequent numbers. If it is lower, then store that number in *lowest*

	{

	lowest=arr[i];

	}

	}

	System.out.println("smallest number is ="+lowest);

	}

	}


