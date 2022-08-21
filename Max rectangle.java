class Solution {
    public int maxArea(int M[][], int n, int m) {
        int ans = 0;
        
        int arr[] = new int[m];
        
        for(int r=0;r<n;r++)
        {
            for(int c =0;c<m;c++)
            {
                if(M[r][c]==0)
                {
                    arr[c] = 0;
                }
                else
                {
                    arr[c]+=1;
                }
            }
            ans = Math.max(ans,getMaxArea(arr,arr.length));
        }
        
        return ans; 
    }
    
    
    public int getMaxArea(int arr[], int n)
    {
        Stack<Integer> st = new Stack<>();
        
        int len = n;
        
        int[] l = new int[len];
        int[] r = new int[len];
        
        for(int i=0;i<len;i++)
        {
            while(st.size()>0 && arr[st.peek()]>=arr[i])
            {
                st.pop();
            }
            
            if(st.size()==0)
            {
                l[i] = -1;
            }
            else
            {
                l[i] = st.peek();
            }
            
            st.push(i);
        }
        
        st = new Stack<Integer>();
        
        for(int i=len-1;i>=0;i--){
            while(st.size()>0 && arr[st.peek()]>=arr[i])
                st.pop();
                
            if(st.size()==0)
                r[i]=len;
                
            else
                r[i] = st.peek();
                
            st.push(i);
        }
        
        int ans = 0;
        
        for(int i=0;i<n;i++)
        {
            int area = arr[i]*(r[i]-l[i]-1);
            ans = Math.max(ans,area);
        }
        
        return ans; 
    }
}
