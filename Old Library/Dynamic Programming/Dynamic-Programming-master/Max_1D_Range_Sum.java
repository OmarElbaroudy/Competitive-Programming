int sum =0 , ans =0;
			for(int i = 0 ; i < n ; i++)
			{
				sum+=arr[i];
				ans = Math.max(ans, sum);
				if(sum<0)sum=0;
			}
