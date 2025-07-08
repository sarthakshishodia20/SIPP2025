class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        generate(ans,n,0,0,"");
        return ans;
    }
    public static void generate(List<String> ans,int n,int open,int close,String str){
        if(open==n && close==n){
            ans.add(str);
            return;
        }
        if(open<n){
            StringBuilder sb=new StringBuilder(str);
            sb.append('(');
            generate(ans,n,open+1,close,sb.toString());
        }
        if(open>close){
            StringBuilder sb=new StringBuilder(str);
            sb.append(')');
            generate(ans,n,open,close+1,sb.toString());
        }
    }
}