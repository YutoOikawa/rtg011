/**
 * 多様な商品を売っている自動販売機
 */
class VendingMachine {
    static String seriesName = "マルチフードボックス";   // このシリーズの名前
    String boxName;      // 店頭での自販機名
    int breadNum;    // パンの在庫
    int cokeNum;     // コーラの在庫
    int snacksNum;   // スナック菓子の在庫
    int total; // 総売上
    static int[][] goods = new int [][]{
        {200,10},
        {100,20},
        {150,15},
    };

    /**
     * コンストラクタ. オレンジジュース、コーラ、ミネラルウォーターの初期値を決めて初期化
     */
    public VendingMachine(String boxName) {
        this.breadNum    = VendingMachine.goods[0][1];
        this.cokeNum     = VendingMachine.goods[1][1];
        this.snacksNum   = VendingMachine.goods[2][1];
        
        this.boxName     = boxName;
        this.total = 0;
    }

    /**
     * このシリーズの自販機の名前を返す
     */
    public static String getSeriesName() {
        return VendingMachine.seriesName;
    }

    /**
     * シリーズ名を変更する
     * @param name
     */
    public static void setSeriesName(String name){
        VendingMachine.seriesName = name;
    }


    /**
     * このBOXの自販機名を返す
     */
    public String getBoxName() {
        return this.boxName;
    }

    /**
     * 代金を受け取って、商品を販売する（出す）
     * @param item 商品名
     * @return 出てくる商品名
     */
    public String sell(String item) {
        if (item == "bread"){
            this.breadNum -= 1;
            this.total += VendingMachine.goods[0][0];
            return "bread";
        } else if (item == "coke") {
            this.cokeNum -= 1;
            this.total += VendingMachine.goods[1][0];
            return "coke";
        } else if (item == "snacks") {
            this.snacksNum -= 1;
            this.total += VendingMachine.goods[2][0];
            return "snacks";
        } else {
            return "no item";
        }
    }

    /**
     * 総売上を取得する
     * @return
     */
    public void getTotal(){
        System.out.println("現在の売上は" + this.total);
    }

    /**
     * 現在の在庫数を伝える
     * @return 各商品の在庫数を伝えるメッセージ
     */
    public String getAllNum() {
        return this.boxName + "では、パンの在庫は" + this.breadNum +
        "。 コーラの在庫は" + this.cokeNum +
        "。 スナック菓子の在庫は" + this.snacksNum + "です。";
    }
}

public class ArrayVending {
    public static void main(String args[]) {
        String separator = System.getProperty("line.separator");
        VendingMachine vmKyoto = new VendingMachine("京都駅前BOX");

        System.out.printf("この自販機のシリーズ名は%s、ボックス名は%sです。%s",
        VendingMachine.getSeriesName(),
        vmKyoto.getBoxName(),
        
        separator
        );

        vmKyoto.sell("coke");
        vmKyoto.sell("snacks");
        vmKyoto.sell("bread");
        vmKyoto.sell("bsss");

        vmKyoto.getTotal();
        System.out.println(vmKyoto.getAllNum());
    }
}