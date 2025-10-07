class Solution {
    public List<String> letterCombinations(String digits) 
    {
        List<String> li = new ArrayList<>();
        if(digits== null||digits.length()==0)
        {
            return li;
        }
        solve(digits,li,"");
        return li;
        
    }

    public void solve(String digits, List<String> li, String ans)
    {
        // if ()
        if(digits== null||digits.length()==0)
        {
            li.add(ans);
            return;
        }

        char ch = digits.charAt(0);

        for(int i = 0; i<array[ch-'0'].length();i++)
        {
            solve(digits.substring(1),li,ans+array[ch-'0'].charAt(i));
        }
    }

    String[] array = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};



}