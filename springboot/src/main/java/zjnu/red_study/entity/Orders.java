package zjnu.red_study.entity;

public class Orders {
    /**
     * 订单id
     */
    private Integer id;
    /**
     * 订单编号
     */
    private String order_no;
    /**
     * 商品ID
     */
    private Integer goods_id;
    /**
     * 购买数量
     */
    private Integer num;
    /**
     * 下单人ID
     */
    private Integer user_id;
    /**
     * 订单状态
     */
    private String status;
    /**
     * 创建时间
     */
    private String time;
     /**
     * 商品名称
     */
    private String goods_name;
     /**
     * 商品图片
     */
    private String goods_img;
    /**
     * 用户名
     */
    private String user_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", order_no='" + order_no + '\'' +
                ", goods_id=" + goods_id +
                ", num=" + num +
                ", user_id=" + user_id +
                ", status='" + status + '\'' +
                ", time='" + time + '\'' +
                ", goods_name='" + goods_name + '\'' +
                ", goods_img='" + goods_img + '\'' +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
