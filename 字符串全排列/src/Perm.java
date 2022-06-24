import java.util.ArrayList;
import java.util.List;

public class Perm {

    //直接运行代码即可，该题为一道递归类型的题目，可以采用dfs进行决策路径的选取作为解答方案。
    public static void main(String[] args) {

        Perm cl = new Perm();
        List<String> res = new ArrayList<>();
        String str = "ABC";
        cl.dfs(str, res, "");
        for (String item : res) {
            System.out.println(item);
        }
    }

    public void dfs(String str, List<String> res,  String path){

        int len = str.length();
        //判断新生成的字符长度和需要排列字符串长度是否相等，相等证明此次递归结束，需要加入结果集
        if(len == path.length()){
            res.add(path);
            return;
        }

        for(int i = 0; i < len; i++){
            char cur = str.charAt(i);
            //判断本次新生成的字符是否包含将要写入的字符，防止重复递归
            if(path.indexOf(cur) != -1){
                continue;
            }
            //做选择
            path += str.charAt(i);
            //写入决策树，进入下一层
            dfs(str, res, path);
            //取消选择
            path = path.substring(0, path.length() - 1);
        }
    }


}
