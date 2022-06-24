public class Game {

    private static final int FACE = 4;

    public static void main(String[] args) {
        Game cl = new Game();
        int[][][] img = {
                {{0, 0, 0, 1}, {0, 1, -1, 0}},
                {{0, 0, 0, 0}, {-1, -1, 0, 0}},
//                {{0, 0, 0, 0}, {-1, -1, -1, -1}},
        };
        System.out.println(cl.numIsImg(img));
    }


    //假设一个碎片4个面，3种情况分别为平面（0）， 凹面（-1）， 凸面（1）
    //一个图形的表示情况为[0,-1, 1, 0]含义为 上（0，平面） 下（-1 凹面） 左（1， 凸面） 右（0， 平面）
    //所以大概题意为img

    /**
     * img = [
     * [[0, -1, 1, 0],  [0, 0, 0, 0]],
     * [[0, 0, 1, 0], [0, 0, 0, 0]]
     * ]
     * 是否能构成一个完整的图形
     */

    private boolean numIsImg(int[][][] img) {
        int m = img.length;
        int n = img[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!dfs(img, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[][][] imgs, int i, int j) {

        int[] img = imgs[i][j];
        //上
        if (i == 0 && img[0] != 0) {
            return false;
        }
        //下
        if (imgs[0].length == i + 1 && img[1] != 0) {
            return false;
        }
        //左
        if (j == 0 && img[2] != 0) {
            return false;
        }
        //右
        if (imgs.length == j + 1 && img[3] != 0) {
            return false;
        }

        //是否越界了
        if (!borderOver(imgs, i, j)) {
            return true;
        }

        //判断当前图片上下左右四个位置与相邻图片是否能组成完整的
        if(i > 0 && img[0] + imgs[i - 1][j][1] != 0){
            return false;
        }

        if(i + 1 < imgs.length &&  img[1] + imgs[i + 1][j][0] !=  0){
            return  false;
        }

        if(j > 0 && img[2] + imgs[i][j - 1][3] != 0){
            return false;
        }

        if(j + 1 < imgs[0].length && img[3] + imgs[i][j + 1][2] != 0){
            return false;
        }

        return  true;


        //判断当前图片上下左右四个位置与相邻图片是否能组成完整的
//        //上 j - 1
//        dfs(imgs, imgs[i][j - 1], i , j - 1);
//
//        //下 j + 1
//        dfs(imgs, imgs[i][j + 1], i , j + 1);
//        //左 i - 1
//        dfs(imgs, imgs[i - 1][j], i - 1, j);
//        //右 i + 1
//        dfs(imgs, imgs[i + 1][j], i + 1, j);
    }

    private boolean borderOver(int[][][] imgs, int i, int j) {
        int i1 = imgs.length;
        int j1 = imgs[0].length;

        return 0 <= i && i < i1 && j >= 0 && j < j1;
    }
}
